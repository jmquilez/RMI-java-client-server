import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CollectionImpl extends UnicastRemoteObject implements Collection {
    private int m_number_of_books;
    private String m_name_of_collection;

    public CollectionImpl(int _number_of_books, String _name_of_collection) throws RemoteException {
        super();
        m_number_of_books = _number_of_books;
        m_name_of_collection = _name_of_collection;
    }

    public int number_of_books() throws RemoteException {
        return m_number_of_books;
    }

    public String name_of_collection() throws RemoteException {
        return m_name_of_collection;
    }

    public void name_of_collection(String _new_value) throws RemoteException {
        m_name_of_collection = _new_value;
    }

    public static void main(String[] args) {
        // Set the directory where java.policy is located
        System.setProperty("java.security.policy", "./java.policy");
        
        // Get port from command line or use default
        int port = 32001; // Default port
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid port number, using default: 32001");
            }
        }
        
        // TODO: enable to set a different IP from command line?
        String hostName = "localhost:" + port;
        System.out.println("Starting server on port: " + port);

        try {
            CollectionImpl obj = new CollectionImpl(10, "Zanos");
            System.out.println("Object created");
            Naming.rebind("rmi://" + hostName + "/MyCollection", obj);
            System.out.println("Object registered");
        } catch (RemoteException e) {
            System.out.println("Remote exception when creating object: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL exception when creating object");
            e.printStackTrace();
        }
    }
}

