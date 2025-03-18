import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class CollectionImpl extends UnicastRemoteObject implements Collection {
    private int m_number_of_books;
    private String m_name_of_collection;

    public CollectionImpl(int _number_of_books, String _name_of_collection) throws RemoteException {
        super();
        m_number_of_books = _number_of_books;
        m_name_of_collection = _name_of_collection;
        // TODO : inicializar las variables privadas
    }
    // TODO : Implementar todos los metodos de la interface remota
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
        // Fijar el dirc to rio donde se encuentra el java . policy
        System.setProperty("java.security.policy", "./java.policy");
        // System.setSecurityManager(new SecurityManager());
        String hostName = "localhost:32001"; // :32001
        File myObj = new File("filename.txt");

        try {
            CollectionImpl obj = new CollectionImpl(10, "Zanos");
            System.out.println("Objeto creado");
            Naming.rebind("rmi://" + hostName + "/MyCollection", obj);
            System.out.println("Objeto registrado");
        } catch (RemoteException e) {
            // Escribimos en un fichero cualquiera el error dado:
            
            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write("Files in Java might be tricky, but it is fun enough!");
                myWriter.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            // writeToFile("error al crear el objeto", "./pepe.txt");
            System.out.println("Error al crear el objeto, " + e.getMessage());
        } catch (MalformedURLException e) {
            // Escribimos en un fichero cualquiera el error dado:

            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write("Files in Java might be tricky, but it is fun enough!");
                myWriter.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            e.printStackTrace();
            System.out.println("Error al crear el objeto");
        }
    }
}

