#!/bin/bash
# Without erros
cat dummy.txt &> dummy.direct.redirection.txt

# With errors
cat dummy1.txt 1> dummy1.direct.redirection.txt 2>&1