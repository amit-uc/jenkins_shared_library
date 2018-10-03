def call(String git_repository, String git_username='amithapa', String git_branch='staging', String pipeline_json_path='pipeline.json') {

    stage('checkout') {
        node('master') {
            // Checks Out to Specific Branch
            git branch: "${git_branch}", url: "git@github.com:${git_username}/${git_repository}.git"

            // Read the pipeline Configuration
            data = readFile pipeline_json_path
            // Convert to map
            def jsonSlurper = new groovy.json.JsonSlurper()
            def pipeline_map_data = jsonSlurper.parseText(data)
            application_name = pipeline_map_data.application_name

            echo data
        }
    }

    stage('Build and Test') {
        node('master') {
            echo "Build and Test"
        }
    }

    stage('Deploy on Staging') {
        node('master') {
            echo 'Deploy on Staging'
        }
    }

    stage('Deploy on Production') {
        node('master') {
            echo 'Deploy on Production'
        }
    }


}