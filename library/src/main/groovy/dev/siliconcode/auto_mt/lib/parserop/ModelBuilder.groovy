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
package dev.siliconcode.auto_mt.lib.parserop

import com.google.common.collect.Sets
import dev.siliconcode.auto_mt.lib.code.Method
import dev.siliconcode.auto_mt.lib.code.Parameter
import dev.siliconcode.auto_mt.lib.code.Project
import dev.siliconcode.auto_mt.lib.code.ProjectFile
import dev.siliconcode.auto_mt.lib.code.Script
import dev.siliconcode.auto_mt.lib.code.Type
import dev.siliconcode.auto_mt.lib.code.TypeType
import groovy.util.logging.Slf4j
/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class ModelBuilder {

    ProjectFile file
    Script script
    Parameter currentParam
    Stack<Type> types = []
    Stack<Method> methods = []
    Stack<Set<String>> scopes = []
    Stack<Integer> decisionCounts = new Stack<>()
    Stack<Integer> returnCounts = new Stack<>()
    Stack<Integer> stmtCounts = new Stack<>()
    Stack<Integer> variableCounts = new Stack<>()

    Map<String, Type> typeMap = [:]

    ModelBuilder(Project proj, ProjectFile file) {
        if (!proj || !file) {
            throw new IllegalArgumentException("Project and File must not be null")
        }

        this.file = file
        this.script = file.getScript()
    }

    //////////////////////
    // Setup Methods
    //////////////////////
    void setFile(ProjectFile file) {
        this.file = file
        this.script = file.script
    }

    //////////////////////
    // Types
    //////////////////////
    void endType() {
        if (types) {
            Type type = types.pop()
//            if (types.isEmpty()) {
//                if (file.getTypeByName(type.getName()) == null)
//                    file.addType(type)
//            } else {
//                if (types.peek().getTypeByName(type.getName()) == null)
//                    types.peek().addType(type)
//            }
        }
    }

    void findOrCreateType(String typeName, TypeType typeType, int start = 1, int stop = 1) {
        Type type
        if (types) {
            type = types.peek().getTypeByName(typeName)
        } else {
            type = script.types.find { it.getName() == typeName }
        }

        if (type != null) {
            type.setStart(start)
            type.setEnd(stop)
            types.push(type)
        } else
            createType(typeName, typeType, start, stop)
    }

    void createType(String typeName, TypeType typeType, int start, int stop) {
        log.info "Creating Type with name: $typeName"
        Type type = findType(typeName)

        if (type) {
            type.setStart(start)
            type.setEnd(stop)
            type.setType(typeType)

            if (typeType != TypeType.UNKNOWN) {
                if (types) {
                    types.peek().types += type
                }

                script.types += type
                types.push(type)
            }
        } else if (types && types.peek().getTypeByName(typeName) != null) {
            types.push(types.peek().getTypeByName(typeName))
        } else {
            type = Type.builder()
                    .type(typeType)
                    .name(typeName)
                    .start(start)
                    .end(stop)
                    .build()
            if (types) {
                types.peek().types += type
            }

            script.types += type
            types.push(type)
        }
    }

    ///////////////////
    // Methods
    ///////////////////
    void findMethod(String signature) {
        Method meth = this.script.findMethodBySignature(signature)

        if (meth) {
            methods.push(meth)
            scopes.push(Sets.newHashSet())
        } else {
            createMethod(signature, 1, 1)
        }
    }

    void createMethod(String name, int start, int end) {
        log.info "Creating Method with name: $name"
        if (types) {
//            Method method = Method.findFirst("compKey = ?", (String) "${types.peek().getCompKey()}#${name}()")
//
//            if (method) {
//                method.setEnd(end)
//                method.setStart(start)
//                method.setConstructor(false)
//                methods.push(method)
//            } else {
                Method method = Method.builder()
                        .name(name)
                        .start(start)
                        .end(end)
                        .constructor(false)
                        .build()
                if (types.peek())
                    types.peek().methods += method
                else
                    script.functions += method
                methods.push(method)
//            }
        }

        scopes.push(Sets.newHashSet())
        decisionCounts.push(0)
        returnCounts.push(0)
        stmtCounts.push(0)
        variableCounts.push(0)
    }

    void findConstructor(String signature) {
        Method cons = types ? types.peek().methods.find { it.getName() == signature && it.constructor } : null

        if (cons) {
            methods.push(cons)
            scopes.push(Sets.newHashSet())
        }
    }

    void createConstructor(String name, int start, int end) {
        if (types) {
            Method cons = Method.builder()
                    .name(name)
                    .start(start)
                    .end(end)
                    .constructor(true)
                    .build()
            types.peek().methods += cons
            methods.push(cons)

        }
        scopes.push(Sets.newHashSet())
        decisionCounts.push(0)
        returnCounts.push(0)
        stmtCounts.push(0)
        variableCounts.push(0)
    }

    void createMethodParameter() {
        currentParam = Parameter.builder().varg(false).build()
        if (methods && methods.peek() != null) {
            methods.peek().parameters += currentParam
        }
    }

    void setVariableParameter(boolean varg) {
        currentParam.setVarg(varg)
    }

    void setKeywordParameter(boolean kwarg) {
        currentParam.setKwarg(kwarg)
    }

    void setParameterName(String name) {
        currentParam.setName(name)
    }

    void finishMethod() {
        if (!methods.isEmpty()) {
            Method member = methods.pop()
            if (member instanceof Method) {
                ((Method) member).setCounts(variableCounts.pop(), returnCounts.pop(), stmtCounts.pop(), decisionCounts.pop())
            }
        }

    }

    ///////////////////
    // Handle Code
    ///////////////////
    void processExpression(String expr) {
        expr = cleanExpression(expr)
        def list = expr.split(/\s+/)

        Type type
        list.each { str ->
            String[] components = str.split(/\./)
            components.eachWithIndex { comp, index ->
                if (comp.find(/\(.*\)/)) {
                    String args = comp.find(/\(.*\)/)
                    args = args.substring(args.indexOf("(") + 1, args.lastIndexOf(")"))
                    int numParams = args.split(",").size()
                   //type = handleMethodCall(type, comp, numParams)
                } // else
                    //type = handleNonMethodCall(type, comp, components, index)
                // addUseDependency(type as Type)
            }
        }
    }

    String cleanExpression(String expr) {
        expr = expr.replaceAll(/[+\-=<>?:;!*&|^]/, " ") // remove all operators
        expr = expr.replaceAll(/((?<![\\])['"])((?:.(?!(?<![\\])\1))*.?)\1/, "String") // remove string literals
        expr = expr.replaceAll(/\bTrue\b|\bFalse\b/, " ") // remove boolean literals
        expr = expr.replaceAll(/\b(0[xX][A-Fa-f\d_]+(\.[A-Fa-f\d_]+)?|0[bB][10_]+(\.[10_]+)?|[\d_]+(\.[\d_]+)?([eE][\d_]+)?)[fFdDlL]?\b/, "Number")
        // remove numeric literals
        expr = expr.replaceAll(/\s\s/, " ") // remove double spaces
        expr = expr.replaceAll(/\(\s+/, "(")
        expr = expr.replaceAll(/\s+\)/, ")")
        expr = expr.replaceAll(/,\s+/, ",")

        return expr
    }

    Type handleIdentifier(Type type, String comp) {
        Type t = null

        if (type) {
            if (type.hasFieldWithName(comp)) {
                t = createFieldUse(type, comp)
            } else {
                t = type.getTypeByName(comp)
            }
        } else {
            if (checkIsLocalVar(comp)) {
                // TODO Finish me
                // set type
            } else if (types.peek().hasFieldWithName(comp)) {
                t = createFieldUse(types.peek(), comp)
            } else if (types.peek().hasTypeWithName(comp)) {
                t = types.peek().getTypeByName(comp)
            }
        }


        return t
    }

    protected boolean checkIsLocalVar(String name) {
        !scopes.isEmpty() && scopes.peek().contains(name)
    }

    ///////////////////
    // Utilities
    ///////////////////
    /**
     * Finds a type with the given name, first searching the current namespace, then searching fully specified imported types,
     * then checking the types defined in known language specific wildcard imports, then checking automatically included language
     * types, and finally checking unknown wildcard imports. If the type is not defined within the context of the system under analysis
     * it will be constructed as an UnknownType.
     *
     * @param name The name of the type
     * @return The Type corresponding to the provided type name.
     */
    Type findType(String name, boolean createUnknown = false) {
        log.info "Finding type with name: $name"
        Type candidate = null

        if (types) {
            candidate = types.find { it.getName() == name }
        }

        candidate
    }

    void incrementMethodVariableCount() {
        if (variableCounts) {
            variableCounts.push(variableCounts.pop() + 1)
        }
    }

    void incrementMethodDecisionCount() {
        if (decisionCounts) {
            decisionCounts.push(decisionCounts.pop() + 1)
        }
    }

    void incrementMethodReturnCount() {
        if (returnCounts) {
            returnCounts.push(returnCounts.pop() + 1)
        }
    }

    void incrementMethodStatementCount() {
        if (stmtCounts) {
            stmtCounts.push(stmtCounts.pop() + 1)
        }
    }
}
