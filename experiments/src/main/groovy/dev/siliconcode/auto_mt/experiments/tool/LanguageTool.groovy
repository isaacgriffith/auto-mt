package dev.siliconcode.auto_mt.experiments.tool

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import dev.siliconcode.auto_mt.experiments.command.DirectoryIdentifier

import dev.siliconcode.auto_mt.experiments.command.ParserCommand

class LanguageTool extends CommandOnlyTool {

    LanguageTool(ExperimentContext context) {
        super(context)
    }

    @Override
    void init() {
        context.registerCommand(new LanguageAICommand())
        context.registerCommand(new ParserCommand())
        context.registerCommand(new DirectoryIdentifier())
    }
}
