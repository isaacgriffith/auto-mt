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

package dev.siliconcode.auto_mt.app

import dev.siliconcode.auto_mt.app.cli.GenerateCommand
import picocli.CommandLine
import picocli.CommandLine.Command

/**
 * Main entry point for the AutoMT application.
 */
@Command(name = "automt", description = "Auto MT", subcommands = [GenerateCommand.class])
class App {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Main entry point for the AutoMT application.
     *
     * @param args Command line arguments
     */
    static void main(String[] args) {
        CommandLine cmdLine = new CommandLine(new App())
        if (args.length > 0) {
            printBanner()
            System.exit(cmdLine.execute(args))
        } else {
            printBanner()
            cmdLine.usage(System.out)
            System.exit(0)
        }
    }

    /**
     * Prints the AutoMT banner to the console.
     */
    private static void printBanner() {
        println("""
        $ANSI_CYAN      _____ _ ___                  ______          __  $ANSI_RESET   
        $ANSI_CYAN     / ___/(_) (_)________  ____  / ____/___  ____/ /__  $ANSI_RESET 
        $ANSI_CYAN     \\__ \\/ / / / ___/ __ \\/ __ \\/ /   / __ \\/ __  / _ \\  $ANSI_RESET
        $ANSI_CYAN    ___/ / / / / /__/ /_/ / / / / /___/ /_/ / /_/ /  __/  $ANSI_RESET
        $ANSI_CYAN   /____/_/_/_/\\___/\\____/_/ /_/\\____/\\____/\\__,_/\\___/  $ANSI_RESET 
        $ANSI_CYAN           /   | __  __/ /_____  /  |/  /_  __/  $ANSI_RESET         
        $ANSI_CYAN          / /| |/ / / / __/ __ \\/ /|_/ / / /  $ANSI_RESET            
        $ANSI_CYAN         / ___ / /_/ / /_/ /_/ / /  / / / /  $ANSI_RESET             
        $ANSI_CYAN        /_/  |_\\__,_/\\__/\\____/_/  /_/ /_/  $ANSI_RESET

        $ANSI_YELLOW                (C) 2023 SiliconCode, LLC  $ANSI_RESET
        $ANSI_YELLOW              https://siliconcode.dev/automt  $ANSI_RESET                                                                   
        """)
    }
}
