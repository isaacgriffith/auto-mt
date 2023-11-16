package dev.siliconcode.auto_mt.lib.parserop

import dev.siliconcode.auto_mt.lib.code.Project

interface Director {

    void build(String path)

    void identify(Project project, String path)
}