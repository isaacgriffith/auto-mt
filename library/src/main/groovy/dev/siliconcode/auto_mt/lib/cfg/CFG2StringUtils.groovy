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

import org.jgrapht.graph.SimpleDirectedGraph

/**
 * This class provides the utilities need to convert a CFG to a String and a String to a CFG for inclusion into a database
 * @author Isaac Griffith
 * @version 1.0.0
 */
class CFG2StringUtils {

    def cfgToString(SimpleDirectedGraph<ControlFlowNode, Integer> graph) {
        def build = new StringBuilder()
        graph.vertexSet().each { ControlFlowNode u ->
            graph.outgoingEdgesOf(u).each { Integer e ->
                ControlFlowNode v = graph.getEdgeTarget(e)
                build << u.toString()
                build << '|->|'
                build << v.toString()
                build << ','
            }
        }
        return build.toString()
    }

    def stringToCFG(String string) {
        if (string.contains(',') && string.contains('|->|')) {

        }
    }
}
