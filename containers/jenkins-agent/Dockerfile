# $ docker pull registry.redhat.io/openshift4/ose-jenkins:<v4.4.0>
# $ docker pull registry.redhat.io/openshift4/jenkins-agent-nodejs-10-rhel7:<v4.4.0>
# $ docker pull registry.redhat.io/openshift4/jenkins-agent-nodejs-12-rhel7:<v4.4.0>
# $ docker pull registry.redhat.io/openshift4/ose-jenkins-agent-maven:<v4.4.0>
# $ docker pull registry.redhat.io/openshift4/ose-jenkins-agent-base:<v4.4.0>

FROM registry.redhat.io/openshift4/ose-jenkins-agent-maven:v4.4.0 AS base
LABEL maintainer="snelson@redhat.com"

USER root
RUN yum -y install --disablerepo='*' --enablerepo='rhel-7-server-rpms' ant && \
    yum -y clean all --enablerepo='*'

USER 1001
