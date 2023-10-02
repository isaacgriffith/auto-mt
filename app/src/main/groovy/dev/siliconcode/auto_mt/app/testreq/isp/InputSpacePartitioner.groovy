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
package dev.siliconcode.auto_mt.app.testreq.isp

import com.zavtech.morpheus.frame.DataFrame
import dev.siliconcode.auto_mt.app.pipeline.DataAnalyzer
import dev.siliconcode.auto_mt.app.pipeline.InputFile
import dev.siliconcode.auto_mt.app.testreq.isp.clustering.ClusteringStrategySelector
import dev.siliconcode.auto_mt.app.testreq.isp.coverage.EachChoiceCoverage

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * A Pipeline Task used to extract the partitions of the input space in order to generate Test Requirements
 * from which a set of Metamorphic Relations can be extracted
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class InputSpacePartitioner extends DataAnalyzer implements TestRequirementGenerator {

    /** The test requirement generator to use */
    def trGenerator = new EachChoiceCoverage()

    /** {@inheritDoc} */
    @Override
    def execute(InputFile... testDataPath) {
        println('Partitioning the input space')

        var dataset = loadTestData(testDataPath)
        var characteristics = partitionData(dataset)
        var testRequirements = trGenerator.generateTestRequirements(characteristics)

        println('Partitioning complete')

        return testRequirements
    }

    /**
     * Load the test feature from a location on disk (or S3 or anywhere else) should be loaded into a table
     *
     * @param testDataPath The path to the CSV data to be loaded
     * @return table containing the data from the testDataPath
     * @throws RuntimeException if the provided path does not exist or is not a file
     */
    def loadTestData(testDataPath) {
        println('- Loading test data')

        Path p = Paths.get(testDataPath)
        if (!(Files.exists(p) && Files.isRegularFile(p))) {
            throw new RuntimeException("Path, ${testDataPath}, does not exist or is not a file.")
        }

        DataFrame.read().csv(options -> {
            options.setResource(testDataPath)
            options.setHeader(true)
        })
    }

    /**
     * For each column of the dataset we extract a characteristic by clustering on the Feature's data
     *
     * @param dataset Table defining the dataset to be used in the partitioning
     * @return a list of Characteristics derived from the provided dataset
     */
    def partitionData(DataFrame dataset) {
        println('- Partitioning data')

        var characteristics = []

        for (feature in dataset.cols()) {
            var strategy = ClusteringStrategySelector.instance.selectClusterMethod(feature)
            var blocks = strategy.cluster((String) feature.key(), feature)
            characteristics += new Characteristic((String) feature.key(), blocks)
        }

        return characteristics
    }

    /**
     * Generate the Test Requirements from the provided Characteristics
     *
     * @param characteristics The characteristics from which to generate the Test Requirements
     * @return a list of Test Requirements
     */
    @Override
    def generateTestRequirements(List<Characteristic> characteristics) {
        return trGenerator.generateTestRequirements(characteristics)
    }
}
