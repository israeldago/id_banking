#!/usr/bin/env bash
./mvnw install:install-file -Dfile=./externLib/app-users-ws-0.0.1-SNAPSHOT.jar -DgroupId=com.israeldago \
        -DartifactId=app-users-ws -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar
./mvnw clean package
