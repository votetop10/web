
pipeline {
   
   agent any
   
   parameters {
   		  choice(name: 'SITES', choices: 'NYTimes\nCNN\nFoxNews', description: 'Select a site to build: ')
    
    }
    
    stages {
    
      stage ('Compile Stage') {
      	
          	steps {
                withEnv(["JAVA_HOME=${ tool 'JDK 8' }", "PATH+MAVEN=${tool 'Maven 3'}/bin:${env.JAVA_HOME}/bin"]) {
                      sh 'mvn clean'
                }
          	}
         
      }
        
      stage ('Stage 1: Firefox') {
      
             
            steps {
                withEnv(["JAVA_HOME=${ tool 'JDK 8' }", "PATH+MAVEN=${tool 'Maven 3'}/bin:${env.JAVA_HOME}/bin"]) {
                
                    script {
                       if ("${params.SITES}" == "NYTimes") {
                            sh 'mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox'	
                       }
                       if ("${params.SITES}" == "CNN") {
                            sh 'mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox'	
                       }
                       if ("${params.SITES}" == "FoxNews") {
                            sh 'mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox'	
                       }
                       else {
                           currentBuild.result = "UNSTABLE"
                       }
                    }
                }
            }

      }
            
      stage ('Stage 2: Chrome') {

            steps {
                withEnv(["JAVA_HOME=${ tool 'JDK 8' }", "PATH+MAVEN=${tool 'Maven 3'}/bin:${env.JAVA_HOME}/bin"]) {
                
                    script {
                       if ("${params.SITES}" == "NYTimes") {
                            sh 'mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome'	
                       }
                       if ("${params.SITES}" == "CNN") {
                            sh 'mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome'	
                       }
                       if ("${params.SITES}" == "FoxNews") {
                            sh 'mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome'	
                       }
                       else {
                           currentBuild.result = "UNSTABLE"
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
