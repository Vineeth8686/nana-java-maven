pipeline{
    agent any
    tools {maven 'mvn-1'}
    stages{
        stage("build jar"){
            steps{
                script{
                    echo "building the application"
                    sh "mvn package"
                }
            }
        }
         stage("build image"){
            steps{
                script{
                    
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                sh """echo "${PASS}"| docker login -u ${USER} --password-stdin"""
                sh "docker build -t vineeth8686/demo-appp:jma-2.0 "

                }
            }
        }
    }
        stage("deploy"){
            steps{
                script{

                    echo "deploying the application"

                }
            }
        }
    }
}