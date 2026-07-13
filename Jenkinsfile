pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }
	environment {
        SONAR_TOKEN = credentials('sonar-tokens')
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
                docker run -d --name springbootapi -p 9000:5000 springbootapi
                '''
            }
        }
		        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh """
                    mvn sonar:sonar \
                    -Dsonar.projectKey=java-app \
                    -Dsonar.host.url=http://13.126.244.207:2222/ \
                    -Dsonar.login=$SONAR_TOKEN
                    """
                }
            }
        }
    }
}
