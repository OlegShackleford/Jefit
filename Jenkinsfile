pipeline {
    agent any

    tools {
        // Устанавливаем Maven версии "M-U"
        maven "M-U"
    }

    stages {
        stage('Build test') {
            steps {
                // Получаем код из репозитория GitHub
                git 'https://github.com/OlegShackleford/Jefit.git'

                // Используем withCredentials для доступа к секретам
                withCredentials([string(credentialsId: 'site_user', variable: 'USERNAME'), 
                                 string(credentialsId: 'site_password', variable: 'PASSWORD')]) {
                    // Запускаем Maven с переданными пользователем и паролем
                    bat "mvn clean test -e -X -DsuiteXmlFile=src/test/resources/suite.xml -Duser=${USERNAME} -Dpassword=${PASSWORD}"
                }
            }

            post {
                success {
                    // Если тесты прошли, записываем результаты и генерируем отчет Allure
                    junit '**/target/surefire-reports/TEST-*.xml'
                    allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                }
            }
        }
    }
}
