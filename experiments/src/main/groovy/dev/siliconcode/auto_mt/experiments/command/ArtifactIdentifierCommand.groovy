package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import dev.siliconcode.auto_mt.lib.parserop.Director
import groovy.util.logging.Slf4j

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class ArtifactIdentifierCommand extends LanguageCommand {

    @Override
    void execute(ExperimentContext context, Language lang) {
        this.name = lang.getCommandName()

        log.info "${lang.getName()} Artifact Identifier Started..."

        String path = context.getProject().getFullPath();

        log.info ""
        log.info "Path: ${path}"
        log.info ""

        Director director = lang.getDirector(context.getProject(), true, true, false, false)
        director.identify(context.getProject(), path)

        log.info "${lang.getName()} Artifact Identification Complete"
    }
}
