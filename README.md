# CST438 Final Project - Libera Restaurant Service

Libera is a food ordering service web application composed of dedicated 
microservices. Restaurant service is a REST api that houses restaurant
metadata and makes it accessible via json responses.

## Usage

* The restaurant microservice should be the first service ran when testing
the application.

* The application.properties file will need to be changed to contain your
MySQL database username and password.

* In the resources folder is a data.sql file. On each run this should
automatically seed your database with five default test restaurants.
If this does not work for whatever reason, the script can be ran itself
to provide the initial dataset.
