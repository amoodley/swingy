#!/usr/bin/env bash
mvn clean package > .maven-build-log && java -cp target/1-1.0-SNAPSHOT.jar amoodley.App cli
