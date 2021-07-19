# Spring Webflux example

## Prerequisite
Java 15

## Run with maven wrapper
```
$ ./mvnw clean spring-boot:run
```

## Example curl
```
$ curl -N -v http://localhost:8080/server
$ curl -N -v http://localhost:8080/served-dishes
$ curl -N -v http://localhost:8080/served-dish

// Web page using thymeleaf
$ curl -N -v http://localhost:8080
```