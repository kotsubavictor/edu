#!/bin/bash
echo "Original file"
cat files/data.log
echo ""
echo "===================="

echo "Display by pattern: sed -n '/col[2-4]1/p' files/data.log"
sed -n '/col[2-4]1/p' files/data.log
echo "===================="

echo "Delete lines 2-4: sed '2,4d' files/data.log"
sed '2,4d' files/data.log
echo "===================="

sed '1i\
Inserted text before line 1:' files/data.log
echo "===================="

sed '1a\
Appended text after line 1:' files/data.log
echo "===================="

sed '/col[2,4]1/a\
Find line by regexp and append data:' files/data.log
echo "===================="

echo "Remove lines by pattern: sed '/col[2,4]1/d' files/data.log"
sed '/col[2,4]1/d' files/data.log
echo "===================="

echo "Replacing lines by pattern: sed '/col[2,4]1/c String as text' files/data.log"
sed '/col[2,4]1/c\
Replace by this string
' files/data.log
echo "===================="

echo "Executing several expressions"
sed -e '/col21/i\
before line: ' -e '/col21/a\
:after line' files/data.log
echo "===================="

echo "Regexp substitution: sed 's/col[2,4]1/***/g' files/data.log"
sed 's/col[2,4]1/***/g' files/data.log
echo "===================="