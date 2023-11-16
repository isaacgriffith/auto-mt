package dev.siliconcode.auto_mt.experiments.tool

import dev.siliconcode.auto_mt.experiments.ExperimentContext

/**
 * @author Isaac D. Griffith
 * @version 1.0.0
 */
abstract class AbstractTool implements Tool {

    protected final ExperimentContext context

    AbstractTool(ExperimentContext context) {
        this.context = context
    }
}
