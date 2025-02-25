def gv

pipeline {
    agent any
    tools { 
        maven 'mvn-1' 
    }
    stages {
        stage("Init Groovy") {
            steps {
                script {
                    gv=load "script.groovy"
                    echo "Failed to load Groovy script"
                }
            }
        }
        stage("Build Jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("Build Image") {
            steps {
                script {
                    echo "Building the Docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh """echo "${PASS}" | docker login -u ${USER} --password-stdin"""
                        sh "docker build -t vineeth8686/demo-appp:jma-2.0 ."
                        sh "docker push vineeth8686/demo-appp:jma-2.0"
                    }
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    echo "Deploying the application"
                    sh "docker run --rm -dit --name javapp -p 8081:8080 vineeth8686/demo-appp:jma-2.0"
                }
            }
        }
    }
}
