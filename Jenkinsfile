pipeline{
    agent any
    tool {name: 'mvn-1', type: 'maven'}
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