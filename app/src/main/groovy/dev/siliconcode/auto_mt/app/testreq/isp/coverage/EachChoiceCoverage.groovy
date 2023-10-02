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
import dev.siliconcode.auto_mt.app.testreq.isp.Characteristic

/**
 * Coverage generation strategy which generates test requirements for the
 * Each Choice coverage strategy.
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class EachChoiceCoverage extends ISPCoverageGenerationStrategy {

    /** {@inheritDoc} */
    @Override
    def generateTestRequirements(List<Characteristic> characteristics) {
        println('- Generating Test Requirements')

        def trs = new TestRequirementSet()
        def allBlocksSelected = false

        while (!allBlocksSelected) {
            def combo = []
            for (c in characteristics) {
                combo += c.selectBlock()
            }
            trs.requirements += combo

            def rem = characteristics.count {it -> !it.allSelected() }
            if (rem == 0)
                allBlocksSelected = true
        }

        return trs
    }
}
