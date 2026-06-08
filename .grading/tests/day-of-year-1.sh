#!/usr/bin/env bash

if ! find -name DayOfYearTest.java | grep -q DayOfYearTest.java; then
	echo "DayOfYearTest.java not found."
	exit 1
fi

./gradlew test --tests DayOfYearTest || true