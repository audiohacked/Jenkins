stage('Switch over to new Version') {
  steps{
    echo "Switching Production application to ${destApp}."
    script {
      // TBD: Execute switch
      //      Hint: sleep 5 seconds after the switch
      //            for the route to be fully switched over
      openshift.withCluster() {
        openshift.withProject("${prodProject}") {
          def route = openshift.selector("route", "tasks").object()
          route.spec.to.name="${destApp}"
          openshift.apply(route)

          sleep 5
        }
      }
    }
  }
}
