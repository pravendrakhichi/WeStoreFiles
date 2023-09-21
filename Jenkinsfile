pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }
    
    environment{
        NAME = 'John'
    }

    stages {
        
        stage('Build') {
            
            steps {
                echo "Building project"
                bat 'echo %JAVA_HOME%'
              
                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always{
                    echo "always after build"
                }
                success {
//                     junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
                failure{
                    echo "build failed post runner"
                }
                unstable{
                    echo "build unstable post runner"
                }
            }
        }

        stage('Test') {
            steps {
                retry(2){
                  bat 'echo "Testing project"'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying project"
                bat '''
                    call javaX "java-17" %1
                    java -jar C:\\Users\\prave\\.jenkins\\workspace\\fileStoragePipeline\\target\\WeStoreFiles-1.0.jar
                '''
            }
        }
    }
}