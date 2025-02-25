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
                    try {
                        gv = load "script.groovys"
                        echo "Groovy script loaded successfully"
                    } catch (Exception e) {
                        echo "Failed to load Groovy script: ${e}"
                    }
                }
            }
        }
        stage("Build Jar") {
            steps {
                script {
                    try {
                        gv.buildJar()
                    } catch (Exception e) {
                        echo "Failed to invoke buildJar method: ${e}"
                    }
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
