SCS Eureka Spike
=============================

This is a boot app that will register itself with a locally running instance of Eureka.  When user hits localhost:8080 from their browser it will show you all the instances of the app that have been registered with Eureka.

## Requirements

In order for the sample to run you will need to have installed:

* Java 8 

## Code Tour

The primary application is located in the org package.  The application.yml located in the resources directory will all the user to set the name of the application, eurekaInstanceId and location of the eureka server.  

## Building with Maven

Build the sample simply by executing:

	source>$ mvn clean package

## Running the Sample

To start the instance of the application:

	sampleclient>$ java -jar target/myproject-0.0.1-SNAPSHOT.jar
	
To start another instance of the application  you can change the port number:

  sampleclient>$ java -jar -Dserver.port=8082 target/myproject-0.0.1-SNAPSHOT.jar
  
  

