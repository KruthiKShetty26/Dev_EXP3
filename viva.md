Since you’ve been working through the practical steps of Git, Maven, and Jenkins, an examiner will likely test if you actually understand *why* you clicked those buttons.

Here are the most likely Viva questions based on our conversation, divided by topic.

### **Topic 1: Git & GitHub (Exp 1-5)**

1.  **What is the difference between `git pull` and `git fetch`?**
    * *Answer:* `git fetch` only downloads the metadata and changes from the remote repo but doesn't change your local files. `git pull` does a `git fetch` AND a `git merge` immediately.
2.  **What does the `-M` in `git branch -M main` do?**
    * *Answer:* It forces the renaming of the current branch to "main." It’s used to ensure the primary branch is named correctly before pushing to GitHub.
3.  **Why do we use `git push -u origin main`? What does `-u` do?**
    * *Answer:* The `-u` flag sets the "upstream" tracking. It links your local branch to the remote branch so that in the future, you can just type `git push` or `git pull` without specifying the name.
4.  **What is a "Pull Request" (PR)?**
    * *Answer:* A PR is a way to propose changes to a repository. It allows others to review your code on a separate branch before it is merged into the main code.
5.  **What is the purpose of Git Tagging (Exp 5)?**
    * *Answer:* Tags are used to mark specific points in history as important, usually for release versions (like v1.0). Unlike branches, tags do not change.

---

### **Topic 2: Maven (Exp 6)**

6.  **What is a `pom.xml` file?**
    * *Answer:* POM stands for Project Object Model. It is the XML file that contains all the configuration for the project, including dependencies (like JUnit) and plugins.
7.  **Explain the Maven Build Lifecycle (Clean, Compile, Package).**
    * *Answer:* * `clean`: Removes the `target` folder (old builds).
        * `compile`: Converts `.java` files to `.class` files.
        * `package`: Takes the compiled code and bundles it into a `.jar` or `.war` file.
8.  **Where does Maven store downloaded dependencies?**
    * *Answer:* In the local repository, which is usually the `.m2` folder in your user directory.

---

### **Topic 3: Jenkins (Exp 7-8)**

9.  **What is Jenkins and why is it called a CI tool?**
    * *Answer:* Jenkins is an open-source automation server. It’s a **Continuous Integration (CI)** tool because it allows developers to integrate code into a shared repository frequently, automatically triggering builds and tests.
10. **What is a "Freestyle Project" in Jenkins?**
    * *Answer:* It is a repeatable build job that allows you to configure steps (like pulling code and running Maven) through a graphical user interface (UI) without writing code.
11. **Explain the difference between SCM Polling and Webhooks.**
    * *Answer:* * **Polling:** Jenkins "asks" GitHub every minute if there are changes.
        * **Webhook:** GitHub "tells" Jenkins immediately when a change is pushed.
12. **What is the significance of the `* * * * *` schedule?**
    * *Answer:* It uses Cron syntax. The five stars represent: Minute, Hour, Day of Month, Month, and Day of Week. `* * * * *` means "every minute of every hour of every day."
13. **What is an "Artifact" in Jenkins?**
    * *Answer:* An artifact is the output file generated during the build process, such as a `.jar` or `.war` file, which is archived for later use or deployment.

---

### **Topic 4: Troubleshooting (Exp 10)**

14. **If a build fails (turns Red), where is the first place you check?**
    * *Answer:* The **Console Output**. It provides the full log of the build and will show exactly which command (Maven, Git, etc.) caused the error.
15. **Why do we need the `initialAdminPassword`?**
    * *Answer:* It is a security feature to ensure that only the person with physical/terminal access to the server can perform the initial setup of Jenkins.

---

### **Bonus Tip for your Exam:**
If they ask, **"What is DevOps?"**, give them this 1-sentence answer:
> "DevOps is a set of practices that combines software development (Dev) and IT operations (Ops) to shorten the systems development life cycle and provide continuous high-quality delivery."


Here are the most likely viva questions for Experiments 13 through 20, categorized by topic. These cover basic definitions, technical "why" questions, and troubleshooting scenarios.

### **Topic 1: Jenkins & CI/CD (Exps 13, 19, 20)**
1.  **What is the difference between Continuous Integration (CI) and Continuous Deployment (CD)?**
    * *Answer:* CI is the practice of automatically building and testing code every time a change is pushed. CD (Delivery) ensures the code is always in a deployable state, while CD (Deployment) automatically pushes those changes to production.
