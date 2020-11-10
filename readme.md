![Java CI with Gradle](https://github.com/simonblund/soa-g2-student-service/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)
# Student-service

State:

- Should be runnable after gradle build
- URI: localhost:8080
- http://localhost/8080/swagger-ui.html

# THIS IS WORK IN PROGRESS
- Not ready for business logic.
- Not ready for branch security.
- Not ready to be used as ground for other projects yet.

## Responsibilities
This is a micro-serviceesque application. Handling the student object and all its functions.

### Handle the student life cycle
On creation of a new student att the University a call to this service is made with the students name, ssn and current email address. This service 
creates a student object containing that information and also trigger other systems to create system-specific identities.

While the student is studying at LTU, this service serves other services with functions relating to the physical student
this can be providing email-address, ssn, or other information to that system.

On deletion of a student, which happens at a specified delay after student disenrollment this service takes care of triggering the removal process 
calling the at the time imaginary student-begone-service that takes care of saving down matricular data and anonymization in other systems.

## Persistance
The student-service has a persistance layer consisting of the student-table in an RDS.


# Docker and Gradle 
The build script is used so that volumes can be mounted and map files between host and docker container. The reason for this is so that a separate build and runtime containers can be used. Now running gradle in a Docker container as a non-root user means that we can't write to the volumes mapped between host and container. Currently we have the options:
1. simply have to accept that the gradle process is run as root in the build container. 
2. start the container and as root run an entrypoint.sh. This scrip chown's the volumes to the non-root user and then starts the build as this same non-root user.

There's more discussion about this online, one place is [here](https://github.com/moby/moby/issues/225).

The sequence for getting a runnable docker image with the relevant artifact inside it is:
1. Run `docker_build.sh`; then
2. `docker build -t my_fat_tag .`
3. Run it with: `docker run my_fat_tag:latest`.
 
 
 # Todo
 In GitHub Actions implement a caching system for dependencies. [Read more here](https://docs.github.com/en/free-pro-team@latest/actions/learn-github-actions/managing-complex-workflows#caching-dependencies).