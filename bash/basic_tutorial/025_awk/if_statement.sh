#!/bin/bash
cat files/data.csv | awk 'BEGIN{FS=";"} {if ($2 == "account") {print "1) Accounting Dep: " $0} else {print "2) Another Dep: " $0} } END{print "Number or records: " NR}'