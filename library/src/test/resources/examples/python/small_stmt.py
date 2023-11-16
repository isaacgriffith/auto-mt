#
# MIT License
#
# SiliconCode AutoMT - Library
# Copyright (c) 2023 SiliconCode, LLC and Isaac Griffith, PhD
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all
# copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# SOFTWARE.
#

# del_stmt: DEL exprlist

del x, d[1], await f

# pass_stmt: PASS
for i in u: pass

# break_stmt: BREAK
for i in u: break

# continue_stmt: CONTINUE
for i in u: continue

# return_stmt: RETURN testlist?
def f():
    # RETURN
    return
def g():
    # RETURN testlist
    return 1, 3

# [Python 3] raise_stmt: RAISE (test (FROM test)?)?

# RAISE test FROM test
raise a from b

# RAISE test
raise a

try:
    a
except:
    # RAISE
    raise

# global_stmt: GLOBAL name (COMMA name)*

# GLOBAL name
global a

# GLOBAL name COMMA name
global a, b

# assert_stmt: ASSERT test (COMMA test)?

# ASSERT test
assert a

# ASSERT test COMMA test
assert a, b

# nonlocal_stmt: NONLOCAL name (COMMA name)*

# NONLOCAL name
nonlocal a

# NONLOCAL name (COMMA name)
nonlocal a, v