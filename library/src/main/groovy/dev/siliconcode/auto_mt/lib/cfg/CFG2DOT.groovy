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

import groovy.util.logging.Slf4j
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultEdge

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

@Slf4j
class CFG2DOT {

    static String generateDot(Graph<ControlFlowNode, DefaultEdge> graph, String name = null) {
        StringBuilder builder = new StringBuilder()
        if (name)
            builder.append("digraph \"${name}\" {\n")
        else
            builder.append("digraph {\n")

        for (DefaultEdge edge : graph.edgeSet()) {
            builder.append("  ${graph.getEdgeSource(edge).getType()}_${graph.getEdgeSource(edge).getLabel()} -> ${graph.getEdgeTarget(edge).getType()}_${graph.getEdgeTarget(edge).getLabel()}\n")
        }

        builder.append("}")

        builder.toString()
    }

    static void saveDOTFile(String filename, Graph<ControlFlowNode, DefaultEdge> graph, String name = "") {
        String dot = generateDot(graph, name)

        Path p = Paths.get(filename)
        PrintWriter pw = new PrintWriter(Files.newBufferedWriter(p, StandardOpenOption.CREATE, StandardOpenOption.WRITE))
        try {
            pw.print(dot)
        } catch (IOException e) {
            log.error(e.getMessage())
        } finally {
            pw.close()
        }
    }
}
