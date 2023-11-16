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

# expr
#     : AWAIT? atom trailer*
#     | <assoc=right> expr op=POWER expr
#     | op=(ADD | MINUS | NOT_OP) expr
#     | expr op=(STAR | DIV | MOD | IDIV | AT) expr
#     | expr op=(ADD | MINUS) expr
#     | expr op=(LEFT_SHIFT | RIGHT_SHIFT) expr
#     | expr op=AND_OP expr
#     | expr op=XOR expr
#     | expr op=OR_OP expr
#     ;

# atom
"123"

# AWAIT atom
await 5

# atom trailer
"1231".lower()

# atom trailer trailer
"1231".lower().upper()

# AWAIT atom trailer trailer
await "1231".lower().upper()

# expr op=POWER expr op=POWER expr
2 ** 2 ** 3

# ADD expr
+6

# MINUS expr
-6

# NOT_OP expr
~6

# expr STAR expr
6 * 7

# expr DIV expr
6 / 7

# expr MOD expr
6 % 8

# expr IDIV expr
6 // 7

# expr AT expr
6 @ 2

# expr ADD expr
6 + 1

# expr MINUS expr
7 - 9

# expr LEFT_SHIFT expr
8 << 9

# expr RIGHT_SHIFT expr
4 >> 1

# expr op=AND_OP expr
4 & 6

# expr op=XOR expr
4 ^ 7

# expr op=OR_OP expr
7 | 1