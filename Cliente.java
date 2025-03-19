import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "./java.policy");
            
            // Get IP address from user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter server IP (leave empty for localhost): ");
            String ip = scanner.nextLine().trim();
            if (ip.isEmpty()) {
                ip = "localhost";
            }
            
            // Get port from command line or use default
            int port = 32001; // Default port
            if (args.length > 0) {
                try {
                    port = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid port number, using default: 32001");
                }
            }
            
            String hostName = ip + ":" + port;
            System.out.println("Connecting to " + hostName);
            Collection collection = (Collection) Naming.lookup("rmi://" + hostName + "/MyCollection");
            System.out.println("Collection name: " + collection.name_of_collection());
            System.out.println("Number of books: " + collection.number_of_books());
            collection.name_of_collection("Zanicos Usericos");
            System.out.println("New collection name: " + collection.name_of_collection());
            
            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception type: " + e.getClass().getName());
            System.out.println("Error: " + e.getMessage());
        }
    }
}