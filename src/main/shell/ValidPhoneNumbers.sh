# Read from the file file.txt and output all valid phone numbers to stdout.

#!/bin/bash

awk '/(^\([0-9]{3}\){1} [0-9]{3}-[0-9]{4}$)|(^[0-9]{3}-[0-9]{3}-[0-9]{4}$)/{print $0}' file.txt