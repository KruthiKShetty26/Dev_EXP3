Step 1: Create the Pipeline Job
Open Jenkins and click New Item.

Enter Name: Experiment_9_Pipeline

Select Pipeline (not Freestyle).

Click OK.

Step 2: Define the Pipeline Script
Scroll down to the Pipeline section.

Ensure Definition is set to "Pipeline script".

In the Script box, copy and paste this entire block exactly:

Groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling code from GitHub...'
                // This simulates pulling your repo
                git 'https://github.com/KruthiKShetty26/Dev_EXP3.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                // Simulating a build command
                bat 'echo "Compilation in progress..." > build_status.txt'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Unit Tests...'
                // Simulating a test command
                bat 'echo "Tests Passed: 100%" >> build_status.txt'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying to Staging Environment...'
                bat 'type build_status.txt'
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline execution finished.'
        }
        success {
            echo 'Project is healthy and ready for production!'
        }
    }
}
Step 3: Run the Pipeline
Click Save.

On the left menu, click Build Now.

You will notice the interface looks different. A Stage View will appear, showing separate boxes for Checkout, Build, Test, and Deploy.

Step 4: Analyze the Outcome
Wait for all boxes in the Stage View to turn green.

Hover over the green boxes to see the duration of each stage.

Click on the build number (e.g., #1) and select Console Output.

You will see how Jenkins clearly separates the logs by stage:

[Pipeline] { (Checkout)

[Pipeline] { (Build)

[Pipeline] { (Test)

...and finally Finished: SUCCESS.

Key Concepts to Remember for the Lab:
Pipeline: The top-level block that contains the entire automation script.

Agent: Defines where the execution happens (any means any available Jenkins executor).

Stages: Logical divisions of the workflow (e.g., Build, Test, Deploy).

Steps: The actual commands executed inside a stage (e.g., echo or bat).

Post: Actions taken based on whether the pipeline succeeded or failed.

Outcome achieved: You have successfully created a Declarative Pipeline that automates a multi-stage software delivery process.
