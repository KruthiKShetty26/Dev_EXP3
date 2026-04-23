Step 1: Create the Project
Open Jenkins and click New Item.

Enter Name: Experiment_8_Triggers

Select Freestyle project and click OK.

In the Source Code Management section:

Select Git.

Repository URL: https://github.com/KruthiKShetty26/Dev_EXP3.git

Branch Specifier: */main

Step 2: Method A - Configure SCM Polling
This method is useful if your Jenkins server is behind a firewall and cannot receive external signals.

Scroll to the Build Triggers section.

Check the box Poll SCM.

In the Schedule box, copy and paste this exactly:

Plaintext
* * * * *
(Note: These five asterisks tell Jenkins to check your GitHub repo every single minute for changes.)

Step 3: Method B - Configure GitHub Webhook
This is the professional standard. GitHub "pushes" a notification to Jenkins.

In the same Build Triggers section, check the box:
GitHub hook trigger for GITScm polling.

Note: For a real Webhook to work, you must also go to your GitHub Repository Settings > Webhooks > Add Webhook and enter your Jenkins URL followed by /github-webhook/.

Step 4: Define a Simple Build Action
We need Jenkins to do something so we can see the trigger worked.

Scroll to Build Steps.

Click Add build step > Execute Windows batch command.

Enter this command:

Code snippet
echo "Trigger Received! Automatic Build Started at:"
date /t
time /t
Click Save.

Step 5: Testing the Automatic Trigger
Go to your GitHub repository (Dev_EXP3) in your browser.

Create a new file or edit the README.md.

Commit the change directly on GitHub.

Go back to your Jenkins Dashboard.

Wait for 1 minute. You will see a build start automatically in the Build History without you touching anything.

Verifying the Outcome
Click on the new automated build number (e.g., #1).

Select Console Output.

Look for a line that says: "Started by an SCM change". This confirms that the build was triggered by your code update rather than a manual click.
