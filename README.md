# SoftwareAcademy-P9-Zuul-Server

# Installation
todo
## Docker installation
###Docker image construction in project directory :

docker build --build-arg JAR_FILE=target/*.jar -t p9-zuul .

### Docker execution :

docker run -p 9004:9004 --name Eureka eureka

### Check Eureka server
* http://localhost:9102/
