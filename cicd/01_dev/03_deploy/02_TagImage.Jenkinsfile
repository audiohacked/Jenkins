// Build the OpenShift Image in OpenShift and tag it.
stage('Build and Tag OpenShift Image') {
  steps {
    dir('openshift-tasks') {
      echo "Building OpenShift container image ${imageName}:${devTag} in project ${devProject}."

      script {
        // TBD: Build Image (binary build), tag Image
        //      Make sure the image name is correct in the tag!
        openshift.withCluster() {
          openshift.withProject("${devProject}") {
            openshift.selector("bc", "tasks").startBuild(
              "--from-file=./target/openshift-tasks.war",
              "--wait=true")
            openshift.tag("${imageName}:latest", "${devProject}/${imageName}:${devTag}")
          }
        }
      }
    }
  }
}
