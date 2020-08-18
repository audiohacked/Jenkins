// Publish the built war file to Nexus
stage('Publish to Nexus') {
  steps {
    dir('openshift-tasks') {
      echo "Publish to Nexus"
      sh """
        ${mvnCmd} deploy \
          -DskipTests=true \
          -DaltDeploymentRepository=nexus::default::http://${nexusUrl}/repository/releases
      """
    }
  }
}
