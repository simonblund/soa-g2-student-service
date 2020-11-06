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