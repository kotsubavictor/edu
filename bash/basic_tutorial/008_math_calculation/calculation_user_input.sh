#!/bin/bash
A=0
B=0

read -rp "A:" A
read -rp "B:" B

# bc is used for calculating floating points
C=$(bc <<< "$A + $B")
echo "A + B = $C"
