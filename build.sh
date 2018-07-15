#!/bin/bash
# requires docker to be installed

docker run -it --rm  --name travel-maven-build \
   -u ${UID}\
   -v ${PWD}/out:/usr/src/mymaven \
   -w /usr/src/mymaven \
   maven:3.3-jdk-8 mvn package

