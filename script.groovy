def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    sh """echo "Building the Docker image"""
    sh """echo "${PASS}" | docker login -u ${USER} --password-stdin"""
    sh "docker build -t vineeth8686/demo-appp:jma-2.0 ."
    sh "docker push vineeth8686/demo-appp:jma-2.0"
}