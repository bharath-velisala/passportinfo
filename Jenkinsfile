pipeline{
    agent{
        docker{
            image 'maven:3.6.3-jdk-11'
            args '-v/root/.m2:/root/.m2'
        }
    }
    stages{
        stage('maven clean'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('maven compile'){
            steps{
                sh 'mvn compile'
            }
        }
        stage('sonar-analysis'){
            agent any
            steps{
                withSonarQubeEnv('SonarQube'){
                    sh 'mvn sonar:sonar'
                } 
            }
        }
    }
}
