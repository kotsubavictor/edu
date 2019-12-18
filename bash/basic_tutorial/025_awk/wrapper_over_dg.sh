#!/bin/bash

ARGUMENTS=("-l" "files" "-e" "log")
[ $# -gt 0 ] && ARGUMENTS=("$@")

LOCATION=*
EXTENSION=*
SIZE=0

while getopts "l:e:h" opt "${ARGUMENTS[@]}"; do
    case ${opt} in
    l)
      LOCATION=${OPTARG}
      ;;
    e)
      EXTENSION=${OPTARG}
      ;;
    h)
      echo "$0 [-l directory] [-e file extension]"
      exit 1
      ;;
    \?)
      echo "$0 [-l directory] [-e file extension]"
      exit 1
      ;;
    esac
done

SIZE=$(ls -l "$LOCATION/"*".$EXTENSION" | awk 'BEGIN{size=0} {size+=$5} END{print size/1024 " KBytes"}')

echo "Location: $LOCATION/*.$EXTENSION : $SIZE"