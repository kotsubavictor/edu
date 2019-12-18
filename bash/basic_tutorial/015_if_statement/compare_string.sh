#!/bin/bash
# Without erros
GREETING="Blank"

read -rp "Did you say anything? " GREETING

if [ "$GREETING" = "hello" ]; then
  echo $GREETING
elif [ "$GREETING" = "bey" ]; then
  echo "See you."
elif [ "$GREETING" \> "hello" ]; then
  echo "greater"
else
  echo "less"
fi