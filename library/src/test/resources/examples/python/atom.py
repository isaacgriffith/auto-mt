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

# atom
#     : OPEN_PAREN (yield_expr | testlist_comp)? CLOSE_PAREN
#     | OPEN_BRACKET testlist_comp? CLOSE_BRACKET
#     | OPEN_BRACE dictorsetmaker? CLOSE_BRACE
#     | REVERSE_QUOTE testlist COMMA? REVERSE_QUOTE
#     | dotted_name
#     | ELLIPSIS
#     | name
#     | PRINT
#     | EXEC
#     | MINUS? number
#     | NONE
#     | STRING+
#     ;

# OPEN_PAREN CLOSE_PAREN
()

# OPEN_PAREN yield_expr CLOSE_PAREN
def f():
    (yield)

# OPEN_PAREN testlist_comp CLOSE_PAREN
(x, a, q == 1)

# OPEN_BRACKET CLOSE_BRACKET
[]

# OPEN_BRACKET testlist_comp CLOSE_BRACKET
[1, 3, b, p == 1]

# OPEN_BRACE CLOSE_BRACE
{}

# OPEN_BRACE dictorsetmaker CLOSE_BRACE
{x : y for x, y in a}

# dotted_name
b.a

# ELLIPSIS
...

# name
f

# number
90

# MINUS number
-1

# NONE
None

# STRING
"12312313"

# STRING STRING
"1231231" "123151"