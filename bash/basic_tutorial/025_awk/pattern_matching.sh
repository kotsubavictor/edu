#!/bin/bash
cat files/data.log | awk '/account/ {print $1 " " $3}'
echo "======================================"

cat files/data.log | awk '$2 =="account" {print $1 " " $3}'
echo "======================================"

cat files/data.log | awk '{print "Number of fields:" NF}'
echo "======================================"

cat files/data.log | awk '{print "Display last field:" $NF}'
echo "======================================"