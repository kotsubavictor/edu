#!/bin/bash
EXISTING_FILE=./files/cat.log

if [ -e $EXISTING_FILE ]; then
  echo "Path to file/directory exists: $EXISTING_FILE"
else
  echo "Path to file/directory does not exist: $EXISTING_FILE"
fi

if [ -f $EXISTING_FILE ]; then
  echo "Path to regullar file exists: $EXISTING_FILE"
else
  echo "Path to regullar file does not exist: $EXISTING_FILE"
fi

if [ -d $EXISTING_FILE ]; then
  echo "Path is a directory: $EXISTING_FILE"
else
  echo "Path is not a directory: $EXISTING_FILE"
fi

if [ -x $EXISTING_FILE ]; then
  echo "Path is an executable file: $EXISTING_FILE"
else
  echo "Path is not an executable file: $EXISTING_FILE"
fi

if [ -L $EXISTING_FILE ]; then
  echo "Path is a symlink: $EXISTING_FILE"
else
  echo "Path is not symlink: $EXISTING_FILE"
fi

if [ -r $EXISTING_FILE ]; then
  echo "Path is readable: $EXISTING_FILE"
else
  echo "Path is not readable: $EXISTING_FILE"
fi

if [ -w $EXISTING_FILE ]; then
  echo "Path is writable: $EXISTING_FILE"
else
  echo "Path is not writable: $EXISTING_FILE"
fi