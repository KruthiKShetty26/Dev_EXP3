For Experiment 10, you will focus on the troubleshooting and visualization aspects of Jenkins. You will intentionally create a "failure" in your pipeline to learn how to identify, analyze, and fix issues using the Jenkins UI and logs.

Step 1: Create the "Debug" Pipeline
Open Jenkins and click New Item.

Enter Name: Experiment_10_Troubleshooting

Select Pipeline and click OK.

Scroll to the Pipeline section and paste this script. Note the intentional error in the 'Test' stage:

Groovy
pipeline {
    agent any
    stages {
        stage('Initialize') {
            steps {
                echo 'Initializing Environment...'
            }
        }
        stage('Build') {
            steps {
                echo 'Building application...'
                bat 'echo "Build Complete" > status.txt'
            }
        }
        stage('Test') {
            steps {
                echo 'Running automated tests...'
                // INTENTIONAL ERROR: Calling a command that doesn't exist to trigger failure
                bat 'non_existent_command_123'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
Step 2: Execute and Observe the Failure
Click Save and then click Build Now.

In the Stage View, you will see the "Initialize" and "Build" boxes turn green, but the "Test" box will turn Red.

The "Deploy" stage will be skipped (greyed out) because the pipeline stops at the first point of failure.

Step 3: Analyze the Logs (The "How-To")
To find out why it failed, you must check the Console Output:

Click on the build number (e.g., #1) in the Build History.

Click Console Output on the left menu.

Scroll to the bottom. Look for the error message in red text. It will likely say:
'non_existent_command_123' is not recognized as an internal or external command...
script returned exit code 1

Notice that Jenkins marks the exact line where the execution stopped.

Step 4: Debug and Fix
Go back to your job and click Configure.

Scroll down to the Pipeline script.

Fix the error by changing the bat 'non_existent_command_123' line to a valid command:

Groovy
bat 'echo "All tests passed successfully!"'
Click Save and click Build Now again.

Step 5: Compare Results
Observe the Stage View for Build #2. All stages should now be green.

Compare the Pipeline Timeline (found by clicking the build number > Pipeline Steps). This view shows exactly how many seconds each individual command took to run.

Learning Outcome for your Lab Record:
Visualization: The Stage View provides a high-level status of the workflow.

Logs: The Console Output is the primary tool for identifying technical errors (Syntax errors, environment issues, or failed tests).

Interdependency: If a critical stage fails, subsequent stages are skipped to prevent deploying "broken" code.

You have now completed the visualization and troubleshooting experiment! This covers the standard flow for identifying CI/CD bottlenecks and errors.
