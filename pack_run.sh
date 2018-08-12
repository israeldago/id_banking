#!/usr/bin/env bash
echo 'Packaging id_Banking application' - `date`
./pack.sh
echo 'id_Banking application packaged'
echo 'Launching app'
./run.sh
