Experiment 7: Jenkins Freestyle Job (Manual Build)
Goal: Prove you can link GitHub to Jenkins and build a project.

Phase 1: The "Fresh" Terminal Setup
Before opening Jenkins, you need to make sure the computer knows where Maven is.

Open Command Prompt.

Type mvn -version. If it shows a version number, you are good. If not, tell the lab instructor.

Phase 2: Jenkins Configuration
Open Chrome and go to http://localhost:8080.

Create Job: Click New Item → Name: Exp7_Freestyle → Select Freestyle project → Click OK.

Link GitHub (Source Code Management):

Select Git.

Repository URL: https://github.com/KruthiKShetty26/Dev_EXP3.git

Branch Specifier: Change */master to */main (Check your GitHub to see which name you use).

The Build Step:

Scroll to Build Steps.

Click Add build step → Invoke top-level Maven targets.

Maven Version: Select the one available (e.g., Maven 3.9).

Goals: Type clean package.

Archive the Result (Post-build Actions):

Click Add post-build action → Archive the artifacts.

Files to archive: Type target/*.jar.

Save & Run: Click Save. Click Build Now.

Phase 3: Verify (How to show the teacher)
Click the Blue Ball (or the #1 build).

Click Console Output.

Scroll to the bottom. If you see BUILD SUCCESS, you are done with Exp 7!
