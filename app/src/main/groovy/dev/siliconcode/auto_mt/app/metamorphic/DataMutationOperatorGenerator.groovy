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
package dev.siliconcode.auto_mt.app.metamorphic

import dev.siliconcode.auto_mt.app.pipeline.MetamorphicRelationGenerator
import dev.siliconcode.auto_mt.app.pipeline.PipelineOutput
import dev.siliconcode.auto_mt.app.pipeline.TestRequirementProcessor
import dev.siliconcode.auto_mt.app.testcase.TestCase
import dev.siliconcode.auto_mt.app.testcase.TestCaseGenerator
import dev.siliconcode.auto_mt.app.testcase.TestCaseSet
import dev.siliconcode.auto_mt.app.testreq.TestRequirementSet
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j

/**
 * Generates a set of metamorphic relations for the given set of test requirements
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class DataMutationOperatorGenerator extends TestRequirementProcessor implements MetamorphicRelationGenerator, TestCaseGenerator {

    /** {@inheritDoc} */
    @Override
    def execute(TestRequirementSet... testRequirementSets) {
        println('Generating Metamorphic Relations')

        def ops = loadDNOperators()
        def testCases = [].toSet() as Set<TestCase>
        for (testRequirement in testRequirementSets.requirements) {
            testCases += generateTestCases(ops, testRequirement.blocks)
        }

        log.info('MRs Generated')

        return testCases
    }

    /**
     * Loads the set of Data Mutation Operators from the JSON file
     */
    def loadDNOperators() {
        log.info('- Loading DN Operators')

        var jsonSlurper = new JsonSlurper()
        jsonSlurper.parse(DataMutationOperatorGenerator.class.getResourceAsStream("/dn_operators.json"))
    }

    /**
     * Generates a set of test cases for the given set of metamorphic relations
     *
     * @param ops  Set of operators
     * @param blocks Set of blocks
     */
    def generateTestCases(ops, blocks) {
        log.info('- Generating Test Cases')

        var testCases = new TestCaseSet()
        for (block in blocks) {
            for (op in ops) {
                var inputRelation = op.'input-relation'
                var outputRelation = op.'output-relation'
                var mr = new MetamorphicRelation(op.name,
                        new Relation(name: inputRelation.name, operator: inputRelation.operator),
                        new Relation(name: outputRelation.name, operator: outputRelation.operator)
                )

                var inputs = [:]
                inputs[block.name] = block.generateRandomValue()

                testCases.cases += new TestCase(mr, inputs)
            }
        }
    }
}
