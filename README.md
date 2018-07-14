# Travel
API for proof of concept for room reservation system

## Requirements


1) Register, Update and Delete Hotels.
	a. Hotels have the at least the following information:
		i. Name
		ii. Address
		iii. City
		iv. Phone
		v. Stars
	b. A hotel can only be deleted if there is no available rooms or valid reservations.
2) Include available rooms for a given hotel.
	a. Available rooms have at least the following information:
		i. Description
		ii. Images
		iii. Start available date
		iv. Last available date
		v. Maximum number of guests
3) Search for an available room.
	a. Search can be done at least by hotel name and dates.
4) Book a room for a hotel based on the searched availability.
	a. The booking needs to have at least the following information:
		i. Guests
			1. Name
			2. Age
		ii. Start date
		iii. End date
		iv. Room
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



