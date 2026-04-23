For Experiment 13, you are bringing everything together: GitHub (Version Control), Maven (Build/Test), and Jenkins (Automation). This is the core of Continuous Integration (CI).

Phase 1: Project Initialization & Code Setup
Generate the Project:

Bash
mvn archetype:generate -DgroupId=com.devops.lab -DartifactId=lab13-junit -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
Organize Folders: (To keep your GitHub clean)

Bash
mkdir experiment-13
move pom.xml experiment-13/
move src experiment-13/
Write Calculator.java in src/main/java/com/devops/lab/:

Java
package com.devops.lab;
public class Calculator {
    public int add(int a, int b) { return a + b; }
}
Write CalculatorTest.java in src/test/java/com/devops/lab/:

Java
package com.devops.lab;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.add(5, 5));
    }
}
Phase 2: Push to GitHub
Run these commands to send your code to your repo:

Bash
git add .
git commit -m "Setup Lab 13 with Maven and JUnit"
git push origin main
Phase 3: Jenkins Pipeline Configuration
Open Jenkins → New Item → Name it Experiment_13_CI → Select Pipeline → OK.

Scroll to the Pipeline script section and paste this (ensure the URL matches your repo):

Groovy
pipeline {
    agent any
    tools {
        maven 'Maven3' // Ensure 'Maven3' is configured in Jenkins Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/KruthiKShetty26/Dev_EXP3.git'
            }
        }
        stage('Build & Test') {
            steps {
                dir('experiment-13') {
                    // Use 'sh' for Linux/Mac or 'bat' for Windows
                    bat 'mvn clean test' 
                }
            }
        }
    }
}
Phase 4: Failure Demonstration (Crucial for Viva)
To show the examiner how Jenkins catches bugs:

Modify Calculator.java to be wrong: return a - b;

Push the bug:

Bash
git add .
git commit -m "Demonstrating test failure"
git push origin main
Build in Jenkins: The stage will turn RED. Check Console Output to see the error: expected: <10> but was: <0>.

Phase 5: Success Verification
Fix the code: Change it back to return a + b;.

Push the fix:

Bash
git add .
git commit -m "Fixed logic"
git push origin main
Build in Jenkins: The stage will turn GREEN.

Summary for Viva
What is CI? It's the practice of automating the building and testing of code every time a team member pushes changes to version control.

Why use dir('experiment-13')? Because the pom.xml is inside a subfolder, we must tell Jenkins to enter that directory before running Maven commands.

What is the benefit? Immediate feedback. If you break the code, you know within seconds, not days.
