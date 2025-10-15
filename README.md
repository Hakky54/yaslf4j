[![Actions Status](https://github.com/Hakky54/yaslf4j/workflows/Build/badge.svg)](https://github.com/Hakky54/yaslf4j/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=io.github.hakky54%3Ayaslf4j&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.github.hakky54%3Ayaslf4j)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=io.github.hakky54%3Ayaslf4j&metric=coverage)](https://sonarcloud.io/dashboard?id=io.github.hakky54%3Ayaslf4j)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=io.github.hakky54%3Ayaslf4j&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=io.github.hakky54%3Ayaslf4j)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=io.github.hakky54%3Ayaslf4j&metric=security_rating)](https://sonarcloud.io/dashboard?id=io.github.hakky54%3Ayaslf4j)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=io.github.hakky54%3Ayaslf4j&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=io.github.hakky54%3Ayaslf4j)
[![Apache2 license](https://img.shields.io/badge/license-Aache2.0-blue.svg)](https://github.com/Hakky54/yaslf4j/blob/master/LICENSE)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.hakky54/yaslf4j/badge.svg)](https://mvnrepository.com/artifact/io.github.hakky54/yaslf4j)
[![javadoc](https://javadoc.io/badge2/io.github.hakky54/yaslf4j/javadoc.svg)](https://javadoc.io/doc/io.github.hakky54/yaslf4j)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FHakky54%2Fyaslf4j.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FHakky54%2Fyaslf4j?ref=badge_shield)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=io.github.hakky54%3Ayaslf4j)

# YASLF4J - yet another simple logging facade for java

# Install library with:
### Install with [maven](https://mvnrepository.com/artifact/io.github.hakky54/yaslf4j)
```xml
<dependency>
    <groupId>io.github.hakky54</groupId>
    <artifactId>yaslf4j</artifactId>
    <version>1.0.5</version>
</dependency>
```
### Install with Gradle
```groovy
implementation 'io.github.hakky54:yaslf4j:1.0.5'
```
### Install with Scala SBT
```
libraryDependencies += "io.github.hakky54" % "yaslf4j" % "1.0.5"
```
### Install with Apache Ivy
```xml
<dependency org="io.github.hakky54" name="yaslf4j" rev="1.0.5" />
```

## Table of contents
1. [Introduction](#introduction)
    - [Advantages](#advantages)
    - [Tested Java versions](#tested-java-versions)
2. [Usage](#usage)
4. [Contributing](#contributing)
5. [License](#license)


# Introduction
YASLF4J is a logging facade / api which will delegate application logs to the underlying provider. It will either delegate it to SLF4J api if present, or else Log4j2 api if present or fallback to Java Util Logging Logger.

# History
When a library owner is using SLF4J or Log4j2 the end-user will end up getting that library as a transitive dependency. The end-user needs to either provide a logging implementation or omit it.
When not providing an implementation the end-user will also get the following error message:
```text
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.

ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
```

YASLF4J is just a simple logging api which is capable of logging. It will use SLF4J as logging api if it is present on the classpath of the end-user, but it won't provide it as a transitive dependency.
The same goes for Log4j2. So the end-user may provide a logging binding but is not required and also won't get bothered if it is absent.

### Advantages
- The end-user won't get a transitive dependency on SLF4J or Log4j2
- The end-user won't get warning from SLF4J or Log4j2 when not having SLF4J or Log4j2 on the classpath  
- It will use either SLF4J or Log4j2 if it is present at the classpath or fallback to Java Util Logging Logger
- Plug & play

### Tested Java versions
- Java 8
- Java 11
- Java 15

# Usage
```java
import nl.altindag.log.Logger;
import nl.altindag.log.LoggerFactory;

public class FooService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FooService.class);

    public void sayHello() {
        LOGGER.info("Keyboard not responding. Press any key to continue...");
        LOGGER.warn("Congratulations, you are pregnant!");
    }

}
```

# Contributing

There are plenty of ways to contribute to this project:

* Give it a star
* Submit a PR

## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FHakky54%2Fyaslf4j.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2FHakky54%2Fyaslf4j?ref=badge_large)

