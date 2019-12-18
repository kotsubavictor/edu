#!/bin/bash
EXTENSION=log
ls -l files | awk -v ext=$EXTENSION '{ if(index($0, ext) != 0 ) print $0} END{ext="txt"}'
echo "$EXTENSION"