package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import dev.siliconcode.auto_mt.lib.code.Project
import dev.siliconcode.auto_mt.lib.code.ExperimentSystem
import groovy.util.logging.Slf4j

/**
 * Command to generate a project for a given language
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class ProjectGenerator extends LanguageCommand {

    @Override
    void execute(ExperimentContext context, Language language) {
        this.name = language.getProjectGeneratorCommandName()

        log.info "Generating project for ${language.name}..."

        ExperimentSystem sys = context.getSystem()
        sys.projects << Project.builder()
            .key(sys.getKey() + "_" + language.name)
            .language(language.getName())
            .build()
    }
}
