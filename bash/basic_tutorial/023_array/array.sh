#!/bin/bash

FILES=($(ls ./files))

echo -e "File\t\t\t\tWritable"

for FILE in "${FILES[@]}" ; do
    echo -n "$FILE"
    echo -ne "\t\t\t\t"
    [ -w "./files/$FILE" ] && echo "YES" || echo "NO"
done