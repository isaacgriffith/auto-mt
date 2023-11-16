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

# varargslist
#     : (vardef_parameters COMMA)? (varargs (COMMA vardef_parameters)? (COMMA varkwargs)? | varkwargs) COMMA?
#     | vardef_parameters COMMA?
#     ;
#
# vardef_parameters
#     : vardef_parameter (COMMA vardef_parameter)*
#     ;
#
# vardef_parameter
#     : name (ASSIGN test)?
#     ;
#
# varargs
#     : STAR name
#     ;
#
# varkwargs
#     : POWER name
#     ;

# vardef_parameters COMMA
# NAME COMMA
lambda x,: 5

# vardef_parameters COMMA
# NAME COMMA STAR COMMA NAME COMMA
lambda x, *, y,: 5

# vardef_parameters
# NAME COMMA STAR COMMA NAME ASSIGN test
lambda x, *, y=7: 5

# varargs
lambda *y: 8

# varargs COMMA vardef_parameters COMMA
lambda *y, z: 8

# vardef_parameters COMMA varargs COMMA vardef_parameters COMMA
lambda a, b, *y, z: 8

# vardef_parameters COMMA varargs COMMA vardef_parameters COMMA varkwargs
lambda a, b, *y, z, **k: 8

# varkwargs
lambda **z: 8

# vardef_parameters COMMA varkwargs
lambda a, b, c, **k: 8