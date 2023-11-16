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


# First, check this one
# import_stmt: IMPORT dotted_as_names
# dotted_as_names: dotted_as_name (COMMA dotted_as_name)*;
# dotted_as_name: dotted_name (AS NAME)?;

# IMPORT dotted_name
import collections.abc

# IMPORT dotted_name AS NAME
import collections.abc as ss

# IMPORT dotted_name AS NAME COMMA dotted_name
import collections.abc as ss, itertools

# Then check this
# import_from: FROM   ((DOT | ELLIPSIS)* dotted_name | (DOT | ELLIPSIS)+)
#              IMPORT (STAR | OPEN_PAREN import_as_names CLOSE_PAREN | import_as_names);
# import_as_names: import_as_name (COMMA import_as_name)*;
# import_as_name: NAME (AS NAME)?;

# FROM dotted_name IMPORT import_as_name
from classdef import bar as b

# FROM DOT IMPORT import_as_name
from . import bar

# FROM DOT DOT DOT IMPORT import_as_name
from . . . import bar

# FROM DOT dotted_name IMPORT import_as_name
from .classdef import bar

# FROM dotted_name IMPORT STAR
from sys import *

# FROM dotted_name IMPORT import_as_name COMMA import_as_name
from collections import bar, baz

# FROM dotted_name IMPORT OPEN_PAREN import_as_name CLOSE_PAREN
from collections import (bar)