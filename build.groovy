pipeline {
    agent {
        node {
            label 'slave1'
        }
    }

    options {
        timestamps()
        skipStagesAfterUnstable()
        buildDiscarder(logRotator(numToKeepStr: '20', daysToKeepStr: '30'))
    }



    stages {

        stage('Compile') {
            steps {
                script {
                    try {
						sh "echo Compile"
                    }

                    catch (Exception errorlogs) {
                        println(errorlogs)
                        currentBuild.result = 'FAILED'
                        echo "Stage Status is ${currentBuild.result}"
                        error 'Exiting CI Pipeline'
                    }
                }
            }
        }

        stage('Unit Test') {
            steps {
                script {
                    try {
						sh "echo Unit Test"
                    }

                    catch (Exception errorlogs) {
                        println(errorlogs)
                        currentBuild.result = 'FAILED'
                        echo "Stage Status is ${currentBuild.result}"
                        error 'Exiting CI Pipeline'
                    }
                }
            }
        }		

        stage('Sonar Analysis') {
            steps {
                script {
                    try {
						sh "echo Sonar Analysis"
                    }

                    catch (Exception errorlogs) {
                        println(errorlogs)
                        currentBuild.result = 'FAILED'
                        echo "Stage Status is ${currentBuild.result}"
                        error 'Exiting CI Pipeline'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    try {
						dir ('apprepo') {
                        sh "echo Deploy"
						}
					}

                    catch (Exception errorlogs) {
                        println(errorlogs)
                        currentBuild.result = 'FAILED'
                        echo "Stage Status is ${currentBuild.result}"
                        error 'Exiting CI Pipeline'
                    }
                }
            }
        }	
		
}
}		
		
		