2.  **What is a Jenkinsfile?**
    * *Answer:* It is a text file that contains the definition of a Jenkins Pipeline and is checked into source control. It allows "Pipeline as Code."
3.  **In a Jenkins Pipeline, what is the purpose of the `agent any` directive?**
    * *Answer:* It tells Jenkins to run the pipeline or stage on any available executor/node in the Jenkins environment.
4.  **What is the "Stage View" in Jenkins?**
    * *Answer:* It is a visual dashboard that shows the progress of different phases (Checkout, Build, Test, Deploy) and how much time each took.
5.  **Why do we use the `|| true` command in shell scripts within Jenkins?**
    * *Answer:* It prevents the pipeline from failing if a command (like `docker stop`) fails. It ensures the script continues to the next line.

### **Topic 2: JUnit & JaCoCo (Exps 13, 14, 20)**
1.  **What is the difference between "Line Coverage" and "Branch Coverage" in JaCoCo?**
    * *Answer:* Line coverage measures if a specific line was executed. Branch coverage measures if all paths (True/False) in an `if` or `switch` statement were executed.
2.  **Why is 100% code coverage not a guarantee that the software is bug-free?**
    * *Answer:* Coverage only shows that the code was *executed*, not that the logic is correct for all possible user inputs or edge cases.
3.  **What is "Mocking" and why did we use Mockito in Experiment 20?**
    * *Answer:* Mocking creates "fake" versions of complex objects (like a Web Server's Request/Response). We use it to test logic without needing a full server running.
4.  **What does the `@Test` annotation do in JUnit?**
    * *Answer:* It tells the JUnit runner that the following method is a test case that should be executed.

### **Topic 3: Docker Fundamentals (Exps 15, 16)**
1.  **What is the difference between a Docker Image and a Docker Container?**
    * *Answer:* An image is a static, read-only template (the blueprint). A container is a running instance of that image (the actual process).
2.  **What is the purpose of the `FROM` instruction in a Dockerfile?**
    * *Answer:* It initializes a new build stage and sets the Base Image (e.g., `python:3.9` or `openjdk:17`) for subsequent instructions.
3.  **What is the difference between `docker ps` and `docker ps -a`?**
    * *Answer:* `docker ps` shows only currently running containers; `-a` shows all containers, including those that have exited or stopped.
4.  **How does Docker help in solving the "it works on my machine" problem?**
    * *Answer:* It packages the application with all its dependencies and environment settings into a single container that runs identically on any system.

### **Topic 4: Docker Advanced & Integration (Exps 17, 18, 19)**
1.  **What is Port Mapping and why is it necessary?**
    * *Answer:* It connects a port on the host machine to a port inside the container. It’s necessary because containers have their own isolated network.
    * 
2.  **What are Docker Volumes?**
    * *Answer:* They are a mechanism for persisting data generated by and used by Docker containers. Data in a volume stays safe even if the container is deleted.
3.  **Why do we need to "Tag" an image before pushing it to Docker Hub?**
    * *Answer:* Tagging allows you to associate the image with your specific username and repository name so Docker Hub knows where to store it.
4.  **What is the Docker Socket (`/var/run/docker.sock`)?**
    * *Answer:* It is the API entry point that the Docker CLI uses to communicate with the Docker Daemon. Jenkins needs access to it to run Docker commands.
5.  **What is the difference between `COPY` and `ADD` in a Dockerfile?**
    * *Answer:* Both copy files, but `ADD` has extra features like extracting ZIP files and downloading files from URLs. `COPY` is generally preferred for simple file transfers.

### **Scenario-Based Questions (Problem Solving)**
1.  **If your Jenkins build fails at the "Build" stage, where do you look for the error?**
    * *Answer:* I would check the **Console Output** of that specific build number in Jenkins.
2.  **If you can run a container but cannot see the website in your browser, what is the likely issue?**
    * *Answer:* Incorrect **Port Mapping**. I likely forgot the `-p` flag or mapped the wrong ports.
3.  **If you delete a container and your database data is gone, how would you fix this in the next run?**
    * *Answer:* I would use a **Docker Volume** (`-v` flag) to map the database folder to a persistent location on the host.
    *

    
