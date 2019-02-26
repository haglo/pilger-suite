#!/usr/bin/env bash
mvn -Dversion=$1 clean verify
mkdir -p artifact
cp "target/pilger-suite-$1.jar" artifact/