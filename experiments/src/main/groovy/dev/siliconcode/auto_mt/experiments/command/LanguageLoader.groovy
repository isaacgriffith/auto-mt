package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import groovy.util.logging.Slf4j

/**
 * Language Loader Command
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class LanguageLoader extends AbstractCommand {

    LanguageLoader() {
        super("Language Loader")
    }

    @Override
    void execute(ExperimentContext context) {
        log.info "Loading languages..."
        LanguageLoader loader = new LanguageLoader(context)
        loader.load()
    }

    @Override
    String getName() {
        return this.name
    }
}
