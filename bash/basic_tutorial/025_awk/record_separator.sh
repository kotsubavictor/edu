#!/bin/bash
cat files/data.csv | awk 'BEGIN{RS=";"} {print $0} END{print NR}'
echo "======================================"