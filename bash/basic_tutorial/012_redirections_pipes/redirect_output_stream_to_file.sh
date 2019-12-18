#!/bin/bash
# Without erros
cat dummy.txt > dummy.default.output.redirection.txt
cat dummy.txt 1> dummy.direct.output.redirection.txt

# With errors
cat dummy1.txt > dummy1.default.output.redirection.txt
cat dummy1.txt 1> dummy1.direct.output.redirection.txt