Experiment 7: Jenkins Freestyle Job
Goal: Automate the process of fetching code from GitHub, building it with Maven, and saving the resulting .jar file.

Step 1: Create the Project
Open Jenkins in your browser (http://localhost:8080).

On the left sidebar, click New Item.

Enter an item name: Type Exp7_Freestyle_Build.

Select a type: Click on Freestyle project.

Click OK at the bottom.

Step 2: Source Code Management (The "Pull" Task)
This tells Jenkins where your code is located on GitHub.

Scroll down to the Source Code Management section.

Select the radio button for Git.

Repository URL: Paste your repo link: https://github.com/KruthiKShetty26/Dev_EXP3.git

Credentials: Leave as none (since your repo is public).

Branch Specifier: Ensure it says */main (or */master if that is your default branch name).

Step 3: Build Steps (The "Build" Task)
This tells Jenkins to run the Maven commands automatically.

Scroll down to the Build Steps section.

Click the Add build step dropdown button.

Select Invoke top-level Maven targets.

Maven Version: Choose the version available in the dropdown (usually Maven 3.9 or Default).

Goals: Type clean package.

Note: This cleans the old build and creates a new .jar file.

Step 4: Post-build Actions (The "Archive" Task)
This saves the final output so it doesn't get deleted when the job finishes.

Scroll down to the Post-build Actions section.

Click the Add post-build action dropdown.

Select Archive the artifacts.

Files to archive: Type target/*.jar.

Note: This tells Jenkins to look in the target folder and save any file ending in .jar.

Step 5: Run and Verify
Click the Save button at the bottom.

On the left-hand menu, click Build Now.

Check Progress: You will see a small circle appearing under "Build History" on the bottom left.

Check Logs: Click the small arrow next to the build number (e.g., #1) and select Console Output.

Look for the message: BUILD SUCCESS.

View Outcome: Go back to the Project dashboard. You should now see a section called "Last Successful Artifacts" showing your sample-app-1.0-SNAPSHOT.jar.
