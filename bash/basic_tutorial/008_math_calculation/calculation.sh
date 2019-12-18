#!/bin/bash
A=2
B=3
let C=A+B
C1=$[ A + B ]
C2=$(expr $A + $B)
C3=$(( A + B ))

echo "A+B=C; $A+$B=$CB"
echo "$C1"
echo "$C2"
echo "$C3"