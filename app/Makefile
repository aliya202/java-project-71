#Makefile
run-dist:
	gradle clean installDist
	./build/install/app/bin/app

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain
