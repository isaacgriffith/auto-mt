package dev.siliconcode.auto_mt.lib.parserop

import dev.siliconcode.auto_mt.lib.cfg.CFGBuilder
import dev.siliconcode.auto_mt.lib.cfg.ControlFlowGraph

trait CFGStatementHandler {

    ModelBuilder modelBuilder
    Stack<CFGBuilder> builderStack = []
    CFGBuilder cfgBuilder

    void startScript() {
        CFGBuilder newBuilder = new CFGBuilder()
        builderStack.push(newBuilder)
        cfgBuilder = newBuilder
        cfgBuilder.startScript()
    }

    void startMethod() {
        CFGBuilder newBuilder = new CFGBuilder()
        builderStack.push(newBuilder)
        cfgBuilder = newBuilder
        cfgBuilder.startMethod()
    }

    void endMethod() {
        if (!modelBuilder.getMethods().isEmpty()) {
            ControlFlowGraph graph = cfgBuilder.endMethod()
            this.modelBuilder.getMethods().peek()?.setCfg(graph)
        }

        builderStack.pop()
        if (builderStack.empty())
            cfgBuilder = null
        else
            cfgBuilder = builderStack.peek()
    }

    void endScript() {
        ControlFlowGraph graph = cfgBuilder.endScript()
        this.modelBuilder.getFile().getScript().setCfg(graph)
        builderStack.pop()
        if (builderStack.empty())
            cfgBuilder = null
        else
            cfgBuilder = builderStack.peek()
    }
}