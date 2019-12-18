#!/bin/bash
cat files/data.csv | awk 'BEGIN{FS=";"} /account/ {print $1 " " $3}'
echo "======================================"
cat files/data.csv | awk -F ";" '/account/ {print $1 " " $3}'
echo "======================================"