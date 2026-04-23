To perform Experiment 7 using your specific repository, follow these exact steps. This guide assumes you have Jenkins open and Git installed on your system.

Step 1: Create the Job
Open Jenkins in your browser (usually http://localhost:8080).

Click New Item on the left sidebar.

Enter Item Name: DevOps_Experiment_7

Select Freestyle project.

Click OK.

Step 2: Configure Source Code (Git)
Scroll down to the Source Code Management section.

Select the radio button for Git.

In Repository URL, copy and paste this exactly:
https://github.com/KruthiKShetty26/Dev_EXP3.git

In Branch Specifier, ensure it says:
*/main
(Note: If your default branch is 'master', change it to */master, but most new repos use main).

Step 3: Define the Build Commands
Since this is a Windows environment (based on your lab manual), we will use batch commands to simulate a build process and generate an output file.

Scroll down to the Build Steps section.

Click the Add build step dropdown.

Select Execute Windows batch command.

In the Command text box, copy and paste these lines exactly:

Code snippet
echo "Starting Build Process for Kruthi's Project..."
echo "Current Build Date and Time:" > build_log.txt
date /t >> build_log.txt
time /t >> build_log.txt
echo "Build Successful. Artifacts generated." >> build_log.txt
dir >> build_log.txt
Step 4: Archive the Results (Artifacts)
This step ensures the file we just created (build_log.txt) is saved by Jenkins.

Scroll down to Post-build Actions.

Click Add post-build action.

Select Archive the artifacts.

In Files to archive, type exactly:
build_log.txt

Step 5: Run and Verify
Click Save at the bottom.

On the left menu, click Build Now.

Wait a few seconds. Under Build History, you will see a blue circle (or green check) with #1.

Click on the #1 (the build number).

Click Console Output to see the logs. It should show:
SUCCESS

Go back to the Build #1 page. You will see a section called Build Artifacts.

Click on build_log.txt to view the automated output.

You are now done with Experiment 7. This confirms you can successfully pull code from your GitHub repo, run a command-line build, and archive the output.
