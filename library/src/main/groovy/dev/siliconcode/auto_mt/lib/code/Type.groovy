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
package dev.siliconcode.auto_mt.lib.code

import groovy.transform.builder.Builder

@Builder
class Type {

    Type[] types
    Method[] methods
//    Field[] fields
    TypeType type
    String name
    int start
    int end

    Type getTypeByName(String name) {
        return types.find { it.name == name }
    }

    /**
     * Returns true if this type has a type with the given name
     */
    boolean hasTypeWithName(String name) {
        return types.find { it.name == name } != null
    }

    /**
     * Returns true if this type has a field with the given name
     */
    boolean hasFieldWithName(String name) {
        return fields.find { it.name == name } != null
    }

    boolean hasMethodWithName(String s) {
        boolean meth = methods.find { it.name == s } != null
        if (!meth) {
            for (Type t : types) {
                if (t.hasMethodWithName(s)) {
                    return true
                }
            }
        } else {
            return true
        }
        return false
    }

    Method getMethodByName(String s) {
        Method meth = methods.find { it.name == s }
        if (!meth) {
            for (Type t : types) {
                if (t.hasMethodWithName(s)) {
                    return t.getMethodByName(s)
                }
            }
        } else {
            return meth
        }
    }
}

enum TypeType {
    CLASS,
    INTERFACE,
    ENUM,
    STRUCT,
    UNION,
    TYPEDEF,
    ANNOTATION,
    UNKNOWN
}