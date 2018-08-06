#!/usr/bin/env bash
gnome-terminal --tab -e "java -Dserver.port=8083 -jar web/target/id_banking-0.0.1-SNAPSHOT.jar" &&
java -jar ./externLib/app-users-ws-0.0.1-SNAPSHOT.jar
