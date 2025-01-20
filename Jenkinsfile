pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M-U"
    }
    withCredentials([string(credentialsId: 'site_user', variable: 'USERNAME'), string(credentialsId: 'site_password', variable: 'PASSWORD')]) {
    // some block
}

    stages {
        stage('Build test') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/OlegShackleford/Jefit.git'

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn clean test -e -X -DsuiteXmlFile=src/test/resources/suite.xml -Duser=${USERNAME} -Dpassword=${PASSWORD}"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                }
            }
        }
    }
}
