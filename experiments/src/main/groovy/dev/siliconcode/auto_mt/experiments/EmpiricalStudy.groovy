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

import com.google.common.collect.Table
import dev.siliconcode.auto_mt.experiments.runner.ReportingLevel
import dev.siliconcode.auto_mt.experiments.runner.ResultsExtractor
import dev.siliconcode.auto_mt.experiments.runner.ResultsReader
import dev.siliconcode.auto_mt.experiments.runner.ResultsWriter
import dev.siliconcode.auto_mt.experiments.runner.StudyConfigReader
import dev.siliconcode.auto_mt.experiments.runner.TimePrinter
import dev.siliconcode.auto_mt.experiments.runner.StudyPhase
import groovy.util.logging.Slf4j

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
abstract class EmpiricalStudy {

    protected Table<String, String, String> results
    protected StudyConfigReader configReader
    protected ResultsExtractor resultsExtractor
    protected ResultsWriter resultsWriter
    protected ResultsReader resultsReader
    protected ConfigObject runnerConfig
    protected int status
    protected int num
    protected long start
    protected long end
    protected long studyStart
    protected long studyEnd
    protected String name
    protected String description
    protected List<StudyPhase> phases
    protected ExperimentContext context

    protected List<String> keyHeaders
    protected List<String> headers
    protected String identifier

    EmpiricalStudy(String name, String description, StudyConfigReader reader) {
        this.name = name
        this.description = description
        this.configReader = configReader
        resultsExtractor = new ResultsExtractor()
        resultsWriter = new ResultsWriter()
        resultsReader = new ResultsReader()
        status = 0
        num = 0
        context = new ExperimentContext()
    }

    void run() {
        studyStart = System.currentTimeMillis()
        initialize()
        executeProcess()
        if (status < 7) extractResults()
        studyEnd = System.currentTimeMillis()

        log.info(TimePrinter.format(studyEnd - studyStart, "Study"))
    }

    def initialize() {
        this.runnerConfig = loadConfiguration()
        readStatus()
        if (status > 0)
            readResults()
        loadTools()
    }

    def executeProcess() {
        if (status < 1) loadStudyConfig()
        for (int i = status - 1; i < phases.size(); i++) {
            executePhase(phases[i])
        }
    }

    void extractResults() {
        log.info("Collecting Experimental REsults")
        start = System.currentTimeMillis()
        resultsExtractor.initialize(ReportingLevel.PROJECT, keyHeaders, runnerConfig.measures, context)
        resultsExtractor.extractResults(results)
        log.info("Finished Collecting Experimental Results")
        end = System.currentTimeMillis()
        updateStatus()
    }

    void updateStatus() {
        log.info(TimePrinter.format(end - start))
        writeResults()
        writeStatus(status++)
    }

    private void writeStatus(int phase) {
        File f = new File(this.runnerConfig.status_file)
        if (f.exists() && f.isFile() && f.canWrite())
            f.text = phase
        else {
            f.createNewFile()
            f.text = phase
        }
    }

    private void readStatus() {
        File f = new File(this.runnerConfig.status_file)
        if (f.exists() && f.isFile() && f.canRead())
            status = Integer.parseInt(f.text.trim())
    }

    private ConfigObject loadConfiguration() {
        ConfigSlurper slurper = new ConfigSlurper()
        File file = new File("config/runner.conf")
        slurper.parse(file.text)
    }

    private void loadTools() {
        log.info("Loading and registering tools")
//        ToolsLoader toolsLoader = new ToolsLoader()
//        toolsLoader.loadTools()
        log.info("Tools loaded and registered")
    }

    private void readResults() {
        resultsReader.initialize(identifier, headers, runnerConfig.measures, runnerConfig.results_file)
        results = resultsReader.readResults()
    }

    private void writeResults() {
        resultsWriter.initialize(headers, runnerConfig.measures, runnerConfig.results_file)
        resultsWriter.writeResults(results)
    }

    def executePhase(StudyPhase phase) {
        if (!phase)
            return

        log.info("$name - Executing Phase ${phase.name}")
        this.start = System.currentTimeMillis()
        phase.setResults(results)
        phase.execute(runnerConfig, num)
        this.end = System.currentTimeMillis()
        log.info("$name - Finished Executing Phase ${phase.name}")
        updateStatus()
    }

    def loadStudyConfig() {
        log.info("Loading Study Config")
        this.start = System.currentTimeMillis()
        configReader.initialize()
        results = configReader.loadNext() as Table<String, String, String>
        num = results.rowKeySet().size()
        log.info("Finished Loading Study Config")
        this.end = System.currentTimeMillis()
        updateStatus()
    }
}
