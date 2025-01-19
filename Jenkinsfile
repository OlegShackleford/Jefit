pipeline {
    agent any

    tools {
        // Указываем инструмент Maven, настроенный в Jenkins
        maven "M-U"
    }

    stages {
        stage('Checkout') {
            steps {
                // Клонируем репозиторий
                git 'https://github.com/OlegShackleford/Jefit'
            }
        }

        stage('Run Tests') {
            steps {
                // Подключаем учетные данные с их Credential IDs
                withCredentials([
                    string(credentialsId: 'site_user', variable: 'USERNAME'),
                    string(credentialsId: 'site_password', variable: 'PASSWORD')
                ]) {
                    // Запускаем тесты с переданными учетными данными
                    bat "mvn clean test -DsuiteXmlFile=src/test/resources/suite.xml -Duser=${USERNAME} -Dpassword=${PASSWORD}"
                }
            }
        }

        stage('Allure Report') {
            steps {
                // Генерация Allure-отчета
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            // Архивирование Allure-результатов
            archiveArtifacts artifacts: '**/target/allure-results/**', fingerprint: true
        }
        success {
            // Добавление JUnit отчетов
            junit '**/target/surefire-reports/TEST-*.xml'
        }
        failure {
            echo "Build failed"
        }
    }
}