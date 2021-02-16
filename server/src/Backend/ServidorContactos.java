package Backend;


import java.io.IOException;
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
            System.out.println("registo não encontrado");
        }
    }

    public ServidorContactos() {
        super();
    }

    public void instanciarAtendedorContactos() throws IOException, ClassNotFoundException {

        AtendedorContactos atendedorContactos = null;
        try {
            atendedorContactos = new AtendedorContactos();
        } catch (RemoteException e1) {
            System.err.println("Erro no servidor");
            e1.printStackTrace();
        }catch(IOException e1){
          System.err.println("Erro ");
            e1.printStackTrace();
        }

        try {
            bindRMI(atendedorContactos);
        } catch (RemoteException e1) {
            System.err.println("Erro no registo do stub");
            e1.printStackTrace();
        }

    }
}
