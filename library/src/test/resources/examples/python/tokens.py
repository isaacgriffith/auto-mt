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

DECIMAL = 0000000000
DECIMAL = 1234567890
OCT_1   = 0o01234567
OCT_2   = 0O01234567
HEX_1   = 0x0123456789abcdef
HEX_2   = 0X0123456789ABCDEF
BIN_1   = 0b01
BIN_1   = 0B01
IMAG_1  = 0123456789.0123456789j
IMAG_2  = 0123456789J
FLOAT_1 = 0123456789.e1234567890
FLOAT_2 = .0123456789E1234567890

LINE_JOIN_EXPR  = 2 + \
                  2

SHORT_STRING_1 = 'a \'\\ b'
SHORT_STRING_2 = "a \"\\ b"
LONG_STRING_1  = b""" asdf " qwer 
zxcv
"""
LONG_STRING_1  = r''' aasdf ' qwer 
zxcv
'''
STRING_WITH_LINE_JOIND = "a \
b"

# COMMENT