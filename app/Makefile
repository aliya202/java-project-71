#Makefile
run-dist:
	gradle clean installDist
	./build/install/app/bin/app

test:
	./gradlew test

report1:
	./gradlew clean
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain
