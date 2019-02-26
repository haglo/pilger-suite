#!/usr/bin/env bash
docker build --build-arg "JAR_FILE=target/pilger-suite-$1.jar" --tag test .