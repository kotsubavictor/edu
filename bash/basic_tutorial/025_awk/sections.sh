#!/bin/bash
echo -e  '1 2 3\r\n4 5 6\r\n7 8 9' | awk 'BEGIN{print "Begin:Once"}'
echo "======================================"

echo -e '1 2 3\r\n4 5 6\r\n7 8 9' | awk '{print "Mid:per each line"}'
echo "======================================"

echo -e  '1 2 3\r\n4 5 6\r\n7 8 9' | awk 'END{print "End: once"}'
echo "======================================"

echo -e  '1 2 3\r\n4 5 6\r\n7 8 9' | awk 'BEGIN{print "Begin:Once"} {print "Mid:per each line"} END{print "End: once"}'