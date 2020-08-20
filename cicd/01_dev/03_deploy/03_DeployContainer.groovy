// Deploy the built image to the Development Environment.
stage('Deploy to Dev') {
  steps {
    dir('openshift-tasks') {
      echo "Deploying container image to Development Project"
      script {
        openshift.withCluster() {
          openshift.withProject("${devProject}") {
            // OpenShift 4
            openshift.set("image", "dc/tasks", "tasks=${intRegistryUrl}/${devProject}/${imageName}:${devTag}")
            openshift.set("env", "dc/tasks", "VERSION=\"${devTag} (tasks-dev)\"")

            // Update the Config Map which contains the users for the Tasks application
            // (just in case the properties files changed in the latest commit)
            openshift.selector('configmap', 'tasks-config').delete()
            def configmap = openshift.create('configmap', 'tasks-config',
              '--from-file=./configuration/application-users.properties',
              '--from-file=./configuration/application-roles.properties')

            // Deploy the development application.
            openshift.selector("dc", "tasks").rollout().latest();

            // Wait for application to be deployed
            def dc = openshift.selector("dc", "tasks").object()
            def dc_version = dc.status.latestVersion
            def rc = openshift.selector("rc", "tasks-${dc_version}").object()

            echo "Waiting for ReplicationController tasks-${dc_version} to be ready"
            while (rc.spec.replicas != rc.status.readyReplicas) {
              sleep 5
              rc = openshift.selector("rc", "tasks-${dc_version}").object()
            }
          }
        }
      }
    }
  }
}
