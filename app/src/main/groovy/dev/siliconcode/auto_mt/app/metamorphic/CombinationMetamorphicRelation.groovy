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
 * A metamorphic relation which is a combination of other metamorphic relations
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class CombinationMetamorphicRelation extends AbstractMetamorphicRelation {

    /** Combined metamorphic relations */
    def relations = []
    /** Operator used to combine the metamorphic relations */
    def combiningOperator

    /**
     * Constructs a new CombinedMetamorphicRelation with the given name and
     * metamorphic relations
     *
     * @param name       Name of this metamorphic relation
     * @param relations  Metamorphic relations to combine
     * @param operator   Operator used to combine the metamorphic relations
     */
    CombinationMetamorphicRelation(name, relations, operator) {
        super(name)
        this.relations = relations
        this.combiningOperator = operator
    }
}
