#!/bin/bash
# requires docker to be installed
# expects swagger.yaml in current directory
# new output directory out is generated (this should be excluded from git)


docker run -it --rm  --name travel-swagger-codegen \
   -v ${PWD}/out:/swagger-api/out \
   -v ${PWD}:/swagger-api/yaml \
   jimschubert/swagger-codegen-cli generate \
   -i /swagger-api/yaml/swagger.yaml \
   -c /swagger-api/yaml/swagger_opts.json \
   -l spring \
   -o /swagger-api/out

# for some reason having the -u ${UID} flag wasn't working so out/ resource get written as root


#   --artifact-id spring-travel-api \
#   --artifact-version 1.0.0 \

#   --api-package com.cliffconsulting.travel.api \
#   --model-package com.cliffconsulting.travel.model \
#   --invoker-package com.cliffconsulting.travel.invoker \
#   --group-id com.cliffconsulting.travel \


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
