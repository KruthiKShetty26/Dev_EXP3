In **Experiment 17**, you will solve the biggest limitation of containers: **ephemeral storage**. By default, if a container is deleted, all data inside it is lost. You will use **Docker Volumes** to ensure data persists even after the container is destroyed.

### **Step 1: Setup and Port Mapping Test**
First, we verify that we can reach Nginx via port mapping.
1. **Pull and Run:**
   ```batch
   docker pull nginx
   docker run -d -p 9001:80 --name temp-web nginx
   ```
2. **Verify:** Open `http://localhost:9001`. You should see the standard Nginx welcome page.
3. **Cleanup:**
   ```batch
   docker stop temp-web
   docker rm temp-web
   ```

---

### **Step 2: Create a Persistent Volume**
We will create a storage unit that lives independently of any container.
1. **Create Volume:**
   ```batch
   docker volume create my-volume
   ```
2. **Confirm:**
   ```batch
   docker volume ls
   ```



---

### **Step 3: Run Container with Volume Mount**
Now, we attach that volume to the specific folder where Nginx looks for website files.
1. **Run with `-v` flag:**
   ```batch
   docker run -d -p 9002:80 -v my-volume:/usr/share/nginx/html --name persistent-web nginx
   ```
   * `-v my-volume:/usr/share/nginx/html`: This links your volume to the container's web folder.

---

### **Step 4: Create Data Inside the Container**
We will go "inside" the running container to create a custom file.
1. **Enter the container shell:**
   ```batch
   docker exec -it persistent-web bash
   ```
2. **Create a file and exit:**
   ```batch
   echo "Hello Persistent Storage!" > /usr/share/nginx/html/index.html
   exit
   ```
3. **Verify:** Visit `http://localhost:9002`. It should now display your custom message.

---

### **Step 5: The Persistence Test (Crucial Step)**
This proves the data is stored in the **volume**, not the **container**.
1. **Delete the container:**
   ```batch
   docker stop persistent-web
   docker rm persistent-web
   ```
   *At this point, the container is gone.*
2. **Start a NEW container using the SAME volume:**
   ```batch
   docker run -d -p 9002:80 -v my-volume:/usr/share/nginx/html --name new-web nginx
   ```
3. **Final Verification:** Visit `http://localhost:9002` again. 
   * **Result:** The "Hello Persistent Storage!" message is still there!



---

### **Key Concepts for Viva**

* **Ephemeral vs. Persistent:** * **Ephemeral:** Data that disappears when the process stops (Standard Container).
    * **Persistent:** Data that stays forever until you manually delete it (Docker Volume).
* **`docker exec -it`:** The `-i` stands for *interactive* and `-t` for *tty* (terminal). It's the standard way to run commands inside a container that is already running.
* **Mounting:** Think of a volume like a USB Pendrive. You "plug it in" (mount it) to a specific folder in the container. When you unplug the "drive," the data stays on the drive, not the computer.
* **Port Mapping vs. Volumes:**
    * **Port Mapping (`-p`):** Handles **Traffic** (Networking).
    * **Volumes (`-v`):** Handles **Data** (Storage).

**Outcome:** You have successfully demonstrated how to manage stateful data in a stateless container environment. This is how databases (like MySQL) are managed in Docker.
