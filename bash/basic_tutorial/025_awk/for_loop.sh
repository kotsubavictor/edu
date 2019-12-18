#!/bin/bash
cat files/data.csv | awk 'BEGIN{FS=";"} { for(i=1; i <= NF; i++) {print "field #" i " value: " $i} }'