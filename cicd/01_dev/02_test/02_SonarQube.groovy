// Using Maven call SonarQube for Code Analysis
stage('Code Analysis') {
    steps {
        dir('openshift-tasks') {
            script {
                echo "Running Code Analysis"
                sh """
                ${mvnCmd} sonar:sonar \
                    -Dsonar.host.url=http://${sonarqubeUrl}/ \
                    -Dsonar.projectName=${GUID}-${JOB_BASE_NAME}-${devTag} \
                    -Dsonar.projectVersion=${devTag}
                """
            }
        }
    }
}
