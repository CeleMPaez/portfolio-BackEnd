FROM amazoncorretto:8-alpine-jdk
MAINTAINER celestempaez
COPY target/portfolioBackEnd-0.0.1-SNAPSHOT.jar portfolioBackEnd-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolioBackEnd-0.0.1-SNAPSHOT.jar"]
spring.datasource.hikari.maximum-pool-size = 2

#JWT

jwt.secret = secret
jwt.expiration = 3600
