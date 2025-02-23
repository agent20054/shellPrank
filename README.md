# shellPrank Application

This project is a simple application that allows for remote execution of shell commands on a client machine from a server.
The server sends commands to the client, which executes them and returns the output.

## General Usage

### Server Side:
1. The server listens for a connection on a specific port (default: **12345**).
2. Once a client connects, the server can send shell commands for the client to execute.
3. The server waits for input from the user (command line), which is sent to the client for execution.
3. Checks which operating system the client is running.
4. Commands are executed on the client machine, and the output is returned and printed on the server.

### Client Side:
1. The client listens for commands from the server.
2. Upon receiving a command, the client executes it on the local system.
3. The client then sends back the command output to the server.

### How to Run:
1. Start the server:
   - Run the `build/Server.bat` file.
   - The server will listen for a client connection on port **12345**.
   
2. Start the client:
   - Run the `build/Client.bat` file on the target machine.
   - The client will connect to the server and wait for commands to execute.

### Custom Commands:
Here are the available commands that the server can send to the client:

1. **`prank`**:
   - This command triggers a "prank" on the client machine. 
   - It simulates a "hack" by showing a few pop-up messages with the text **"You have been hacked!"**.
   - **Note**: This is a harmless prank and is for educational purposes only.

2. **`sleep`**:
   - This command suspends the client machine, effectively putting it to sleep.
   - On Windows, it triggers the **Sleep** function using the `rundll32` command.
   - On Linux, it calls the `systemctl suspend` command.
   
3. **`exit`**:
   - This command gracefully closes the connection between the server and client.
   - It tells the client to stop listening for commands and exit.

### Important Warning

**Do not use this tool for malicious purposes. Unauthorized use may be illegal.**

By using this software, you agree to use it only in accordance with ethical and legal standards. The creator of this project is not responsible for any misuse of the code. The software should only be used for the following purposes:

- **Penetration Testing**: Only use on systems you own or have explicit permission to test.
- **Educational Use**: To understand how remote command execution works.

### Disclaimer

This project is for educational purposes only. The creator does not condone the unauthorized use of this software in any illegal activities. Use this software responsibly and ethically.

- **Creator**: Adam M. Hache
- **Made in**: 2025
- **Version**: 1.0.0

---

### License
This project is licensed under the MIT License. See the LICENSE file for more information.

---
