// Checkout Source Code.
stage('Checkout Source') {
    steps {
        checkout scm
        // git branch: 'master', url: ''
        // dir('openshift-tasks') {
        //     script {
        //         def pom = readMavenPom file: 'pom.xml'
        //         def version = pom.version

        //         // Set the tag for the development image: version + build number
        //         devTag  = "${version}-" + currentBuild.number
        //         // Set the tag for the production image: version
        //         prodTag = "${version}"

        //         // Patch Source artifactId to include GUID
        //         sh "sed -i 's/GUID/${GUID}/g' ./pom.xml"
        //     }
        // }
    }
}
