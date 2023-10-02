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

/**
 * A block partitioning a domain of numerical data
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class NumericalBlock extends Block {

    /** Random number generator */
    private final Random rand = new Random()
    /** Minimum value of this block */
    def min = Double.NEGATIVE_INFINITY
    /** Maximum value of this block */
    def max = Double.POSITIVE_INFINITY

    /**
     * Constructs a new NumericalBlock with the given name and default min and
     * max values of Double.NEGATIVE_INFINITY and Double.POSITIVE_INFINITY
     *
     * @param name Name of this block
     */
    NumericalBlock(name, min = Double.NEGATIVE_INFINITY, max = Double.POSITIVE_INFINITY) {
        super(name)
        this.min = min
        this.max = max
    }

    /** {@inheritDoc} */
    @Override
    def generateRandomValue() {
        return min + Random.nextDouble() * (max - min)
    }

    /** {@inheritDoc} */
    @Override
    def generateBoundaryValue() {
        return rand.nextBoolean() ? min : max
    }
}
