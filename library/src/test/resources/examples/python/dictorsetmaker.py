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

# dictorsetmaker
#     : (test COLON test | POWER expr) (COMMA (test COLON test | POWER expr))* COMMA? // key_datum_list
#     | test COLON test comp_for                                                      // dict_comprehension
#     | testlist_comp
#     ;

# test COLON test
{d : y}

# POWER expr
{**x}

# test COLON test COMMA test COLON test
{d : y, x : z}

# test COLON test COMMA test COLON test COMMA
{d : y, x : z,}

# POWER expr COMMA test COLON test
{**x, d : y}

# test COLON test COMMA POWER expr
{d : y, **x}

# test COLON test comp_for
{d : y for d, y in x}

# testlist_comp
{x, q, y}