#!/bin/bash

FILE=
DATA=

while [ $# -gt 0 ]; do
    case $1 in
    -f)
      FILE=$2
      shift
      shift
      ;;
    -d)
      DATA=$2
      shift
      shift
      ;;
    -h)
      echo "Exiting because, help function is called."
      shift
      echo "State before exiting was: file=$FILE, data=$DATA"
      exit 0;
      ;;
    *)
      echo "Another argument, that will not be processed: $1"
      shift
      ;;
    esac
done