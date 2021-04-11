# SoftwareAcademy-P9-Zuul-Server
Micro-service Zuul Server for MEDISCREEN Application. 

This microservice use SPRINT BOOT

# Getting Started
EndPoint for global application  : 
* http://localhost:4200

# Prerequis
For USER microservice
* Java 1.8 or later
* Spring Boot 2.2.6
* Docker 2.5.0.0 or later (optional)

For Global application
* Java 1.8 or later
* MySQL
* MongoDB
* Spring Boot 2.2.6
* Docker 2.5.0.0 or later (optional)
* Angular
* Zipkin
* Eureka
* Config server
# Installation
Check PatientV2 Readme.md for global installation 

### Docker image construction in project directory :
docker build --build-arg JAR_FILE=target/*.jar -t p9-zuul .

### Docker execution if docker-compose is not use
docker run -p 9004:9004 --name Eureka eureka