pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/birarivb/springbootapi.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Image') {
            steps {
                sh 'docker build -t springbootapi .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker rm -f springbootapi || true
                docker run -d --name springbootapi -p 8080:5000 springbootapi
                '''
            }
        }
    }
}