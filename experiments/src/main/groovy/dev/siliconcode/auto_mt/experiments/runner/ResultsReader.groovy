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

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import groovy.util.logging.Slf4j
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class ResultsReader {

    String file
    List<String> measures
    String[] headers
    String identifier

    void initialize(String identifier, List<String> headers, List<String> measures, String file) {
        this.identifier = identifier
        this.headers = headers
        this.measures = measures
        this.file = file
    }

    Table<String, String, String> readResults() {
        combineHeadersAndMeasures()
        Table<String, String, String> table = HashBasedTable.create()
        processResults(table)

        return table
    }

    void processResults(Table<String, String, String> table) {
        Reader reader = new FileReader(file)
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)
        records.each { record ->
            headers.each {
                if (it != identifier) {
                    table.put(record.get(identifier), it, record.get(it))
                }
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
