#!/bin/bash
awk 'BEGIN{print 1+1}'
awk 'BEGIN{print 1-1}'
awk 'BEGIN{print 2*3}'
awk 'BEGIN{print 3/2}'

cat files/data.csv | awk 'BEGIN{RS=";"; count=0} {count++; print count ". " $0} END{print "Number or records: " count}'