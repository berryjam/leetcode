# Read from the file file.txt and output the tenth line to stdout.

#!/bin/bash

awk 'BEGIN{count=0;}{count++;if(count==10) print $0;}' file.txt