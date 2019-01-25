pipeline {
   
   agent any
   
   parameters {
   		  choice(name: 'SITES', choices: 'NYTimes\nCNN\nFoxNews', description: 'Select a site to build: ') 
    }
  stages{
  
    stage ('Create test image') {
            steps {
                script {
                        def image = docker.build("web-app:${BUILD_NUMBER}")
                        echo "Debug: Before push to registry"
                }
            }
          }


    stage ('Build on image'){ 
           agent {
                docker {
                        image "web-app:${BUILD_NUMBER}"
                        reuseNode true
                        }
                     }
              environment {
                      HOME = "${WORKSPACE}"
                      
                      }
              steps {
                      sh 'env'
                      sh 'mvn clean -X'
                           }
                         }
         
      stage ('Stage 1: Firefox') {
          agent {
              docker {
                        image "web-app:${BUILD_NUMBER}"
                        reuseNode true
                        }
                     }
              environment {
                      HOME = "${WORKSPACE}"
                      
                      }
            steps {
                    script {
                       if ("${params.SITES}" == "NYTimes") {
                            sh 'mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox'	
                       }
                      else { if ("${params.SITES}" == "CNN") {
                            sh 'mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox'	
                       }
                            else { if ("${params.SITES}" == "FoxNews") {
                            sh 'mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox'	
                       }
                       else {
                           currentBuild.result = "UNSTABLE"
                          }  
                         }
                       }
                }
            }

      }
            
      stage ('Stage 2: Chrome') {
            agent {
                docker {
                        image "web-app:${BUILD_NUMBER}"
                        reuseNode true
                        }
                     }
              environment {
                      HOME = "${WORKSPACE}"
                      
                      }
            steps {
                
                    script {
                       if ("${params.SITES}" == "NYTimes") {
                            sh 'mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome'	
                       }
                      else{  if ("${params.SITES}" == "CNN") {
                            sh 'mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome'	
                       }
                           else { if ("${params.SITES}" == "FoxNews") {
                            sh 'mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome'	
                       }
                       else {
                           currentBuild.result = "UNSTABLE"
                       }
                      }
                     }
                   }
                
            }

      }
     
      stage ('Publish Reports') {

            steps {
                   publishHTML (target: [ allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: "Serenity Report"     ])
            }
            
      }    
   
   }
}
