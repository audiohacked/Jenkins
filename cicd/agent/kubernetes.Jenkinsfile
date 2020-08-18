kubernetes {
    label "maven-skopeo-agent"
    cloud "openshift"
    inheritFrom "maven"
    containerTemplate {
    name "jnlp"
    image "image-registry.openshift-image-registry.svc:5000/${GUID}-jenkins/jenkins-agent-appdev:latest"
    resourceRequestMemory "2Gi"
    resourceLimitMemory "2Gi"
    resourceRequestCpu "2"
    resourceLimitCpu "2"
    }
}
