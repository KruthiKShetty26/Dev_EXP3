

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

    Perfect — this is exactly what you need before viva. I’ll give you **module-wise viva questions with short, crisp answers** so you can answer confidently without overthinking.

---

# 🎯 DEVOPS VIVA QUESTIONS (WITH SIMPLE ANSWERS)

---

# 📘 MODULE 1 – Basics

### 1. What is DevOps?

DevOps is a practice that combines **development and operations** to enable faster and reliable software delivery.

---

### 2. Why is DevOps important?

It improves **speed, collaboration, automation, and software quality**.

---

### 3. DevOps vs Traditional IT?

Traditional IT is slow and separate teams; DevOps is **fast, automated, and collaborative**.

---

### 4. What is Agile?

Agile is a method of developing software in **small iterations with continuous feedback**.

---

### 5. Agile vs DevOps?

Agile focuses on development; DevOps covers **development + deployment + operations**.

---

### 6. What is Scrum?

Scrum is an Agile framework where work is done in **short sprints (2–4 weeks)**.

---

### 7. What is Kanban?

Kanban is a method that uses a **visual board (To Do, In Progress, Done)** to manage tasks.

---

### 8. What is DevOps lifecycle?

Plan → Develop → Build → Test → Deploy → Monitor

---

### 9. What are benefits of DevOps?

Faster delivery, better quality, automation, continuous feedback.

---

### 10. Who is a DevOps Engineer?

A person who manages **CI/CD, automation, deployment, and infrastructure**.

---

# 📘 MODULE 2 – Git & Docker

### 11. What is Version Control?

A system to **track changes in code**.

---

### 12. What is Git?

A distributed version control system.

---

### 13. Centralized vs Distributed VCS?

Centralized → one server
Distributed → local copies (Git)

---

### 14. What is branching?

Creating separate paths to develop features independently.

---

### 15. Git fetch vs pull?

Fetch → download only
Pull → download + merge

---

### 16. What is merge conflict?

When Git cannot automatically merge changes.

---

### 17. What is Git Bash?

Command-line tool to run Git commands.

---

### 18. What is Docker?

A tool for **containerization**.

---

### 19. What is container?

A lightweight environment to run applications.

---

### 20. Docker vs VM?

Docker is lightweight; VM is heavy with full OS.

---

# 📘 MODULE 3 – CI/CD & Jenkins

### 21. What is CI/CD?

CI → integrate code
CD → deliver/deploy code automatically

---

### 22. CI vs CD?

CI = build & test
CD = deploy

---

### 23. What is Jenkins?

An automation tool for CI/CD.

---

### 24. What is pipeline?

A sequence of steps: build → test → deploy

---

### 25. What is Freestyle project?

Basic Jenkins job with simple configuration.

---

### 26. What are build triggers?

Events that start a build (poll SCM, webhook)

---

### 27. What is Poll SCM?

Jenkins checks repo periodically.

---

### 28. What is Webhook?

Repo notifies Jenkins instantly.

---

### 29. What is Maven?

A build tool for Java projects.

---

### 30. What is POM?

XML file containing project configuration.

---

### 31. Maven lifecycle?

Validate → Compile → Test → Package → Install → Deploy

---

### 32. What is artifact?

Final build output (JAR/WAR file)

---

# 📘 MODULE 4 – Testing

### 33. What is testing?

Process of checking if code works correctly.

---

### 34. What is unit testing?

Testing individual components.

---

### 35. What is JUnit?

Framework for unit testing in Java.

---

### 36. What is annotation in JUnit?

Special keywords like `@Test` to define test behavior.

---

### 37. What is assertion?

Used to verify expected vs actual output.

---

### 38. What is code coverage?

Percentage of code tested.

---

### 39. What is JaCoCo?

Tool to measure code coverage.

---

### 40. Types of testing?

Unit, Integration, System, Performance

---

# 📘 MODULE 5 – Cloud & Deployment

### 41. What is cloud computing?

Using internet to access computing resources.

---

### 42. Types of cloud?

Public, Private, Hybrid

---

### 43. What is AWS?

Cloud platform by Amazon.

---

### 44. What is EC2?

Virtual server in AWS.

