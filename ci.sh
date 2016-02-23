#!/bin/bash
cd $(dirname $0)

set -e

./gradlew clean build
sudo rm -rf build

mvn clean package -DskipTests
sudo rm -rf target
