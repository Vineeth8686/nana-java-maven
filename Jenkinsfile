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
                    
                        gv = load "script.groovy"
                        echo "Groovy script loaded successfully" 
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
        }
        stage("Build Image") {
            steps {
                script {
                    
                    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        gv.buildImage()
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
