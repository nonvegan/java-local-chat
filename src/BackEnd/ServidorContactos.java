package BackEnd;


import java.lang.SecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorContactos {

    String NOME_SERVICO = "/ServidorContactos";

    private void bindRMI(AtendedorContactos atendedor) throws RemoteException {

        System.getProperties().put("java.security.policy", "./server.policy");

        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {

        }
        try {
            LocateRegistry.getRegistry("127.0.0.1", 1099).rebind(NOME_SERVICO, atendedor);
        } catch (RemoteException e) {
            System.out.println("Registry not found");
        }
    }

    public ServidorContactos() {
        super();
    }

    public void instanciarAtendedorContactos() {

        AtendedorContactos atendedorContactos = null;
        try {
            atendedorContactos = new AtendedorContactos();
        } catch (RemoteException e1) {
            System.err.println("unexpected error...");
            e1.printStackTrace();
        }

        try {
            bindRMI(atendedorContactos);
        } catch (RemoteException e1) {
            System.err.println("erro ao registar o stub...");
            e1.printStackTrace();
        }

    }
}
