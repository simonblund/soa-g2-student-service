#!/bin/bash
# Gradle build in Docker with persistent Gradle cache.
#
# author: Weleoka <weleoka@mailfence.com>
# edited: 2020-11-08
#
# Creates a persistent gradle cache for the build container here in the project /build dir.
# Because Gradle is "installed" for a normal user in the official Gradle docker images we have to work around that.
# On the development machine the cache will be saved in project_dir/build/gradle_build_cache.
#
# This script is here because Gradle does not allow a neat and effective way to fetch dependencies and host them locally.
#
# Mistakes made when in the process of arriving at this script:
# - tried to use volumes in a multistage Dockerfile for early targets
# - tried to mount the modules-2 folder as a volume but that made the parent dir owned by root,
#     so sister files to modules-2 could not be created
#
set -euo pipefail
script="`realpath "$0"`"
project_dir="`dirname "$script"`"
docker_gradle_image="gradle:6.7.0-jdk11"
# gradle:6.7.0-jdk11 is gradle@sha256:33f85a6c2d3fd5f81987f66db3a3e379e562587e20b5ae404d8c4f7f62f37fb3

echo
echo "== Building Gradle project: ${project_dir} in Docker container (${docker_gradle_image})."

echo "> Create persistent build cache directory."
mkdir -p "$project_dir"/build/docker_build_cache


# Note added this as removing classes in source code was not reflected
# in the extracted archive contents after build. Due to class autoloading
# old classes appear again and again.
echo "> (disabled) Removing build/application and build/classes folder to ensure clean build."
# This is disabled as we do not use multilayer Jars yet."
#rm -r "${project_dir}/build/application"
#rm -r "${project_dir}/build/classes"


echo "> Start the build process..."
# Choose here if you want to do manual bash commands or the provided ones.
docker run --name gradle_builder --rm \
-v "$project_dir":/home/gradle \
-v "$project_dir"/build/docker_build_cache:/home/gradle/.gradle/caches \
-w /home/gradle \
"$docker_gradle_image" \
/bin/bash -c "gradle --quiet --no-daemon build"
#/bin/bash -c "gradle --quiet --no-daemon bootJar"
#/bin/bash


# Todo: multilayer jars so run-container can have optimised docker caching.
#/bin/bash -c "gradle --quiet --no-daemon bootJar && cd build && java -Djarmode=layertools -jar ./libs/*.jar extract"
#/bin/bash -c "gradle --quiet --no-daemon bootJar && cd service/build && java -Djarmode=layertools -jar ./libs/*.jar extract"
# todo: the extracting of multilayer jar is not very neat as we have to cd to ./build to extract to build.
# todo: Q: what's the --build-cache flag for gradle?
# todo: Q: the --no-daemon flag for gradle? Might be important for parallel running,
#   as per: https://dev.to/markomannux/gradle-daemon-with-multi-module-spring-project-3nog


echo "> Remove *.lock in Gradle persistent cache for next time running."
rm -r "$project_dir"/build/docker_build_cache/modules-2/*.lock 2> /dev/null


echo "> Done!"
echo
