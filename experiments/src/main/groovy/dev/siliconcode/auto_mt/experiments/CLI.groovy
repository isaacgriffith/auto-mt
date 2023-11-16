/*
 * MIT License
 *
 * SiliconCode AutoMT - Experiments
 * Copyright (c) 2023 SiliconCode, LLC and Isaac Griffith, PhD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.siliconcode.auto_mt.experiments

import dev.siliconcode.auto_mt.experiments.runner.StudyManager
import groovy.cli.Option
import groovy.cli.Unparsed
import groovy.cli.picocli.CliBuilder
import groovy.util.logging.Slf4j

import java.nio.file.Paths

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class CLI {

    static final String VERSION = "1.0.0"

    static void main(String[] args) {
        ExperimentContext context = new ExperimentContext()
        StudyManager studyManager = new StudyManager()
        EmpiricalStudy empiricalStudy = null

        // Setup CLI
        CommandLineInterface cli = CommandLineInterface.instance
        cli.manager = studyManager
        cli.context = context

        String base = ""
        ConfigLoader loader = ConfigLoader.instance

        // Load Configuration
        log.info("Loading Configuration")

        (base, empiricalStudy) = cli.initializeAndParse(args)

        File fBase
        if (System.getenv("AUTO_MT_HOME") == null)
            fBase = new File(base)
        else fBase = new File((String) System.getenv("AUTO_MT_HOME"))
        File fConfig = new File(fBase)
        Properties config = loader.loadConfiguration(fConfig)
        context.setProperties(config)
        if (System.getenv("AUTO_MT_HOME") == null)
            context.addProperty(ExperimentProperties.AUTOMT_HOME_DIR, "")
        else context.addProperty(ExperimentProperties.AUTOMT_HOME_DIR, System.getenv("AUTO_MT_HOME"))


        log.info "Configuration loaded"

        // Process Command Line Args
        log.info "Processing Command Line Arguments"
        context.addProperty(ExperimentProperties.BASE_DIRECTORY, base)
        log.info "Command Line Arguments Processed"

        empiricalStudy?.run()
    }
}

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Singleton
@Slf4j
class CommandLineInterface {
    CliBuilder cli
    StudyManager manager
    ExperimentContext context

    def initializeAndParse(String[] args) {
        log.info "Initializing CLI"

        cli = new CliBuilder(
                usage: "auto-mt experiment [options] <base>",
                header: "\nOptions:",
                footer: "\nCopyright (c) 2017-2023 Isaac D. Griffith, Ph.D. and SiliconCode, LLC",
        )

        // set the amount of columns the usage message will be in width
        cli.width = 80 // default is 74
        log.info "Completed CLI Initialization"
        log.info "started parsing command ling arguments"

        cli.parseFromInstance(new AutoMTCli(), args)

        if (arc.version) {
            println "auto-mt experimenter version ${CLI.VERSION}"
            System.exit 0
        }

        if (arc.help) {
            println ""
            cli.usage()
            System.exit 0
        }

        String base
        if (arc.base) {
            if ((arc.base.first() as String).contains("."))
                (arc.base.first() as String).replace(".", "")
            base = Paths.get(arc.base.first()).toAbsolutePath().toString()
        } else {
            base = Paths.get("").toAbsolutePath().toString()
        }

        EmpiricalStudy empiricalStudy = null
        if (arc.study) {
            String studyName = arc.study
            if (manager.studies.keySet().contains(studyName))
                empiricalStudy = manager.studies[studyName]
            else {
                log.error "Empirical Study, ${studyName}, is unknown. Failed to execute study runner."
                System.exit 1
            }
        } else {
            log.error "No empirical study specified. Failed to execute study runner."
            System.exit 1
        }
        log.info "Completed parsing command line arguments"
        return [base, empiricalStudy]
    }
}

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class AutoMTCli {
    @Option(shortName = 'h', description = "Print this help text and exit", longName = 'help')
    Boolean help

    @Option(shortName = 'v', description = 'Print the version information', longName = 'version')
    Boolean version

    private String study
    @Option(shortName = 'e', longName = 'empirical-study', description = 'Name of the study to execute')
    void setStudy(String study) {
        this.study = study
    }
    String getStudy() { study }

    @Unparsed(description = 'base directory')
    List base
}
