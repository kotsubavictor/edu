#!/bin/bash
COUNTER=0
AMOUNT=5

echo "Variant #1"
while [ $COUNTER -lt $AMOUNT ]; do
    echo "Iteration #$COUNTER"
    (( COUNTER++ ))
done

echo "Variant #2"
COUNTER=0
while (( COUNTER < AMOUNT )); do
    echo "Iteration #$COUNTER"
    (( COUNTER++ ))
done