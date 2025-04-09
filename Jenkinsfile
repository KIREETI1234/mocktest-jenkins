@Library('my-shared-library') _

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
        commonBuild()
      }
    }
  }
}
