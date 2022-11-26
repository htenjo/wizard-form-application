DOCKER_USERNAME ?= htenjo
SPRING_PROFILE ?= dev
APP_NAME ?= wizard-form-application
GIT_HASH ?= $(shell git log --format="%h" -n 1)

build:
	mvn clean package -DskipTests

build_all:
	mvn clean package

run:
	java -jar target/${APP_NAME}-0.0.1-SNAPSHOT.jar

build_run: build run

mvn_dependency:
	rm -rf target/dependency
	mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

docker_build:
	docker build --tag ${DOCKER_USERNAME}/${APP_NAME}:${GIT_HASH} --tag ${DOCKER_USERNAME}/${APP_NAME}:latest .

docker_build_full: build_all mvn_dependency docker_build

docker_run:
	docker run -e "SPRING_PROFILES_ACTIVE=${SPRING_PROFILE}" -p 8080:8080 ${DOCKER_USERNAME}/${APP_NAME}

docker_run_debug:
	docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" \
		-e "SPRING_PROFILES_ACTIVE=${SPRING_PROFILE}" -p 8080:8080 -p 5005:5005 -t ${DOCKER_USERNAME}/${APP_NAME}

docker_build_run: docker_build docker_run

docker_push:
	docker push ${DOCKER_USERNAME}/${APP_NAME}:${GIT_HASH}

docker_release:
	docker pull ${DOCKER_USERNAME}/${APP_NAME}:${GIT_HASH}
	docker tag  ${DOCKER_USERNAME}/${APP_NAME}:${GIT_HASH} ${DOCKER_USERNAME}/${APP_NAME}:latest
	docker push ${DOCKER_USERNAME}/${APP_NAME}:latest

build_compose: build mvn_dependency
	docker-compose up --build

compose: mvn_dependency
	docker-compose up
