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
import groovy.util.logging.Slf4j

import java.nio.file.Files
import java.nio.file.Paths

/**
 * Test Case Constructor which constructs the actual test cases from the template
 */
@Slf4j
class TestConstructor extends TestCaseProcessor {

    /** {@inheritDoc} */
    @Override
    def execute(TestCaseSet... testCaseSets) {
        log.info("Generating Test Code")

        def mrCode = [].toSet() as Set<String>
        def irCode = [].toSet() as Set<String>
        def tcCode = [].toSet() as Set<String>

        testCaseSets.each { testCaseSet ->
            mrCode += generateMetamorphicRelationCode(testCaseSet.cases)
            irCode += generateInputRelationCode(testCaseSet.cases)
            tcCode += generateTestCaseCode(testCaseSet.cases)
        }

        generateTestCode(mrCode, irCode, tcCode)

        log.info("Test Code Generate")
    }

    /**
     * Generates the code for the metamorphic relations
     *
     * @param testCases Set of test cases
     * @return Set of metamorphic relation code
     */
    def generateMetamorphicRelationCode(testCases) {
        println('- Generating MR Code')

        def mrCodeImpls = [].toSet()
        def template = TestConstructor.class.getResourceAsStream('/mr_template.txt').readLines().join('/n')

        for (testCase in testCases) {
            def metamorphicRelation = testCase.metamorphicRelation
            def inst = template.replace('{name}', metamorphicRelation.outputRelation.name)
            inst = inst.replace('{operator}', metamorphicRelation.outputRelation.operator)

            mrCodeImpls += inst
        }

        return mrCodeImpls
    }

    /**
     * Generates the code for the input relations
     *
     * @param testCases Set of test cases
     * @return Set of input relation code
     */
    def generateInputRelationCode(testCases) {
        log.info('- Generating IR Code')

        def irCodeImpls = [].toSet()
        def template = TestConstructor.class.getResourceAsStream('/ir_template.txt').readLines().join('/n')

        for (testCase in testCases) {
            def metamorphicRelation = testCase.metamorphicRelation
            def inst = template.replace('{name}', metamorphicRelation.inputRelation.name)
            inst = inst.replace('{operator}', metamorphicRelation.inputRelation.operator)

            irCodeImpls.add(inst)
        }

        return irCodeImpls
    }

    /**
     * Generates the code for the test cases
     *
     * @param testCases Set of test cases
     * @return Set of test case code
     */
    def generateTestCaseCode(testCases) {
        log.info('- Generating Test Case Code')

        def tcCodeImpls = [].toSet()
        def template = TestConstructor.class.getResourceAsStream('/tc_template.txt').readLines().join('/n')

        def count = 1
        for (testCase in testCases) {
            def metamorphicRelation = testCase.metamorphicRelation
            def inst = template.replace('{test_name}', "mr_${count}")
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

    /**
     * Produces the final test code
     *
     * @param mrCode Set of metamorphic relation code
     * @param irCode Set of input relation code
     * @param tcCode Set of test case code
     */
    void generateTestCode(mrCode, irCode, tcCode) {
        log.info('- Generating final test code')

        def template = TestConstructor.class.getResourceAsStream('/test_template.txt').readLines().join('/n')

        def testCode = template.replace('{metamorphic_relations}', mrCode.join('\n\n'))
        testCode = testCode.replace('{input_transforms}', irCode.join('\n\n'))
        testCode = testCode.replace('{test_cases}', tcCode.join('\n\n'))

        if (!Files.exists(Paths.get('./test'))) {
            // TODO make dir
        }

        try (def pw = Paths.get('./test/dataprocess.py').newPrintWriter()) {
            pw.write(testCode)
        }
    }
}
