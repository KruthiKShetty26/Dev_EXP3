In **Experiment 18**, you will complete the full Docker lifecycle. After building an image, you will share it with the world by pushing it to **Docker Hub**, a public registry. This makes your application "globally portable"—anyone can pull and run your Java application without needing to install Java or compile the code themselves.

### **Step 1: Setup the Workspace**
1. Open CMD and create your project folder:
   ```batch
   mkdir Docker-Java
   cd Docker-Java
   ```
2. **Create the Java File (`Grade.java`):**
   ```batch
   notepad Grade.java
   ```
   *Paste the `Grade.java` code provided in your manual. This program calculates average grades and returns a letter grade (A-F).*

---

### **Step 2: Create the Dockerfile**
This Dockerfile uses a specific Java base image to compile and run your code.
1. Create the file:
   ```batch
   notepad Dockerfile
   ```
2. **The Blueprint Content:**
   ```dockerfile
   FROM eclipse-temurin:17-jdk
   WORKDIR /app
   COPY . /app
   RUN javac Grade.java
   CMD ["java", "Grade"]
   ```
3. **Fix Windows Extension:**
   ```batch
   ren Dockerfile.txt Dockerfile
   ```



---

### **Step 3: Build and Test Locally**
Before pushing to the cloud, ensure the image works on your machine.
1. **Build:**
   ```batch
   docker build -t java-app .
   ```
2. **Run Interactively:**
   ```batch
   docker run -it java-app
   ```
   * **Note:** You must use `-it` (Interactive Terminal) because this program waits for you to type in grades.

---

### **Step 4: Authenticate and Tag for Docker Hub**
Docker Hub won't accept your image unless it is specifically named with your account ID.
1. **Login:**
   ```batch
   docker login
   ```
   *Enter your Docker Hub username and password. (Characters won't appear as you type).*
2. **Tag your image:**
   ```batch
   docker tag java-app yourusername/java-app:v1
   ```
   *Replace `yourusername` with your actual Docker Hub ID. This creates a "link" from your local name to the registry name.*



---

### **Step 5: Push to Docker Hub**
Now, upload your image to the global registry.
1. **Push:**
   ```batch
   docker push yourusername/java-app:v1
   ```
2. **Verify:** Go to [hub.docker.com](https://hub.docker.com), log in, and you will see `java-app` listed under your repositories.

---

### **Step 6: The "Global Portability" Test**
To prove it worked, delete your local copy and pull it back from the cloud.
1. **Delete local image:** `docker rmi -f yourusername/java-app:v1`
2. **Pull and Run:**
   ```batch
   docker run -it yourusername/java-app:v1
   ```

---

### **Key Concepts for Viva**

* **Docker Registry:** A central library for images. Docker Hub is the most popular public registry.
* **Tagging:** Why is it required? Docker Hub uses the tag to identify which user account and which version (`v1`, `v2`, `latest`) the image belongs to.
* **Layer Reusability:** When you push, you might see "Layer already exists." This means Docker Hub already has that part of the image (like the Java base), so it doesn't waste time uploading it again.
* **`-it` Flag:**
    * `-i` (Interactive): Keeps the input stream open.
    * `-t` (TTY): Allocates a virtual terminal so you can see the prompts.

**Outcome:** You have successfully moved from local development to global distribution. Your application is now a "cloud-ready" artifact.
