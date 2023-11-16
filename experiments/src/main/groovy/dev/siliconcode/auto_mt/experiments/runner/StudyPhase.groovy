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
import dev.siliconcode.auto_mt.experiments.ExperimentContext
import groovy.transform.ToString
import groovy.util.logging.Slf4j

@Slf4j
@ToString(includes = ["name"])
abstract class StudyPhase {

    String name
    String description
    Table<String, String, String> results

    ExperimentContext context

    StudyPhase(String name, String description) {
        this.name = name
        this.description = description
    }

    void execute(ConfigObject config, int num) {
        log.info("Running Empirical Study: $name")
        log.info("Initializing study workflow...")
        initWorkflow(config, num)

        log.info("Starting empirical study workflow...")
        executeStudy()
        log.info("Empirical study workflow complete")
    }

    abstract void initWorkflow(ConfigObject runnerConfig, int num)

    abstract void executeStudy()

    String normalizePath(String path) {
        while (path.contains("/"))
            path = path.replace("/", "[sep]")
        while (path.contains("\\"))
            path = path.replace("\\", "[sep]")
        while (path.contains("[sep]"))
            path = path.replace("[sep]", File.separator)
        path
    }
}
