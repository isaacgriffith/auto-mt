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
 * A characteristic is a set of blocks which are associated with a single input parameter of the metamorphic relation
 * under test.
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class Characteristic {

    /** The name of the characteristic */
    def name
    /** The set of blocks associated with this characteristic */
    def blocks

    /**
     * Constructs a new Characteristic with the given name and set of blocks
     *
     * @param name  Name of this characteristic
     * @param blocks    Set of blocks associated with this characteristic
     */
    Characteristic(name = "", blocks = []) {
        this.name = name
        this.blocks = blocks
    }

    /**
     * Selects the next unselected block of this characteristic, unless all have already been selected, in
     * the latter case, a random block is selected.
     *
     * @return a block of this characteristic
     */
    def selectBlock() {
        if (allSelected()) {
            Random rand = new Random()
            return blocks[rand.nextInt(blocks.size())]
        } else {
            return blocks.find { !it.selected }
        }
    }

    /**
     * Tests whether all blocks associated with this Characteristic have been selected
     *
     * @return True, if all blocks have been selected, False otherwise
     */
    def allSelected() {
        return blocks.size() == blocks.count { it.selected }
    }
}
