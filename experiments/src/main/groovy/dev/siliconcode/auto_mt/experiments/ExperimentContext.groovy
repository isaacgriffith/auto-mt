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
package dev.siliconcode.auto_mt.experiments


import dev.siliconcode.auto_mt.experiments.collector.Collector
import dev.siliconcode.auto_mt.experiments.command.Command
import dev.siliconcode.auto_mt.experiments.command.Language
import dev.siliconcode.auto_mt.lib.code.ExperimentSystem
import dev.siliconcode.auto_mt.lib.code.Project
import groovy.util.logging.Slf4j
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
/**
 * Context for an experiment
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class ExperimentContext {

    Dataset<Row> data
    String language
    Project project
    ExperimentSystem system
    Map<String, Command> commandMap
    Map<String, Collector> collectorMap
    Properties properties
    List<Language> languages

    ExperimentContext() {
        commandMap = [:]
        collectorMap = [:]
        properties = new Properties()
    }

    String getProperty(String key) {
        if (properties.getProperty(key) == null)
            throw new IllegalArgumentException("Property $key not found in experiment properties")
        properties.getProperty(key)
    }

    void setProperty(String key, String value) {
        if (key && !key.isBlank() && value && !value.isBlank())
            properties.setProperty(key, value)
    }

    void addProperty(String key, String value) {
        if (!properties) {
            properties = new Properties()
        }
        properties.setProperty(key, value)
    }

    void updateProperty(String key, String newValue) {
        properties.setProperty(key, newValue)
    }

    void registerCommand(Command command) {
        commandMap.put(command.name, command)
    }

    void registerCollector(Collector collector) {
        collectorMap.put(collector.name, collector)
    }

    String getProjectDirectory() {
        if (project != null) {
            return project.getFullPath();
        } else {
            return null;
        }
    }

    public String getReportDirectory() {
        return getProperty(ExperimentProperties.TOOL_OUTPUT_DIR);
    }
}
