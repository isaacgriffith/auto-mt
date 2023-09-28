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
import dev.siliconcode.auto_mt.app.pipeline.TestRequirementProcessor
import dev.siliconcode.auto_mt.app.testcase.TestCase
import dev.siliconcode.auto_mt.app.testcase.TestCaseGenerator
import dev.siliconcode.auto_mt.app.testcase.TestCaseSet
import groovy.json.JsonSlurper

class DataMutationOperatorGenerator extends TestRequirementProcessor implements MetamorphicRelationGenerator, TestCaseGenerator {

    /** {@inheritDoc} */
    @Override
    def execute(Object input) {
        println('Generating Metamorphic Relations')

        var ops = loadDNOperators()
        var tcs = generateTestCases(ops, testRequirements)

        printf('MRs Generated')

        return tcs
    }

    def loadDNOperators() {
        println('- Loading DN Operators')

        var jsonSlurper = new JsonSlurper()
        jsonSlurper.parse(DataMutationOperatorGenerator.class.getResourceAsStream("/dn_operators.json"))
    }

    def generateTestCases(ops, testRequirements) {
        println('- Generating Test Cases')

        var testCases = new TestCaseSet()
        for (tr in testRequirements) {
            for (op in ops) {
                var inputRelation = op.'input-relation'
                var outputRelation = op.'output-relation'
                var mr = new MetamorphicRelation(
                        new Relation(inputRelation.name, inputRelation.operator),
                        new Relation(outputRelation.name, outputRelation.operator)
                )

                var inputs = [:]
                for (block in tr.blocks) {
                    inputs[block.name] = block.generateRandomValue()
                }

                testCases.cases += new TestCase(mr, inputs)
            }
        }
    }
}
