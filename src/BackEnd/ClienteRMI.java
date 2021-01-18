package BackEnd;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class ClienteRMI {

    public void EnviarContacto(Sistema sistema) {
        try {
            InterfaceContactos interfaceContacto = (InterfaceContactos) LocateRegistry.getRegistry(sistema.getIP_SERVIDOR()).lookup(sistema.getNOME_SERVICO());
            interfaceContacto.putContacto(sistema.getCurrentUser());
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
    public void EnviarContacto(Sistema sistema,User user) {
        try {
            InterfaceContactos interfaceContacto = (InterfaceContactos) LocateRegistry.getRegistry(sistema.getIP_SERVIDOR()).lookup(sistema.getNOME_SERVICO());
            interfaceContacto.putContacto(user);
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
    public void pedirContactos(Sistema sistema) {
        try {
            InterfaceContactos interfaceContacto = (InterfaceContactos) LocateRegistry.getRegistry(sistema.getIP_SERVIDOR()).lookup(sistema.getNOME_SERVICO());
            sistema.setListaContactosGlobal(interfaceContacto.getContactos());
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
        public void pedirContactos(Sistema sistema, String stringProcurada) {
        try {
            InterfaceContactos interfaceContacto = (InterfaceContactos) LocateRegistry.getRegistry(sistema.getIP_SERVIDOR()).lookup(sistema.getNOME_SERVICO());
            sistema.setListaContactosGlobal(interfaceContacto.getContactos(stringProcurada));
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
    
}
