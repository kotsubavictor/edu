#!/bin/bash
FILE_LIST="cat.log cat1.log"
FILE_PATTERN=./files/cat[1]*.log
FILE=

NUMBER=

WORDS=('firs' 'second' 'third')
WORD=


echo "Iterate through files via pattern $FILE_PATTERN"
for FILE in $FILE_PATTERN ; do
  echo "$FILE"
done

echo "Iterate through a predefined list of files: $FILE_LIST"
for FILE in $FILE_LIST ; do
    echo "$FILE"
done

echo "Iterate through a number range: {1..5}"
for NUMBER in {1..5} ; do
    echo "$NUMBER"
done

echo "Iterate through an array : $WORDS"
for WORD in "${WORDS[@]}" ; do
    echo "$WORD"
done