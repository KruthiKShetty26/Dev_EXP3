For Experiment 14, you will use JaCoCo (Java Code Coverage), which is a vital tool for ensuring the quality of your code. It tells you exactly which lines of your code were tested and which were missed.

Phase 1: Project Setup
Create Folders: Open CMD and run these commands to create the directory structure manually:

Code snippet
mkdir devops-lab14\src\main\java\com\devops\lab
mkdir devops-lab14\src\test\java\com\devops\lab
cd devops-lab14
Create the Source Code: Create Calculator.java in src\main\java\com\devops\lab\:

Java
package com.devops.lab;
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public int multiply(int a, int b) { return a * b; }
}
Create the Test Code: Create CalculatorTest.java in src\test\java\com\devops\lab\:

Java
package com.devops.lab;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class CalculatorTest {
    Calculator calc = new Calculator();
    @Test
    void testAdd() { assertEquals(10, calc.add(5, 5)); }
    @Test
    void testMultiply() { assertEquals(25, calc.multiply(5, 5)); }
}
Configure the POM: Create pom.xml in the devops-lab14 root. This file includes the JaCoCo Maven Plugin, which is the "engine" that measures coverage.

Phase 2: Execution and Analysis
Run the Analysis:

Code snippet
mvn clean test
This command compiles the code, runs the tests, and triggers JaCoCo to "instrument" the code to track execution.

View the Report:

Code snippet
explorer target\site\jacoco\index.html
This opens a browser window. You will see a table showing 100% coverage. If you click through the links, you will see green highlights on the lines that were executed.

Phase 3: Jenkins CI Integration
Push to GitHub:

Code snippet
git add .
git commit -m "Added JaCoCo coverage lab"
git push origin main
Configure Jenkins Pipeline: Create a new Pipeline job named Experiment_14_Coverage.

Pipeline Script: Use the following script. Notice the Archive Coverage Report stage—this saves the HTML report so you can view it directly from the Jenkins dashboard.

Groovy
pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/KruthiKShetty26/Dev_EXP3.git'
            }
        }
        stage('Build & Test') {
            steps {
                dir('devops-lab14') {
                    bat 'mvn clean test'
                }
            }
        }
        stage('Archive Coverage Report') {
            steps {
                // This saves the JaCoCo HTML files as Jenkins artifacts
                archiveArtifacts artifacts: 'devops-lab14/target/site/jacoco/**', allowEmptyArchive: true
            }
        }
    }
}
Key Concepts for Viva
What is Code Coverage? A metric that shows the percentage of source code executed during testing.

Why is 100% important? While 100% doesn't guarantee "bug-free" code, it ensures that every logical path has been at least touched by a test.

Green vs. Red in Reports: In the JaCoCo HTML report, Green means the line was executed, Yellow means a partial branch (like an if without an else) was hit, and Red means the line was completely missed.

Outcome: You have successfully integrated automated quality metrics into your CI/CD pipeline, allowing the team to see code quality with every build.
