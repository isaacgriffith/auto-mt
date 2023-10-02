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
package dev.siliconcode.auto_mt.app.metamorphic

/**
 * Representation of a Relation which either transforms input data or compares output results
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class MetamorphicRelation extends AbstractMetamorphicRelation {

    /** The input transformation relation */
    Relation inputRelation
    /** The output comparison relation */
    Relation outputRelation

    /**
     * Constructs a new MetamorphicRelation with the given name and relations
     *
     * @param name       Name of this metamorphic relation
     * @param ir         Input relation
     * @param or         Output relation
     */
    MetamorphicRelation(String name,ir, or) {
        super(name)
        this.inputRelation = ir
        this.outputRelation = or
    }
}
