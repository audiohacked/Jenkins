// Copy Image to Nexus Container Registry
stage('Copy Image to Nexus Container Registry') {
  steps {
    echo "Copy image to Nexus Container Registry"
    script {
      // TBD: Copy image to Nexus container registry
      sh """
        skopeo copy \
          --src-tls-verify=false \
          --dest-tls-verify=false \
          --src-creds openshift:\$(oc whoami -t) \
          --dest-creds ${nexusCreds} \
          docker://${intRegistryUrl}/${devProject}/${imageName}:${devTag} \
          docker://${nexusRegistryUrl}/${prodProject}/${imageName}:${prodTag}
      """

      // TBD: Tag the built image with the production tag.
      openshift.withCluster() {
        openshift.withProject("${prodProject}") {
          openshift.tag("${devProject}/${imageName}:${devTag}", "${prodProject}/${imageName}:${prodTag}")
        }
      }
    }
  }
}
