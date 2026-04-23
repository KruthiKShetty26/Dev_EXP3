EXP 1

mkdir Git_Lab_Experiment1
cd Git_Lab_Experiment1
git init
git config --global user.name "Kruthi Shetty"
git config --global user.email "kruthikpuce@gmail.com"
echo "Hello Git" > sample.txt
git status
git add sample.txt
git commit -m "Initial commit: Added sample.txt"
git log
git log --oneline


EXP 2

git branch feature-1
git checkout feature-1
echo "New Feature Details" > feature.txt
git add feature.txt
git commit -m "Added new feature in feature-1 branch"
git checkout main
git branch
git merge feature-1
dir


EXP 3

mkdir Exp3_GitHub_Push
cd Exp3_GitHub_Push
git init
git config --global user.name "Kruthi K Shetty"
git config --global user.email "kruthikpuce@gmail.com"
echo "Experiment 3: Remote Repository Management" > readme.txt
git add readme.txt
git commit -m "Initial commit for Exp 3"
git branch -M main
git remote remove origin
git remote add origin https://github.com/KruthiKShetty26/Dev_EXP3.git
git push -u origin main
cd ..
git clone https://github.com/KruthiKShetty26/Dev_EXP3.git Exp3_Verify_Clone
cd Exp3_Verify_Clone
dir

EXP 4

mkdir Exp4_Collab_Fresh
cd Exp4_Collab_Fresh
git init
git config --global user.name "Kruthi K Shetty"
git config --global user.email "kruthikpuce@gmail.com"
echo "Base code for Experiment 4" > collab.txt
git add collab.txt
git commit -m "Initial commit for Exp 4"
git branch -M main
git remote add origin https://github.com/KruthiKShetty26/Dev_EXP3.git
git push -u origin main --force
git checkout -b feature-update
echo "Collaborator update: Adding new features" >> collab.txt
git add collab.txt
git commit -m "Added features in separate branch"
git push origin feature-update

Now, open your browser and go to your GitHub repository:
https://github.com/KruthiKShetty26/Dev_EXP3
Click the Button: You will see a green button that says "Compare & pull request". Click it.
Create PR: Click the green "Create pull request" button.
Merge: Click the green "Merge pull request" button, then "Confirm merge".

git checkout main
git pull origin main

EXP 5

mkdir Exp5_Tagging
cd Exp5_Tagging
git init
git config --global user.name "Kruthi K Shetty"
git config --global user.email "kruthikpuce@gmail.com"
echo "Stable version of my software" > app.txt
git add app.txt
git commit -m "Complete stable feature for release"
git branch -M main
git remote add origin https://github.com/KruthiKShetty26/Dev_EXP3.git
git push -u origin main --force
git tag -a v1.0 -m "Release version 1.0 - Stable"
git tag
git show v1.0
git push origin v1.0

Now, turn that tag into an official "Release" on the website:
Open your GitHub repo: https://github.com/KruthiKShetty26/Dev_EXP3
On the right-hand side, click on "Releases" (it might say "Create a new release").
Click "Draft a new release".
Click "Choose a tag" and select v1.0.
Give it a title: First Stable Release.
Write a brief description: This release contains the final stable code for Experiment 5.
Click "Publish release".

EXP 6

mvn -version
mvn archetype:generate -DgroupId=com.bnmit.app -DartifactId=sample-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
cd sample-app
dir
mvn clean
mvn compile
mvn package
cd target
dir

Outcome: You should see a file named sample-app-1.0-SNAPSHOT.jar.

cd ..
notepad src\main\java\com\bnmit\app\App.java
java -cp target/sample-app-1.0-SNAPSHOT.jar com.bnmit.app.App

