/*
 * MIT License
 *
 * SiliconCode AutoMT - Library
 * Copyright (c) 2023 SiliconCode, LLC and Isaac Griffith, PhD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.siliconcode.auto_mt.lib.cfg


import org.apache.commons.lang3.tuple.Pair
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge
/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
class CFGBuilder {

    Graph<ControlFlowNode, DefaultEdge> currentCFG
    ControlFlowNode prevNode
    Stack<Pair<BlockStart, BlockEnd>> blocks
    Stack<Pair<MethodStart, MethodEnd>> methodNodes
    int stmtCount = 1
    def labeledStatements = [:]
    ControlFlowNode loopNext
    MethodStart start
    MethodEnd end
    long edgeIndex = 0

    CFGBuilder() {
        currentCFG = new DefaultDirectedGraph<>(DefaultEdge.class)
        prevNode = null
        blocks = new Stack<>()
        methodNodes = new Stack<>()
    }

    ControlFlowGraph getCFG() {
        return new ControlFlowGraph(currentCFG, start, end)
    }

    void inject(BlockStart start, BlockEnd end) {
        Set<ControlFlowNode> outs = successors(prevNode)
        if (loopNext != null && outs.contains(loopNext))
            outs.remove(loopNext)

        // unless special case of if
        //if (!blocks.empty() && blocks.peek().getLeft().getType() != StatementType.IF) {
        for (ControlFlowNode out : outs) {
            currentCFG.removeEdge(prevNode, out)
        }
        //}

        if (!currentCFG.vertexSet().contains(start))
            currentCFG.addVertex(start)
        if (!currentCFG.vertexSet().contains(end))
            currentCFG.addVertex(end)
        currentCFG.addEdge(start, end)
        currentCFG.addEdge(prevNode, start)

        // Unless special case of Break, Continue, or Return
        for (ControlFlowNode out : outs) {
            currentCFG.addEdge(end, out)
        }

        prevNode = start

        blocks.push(Pair.of(start, end))
    }

    void inject(ControlFlowNode node) {
        Set<ControlFlowNode> outs = successors(prevNode)

        ControlFlowNode endNode = !blocks.empty() ? blocks.peek().getRight() : null
        if (endNode != null) {
            currentCFG.removeEdge(prevNode, endNode)
            currentCFG.addEdge(prevNode, node)
            currentCFG.addEdge(node, endNode)
        } else {
            currentCFG.addEdge(prevNode, node)
            for (ControlFlowNode out : outs) {
                currentCFG.removeEdge(prevNode, out)
                currentCFG.addEdge(node, out)
            }
        }

        prevNode = node
    }

    ControlFlowNode createStatement(StatementType type, String label = null, boolean jump = false, JumpTo jumpto = null) {
        ControlFlowNode stmt
        if (label != null && type == null) {
            stmt = LabeledStatement.builder().label(stmtCount++).codeLabel(label).create()
            labeledStatements.put(label, stmt)
        } else {
            stmt = Statement.builder().type(type).label(stmtCount++).create()
        }
        currentCFG.addVertex(stmt)

        if (jump) {
            ControlFlowNode oldPrev = prevNode
            inject(stmt)
            prevNode = oldPrev
            Pair<BlockStart, BlockEnd> loop = findLoop()
            Set<ControlFlowNode> succ = successors(stmt)
            switch (jumpto) {
                case JumpTo.LABEL:
                    succ.each { currentCFG.removeEdge(stmt, it)}
                    currentCFG.addEdge(stmt, (ControlFlowNode) labeledStatements.get(label))
                    break
                case JumpTo.LOOP_END:
                    if (loop != null) {
                        succ.each { currentCFG.removeEdge(stmt, it)}
                        if (loopNext != null)
                            currentCFG.addEdge(stmt, loopNext)
                        else
                            currentCFG.addEdge(stmt, loop.getRight())
                    }
                    else {
                        succ.each { currentCFG.removeEdge(stmt, it) }
                        currentCFG.addEdge(stmt, blocks.peek().getRight())
                    }
                    break
                case JumpTo.LOOP_START:
                    succ.each { currentCFG.removeEdge(stmt, it)}
                    if (loop != null)
                        currentCFG.addEdge(stmt, loop.getLeft())
                    else
                        currentCFG.addEdge(stmt, blocks.peek().getLeft())
                    break
                case JumpTo.METHOD_END:
                    succ.each { currentCFG.removeEdge(stmt, it)}
                    currentCFG.addEdge(stmt, methodNodes.peek().getRight())
                    break
            }
        } else {
            inject(stmt)
        }

        stmt
    }

    private Set<ControlFlowNode> successors(ControlFlowNode node) {
        return currentCFG.outgoingEdgesOf(node).collect { currentCFG.getEdgeTarget(it) }.toSet();
    }

    private Pair<BlockStart, BlockEnd> findLoop() {
        Stack<Pair<BlockStart, BlockEnd>> temp = new Stack<>()
        Pair<BlockStart, BlockEnd> loop = null

        while (!blocks.empty()) {
            if (blocks.peek().left.isLoop()) {
                loop = blocks.peek()
                break
            }

            temp.push(blocks.pop())
        }

        while (!temp.empty())
            blocks.push(temp.pop())

        loop
    }

    void startLoop(StatementType type, boolean atLeastOne = false) {
        BlockStart bs = LoopStart.builder().type(type).label(stmtCount++).create()
        BlockEnd be = BlockEnd.builder().type(StatementType.END).label(stmtCount++).create()
        BlockEnd next = BlockEnd.builder().type(StatementType.END).label(stmtCount++).create()

        if (atLeastOne)
            inject(bs, be)
        else {
            inject(bs, next)
            if (!currentCFG.vertexSet().contains(be))
                currentCFG.addVertex(be)
            currentCFG.addEdge(bs, be)
            blocks.pop()
            blocks.push(Pair.of(bs, be))
//            Set<ControlFlowNode> set = Sets.newHashSet(currentCFG.successors(be))
//
//            for (ControlFlowNode node : set) {
//                currentCFG.addEdge(bs, node)
//                currentCFG.removeEdge(be, node)
//            }
            loopNext = next
        }
        currentCFG.addEdge(be, bs)

        prevNode = bs
    }

    void endLoop(atLeastOne = false) {
        Pair<BlockStart, BlockEnd> pair = blocks.peek()

        endBlock()

        if (!atLeastOne)
            prevNode = pair.getLeft()
    }

    void startDecision(StatementType type) {
        BlockStart bs = BlockStart.builder().type(type).label(stmtCount++).create()
        BlockEnd be = BlockEnd.builder().type(StatementType.END).label(stmtCount++).create()

        inject(bs, be)
    }

    void endDecision(boolean hasDefault = true) {
        if (hasDefault)
            currentCFG.addEdge(blocks.peek().getLeft(), blocks.peek().getRight())

        endBlock()
    }

    void startBlock(StatementType type, StatementType endType = StatementType.END) {
        BlockStart bs = BlockStart.builder().type(type).label(stmtCount++).create()
        BlockEnd be = BlockEnd.builder().type(endType).label(stmtCount++).create()

        inject(bs, be)
    }

    void endBlock() {
        Pair<BlockStart, BlockEnd> p = blocks.pop()
        loopNext = null

        if (!blocks.empty() && (blocks.peek().getLeft().getType() == StatementType.IF || blocks.peek().getLeft().getType() == StatementType.SWITCH)) {
            prevNode = blocks.peek().getLeft()
        }
        else
            prevNode = p.getRight()
    }

    void startScript() {
        currentCFG = new DefaultDirectedGraph<>(DefaultEdge.class)
        start = new MethodStart()
        end = new MethodEnd()

        methodNodes.push(Pair.of(start, end))

        currentCFG.addVertex(start)
        currentCFG.addVertex(end)
        currentCFG.addEdge(start, end)

        prevNode = start
    }

    void startMethod() {
        currentCFG = new DefaultDirectedGraph<>(DefaultEdge.class)
        start = new MethodStart()
        end = new MethodEnd()

        methodNodes.push(Pair.of(start, end))

        currentCFG.addVertex(start)
        currentCFG.addVertex(end)
        currentCFG.addEdge(start, end)

        prevNode = start
    }

    ControlFlowGraph endScript() {
        Pair<MethodStart, MethodEnd> pair = methodNodes.pop()
        ControlFlowGraph cfg = new ControlFlowGraph(currentCFG, pair.getLeft(), pair.getRight())

        //println(CFG2DOT.generateDot(currentCFG, (String)methods.peek().name()))

        currentCFG = null
        prevNode = null
        stmtCount = 1
        return cfg
    }

    ControlFlowGraph endMethod() {
        Pair<MethodStart, MethodEnd> pair = methodNodes.pop()
        ControlFlowGraph cfg = new ControlFlowGraph(currentCFG, pair.getLeft(), pair.getRight())

        //println(CFG2DOT.generateDot(currentCFG, (String)methods.peek().name()))

        currentCFG = null
        prevNode = null
        stmtCount = 1
        return cfg
    }

    void createReturnStatement() {
        ControlFlowNode s = createStatement(StatementType.RETURN, null, true, JumpTo.METHOD_END)
        def others = currentCFG.outgoingEdgesOf(s).collect { currentCFG.getEdgeTarget(it) }.findAll { it != methodNodes.peek().getRight() }
        others.each { currentCFG.removeEdge(s, it) }
    }

    void exitSwitchBlock() {
        def succ = currentCFG.outgoingEdgesOf(prevNode).collect { currentCFG.getEdgeTarget(it) }.find { it.type == StatementType.BREAK }

        if (succ != null) {
            prevNode = blocks.peek().getLeft()
        }
    }

    void startDecisionBlock() {
        prevNode = blocks.peek().getLeft()
    }
}
