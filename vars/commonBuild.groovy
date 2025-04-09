// vars/commonBuild.groovy

def call() {
  pipeline {
    agent any

    stages {
      stage('Checkout') {
        steps {
          checkout scm
        }
      }

      stage('Build') {
        steps {
          sh 'gradle build'
        }
      }

      stage('Test') {
        steps {
          sh 'gradle test'
        }
      }

      stage('Deploy') {
        steps {
          sh 'ansible-playbook site.yml'
        }
      }
    }

    post {
      always {
        junit 'build/test-results/test/*.xml'
        archiveArtifacts 'build/libs/*.jar'
      }
    }
  }
}
