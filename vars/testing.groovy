def call() {
    stage('checkout') {
        node('master') {
            // Checks Out to Specific Branch
            git branch: 'staging', url: 'git@github.com:amithapa/development_docker.git'
            String pipeline_json_path = "pipeline.json"

            // Read the pipeline Configuration
            data = readFile pipeline_json_path
            // Convert to map
            def jsonSlurper = new groovy.json.JsonSlurper()
            def pipeline_map_data = jsonSlurper.parseText(data)

            sh "echo ${data}"
        }
    }
}