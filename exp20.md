To perform **Experiment 20**, you will execute a full "Build-Test-Deploy" cycle. This experiment is the culmination of DevOps, where every code change is automatically verified and hosted.

### **Phase 1: Project Structure & File Creation**
On your local machine, open a command prompt and set up the directory structure manually.

**1. Create Directories:**
```batch
mkdir cicd-web-app
cd cicd-web-app
mkdir src\main\java\com\example
mkdir src\main\webapp\WEB-INF
mkdir src\test\java\com\example
```

**2. Create the Application Files:**
Use Notepad to create the following files with the logic provided in your manual:
* **`src\main\java\com\example\HelloServlet.java`**: The Java backend logic.
* **`src\main\webapp\WEB-INF\web.xml`**: Mapping the URL to the servlet.
* **`src\main\webapp\index.jsp`**: The frontend landing page.
* **`src\test\java\com\example\HelloServletTest.java`**: The Mockito-based unit test.
* **`pom.xml`**: The Maven configuration (ensure `<finalName>sample-webapp</finalName>` is present).
* **`Dockerfile`**: Instructions to package the app into Tomcat.
* **`Jenkinsfile`**: The pipeline script defining the stages.

**Note:** After saving in Notepad, ensure you rename the files to remove `.txt`:
`ren Dockerfile.txt Dockerfile` and `ren Jenkinsfile.txt Jenkinsfile`.



---

### **Phase 2: Version Control (GitHub)**
Push your local code to a new GitHub repository.
```batch
git init
git add .
git commit -m "Complete CI/CD setup"
git branch -M main
git remote add origin https://github.com/KruthiKShetty26/jenkins-tomcat-tested.git
git push -u origin main
```

---

### **Phase 3: Jenkins Configuration**

**1. Configure Maven Tool:**
* Navigate to **Manage Jenkins** → **Tools**.
* Under **Maven**, click **Add Maven**.
* Name it `mymaven` (this must match your Jenkinsfile).
* Select **Install automatically** and click **Save**.

**2. Create the Pipeline Job:**
* **New Item** → Name: `Final-Pipeline` → Select **Pipeline** → **OK**.
* Under **Pipeline Definition**, select **Pipeline script from SCM**.
* **SCM:** Git.
* **Repository URL:** Your GitHub URL.
* **Script Path:** Ensure it says `Jenkinsfile`.
* Click **Save**.



---

### **Phase 4: Execution and Deployment**
1.  **Trigger the Build:** Click **Build Now** in Jenkins.
2.  **Monitor the Stages:**
    * **Build & Test:** Maven compiles the code and runs JUnit/Mockito tests.
    * **Docker Build:** A Tomcat image is created with your `.war` file.
    * **Deploy:** The container is launched on the host machine.
3.  **Verify via Browser:**
    * Navigate to `http://localhost:8087/sample-webapp`.
    * You should see the welcome page. Click the link to verify the servlet output: **"Deployment Successful!"**

---

### **Summary of the Lifecycle**
The pipeline ensures that if any stage fails (e.g., a test fails), the deployment is aborted, protecting the production environment.



**Key Viva Check:**
* **Mockito's Role:** It "mocks" the `HttpServletRequest` so we can test the servlet without a running browser or server.
* **The Container:** We use `tomcat:9.0-jdk11-openjdk` as a base because it provides the environment needed to run Java Web Archives (WAR).
