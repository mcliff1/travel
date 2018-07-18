# Travel
API for proof of concept for room reservation system
Author: Matt Cliff
Created: July 14, 2018

## Provide links for each of these
· How to compile the application
· How to run your application
· Examples of the REST calls
· How to run the test cases
· Mention anything that was asked but not delivered and why



## Approach

0. prequisites - text editor of your choice and docker
1. create swagger.yaml to meet requirements (dockerized swagger-editor)
2. use swagger-codegen (dockerized) to build framework
3. add custom implementation to generated framework
4. use maven (dockerized) to build
5. use java8 (dockerized) to run

Future enhancements - 
   create docker image for the runtime, and deploy to AWS ECS cluster


## Requirements


1) Register, Update and Delete Hotels.
	a. Hotels have the at least the following information:
		Name, Address, City, Phone, Stars
	b. A hotel can only be deleted if there is no available rooms or valid reservations.
2) Include available rooms for a given hotel.
	a. Available rooms have at least the following information:
		Description, Images, Start available date, Last available date, Maximum number of guests
3) Search for an available room.
	a. Search can be done at least by hotel name and dates.
4) Book a room for a hotel based on the searched availability.
	a. The booking needs to have at least the following information: (Guests (Name, Age), Start date,End date, Room)
	b. The booking needs to respect the maximum number of guests in the room and the dates.
Also, our architecture team give us the following technical requirements:
5) The solution should be a REST API.
6) If any data needs to be saved an embedded in-memory database should be used.
7) The application must have a stateless API.
8) Tests are mandatory.
9) Authentication is not mandatory but is a nice to have.
After the solution is done you must provide an bitbucket or github repository with a README file at the root explaining:
· How to compile the application
· How to run your application
· Examples of the REST calls
· How to run the test cases
· Mention anything that was asked but not delivered and why
Any additional comments.



## Architecture

This uses springboot 2.0.3 to build a stand-alone java application jar file to be executed with jdk8. 

## Build and Deploy

The `build.sh` script will launch a Docker image to run maven to build and run the unit tests. The `run.sh` shell script has been provided to launch a docker image with java8 and bind to local port 80 to serve the API.

Access the API at **http://localhost/v1/<api>**

H2 in-memory database is used and console is accessible **http://localhost/v1/h2**