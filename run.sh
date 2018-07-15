#!/bin/bash
# requires docker to be installed
# expects to have build script executed to create target dir


docker run -it --rm --name travel-java \
  -p 80:8080 \
  -v ${PWD}/target:/usr/src/myapp \
  -w /usr/src/myapp \
  openjdk:8 java -jar travel-api-server-1.0.0.jar

