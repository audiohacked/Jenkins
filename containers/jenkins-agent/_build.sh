#!/usr/bin/bash

CONTAINER_TAG="nexus:5000/jenkins/agent-maven-custom:1.0.0"
CONTAINER_FORMAT="docker"
DOCKER="podman"

${DOCKER} build --format=${CONTAINER_FORMAT} -t ${CONTAINER_TAG} .
