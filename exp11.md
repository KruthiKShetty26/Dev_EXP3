For Experiment 11, you will be using Maven to manage a Java project and JUnit to write automated tests. This is a foundational practice in DevOps known as Continuous Testing.

Follow these exact steps to complete the experiment.

Step 1: Verify Environment
Open your terminal or command prompt and ensure the tools are ready:

Bash
java -version
mvn -version
Step 2: Generate the Maven Project
Run the generation command:

Bash
mvn archetype:generate -DgroupId=com.devops.lab -DartifactId=lab11-junit -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
Move into the project directory:

Bash
cd lab11-junit
Step 3: Configure Dependencies (pom.xml)
Open the pom.xml file in your editor and replace the <dependencies> and <build> sections with this exact code to support JUnit 5:

XML
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope=test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
    </plugins>
</build>
Step 4: Create the Java Program
Navigate to src/main/java/com/devops/lab/.

Delete App.java and create a new file named Calculator.java.

Paste the following code:

Java
package com.devops.lab;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int divide(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
Step 5: Create the Unit Tests
Navigate to src/test/java/com/devops/lab/.

Delete AppTest.java and create a new file named CalculatorTest.java.

Paste the following code:

Java
package com.devops.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
Step 6: Run the Tests
Go back to your terminal (in the lab11-junit root folder) and run:

Bash
mvn clean test
Step 7: Verify Results
Terminal: Look for Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 and BUILD SUCCESS.

Reports: Check the target/surefire-reports folder. You will find XML and text files summarizing the test results.
