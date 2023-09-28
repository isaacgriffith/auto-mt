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

import com.zavtech.morpheus.frame.DataFrameColumn

class NumericalClustering extends ClusteringStrategy {

    /** {@inheritDoc} */
    @Override
    def cluster(String name, DataFrameColumn feature) {
        return null
    }

    def bestNaturalBreaks(data, maxClasses, minGvf) {
        data = sortData(data)

        var uniq = countUniqueValues(data)
        if (maxClasses > uniq) {
            maxClasses = uniq
        }

        var lowerClassLimit, _ = getMatrices(data, maxClasses)
        var bestGvf
        var bestClass = 1

        for (int nClasses = 2; nClasses <= maxClasses; nClasses++) {
            var gvf = goodnessOfVarianceFit(data, lowerClassLimit, maxClasses, nClasses, uniq)

            if (gvf > bestGvf) {
                bestGvf = gvf
                bestClass = nClasses
            }

            if (gvf >= minGvf)
                break
        }

        return breaks(data, lowerClassLimit, maxClasses, bestClass, uniq)
    }

    def naturalBreaks(data, nClasses) {
        data = sortData(data)

        var uniq = countUniqueValues(data)
        if (nClasses >= uniq) {
            return deduplicate(data)
        }

        var lowerClassLimits, _ = getMatrices(data, nClasses)

        return breaks(data, lowerClassLimits, nClasses, nClasses, uniq)
    }

    def allNaturalBreaks(data, maxClasses) {
        data = sortData(data)

        var uniq = countUniqueValues(data)
        if (maxClasses > uniq) {
            maxClasses = uniq
        }

        var lowerClassLimits, _ = getMatgrices(data, maxClasses)

        allBreaks = []
        for (nClasses = 2; nClasses <= maxClasses; nClasses++) {
            allBreaks += breaks(data, lowerClassLimits, maxClasses, nClasses, uniq)
        }
    }
}
