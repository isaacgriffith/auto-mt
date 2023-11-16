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

# logical_test
#     : comparison
#     | NOT logical_test
#     | logical_test op=AND logical_test
#     | logical_test op=OR logical_test
#     ;
#
# comparison
#     : comparison (LESS_THAN | GREATER_THAN | EQUALS | GT_EQ | LT_EQ | NOT_EQ_1 | NOT_EQ_2 | optional=NOT? IN | IS optional=NOT?) comparison
#     | expr
#     ;

# expr EQUALS expr
a == b

# not expr
not a

# expr AND expr
a and b

# expr OR expr
a or b

# expr LESS_THAN expr
a < b

# expr GREATER_THAN expr
a > b

# expr GT_EQ expr
a >= b

# expr LT_EQ expr
a <= b

# expr NOT_EQ_2 expr
a != b

# expr IN expr
a in b

# expr NOT IN expr
a not in b

# expr IS expr
a is b

# expr IS NOT expr
a is not b