---

### 45. What is S3?

Storage service in AWS.

---

### 46. What is RDS?

Managed database service.

---

### 47. What is Lambda?

Serverless computing service.

---

### 48. AWS vs Azure?

AWS → flexible
Azure → Microsoft integration

---

### 49. What is virtualization?

Running multiple OS on one machine.

---

### 50. What is containerization?

Running apps in lightweight containers.

---

### 51. What is Puppet?

Configuration management tool.

---

### 52. Puppet architecture?

Master → Agents

Good — this is exactly how you push from “prepared” to **actually confident in viva**.

Examiners LOVE **application-based questions** where they check if you *understand*, not just memorize. I’ll give you the **most realistic application + scenario questions** with **simple answers you can speak**.

---

# 🔥 APPLICATION / SCENARIO-BASED VIVA QUESTIONS

---

## 📘 GENERAL DEVOPS

### 1. How would you implement DevOps in a project?

**Answer:**
I would use Git for version control, Jenkins for CI/CD, Maven for build, Docker for containerization, and deploy on cloud like AWS. Automation will be used in every stage.

---

### 2. Your deployment failed. What will you do?

**Answer:**
I will check logs, identify the error, rollback to previous stable version, fix the issue, and redeploy.

---

### 3. Why is automation important in DevOps?

**Answer:**
Automation reduces manual errors, saves time, and ensures faster and consistent delivery.

---

---

## 📘 GIT (VERY COMMON SCENARIOS)

### 4. Two developers changed the same file. What happens?

**Answer:**
A merge conflict occurs. It must be resolved manually by choosing correct changes.

---

### 5. When will you use branching?

**Answer:**
When developing new features or fixing bugs without affecting the main code.

---

### 6. When do you use git fetch instead of pull?

**Answer:**
When I want to review changes before merging them.

---

### 7. How do you recover deleted code?

**Answer:**
Using Git history or checkout previous commit.

---

---

## 📘 JENKINS / CI-CD

### 8. What happens when you push code to Git?

**Answer:**
Webhook triggers Jenkins → build starts → tests run → deployment happens.

---

### 9. Why did your Jenkins build fail?

**Answer:**
Possible reasons:

* Code errors
* Test failures
* Dependency issues

---

### 10. How do you improve CI/CD pipeline?

**Answer:**
By adding automation, parallel testing, faster builds, and proper monitoring.

---

### 11. When would you use Poll SCM?

**Answer:**
When webhooks are not available or cannot be configured.

---

---

## 📘 DOCKER / CONTAINERS

### 12. Why use Docker instead of VM?

**Answer:**
Docker is lightweight, faster, and uses fewer resources.

---

### 13. How would you deploy an app using Docker?

**Answer:**
Create Dockerfile → build image → run container → deploy.

---

### 14. What problem does Docker solve?

**Answer:**
It solves environment mismatch issues (works same everywhere).

---

---

## 📘 TESTING

### 15. Why is testing important in CI/CD?

**Answer:**
It ensures code is correct before deployment and prevents bugs in production.

---

### 16. What if tests fail?

**Answer:**
Pipeline stops, errors are fixed, and code is retested.

---

---

## 📘 CLOUD / AWS

### 17. Why use cloud instead of local servers?

**Answer:**
Cloud provides scalability, flexibility, and reduces cost.

---

### 18. How would you host a web app on AWS?

**Answer:**
Use EC2 for server, RDS for database, S3 for storage.

---

### 19. When would you use Lambda?

**Answer:**
When we need event-based execution without managing servers.

---

---

## 📘 REAL-WORLD SCENARIOS (VERY HIGH VALUE)

### 20. Your app works locally but not on server. Why?

**Answer:**
Environment differences. Docker can solve this.

---

### 21. Your system is slow during high traffic. What will you do?

**Answer:**
Scale using cloud (increase instances or use load balancing).

---

### 22. How do you ensure zero downtime deployment?

**Answer:**
Using techniques like rolling deployment or blue-green deployment.

---

### 23. What if production crashes?

**Answer:**
Rollback to previous version and fix issue.

---

### 24. How do you monitor applications?

**Answer:**
Using monitoring tools and logs.

---
