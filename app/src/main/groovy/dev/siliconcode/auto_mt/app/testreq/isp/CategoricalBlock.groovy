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

import groovy.transform.ToString

/**
 * A block partitioning categorical data
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@ToString(includeNames = false, includePackage = false)
class CategoricalBlock extends Block {

    /** Value of this block */
    final def value;

    /**
     * Constructs a new CategoricalBlock with the given name and value
     *
     * @param name  Name of this block
     * @param value Value of this block
     */
    CategoricalBlock(name, value) {
        super(name)
        this.value = value
    }

    /** {@inheritDoc} */
    @Override
    def generateRandomValue() {
        return null
    }

    /** {@inheritDoc} */
    @Override
    def generateBoundaryValue() {
        return null
    }
}
