package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import groovy.util.logging.Slf4j

/**
 * C Directory Identifier Command
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class DirectoryIdentifier extends LanguageCommand {

    @Override
    void execute(ExperimentContext context, Language lang) {
        this.name = lang.getDirectoryIdentifierCommandName()

        log.info "Setting project paths..."

        PathsDetector detector = new PathsDetector(context)
        detector.detect()
    }
}
