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
package dev.siliconcode.auto_mt.app.testreq.isp.clustering

import dev.siliconcode.auto_mt.app.testreq.isp.Block
import dev.siliconcode.auto_mt.app.testreq.isp.NumericalBlock
import tech.tablesaw.api.DoubleColumn

/**
 * Clustering strategy for numerical data
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class NumericalClustering extends ClusteringStrategy<DoubleColumn> {

    /** {@inheritDoc} */
    @Override
    def cluster(String name, DoubleColumn feature) {
        Jenks jenks = new Jenks(feature)
        Jenks.Breaks breaks = jenks.computeBreaks()

        def blocks = []
        breaks.numClassses().times {
            Block block = new NumericalBlock(name, breaks.getClassMin(it), breaks.getClassMax(it))
            blocks.add(block)
        }

        return blocks
    }
}
