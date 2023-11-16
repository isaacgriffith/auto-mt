package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.lib.code.Project
import dev.siliconcode.auto_mt.lib.parserop.Director

import java.lang.reflect.Constructor

class Language {

    String name
    String directorClassName

    Director getDirector(Project proj, boolean statements = true, boolean useSinglePass = false, boolean createCFG = true, boolean useExpressions = false) {
        Class directorClass = Class.forName(directorClassName)
        Constructor const = directorClass.getDeclaredConstructor(Project.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class)
        (Director) const.newInstance(proj, statements, useSinglePass, createCFG, useExpressions)
    }

    String getCommandName() {
        "${name} Artifact Identifier"
    }

    String getDirectoryIdentifierCommandName() {
        "${name} Directory Identifier"
    }

    String getParserCommandName() {
        "${name} Parser"
    }
}
