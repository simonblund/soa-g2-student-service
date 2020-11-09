#!/bin/sh
# Everything
chown -R gradle:gradle /home/gradle


# Specific to the volumes we know we have.
#chown -R gradle:gradle /home/gradle/caches
#chown -R gradle:gradle /home/gradle/service/build/libs


# Now run Gradle process as non-root user.
#Syntax: runuser -l userNameHere -c '/path/to/command arg1 arg2'
runuser gradle --preserve-environment -c 'gradle -g /home/gradle build'