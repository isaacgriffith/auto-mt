/*
 * MIT License
 *
 * SiliconCode AutoMT - Library
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
package dev.siliconcode.auto_mt.lib.parserop.rust

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.rust.RustParser
import dev.siliconcode.auto_mt.parsers.rust.RustParserBaseListener

class RustFileAndTypeExtractor extends RustParserBaseListener {

    ModelBuilder modelBuilder
    boolean inTypeDecl = false

    RustFileAndTypeExtractor(ModelBuilder builder) {
        modelBuilder = builder
    }

    @Override
    void enterCrate(RustParser.CrateContext ctx) {
        super.enterCrate(ctx)
    }

    @Override
    void exitCrate(RustParser.CrateContext ctx) {
        super.exitCrate(ctx)
    }

    @Override
    void enterModule(RustParser.ModuleContext ctx) {
        super.enterModule(ctx)
    }

    @Override
    void exitModule(RustParser.ModuleContext ctx) {
        super.exitModule(ctx)
    }

    @Override
    void enterStruct_(RustParser.Struct_Context ctx) {
        super.enterStruct_(ctx)
    }

    @Override
    void exitStruct_(RustParser.Struct_Context ctx) {
        super.exitStruct_(ctx)
    }

    @Override
    void enterEnumeration(RustParser.EnumerationContext ctx) {
        super.enterEnumeration(ctx)
    }

    @Override
    void exitEnumeration(RustParser.EnumerationContext ctx) {
        super.exitEnumeration(ctx)
    }

    @Override
    void enterTrait_(RustParser.Trait_Context ctx) {
        super.enterTrait_(ctx)
    }

    @Override
    void exitTrait_(RustParser.Trait_Context ctx) {
        super.exitTrait_(ctx)
    }

    @Override
    void enterType_(RustParser.Type_Context ctx) {
        super.enterType_(ctx)
    }

    @Override
    void exitType_(RustParser.Type_Context ctx) {
        super.exitType_(ctx)
    }

    @Override
    void enterNeverType(RustParser.NeverTypeContext ctx) {
        super.enterNeverType(ctx)
    }

    @Override
    void exitNeverType(RustParser.NeverTypeContext ctx) {
        super.exitNeverType(ctx)
    }
}
