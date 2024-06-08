#Makefile
.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew clean build

run:
	./gradlew run --args="-h"

run-dist:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

install:
	./gradlew clean install

build-run: build run

.PHONY: build