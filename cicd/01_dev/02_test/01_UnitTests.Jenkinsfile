// Using Maven run the unit tests
stage('Unit Tests') {
    steps {
        dir('openshift-tasks') {
        echo "Running Unit Tests"
        sh "${mvnCmd} test"
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        }
    }
}
