#! groovy
/* Instead of get the jenkins library from other repository and working in a monorepository environment like we are
*  assuming, we are going to load de jenkins library from the same repo where code from all apps is stored.
*/
def mainLibrary = library (identifier: 'mainMonoRepoLib@master', retriever: modernSCM(
  [$class: 'GitSCMSource',
   remote: 'file:///C:/_/codeprojects/ejercicioMircroservicios/.git']))

pipeline {
    agent any

    stages {
        // Identification of changed projects inside mono-repository
        stage('Finding changed projects in monorepo') {
            steps {
                processingMonoRepoMultiApp()
            }
        }
    }

    post {
        always {
            script {
                echo '-=- Slack Notification -=-'
                buildStatus =  currentBuild.result ?: 'SUCCESSFUL'
                // Default values
                subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
                summary = "${subject} (${env.BUILD_URL})"
                // Override default values based on build status
                if (buildStatus == 'STARTED') {
                    color = 'YELLOW'
                    colorCode = '#FFFF00'
                } else if (buildStatus == 'SUCCESSFUL') {
                    color = 'GREEN'
                    colorCode = '#00FF00'
                } else {
                    color = 'RED'
                    colorCode = '#FF0000'
                }
                // Send notifications
                slackSend (color: colorCode, message: summary)
            }
            //deleteDir() /* clean up our workspace */
        }
    }
}
