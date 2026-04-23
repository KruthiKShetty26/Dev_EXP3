In **Experiment 16**, you move from using pre-built images to building your own. This is the essence of **Application Containerization**: taking your custom code (`app.py`) and packaging it into a portable image using a **Dockerfile**.

### **Step 1: Project Setup**
1. Open CMD and create your workspace:
   ```batch
   mkdir docker-app
   cd docker-app
   ```
2. **Create the Python script (`app.py`):**
   ```batch
   notepad app.py
   ```
   *Paste the Python code provided in your manual. It creates a simple server that listens on port **5020**.*

---

### **Step 2: Create the Dockerfile**
The Dockerfile is the "blueprint" for your image.
1. Create the file:
   ```batch
   notepad Dockerfile
   ```
   *(Ensure you save it exactly as `Dockerfile` with no extension.)*
2. **The Blueprint Content:**
   ```dockerfile
   FROM python:3.9-slim
   WORKDIR /app
   COPY app.py .
   EXPOSE 5020
   CMD ["python", "app.py"]
   ```
3. **Fix Windows Extension (Crucial):** If Notepad added `.txt`, rename it:
   ```batch
   ren Dockerfile.txt Dockerfile
   ```



---

### **Step 3: Build the Image**
Now, tell Docker to read your blueprint and assemble the image.
1. Run the build command:
   ```batch
   docker build -t my-python-app .
   ```
   * The `-t` "tags" (names) your image so you can find it easily later.
   * The `.` tells Docker to look in the current folder for the `Dockerfile`.
2. **Verify:**
   ```batch
   docker images
   ```
   *You should see `my-python-app` in the list.*

---

### **Step 4: Run the Container**
1. Start the container with port mapping:
   ```batch
   docker run -d -p 5050:5020 --name my-python-container my-python-app
   ```
   * **Host Port (5050):** This is what you type in your browser.
   * **Container Port (5020):** This is what the Python script is actually listening on.



---

### **Step 5: Verify & Cleanup**
1. Open your browser to `http://localhost:5050`. You should see "Hello from Docker Python Container".
2. **Cleanup:**
   ```batch
   docker stop my-python-container
   docker rm my-python-container
   ```

---

### **Key Concepts for Viva**

* **The Build Flow:** Remember the sequence: **Dockerfile** (the script) $\rightarrow$ **Image** (the template) $\rightarrow$ **Container** (the running instance).
* **RUN vs. CMD:**
    * `RUN` happens during **build time** (e.g., installing libraries).
    * `CMD` happens during **runtime** (the command that starts your app).
* **Base Image (`FROM`):** Why start from scratch? We use `python:3.9-slim` because it already has Linux and Python installed, saving us time and disk space.
* **Layering:** Every line in your Dockerfile creates a "layer." If you change your code but not your base image, Docker only rebuilds the layers that changed, making subsequent builds very fast.

**Outcome:** You have successfully containerized a custom application! This image can now be sent to any server in the world and it will run exactly the same way.
