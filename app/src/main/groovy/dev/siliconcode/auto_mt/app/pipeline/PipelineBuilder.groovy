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

import dev.siliconcode.auto_mt.app.metamorphic.DataMutationOperatorGenerator
import dev.siliconcode.auto_mt.app.testcase.TestConstructor
import dev.siliconcode.auto_mt.app.testreq.isp.InputSpacePartitioner
import groovy.json.JsonSlurper

@Singleton
class PipelineBuilder {

    def buildGenerationPipeline() {
        println('Constructing generation pipeline')

        var pipeline = new Pipeline()
        var isp = new InputSpacePartitioner()
        var mrg = new DataMutationOperatorGenerator()
        var tc = new TestConstructor()

        isp.next = mrg
        mrg.next = tc

        pipeline.start = isp

        println('Pipeline constructed')

        return pipeline
    }

    /**
     * Builds a pipeline from a JSON file
     *
     * @param file The JSON file to build the pipeline from
     * @return The pipeline
     */
    def buildPipelineFromJson(file) {
        println('Constructing pipeline from JSON file')
        JsonSlurper slurper = new JsonSlurper()
        def json = slurper.parse(file)
        def pipeline = new Pipeline()
    }
}
