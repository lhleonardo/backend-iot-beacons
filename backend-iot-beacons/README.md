# backend-iot-beacons

Application developed for the discipline of IoT, present in the Master's program in Computer Science. 

It is for managing bluetooth beacons, controlling their positioning and characteristics (labels, descriptions and types).

Made with [Spring Boot](http://projects.spring.io/spring-boot/).

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. 
One way is to execute the `main` method in the `br.unicamp.iot.beacons.backend.BackendIotBeaconsApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.