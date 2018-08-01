#!/usr/bin/env bash
echo 'Packaging id_Banking application' - `date`
./pack.sh
echo 'id_Banking application packaged'
echo 'Launching app'
java -jar web/target/id_banking-0.0.1-SNAPSHOT.jar
