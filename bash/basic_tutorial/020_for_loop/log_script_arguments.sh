#!/bin/bash
COUNT=0

for arg in "$@" ; do
  (( COUNT++ ))
  echo "$COUNT. argument: $arg"
done