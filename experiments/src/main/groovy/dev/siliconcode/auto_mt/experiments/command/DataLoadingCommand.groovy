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
package dev.siliconcode.auto_mt.experiments.command

import com.zavtech.morpheus.frame.DataFrame
import dev.siliconcode.auto_mt.experiments.ExperimentContext
import groovy.util.logging.Slf4j
/**
 * Command to load data into memory
 */
@Slf4j
class DataLoadingCommand extends AbstractCommand {

    String testDataPath

    DataLoadingCommand(String testDataPath) {
        super("data")
        this.testDataPath = testDataPath
    }

    @Override
    void execute(ExperimentContext context) {
        log.info "Loading Data..."
        context.data = DataFrame.read().csv(options -> {
            options.setResource(testDataPath)
            options.setHeader(true)
        })
    }

    @Override
    String getName() {
        "Data Loading"
    }
}
