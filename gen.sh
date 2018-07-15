#!/bin/bash
# requires docker to be installed
# expects swagger.yaml in current directory
# new output directory out is generated (this should be excluded from git)


#docker run -it \ 
#   -v ~/out:/swagger-api/out \
#   -v ${PWD}:/swagger-api/yaml \
#   jimschubert/swagger-codegen-cli generate \
#   -i /swagger-api/yaml/swagger.yaml \
#   -l java \
#   -o /swagger-api/out/java

docker run -it \
   -v ${PWD}/out:/swagger-api/out \
   -v ${PWD}:/swagger-api/yaml \
   jimschubert/swagger-codegen-cli generate \
   --api-package com.cliffconsulting.travel.api \
   -i /swagger-api/yaml/swagger.yaml \
   -l spring \
   -o /swagger-api/out/java-springboot


#java -jar swagger-codegen-cli.jar generate \
#  -i http://petstore.swagger.io/v2/swagger.json \
#  --api-package com.baeldung.petstore.client.api \
#  --model-package com.baeldung.petstore.client.model \
#  --invoker-package com.baeldung.petstore.client.invoker \
#  --group-id com.baeldung \
#  --artifact-id spring-swagger-codegen-api-client \
#  --artifact-version 0.0.1-SNAPSHOT \
#  -l java \
#  --library resttemplate \
#  -o spring-swagger-codegen-api-client
#
