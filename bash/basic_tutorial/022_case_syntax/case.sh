#!/bin/bash

WORD="test"
PATTERN="p?ng"

read -p "Type anything: " WORD

case $WORD in
"test")
  echo "It is a test word"
  ;;
$PATTERN)
  echo "String is compatible with pattern: $PATTERN"
  ;;
*)
  echo "Other words: $WORD"
  ;;
esac