#!/usr/bin/bash

CONTAINER_TAG="nexus:5000/jenkins/agent-maven-custom"
CONTAINER_FORMAT="docker"
DOCKER="podman"

${DOCKER} push ${CONTAINER_TAG}
