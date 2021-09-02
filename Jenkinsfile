pipeline {
  agent any
    stages {
      stage('commit') {
        steps {
          bat './gradlew clean test'
        }
      }
    }

    post {
        always {
          archiveArtifacts(artifacts: 'build/', fingerprint: true)
        }
        success {
          emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}',
                    to: "jorge.caceres@jalasoft.com",
                    subject: 'Jenkins build is ok: $PROJECT_NAME - #$BUILD_NUMBER - $BUILD_STATUS'
        }
        failure {
          emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}',
                   to: "jorge.caceres@jalasoft.com",
                   subject: 'Build failed in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER - $BUILD_STATUS'
        }
        unstable {
          emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}',
                   to: "jorge.caceres@jalasoft.com",
                   subject: 'Unstable build in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER - $BUILD_STATUS'
        }
        changed {
          emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}',
                   to: "jorge.caceres@jalasoft.com",
                   subject: 'Jenkins build status has changed: $PROJECT_NAME - #$BUILD_NUMBER - $BUILD_STATUS'
        }
      }
}