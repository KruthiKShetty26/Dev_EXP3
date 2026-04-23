Step 1: Verify Installation
Before starting, ensure Docker Desktop is running (look for the whale icon in your system tray).

Open CMD and run:

Code snippet
docker --version
Step 2: Run "Hello World" (Testing the Engine)
This command tests if your Docker can talk to Docker Hub (the cloud registry for images).

Run:

Code snippet
docker run hello-world
What happens: Docker looks for the hello-world image locally. Since you don't have it, it "pulls" it from the internet and runs it.

Success: You should see: Hello from Docker!.

Step 3: Run a Web Server (Nginx)
Now, you will run a functional web server and map it to your physical computer's port.

Pull the image:

Code snippet
docker pull nginx
Run the container with Port Mapping:

Code snippet
docker run -d -p 8080:80 --name my-web nginx
-d: Detached mode (runs in the background).

-p 8080:80: This is crucial. It connects your machine's port 8080 to the container's port 80.

Verify: Open your browser and go to http://localhost:8080. You should see the "Welcome to nginx!" page.

Step 4: Lifecycle Management Commands
Practice managing the container you just created:

List running containers:

Code snippet
docker ps
Stop the container:

Code snippet
docker stop my-web
(Try refreshing your browser now; the page will fail to load.)

List all containers (including stopped ones):

Code snippet
docker ps -a
Remove the container permanently:

Code snippet
docker rm my-web
Key Concepts for Viva
Image vs. Container: An Image is like a recipe (static file). A Container is the actual meal being cooked (the running process).

Port Mapping (-p): Containers live in their own network. To see a web app running inside a container, you must "tunnel" a port from your laptop into the container.

Docker Hub: Think of this as the "GitHub for Docker Images." It's where you download pre-built software like Nginx, MySQL, or Python.

Outcome: You have successfully mastered the basics of containerization, which is the foundation for modern cloud-native development.
Task 3: Lifecycle Management
Practice the commands used to clean up your environment:

List Running Containers: docker ps

Stop the Server: docker stop my-web (Browser will now fail to load).

List All (Including Stopped): docker ps -a

Delete the Container: docker rm my-web

List Images on Disk: docker images
