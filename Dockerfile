FROM gradle:6.7.0-jdk11 as builder
#as deps

#RUN addgroup gradle && adduser --system gradle
#RUN adduser gradle gradle && mkdir -p /home/gradle
#RUN mkdir -p /home/gradle/.gradle/caches/modules-2
WORKDIR /home/gradle
# Copy in dependency and build instructions
COPY ./api/build.gradle ./api/build.gradle
COPY ./service/build.gradle ./service/build.gradle

# Copy main project and settings.gradle
COPY ./build.gradle ./build.gradle
COPY ./settings.gradle ./settings.gradle
#RUN gradle --info build



#FROM gradle:6.7.0-jdk11 as builder
#WORKDIR /home/gradle
# Copy in all the dependencies
#COPY --from=deps /root/.m2 /root/.m2
#COPY --from=deps /opt/app/ /opt/app

# Copy in your source files
COPY ./api/src /home/gradle/api/src
COPY ./service/src /home/gradle/service/src

# Make the wrapper for use in the execution environment and build project
RUN gradle --no-daemon wrapper
RUN gradle --no-daemon build
#RUN gradle --no-daemon --info build # extra debug

# Copy in the cache if this build has been run before so that we don't have to download dependencies again.
# --chown=gradle:gradle
#RUN mkdir -p /home/gr  adle/.gradle/caches/modules-2
#RUN chown -R gradle:gradle /home/gradle/.gradle/caches
# --chown=gradle:gradle
#COPY ./gradle_caches /home/gradle/.gradle/caches/modules-2


# === The execution ===
FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
LABEL maintainer="weleoka@gitlab.com"
WORKDIR /home/spring
COPY --from=builder /home/gradle ./

# Create the group and user
RUN addgroup spring && adduser --system spring
# Own all by gradle user.
RUN chown -R spring:spring /home/spring
# Set the active user.
USER spring:spring

# Build the layered fat jar with gradle
#RUN gradle --no-daemon bootJar
# Extract with Spring 2.3 layered fat jar fuctionality.
#RUN java -Djarmode=layertools -jar build/libs/*.jar extract

# Run the process. This can be overriden if using DC to start the container.
#ENTRYPOINT ["./gradlew", "bootRun"]
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
CMD ["java", "-jar", "./service/build/libs/service-1.0.null.jar"]
# This works.
