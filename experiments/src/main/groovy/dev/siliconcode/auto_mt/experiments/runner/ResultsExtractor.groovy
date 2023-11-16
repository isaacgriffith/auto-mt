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
import dev.siliconcode.auto_mt.lib.code.Project
import groovy.util.logging.Slf4j

/**
 * @author Isaac D. Griffith Ph.D.
 * @version 1.0.0
 */
@Slf4j
class ResultsExtractor {

    List<String> measures = []
    ReportingLevel level
    List<String> keyHeaders = []

    void initialize(ReportingLevel level, List<String> keyHeaders, List<String> measures) {
        this.level = level
        this.keyHeaders = keyHeaders
        this.measures = measures
    }

    void extractResults(Table<String, String, String> table) {
        switch(level) {
            case ReportingLevel.SYSTEM:
                extractSystemResults(table)
                break
            case ReportingLevel.PROJECT:
                extractProjectResults(table)
                break
        }
    }

    void extractSystemResults(Table<String, String, String> values) {
        values.rowKeySet().each {id ->
            List<String> keys = []
            keyHeaders.each {
                keys << values.get(id, it)
            }

            List<System> systems = []
            keys.each {
                systems << (System) System.findFirst("key = ?", it)
            }

            measures.each {measure ->
                log.info "Measure: $measure"
                List<Double> vals = []
                systems.each { sys ->
                    vals << (sys as System).getMeasureValueByName(measure)
                }

                double diff = vals[-1]
                if (vals.size() > 1) {
                    for (int i = vals.size() - 2; i >= 0; i--)
                        diff -= vals[i]
                }

                String name = measure.split(/:/)[1]
                values.put(id, name, "$diff")
            }
        }
    }

    void extractProjectResults(Table<String, String, String> values) {
        values.rowKeySet().each {id ->
            List<String> keys = []
            keyHeaders.each {
                keys << values.get(id, it)
            }

            List<Project> projects = []
            keys.each {
                projects << (Project) Project.findFirst("projKey = ?", it)
            }

            measures.each {measure ->
                log.info "Measure: $measure"
                List<Double> vals = []
                projects.each { proj ->
                    vals << (proj as Project).getValueFor(measure)
                }

                double diff = vals[-1]
                if (vals.size() > 1) {
                    for (int i = vals.size() - 2; i >= 0; i--)
                        diff -= vals[i]
                }

                String name = measure.split(/:/)[1]
                values.put(id, name, "$diff")
            }
        }
    }
}
