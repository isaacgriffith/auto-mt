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
package dev.siliconcode.auto_mt.app.testreq.isp.coverage

import dev.siliconcode.auto_mt.app.testreq.TestRequirementSet
import dev.siliconcode.auto_mt.app.testreq.isp.CategoricalBlock
import dev.siliconcode.auto_mt.app.testreq.isp.Characteristic
import spock.lang.Specification

class EachChoiceCoverageSpec extends Specification {
    void setup() {
    }

    void cleanup() {
    }

    def "GenerateTestRequirements"() {
        given:
        def coverage = new EachChoiceCoverage()
        def characteristics = [
                new Characteristic("test", [
                        new CategoricalBlock("Test", "Small"),
                        new CategoricalBlock("Test", "Medium"),
                        new CategoricalBlock("Test", "Large")]),
                new Characteristic("test2", [
                        new CategoricalBlock("Test2", "Small"),
                        new CategoricalBlock("Test2", "Medium"),
                        new CategoricalBlock("Test2", "Large")])
        ]

        when:
        TestRequirementSet trs = coverage.generateTestRequirements(characteristics)

        then:
        trs.requirements.size() == 3
    }
}
