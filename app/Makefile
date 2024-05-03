#Makefile
run-dist:
	gradle clean installDist
	./build/install/app/bin/app

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain
