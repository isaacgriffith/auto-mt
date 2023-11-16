package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext

abstract class LanguageCommand {

    String name

    abstract void execute(ExperimentContext context, Language language)
}
