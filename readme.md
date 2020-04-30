# Scramble Web API

Scramble Web API is written in Java and delivers scrambles for official puzzles from the [World Cube Association](https://github.com/thewca).

You can see a live version of the documentation at [https://scramble-web-api.herokuapp.com/swagger-ui.html#/](https://scramble-web-api.herokuapp.com/swagger-ui.html#/).

## Project Details

Scramble Web API uses [Gradle](https://gradle.com), [Spring Boot](https://spring.io/projects/spring-boot) and [Swagger](https://swagger.io/). On a simple version, this project serves the web with scrambles from [tnoodle-lib](https://github.com/thewca/tnoodle-lib). Your IDE should support [Lombok](https://projectlombok.org/) as well.

### Overview

Gradle is served through the use of a `Gradle wrapper` available as `gradlew` (UNIX systems) or `gradlew.bat` (DOS systems).

Get an overview of the core project tasks by executing

    ./gradlew tasks

### Setup

Gradle automagically handles all dependencies for you. You just need an Internet connection upon your first build run!

When you're ready to develop, run the following and then visit the logged url for the documentation, probably <http://localhost:2020/swagger-ui.html>, unless you change the `server.port` property.

    ./gradlew bootRun

To build a distributable/executable `.jar` file, run:

    ./gradlew bootJar

You can run the `.jar` from the commandline using: (replace the `$VERSION` tag accordingly)

    java -jar build/libs/scramble-web-api-$VERSION.jar


