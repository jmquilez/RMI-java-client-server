import java.rmi.Remote;
import java.rmi.RemoteException;
//  Todo: Import more shit
public interface Collection extends Remote {
    int number_of_books() throws RemoteException;
    String name_of_collection() throws RemoteException;
    void name_of_collection(String _new_value) throws RemoteException;
}