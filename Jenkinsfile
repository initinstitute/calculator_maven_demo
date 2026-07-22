pipeline {
    agent any
    parameters{
        string(
            name: 'version',
            defaultValue: 'v1.0',
            description: 'enter the version you want to pass'
        )
    }

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
                        echo "Maven deployed with version ${params.version} completed"
                    }
                }
             stage('Notification2') {
                    steps {
                        sh '''
                        echo "Maven deployed with version $version completed"
                        '''
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
