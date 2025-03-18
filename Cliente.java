import java.rmi.Naming;
// import servidor.Collection;

public class Cliente {
    public static void main(String[] args) {
        /*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
        try {
            System.setProperty("java.security.policy", "./java.policy");
            String hostName = "localhost:32001";
            System.out.println("Connecting to " + hostName);
            Collection collection = (Collection) Naming.lookup("rmi://" + hostName + "/MyCollection");
            System.out.println("Collection name: " + collection.name_of_collection());
            System.out.println("Number of books: " + collection.number_of_books());
            collection.name_of_collection("Zanicos Usericos");
            System.out.println("New collection name: " + collection.name_of_collection());
        } catch (Exception e) {
            System.out.println("Exception type: " + e.getClass().getName());
            System.out.println("Error: " + e.getMessage());
        }
    }
}