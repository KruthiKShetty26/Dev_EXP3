For **Experiment 19**, you are reaching the peak of CI/CD integration. You will configure Jenkins to act as the "brain" that automatically triggers **Docker** to build and deploy your application. This removes the need for any manual `docker build` commands.

### **Phase 1: Source Code Setup**
Ensure your GitHub repository (`jenkins-docker-test`) has these two files:
1.  **`Grade.java`**: Your Java logic.
2.  **`Dockerfile`**:
    ```dockerfile
    FROM eclipse-temurin:17-jdk
    WORKDIR /app
    COPY . /app
    RUN javac Grade.java
    CMD ["java", "Grade"]
    ```

---

### **Phase 2: Jenkins Job Configuration**
1.  Open Jenkins and click **New Item**.
2.  Name it `Docker-Integration-Job` and select **Freestyle project**.
3.  **Source Code Management:** * Select **Git**.
    * Repository URL: `https://github.com/KruthiKShetty26/jenkins-docker-test.git`
4.  **Build Steps:**
    * If your Jenkins is on **Windows**, select **Execute Windows batch command**.
    * If your Jenkins is on **Linux/Docker**, select **Execute shell**.
5.  **Copy and paste these commands exactly:**
    ```batch
    :: Build the image from the Dockerfile
    docker build -t java-jenkins-app .
    
    :: Remove old container if it exists (prevents naming conflicts)
    docker rm -f test-container || true
    
    :: Run the container
    docker run --name test-container -d java-jenkins-app
    ```



---

### **Phase 3: Handling Permissions (Critical for Docker-in-Docker)**
If your Jenkins build fails with a "Permission Denied" error regarding the Docker socket, run this command in your **host machine's terminal** (not inside Jenkins):
```batch
docker exec -u 0 -it jenkins chmod 666 /var/run/docker.sock
```
*This allows the Jenkins user to talk to the Docker engine.*

---

### **Phase 4: Execution and Verification**
1.  Click **Build Now** in Jenkins.
2.  Click the build number (e.g., **#1**) and select **Console Output**.
3.  **The Goal:** You should see Jenkins successfully cloning the repo, running the `docker build` layers, and finishing with `Finished: SUCCESS`.



---

### **Key Concepts for Viva**

* **Continuous Integration (CI):** The specific act of Jenkins pulling code and building a Docker image automatically upon every change.
* **The Docker Socket (`/var/run/docker.sock`):** This is the "phone line" Jenkins uses to call the Docker engine and ask it to build images.
* **Freestyle vs. Pipeline:** A **Freestyle** project (used here) is configured via the Jenkins buttons and menus. A **Pipeline** uses a `Jenkinsfile` (script).
* **Why use Docker with Jenkins?** It ensures that Jenkins builds an image that is exactly the same as the one used in production, avoiding the "it works on my machine" problem.

**Outcome:** You have successfully automated the "Build-Ship-Run" cycle. Jenkins now handles the building and containerization of your application automatically.
