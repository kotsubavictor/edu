#!/bin/bash
CURRENT_DIRECTORY=$(pwd)
START=0
END=0
DIFFERENCE=0

START=$(date +%s)
echo "Current directory: $CURRENT_DIRECTORY"
sleep 1
END=$(date +%s)
DIFFERENCE=$(( END - START ))
echo "Execution time: $DIFFERENCE"