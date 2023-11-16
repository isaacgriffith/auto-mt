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

# with_stmt: ASYNC? WITH with_item (COMMA with_item)* COLON suite

# WITH with_item COLON suite
with open("with_stmt.py"):
    pass

# WITH with_item COMMA with_item COLON suite
with open("with_stmt.py") as a, open("with_stmt.py") as b:
    pass

# async_stmt must be inside async function
async def f():
    # ASYNC with_stmt
    async with open("with_stmt.py") as f:
        pass