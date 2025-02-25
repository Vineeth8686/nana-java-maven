pipeline{
    agent any
    tools {maven 'mvn-1'}
    stages{
        stage("build jar"){
            steps{
                script{
                    echo "building the application"
                    sh "maven package"
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