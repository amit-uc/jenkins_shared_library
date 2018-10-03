def call(Map data) {
    stage('checkout') {
        node('master') {
            // Checks Out to Specific Branch
            git branch: 'staging', url: 'git@github.com:amithapa/development_docker.git'
            echo data
        }
    }
}