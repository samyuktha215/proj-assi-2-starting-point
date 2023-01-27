pipeline {
    agent any

    tools {
        // Run the Maven installation named "MY_MAVEN" and add it to the path.
        maven "MY_MAVEN"
    }

    stages {
        stage('clean and checkout') {
            steps {
                sh 'mvn clean -f backend'
                echo 'downloading github project...'
                git credentialsId: 'assignment2', url: 'https://github.com/samyuktha215/proj-assi-2-starting-point.git'
            }
        }

        stage('build') {
            steps {
                echo 'building...'
                sh 'mvn test-compile'
                echo 'finished building'
            }
        }

        stage('test') {
            steps {
                echo 'starting test.....'
                // sh 'mvn test'
                sh 'mvn surefire:test'
                echo 'finished test'
            }
        }

        stage('package') {
            steps {
                echo 'packaging...'
                sh 'mvn war:war'
                echo 'packaged'
            }
        }
        stage('somestage') {
            steps {
                dir('backend') {
                    sh 'pwd' // prints /var/jenkins_home/workspace/proj_assi_2_starting_point/backend
                    sh 'mvn clean'
                }
            }
        }
    }
   
    post {
        always {
            echo 'generating test report....'
            junit 'target/*reports/**/*.xml'
            echo 'test report generated'
        }
        failure {
              echo 'it has failed or something'
        }         
        
    }
}
