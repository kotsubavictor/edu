#!/bin/bash
FILE_CONTENT="Blank"

read -r FILE_CONTENT < ./file_input.txt

echo ""
echo "=========================="
echo "FILE_CONTENT: $FILE_CONTENT"