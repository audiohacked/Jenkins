// Blue/Green Deployment into Production
// -------------------------------------
stage('Blue/Green Production Deployment') {
  steps {
    dir('openshift-tasks') {
      echo "Deploying container image to Production Project"
      script {
        // TBD: Determine which application is active
        openshift.withCluster() {
          openshift.withProject("${prodProject}") {
            activeApp = openshift.selector("route", "tasks").object().spec.to.name
            if (activeApp == "tasks-green") {
              destApp = "tasks-blue"
            }
            echo "Active Application:      " + activeApp
            echo "Destination Application: " + destApp

            // Update the Image on the Production Deployment Config
            //      Set Image, Set VERSION
            openshift.set("image", "dc/${destApp}", "${destApp}=${intRegistryUrl}/${devProject}/${imageName}:${devTag}")
            openshift.set("env", "dc/${destApp}", "VERSION=\"${prodTag} (${destApp})\"")
            // def dc = openshift.selector("dc", "${destApp}").object()
            // dc.spec.template.spec.containers[0].image="${intRegistryUrl}/${devProject}/${imageName}:${devTag}"
            // dc.spec.template.spec.conatiners[0].env[0].value="${prodTag} (${destApp})"
            // openshift.apply(dc)

            // Update Config Map in change config files changed in the source
            //      (Re-)create ConfigMap
            openshift.selector("configmap", "${destApp}-config").delete()
            // def old_configmap = openshift.selector("configmap", "${destApp}-config")
            // if (old_configmap.exists()) {
            //   old_configmap.delete()
            // }
            def configmap = openshift.create("configmap", "${destApp}-config",
              "--from-file=./configuration/application-users.properties",
              "--from-file=./configuration/application-roles.properties" )

            // Deploy the inactive application.
            //      Deploy into the other application
            openshift.selector("dc", "${destApp}").rollout().latest();

            // Wait for application to be deployed
            //      Make sure the application is running and ready before proceeding
            def dc_prod = openshift.selector("dc", "${destApp}").object()
            def dc_version = dc_prod.status.latestVersion
            def rc_prod = openshift.selector("rc", "${destApp}-${dc_version}").object()
            echo "Waiting for ${destApp} to be ready"
            while (rc_prod.spec.replicas != rc_prod.status.readyReplicas) {
              sleep 5
              rc_prod = openshift.selector("rc", "${destApp}-${dc_version}").object()
            }
          }
        }
      }
    }
  }
}
