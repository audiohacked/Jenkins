// Build the Tasks Application in the directory 'openshift-tasks'
stage('Build war') {
    steps {
        dir('openshift-tasks') {
            echo "Building version ${devTag}"
            script {
                sh "${mvnCmd} clean package -DskipTests=true"
            }
        }
    }
}
