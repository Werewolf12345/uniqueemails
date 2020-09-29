# Fetch Rewards Coding Exercise - Backend Software Engineering

### Reference Documentation
Libraries used:

* [Java 11](https://openjdk.java.net/projects/jdk/11/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Build
Run maven  goals from command line in the project root folder to compile the project

   ```shell
   mvn clean install
   ```
### Run
Run from command line in the project/target folder

   ```shell
   java -jar uniqueemails-0.0.1-SNAPSHOT.jar
   ```
### Use
Send GET request to [http://localhost:8080/emailscount](http://localhost:8080/emailscount)
with JSON array of emails to count in the request body
`[
     "test.email@gmail.com",
     "test.email+spam@gmail.com",
     "testemail@gmail.com"
 ]
 `
 You should get an answer as a number in the response body 
