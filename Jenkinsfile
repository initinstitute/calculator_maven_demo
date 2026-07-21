pipeline {
    agent any

    tools {
        maven 'maven-3.9.16'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[
                        credentialsId: 'git_cred_maven',
                        url: 'https://github.com/initinstitute/calculator_maven_demo.git'
                    ]]
                )
            }
        }

        stage('Parallel') {
            parallel {

                stage('Build & Deploy') {
                    steps {
                        sh 'mvn clean install'
                    }
                }

                stage('Notification') {
                    steps {
                        sh 'echo "Maven deploy completed"'
                    }
                }

            }
        }

        stage('Complete') {
            steps {
                echo 'Pipeline is completed'
            }
        }

    }
}
