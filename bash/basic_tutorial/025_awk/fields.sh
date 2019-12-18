#!/bin/bash
echo "All lines of data"
echo -e  '1 2 3\r\n4 5 6\r\n7 8 9' | awk '{print $0}'
echo "======================================"

echo "First collumn"
echo -e  '1 2 3\r\n4 5 6\r\n7 8 9' | awk '{print $1}'
echo "======================================"

echo "Second collumn"
echo -e  '1 2 3\r\n4 5 6\r\n7 8 9' | awk '{print $2}'
echo "======================================"

echo "Third collumn"
echo -e  '1 2 3\r\n4 5 6\r\n7 8 9' | awk '{print $3}'
echo "======================================"