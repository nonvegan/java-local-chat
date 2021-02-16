<<<<<<< HEAD
package BackEnd;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceContactos extends Remote {

    public void putContacto(User user) throws RemoteException;
    
    public ListaUsers getContactos() throws RemoteException;
    
    public ListaUsers getContactos(String stringProcura) throws RemoteException;

=======
package BackEnd;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceContactos extends Remote {

    public void putContacto(User user) throws RemoteException;
    
    public ListaUsers getContactos() throws RemoteException;
    
    public ListaUsers getContactos(String stringProcura) throws RemoteException;

>>>>>>> cc0b55b0f272b57bd005af34d401f6a89f2354d0
}