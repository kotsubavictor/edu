#!/bin/bash
EXISTING_FILE=./files/cat.log
NON_EXISTING_FILE=./files/non_cat.log

# single operation true or false
[ -e $EXISTING_FILE ] && echo "Path to file/directory exists: $EXISTING_FILE";
[ -d $EXISTING_FILE ] || echo "Path is not a directory: $EXISTING_FILE";

# full case with true/false block
[ -e $EXISTING_FILE ] && echo "Path to file/directory exists: $EXISTING_FILE" || echo "Path to file/directory does not exist: $EXISTING_FILE";
[ -e $NON_EXISTING_FILE ] && echo "Path to file/directory exists: $NON_EXISTING_FILE" || echo "Path to file/directory does not exist: $NON_EXISTING_FILE";

echo "It is not a real ternarry operation, because it uses the idea of terminal logical operations && vs ||"