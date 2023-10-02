/*
 * MIT License
 *
 * SiliconCode AutoMT - Application
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
package dev.siliconcode.auto_mt.app.pipeline

import org.jgrapht.graph.SimpleDirectedGraph
import org.jgrapht.traverse.TopologicalOrderIterator

/**
 * Pipeline for processing input data
 */
class Pipeline {

    /** Graph representation of the pipeline */
    SimpleDirectedGraph<Task, Integer> processingGraph
    /** First task in the pipeline */
    Task start
    /** Last task in the pipeline */
    Map<Task, PipelineOutput> outputs;

    /**
     * Executes the pipeline on the given input
     *
     * @param initialInput Input to the pipeline
     */
    def execute(initialInput) {
        def inputs = [initialInput]

        Iterator<Integer> iterator = new TopologicalOrderIterator<>(processingGraph);
        while (iterator().hasNext()) {
            Task task = iterator().next();
            processingGraph.incomingEdgesOf(task).forEach { edge ->
                Task source = processingGraph.getEdgeSource(edge);
                inputs += outputs.get(source);
            }
            PipelineOutput output = task.execute(inputs);
            outputs.put(task, output);
            inputs = []
        }
    }
}
