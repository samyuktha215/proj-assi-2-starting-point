pipeline {
    agent any

    tools {
        // Run the Maven installation named "MY_MAVEN" and add it to the path.
        maven "MY_MAVEN"
    }

    stages {
        stage('clean and checkout') {
            steps {
                dir('backend') {
                    sh 'mvn clean'
                }
                echo 'downloading github project...'
                git branch: 'main', credentialsId: 'assignment2', url: 'https://github.com/samyuktha215/proj-assi-2-starting-point.git'
            }
        }

        stage('build') {
            steps {
                dir('backend') {
                    sh 'mvn test-compile'
                }
                echo 'building...'
                echo 'finished building'
            }
        }

        stage('test') {
            steps {
                dir('backend') {
                    sh 'mvn surefire:test'
                }
                echo 'starting test.....'
                // sh 'mvn test'
                
                echo 'finished test'
            }
        }

        stage('package') {
            steps {
                dir('backend') {
                  sh 'mvn war:war'
                }
                echo 'packaging...'
                
                echo 'packaged'
            }
        }
        stage('deploy') {
            steps {
                dir('backend') {
                    sh 'pwd' // prints /var/jenkins_home/workspace/proj_assi_2_starting_point/backend
                    sh 'cp target/ROOT.war /artifacts'
                }
            }
        }
    }
    
    post {
        always {
            echo 'generating test report....'

            sh 'ls ./backend/target/surefire-reports'
            
            dir('backend') {
               
               junit 'target/surefire-reports/*.xml'
            }
            
            echo 'test report generated'
        }
        failure {
              echo 'it has failed or something'
        }         
        
    }
}
