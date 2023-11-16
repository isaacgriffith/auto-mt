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

import groovy.util.logging.Slf4j

import java.util.concurrent.TimeUnit

/**
 * Utility class providing a means to correctly format time for logs
 *
 * @author Isaac D. Griffith
 * @version 1.0.0
 */
@Slf4j
class TimePrinter {

    static String format(long duration, String heading = "Process") {
        long days = TimeUnit.MILLISECONDS.toDays(duration)
        duration -= TimeUnit.DAYS.toMillis(days)
        long hours = TimeUnit.MILLISECONDS.toHours(duration)
        duration -= TimeUnit.HOURS.toMillis(hours)
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
        duration -= TimeUnit.MINUTES.toMillis(minutes)
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)

        return "$heading took: $days days, $hours hours, $minutes minutes, $seconds seconds"
    }
}
