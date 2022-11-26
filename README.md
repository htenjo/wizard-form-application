# Wizard Form Application

Application client to validate the form models project

Useful commands:

| Command            | Description                                                         |
|--------------------|---------------------------------------------------------------------|
| `$ make build`     | Build the project with maven but without tests                      |
| `$ make build_all` | Build the whole project with maven                                  |
| `$ make run`       | Run the APP from the jar created in the build                       |
| `$ make build_run` | Execute both commands `build` -> `run`                              |
| `$ make mvn_dependency` | extract the jar content into a new directory for docker image build |
| `$ make docker_build` | Creates a docker image with the APP                                 |
| `$ make docker_build_full` | Execute 3 commands `build_all` -> `mvn_dependency`-> `docker_build` |
| `$ make docker_run` | Creates a container from image built previously and executes it     |
| `$ make docker_run_debug` | Same as `docker_run` but with DEBUG configs on port 5005            |
