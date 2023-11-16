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

# expr_stmt: testlist_star_expr assign_part?
#
# testlist_star_expr : (test | star_expr) (COMMA (test | star_expr))* COMMA?
#
# assign_part
#     : (ASSIGN testlist_star_expr)* (ASSIGN yield_expr)?
#     | COLON test (ASSIGN testlist)?
#     | op=( ADD_ASSIGN
#          | SUB_ASSIGN
#          | MULT_ASSIGN
#          | AT_ASSIGN
#          | DIV_ASSIGN
#          | MOD_ASSIGN
#          | AND_ASSIGN
#          | OR_ASSIGN
#          | XOR_ASSIGN
#          | LEFT_SHIFT_ASSIGN
#          | RIGHT_SHIFT_ASSIGN
#          | POWER_ASSIGN
#          | IDIV_ASSIGN
#          )
#       (yield_expr | testlist)
#     ;

# Yield tests (should not be used outside the function)
def f():
    # test ASSIGN yield_expr
    x = yield

    # test COMMA test COMMA ASSIGN test COMMA star_expr ASSIGN yield_expr
    x, [*t], = y, *z = yield

    # test '+=' yield_expr
    x += yield

# test ASSIGN testlist_star_expr
z = 1, *y

# test ASSIGN test COMMA test ASSIGN test COMMA star_expr COMMA
x = y, a = z, *q,

# test COLON test
x: int

# COLON test ASSIGN testlist
x: int = 8

# test '-=' testlist
x -= 9