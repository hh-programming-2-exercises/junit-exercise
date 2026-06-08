#!/usr/bin/env bash

cp .grading/tests/DOYTest.txt src/test/java/DOYTest.java

./gradlew test --tests DOYTest