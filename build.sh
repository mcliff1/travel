#!/bin/bash
# requires docker to be installed

docker run -it --rm  --name travel-maven-build \
   -v ${PWD}:/usr/src/mymaven \
   -w /usr/src/mymaven \
   maven:3.3-jdk-8 mvn package

# this wasn't working with the gen.sh script
#   -u ${UID}\

