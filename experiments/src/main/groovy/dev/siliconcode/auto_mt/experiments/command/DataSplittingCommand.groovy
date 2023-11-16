package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import groovy.util.logging.Slf4j

/**
 * Command to split data into training and testing sets
 *
 * @author Isaac D. Griffith
 * @version 1.0.0
 */
@Slf4j
class DataSplittingCommand extends AbstractCommand {

    DataSplittingCommand() {
        super(name)
    }

    @Override
    void execute(ExperimentContext context) {
        log.info "Splitting Data..."
        context.data.split { row -> row.get("id") }
    }

    @Override
    String getName() {
        return null
    }
}
