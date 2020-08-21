kubernetes {
    cloud "openshift"
    label "agent-maven-custom"
    // inheritFrom "maven"
    containerTemplate {
        name "jnlp"
        image "nexus:5000/jenkins/agent-maven-custom:1.0.0"
        // resourceRequestMemory "2Gi"
        // resourceLimitMemory "2Gi"
        // resourceRequestCpu "2"
        // resourceLimitCpu "2"
    }
}
