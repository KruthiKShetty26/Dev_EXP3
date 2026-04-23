Experiment 8: Jenkins Build Triggers
Goal: Automate the build start using two methods: Poll SCM (Jenkins checks GitHub) and Webhooks (GitHub tells Jenkins).

Method A: SCM Polling (The "Timer" Method)
This is the most common lab method because it doesn't require complex network settings.

Open Project: Go to your Exp7_Freestyle_Build project and click Configure on the left.

Locate Triggers: Scroll down to the Build Triggers section.

Enable Polling: Check the box for Poll SCM.

Enter Schedule: In the Schedule text box, type:
* * * * *
(Note: That is 5 asterisks with a space between each. This tells Jenkins to check GitHub every single minute.)

Save: Click Save.

Test it: * Go to your GitHub website and edit your readme.txt or App.java.

Commit the change.

Wait 1 minute. You will see a new build start automatically in Jenkins without you touching anything.

Method B: GitHub Webhook (The "Instant" Method)
This is how professional companies do it. GitHub "pokes" Jenkins the second a change happens.

In Jenkins:

Go to Configure for your project.

Under Build Triggers, check the box: GitHub hook trigger for GITScm polling.

Click Save.

In GitHub:

Go to your repository Settings (on the top tab).

Click Webhooks on the left sidebar.

Click Add webhook.

Payload URL: Enter your Jenkins URL + /github-webhook/ (e.g., http://your-ip:8080/github-webhook/).

Content type: Select application/json.

Click Add webhook.

Test it: * Push a change to GitHub. Jenkins should start the build instantly.

Outcome Verification
Automatic Start: Look at the Build History. You should see a build triggered by "Started by an SCM change" instead of "Started by user Kruthi."

Polling Log: On the project page, click Git Polling Log to see Jenkins checking GitHub.
