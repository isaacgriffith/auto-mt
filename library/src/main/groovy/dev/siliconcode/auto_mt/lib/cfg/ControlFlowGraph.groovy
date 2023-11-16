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


import org.jgrapht.Graph
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge
/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
class ControlFlowGraph {

    MethodStart start
    MethodEnd end
    Graph<ControlFlowNode, DefaultEdge> graph

    ControlFlowGraph(graph, start, end) {
        this.start = start
        this.end = end
        this.graph = graph
    }

    String toDOT() {
        CFG2DOT.generateDot(graph)
    }

    def cfgToString() {
        def build = new StringBuilder()
        graph.vertexSet().each { ControlFlowNode v ->
            graph.outgoingEdgesOf(v).each { DefaultEdge e ->
                build << v.toString()
                build << '|->|'
                build << graph.getEdgeTarget(e).toString()
                build << ','
            }
            build << '\n'
        }
        return build.toString()
    }

    static ControlFlowGraph fromString(String string) {
        if (string == null || string.isEmpty())
            return null;

        Graph<ControlFlowNode, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class)
        ControlFlowNode start, end
        if (string.contains(':') && string.contains(',') && string.contains('|->|')) {
            def edges = string.split(',')
            edges.each { e ->
                def nodes = e.split(/\|->\|/)
                def nodeU = ControlFlowNodeFactory.instance.createNode(nodes[0])
                def nodeV = ControlFlowNodeFactory.instance.createNode(nodes[1])

                if (!graph.vertexSet().contains(nodeU))
                    graph.addVertex(nodeU)
                if (!graph.vertexSet().contains(nodeV))
                    graph.addVertex(nodeV)
                graph.addEdge(nodeU, nodeV)
                if (nodeU instanceof MethodStart)
                    start = nodeU
                else if (nodeU instanceof MethodEnd)
                    end = nodeU
                else if (nodeV instanceof MethodStart)
                    start = nodeV
                else if (nodeV instanceof MethodEnd)
                    end = nodeV
            }
        }

        return new ControlFlowGraph(graph, start, end)
    }
}
