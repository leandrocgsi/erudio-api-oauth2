#!/bin/bash
cd $(dirname $0)

set -e

./gradlew clean build
sudo rm -rf build

mvn clean package -Dmaven.test.skip=true
sudo rm -rf target
