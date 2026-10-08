

Spring Boot(Autoconfiguration )

\-------------

Its an extension of spring framework introduced to overcome the challenges faced in a spring application like ,





1\. Configuration. 

2\. Project Dependency management



the above mentioned drawbacks reduce the productivity of a developer, hence Spring Boot is used to overcome it.







Spring Boot is a framework built on top of springframewok that helps developers build spring based apps 

quickly and easily.



features. 

Spring Boot is framework that fascilitates development of microservice based projects.





1\. Spring Boot is an opiniated framework. ex spring boot uses tomcat as a default web container.



2\. Spring Boot is customizable.



3\. Starter Dependencies



4\. Automatic Configuration



5\. Spring Boot Actuator



6\. Embedded servlet container



Spring boot =  embedded server(tomcat) - configuration



**1. Spring initializr**

**2. STS.**





some popular starter dependencies we are going to use



spring boot starter

spring boot starter aop

spring boot starter jdbc-

spring boot starter data-jpa-hibernate



spring boot starter web-creating rest apis

spring boot starter test- testing/mocking

spring boot starter log4j2-logging

spring boot starter actuator- health check, monitoring app



\------------------------------------





@SpringBootAnnotation

\------------------------

This annotation indicates that it is a configuration class that triggers auto-configuration and component scanning.

Its a combo of the following annotations



1\. @EnableAutoConfiguration



2\. @ComponenetScan -> @Component , @Controller, @Service , @Repository, scan these create objects and inject them in @Autowired.



3\. @Configuration/ @SpringBootConfiguration 





\--------------------------------------------------------------



Spring Boot JDBC
------------------





Spring Jdbc

\------------

JDBC Api drawbacks

1\. We need to write lengthy code

2\.  Exception handling makes code bulky

3\. Boilerplate(repetative) code

4\. database querying is time consuming.





Spring Jdbc

\---------------



Spring Jdbc  Provides JdbcTemplate class which has all the important methods to perform

operations with database.





//////////////////////////////



1. Batch Operations
2. Calling Stored procedures and working with views
3. transactions

















&#x09;





