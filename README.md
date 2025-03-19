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

3. Start the server, optionally specifying a port:
   ```
   java CollectionImpl [port]
   ```
   Example with custom port:
   ```
   java CollectionImpl 32005
   ```

4. Start the client, optionally specifying a port:
   ```
   java Cliente [port]
   ```
   When prompted, enter the server IP address or leave empty to use localhost.

## Notes

- If no port is specified, the default port 32001 will be used
- The client will prompt for the server IP address
- Enter a valid IP address or leave empty to use localhost
