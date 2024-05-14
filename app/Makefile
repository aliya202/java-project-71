#Makefile
run-dist:
	gradle clean installDist
	./build/install/app/bin/app

report:
	./gradlew test jacocoTestReport --debug

lint:
	./gradlew checkstyleMain
