#!/bin/bash
# Without erros
INPUT=0
VALUE=5


read -rp "Select number from 0 - 9? " INPUT

if [ $INPUT -gt $VALUE ]; then
  echo "It is greater than $VALUE"
elif [ $INPUT -lt $VALUE ]; then
  echo "It is less than $VALUE"
elif [ $INPUT -eq $VALUE ]; then
  echo "It is equal to $VALUE"
fi

if [ $INPUT -ne $VALUE ]; then
  echo "It is not equal to $VALUE"
fi

if [ $INPUT -ge $VALUE ]; then
  echo "It is greater or equeal to $VALUE"
fi

if [ $INPUT -le $VALUE ]; then
  echo "It is less or equal to $VALUE"
fi