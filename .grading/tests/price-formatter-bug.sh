#!/usr/bin/env bash

if [ ! -f success.txt ]; then
	echo "The tests for the PriceFormatter class failed."
	exit 1
fi

bug_file="$1"

cp ".grading/tests/$bug_file" src/main/java/price/formatter/PriceFormatter.java

if ./gradlew clean test --tests PriceFormatterTest >/dev/null; then
	echo "Your tests didn't spot all the possible bugs in the PriceFormatter class. Make sure that you are testing all the scenarios."
    cp .grading/tests/PriceFormatter.txt src/main/java/price/formatter/PriceFormatter.java
	exit 1
fi

cp .grading/tests/PriceFormatter.txt src/main/java/price/formatter/PriceFormatter.java