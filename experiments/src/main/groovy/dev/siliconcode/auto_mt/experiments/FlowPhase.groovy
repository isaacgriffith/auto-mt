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

import dev.siliconcode.auto_mt.experiments.command.Command
import groovy.transform.EqualsAndHashCode
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.util.logging.Slf4j

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Builder
@MapConstructor
@EqualsAndHashCode
@ToString(includeNames = false, includePackage = false, excludes = ["commands"])
@Slf4j
class FlowPhase {

    List<String> commands
    String name
    ExperimentContext context

    void execute() {
        for (String cmdName : commands) {
            log.info String.format("Starting %s command:", cmdName)
            Command cmd = context.getRegisteredCommand(cmdName)
            cmd.execute(context)
            log.info String.format("Finished %s command.", cmdName)
        }
    }
}
