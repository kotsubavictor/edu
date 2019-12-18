#!/bin/bash
# Without erros
IP="192.168.1.2"
PATTERN="(([0-9]+)\.([0-9]+)\.([0-9]+)\.([0-9]+))"

if [[ $IP =~ $PATTERN ]]; then
  echo "an IP! $PATTERN"
  echo "\$BASH_REMATCH[0] = ${BASH_REMATCH[0]}"
  echo "\$BASH_REMATCH[1] = ${BASH_REMATCH[1]}"
  echo "\$BASH_REMATCH[2] = ${BASH_REMATCH[2]}"
  echo "\$BASH_REMATCH[3] = ${BASH_REMATCH[3]}"
  echo "\$BASH_REMATCH[4] = ${BASH_REMATCH[4]}"
  echo "\$BASH_REMATCH[5] = ${BASH_REMATCH[5]}"
else
  echo "not an IP"
fi
