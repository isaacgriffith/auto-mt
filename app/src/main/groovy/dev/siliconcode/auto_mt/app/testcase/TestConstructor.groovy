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
package dev.siliconcode.auto_mt.app.testcase

import dev.siliconcode.auto_mt.app.pipeline.TestCaseProcessor

import java.nio.file.Files
import java.nio.file.Paths

class TestConstructor extends TestCaseProcessor {

    def execute(testCases) {
        println("Generating Test Code")

        var mrCode = generateMetamorphicRelationCode(testCases)
        var irCode = generateInputRelationCode(testCases)
        var tcCode = generateTestCaseCode(testCases)

        produceTestCode(mrCode, irCode, tcCode)

        println("Test Code Generate")
    }

    def generateMetamorphicRelationCode(testCases) {
        println('- Generating MR Code')

        var mrCodeImpls = [].toSet()
        var template = TestConstructor.class.getResourceAsStream('/mr_template.txt').readLines().join('/n')

        for (testCase in testCases) {
            var metamorphicRelation = testCase.metamorphicRelation
            var inst = template.replace('{name}', metamorphicRelation.outputRelation.name)
            inst = inst.replace('{operator}', metamorphicRelation.outputRelation.operator)

            mrCodeImpls.append(inst)
        }

        return mrCodeImpls
    }

    def generateInputRelationCode(testCases) {
        println('- Generating IR Code')

        var irCodeImpls = [].toSet()
        var template = TestConstructor.class.getResourceAsStream('/ir_template.txt').readLines().join('/n')

        for (testCase in testCases) {
            var metamorphicRelation = testCase.metamorphicRelation
            var inst = template.replace('{name}', metamorphicRelation.inputRelation.name)
            inst = inst.replace('{operator}', metamorphicRelation.inputRelation.operator)

            irCodeImpls.add(inst)
        }

        return irCodeImpls
    }

    def generateTestCaseCode(testCases) {
        println('- Generating Test Case Code')

        var tcCodeImpls = [].toSet()
        var template = TestConstructor.class.getResourceAsStream('/tc_template.txt').readLines().join('/n')

        var count = 1
        for (testCase in testCases) {
            var metamorphicRelation = testCase.metamorphicRelation
            var inst = template.replace('{test_name}', "mr_${count}")
            inst = inst.replace('{inputs}', testCase.inputs)
            inst = inst.replace('{transform}', metamorphicRelation.inputRelation.name)
            inst = inst.replace('{relation}', metamorphicRelation.outputRelation.name)

            if (!tcCodeImpls.contains(inst)) {
                tcCodeImpls.add(inst)
                count++
            }
        }

        return tcCodeImpls
    }

    void produceTestCode(mrCode, irCode, tcCode) {
        println('- Generating final test code')

        var template = TestConstructor.class.getResourceAsStream('/test_template.txt').readLines().join('/n')

        var testCode = template.replace('{metamorphic_relations}', mrCode.join('\n\n'))
        testCode = testCode.replace('{input_transforms}', irCode.join('\n\n'))
        testCode = testCode.replace('{test_cases}', tcCode.join('\n\n'))

        if (!Files.exists(Paths.get('./test'))) {
            // TODO make dir
        }

        try (var pw = Paths.get('./test/dataprocess.py').newPrintWriter()) {
            pw.write(testCode)
        }
    }
}
