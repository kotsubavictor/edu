#!/bin/bash
# Without erros

echo "ls ./files/cat?.txt (? - single character)"
ls ./files/cat?.txt

echo "ls ./files/cat*.txt (* - any number of charecters)"
ls ./files/cat*.txt

echo "ls ./files/cat[0-9].txt ([] - single character from range)"
ls ./files/cat[0-9].txt

echo "ls ./files/cat?.{txt,log} ({} - comma separated terms)"
ls ./files/cat?.{txt,log}
