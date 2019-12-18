#!/bin/bash

function addStringToPipe() {
  local word="default string"

  while getopts "w:" options; do
    case $options in
    w)
      word=${OPTARG}
      ;;
    esac
  done

  while read -r line ; do
      echo "$line $word"
  done
}

cat ./files/data.log | addStringToPipe -w k1
cat ./files/data.log | addStringToPipe > ./files/data1.log