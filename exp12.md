For Experiment 12, you will explore the two most popular build automation tools in the Java ecosystem: Maven and Gradle. While Maven uses XML-based configuration, Gradle uses a more modern, script-based approach.

Phase 1: Maven Setup
Step 1: Verify & Generate Project
Open your terminal and verify tools:

Bash
mvn -version
gradle -version
Generate the project:

Bash
mvn archetype:generate -DgroupId=com.devops.lab -DartifactId=lab12-maven -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
Navigate into the folder:

Bash
cd lab12-maven
Step 2: Configure Maven (pom.xml)
Open pom.xml and replace its content with this configuration to support JUnit 5 and Java 17:

XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.devops.lab</groupId>
    <artifactId>lab12-maven</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.release>17</maven.compiler.release>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
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
</project>
Step 3: Create Java Files
Create src/main/java/com/devops/lab/App.java:

Java
package com.devops.lab;
public class App {
    public int multiply(int a, int b) { return a * b; }
}
Create src/test/java/com/devops/lab/AppTest.java:

Java
package com.devops.lab;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AppTest {
    @Test
    void testMultiply() {
        App app = new App();
        assertEquals(20, app.multiply(4, 5));
    }
}
Step 4: Run Maven Build
Bash
mvn clean test
Phase 2: Gradle Setup
Step 5: Create Folder Structure
Move out of the Maven folder and create a new directory:

Bash
cd ..
mkdir lab12-gradle
cd lab12-gradle
mkdir src\main\java\com\devops\lab
mkdir src\test\java\com\devops\lab
Step 6: Create build.gradle
Create a file named build.gradle and paste this configuration:

Groovy
plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}

test {
    useJUnitPlatform()
}
Step 7: Transfer Code & Run
Copy the files you wrote in Phase 1 into your new Gradle folders:

Bash
copy "..\lab12-maven\src\main\java\com\devops\lab\App.java" "src\main\java\com\devops\lab\"
copy "..\lab12-maven\src\test\java\com\devops\lab\AppTest.java" "src\test\java\com\devops\lab\"
Run the Gradle test:

Bash
gradle test
