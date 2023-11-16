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

import spock.lang.Specification
import tech.tablesaw.api.DoubleColumn

class NumericalClusteringSpec extends Specification {

    def "Cluster"() {
        given:
        def clustering = new NumericalClustering()
        def name = "test"
        def feature = DoubleColumn.create("test", [1.0, 2.0, 3.0, 4.0, 5.0, 6.0])

        when:
        def blocks = clustering.cluster(name, feature)

        then:
        blocks.size() == 2
        blocks[0].getName() == name
        blocks[0].getMin() == 1.0
        blocks[0].getMax() == 3.0
        blocks[1].getName() == name
        blocks[1].getMin() == 4.0
        blocks[1].getMax() == 6.0
    }
}
