package BackEnd;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceContactos extends Remote {

    public void putContacto(User user) throws RemoteException;
    
    public ListaUsers getContactos() throws RemoteException;
    
    public ListaUsers getContactos(String stringProcura) throws RemoteException;

}