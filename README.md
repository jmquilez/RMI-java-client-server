# RMI-java-client-server

## Description

This is a simple RMI example in Java. It consists of a client and a server.

## How to run

1. Compile all Java files:
   ```
   javac *.java
   ```

2. Start the RMI registry on a specific port (default is 32001):
   ```
   rmiregistry 32001
   ```

3. Start the server:
   ```
   java CollectionImpl <IP> [port]
   ```
   Examples:
   ```
   java CollectionImpl 192.168.1.2         # Uses specified IP with default port 32001
   java CollectionImpl 192.168.1.2 32005   # Uses specified IP and port
   ```

4. Start the client, optionally specifying a port:
   ```
   java Cliente [port]
   ```
   When prompted, enter the server IP address or leave empty to use localhost.

## Notes

- The server requires the IP address of the machine it's running on as a mandatory argument
- The port number is optional (defaults to 32001)
- Make sure the java.policy file is in the same directory as the application
- The client will prompt for the server IP address
- Enter a valid IP address or leave empty to use localhost
