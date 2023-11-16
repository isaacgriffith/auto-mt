/*
 * MIT License
 *
 * SiliconCode AutoMT - Experiments
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
package dev.siliconcode.auto_mt.experiments.runner

import com.google.common.collect.Table
import groovy.util.logging.Slf4j
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter

/**
 * @author Isaac D. Griffith Ph.D.
 * @version 1.0.0
 */
@Slf4j
class ResultsWriter {

    String[] headers = []
    String[] measures = []
    String file

    void initialize(List<String> headers, List<String> measures, String file) {
        this.headers = headers
        this.measures = measures
        this.file = file
    }

    void writeResults(Table<String, String, String> table) {
        combineHeadersAndMeasures()
        produceResults(table)
    }

    void produceResults(Table<String, String, String> table) {
        FileWriter out = new FileWriter(file)
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(headers))) {
            table.rowKeySet().each {id ->
                Map<String, String> row = table.row(id)
                List<String> rowValues = []
                headers.each {
                    if (row.containsKey(it)) rowValues << row.get(it)
                    else rowValues << ""
                }
                rowValues.remove(0)
                rowValues.add(0, id.toString())
                printer.printRecord(rowValues)
            }
        }
    }

    void combineHeadersAndMeasures() {
//        headers = ExperimentConstants.HEADERS
        measures.each {
            headers += it.split(":")[1]
        }
    }
}
