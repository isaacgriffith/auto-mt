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

import groovy.util.logging.Slf4j
import tech.tablesaw.api.NumberColumn
import tech.tablesaw.columns.AbstractColumn
import tech.tablesaw.columns.strings.AbstractStringColumn

/**
 * Factory class used to select the appropriate clustering strategy for a vector
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Singleton
@Slf4j
class ClusteringStrategySelector {

    /**
     * Factory method that actually performs the strategy selection
     *
     * @param feature The feature vector for which the strategy will be selected
     * @return a strategy for clustering
     * @throws RuntimeException if there is no known clustering strategy for the given feature vector
     */
    ClusteringStrategy selectClusterMethod(AbstractColumn feature) {
        if (!feature) {
            log.error("Feature vector cannot be null")
            throw new RuntimeException("Feature vector cannot be null")
        }

        switch(feature) {
            case { it instanceof AbstractStringColumn }:
                return new CategoricalClustering()
            case { it instanceof NumberColumn }:
                return new NumericalClustering()
            default:
                log.error("Current type: ${feature.getClass().getSimpleName()} not yet supported")
                throw new RuntimeException("Current type: ${feature.getClass().getSimpleName()} not yet supported")
        }
    }
}
