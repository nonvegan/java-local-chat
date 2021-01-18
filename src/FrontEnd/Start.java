package FrontEnd;

import BackEnd.User;
import BackEnd.ListaUsers;
import BackEnd.Servidor;
import BackEnd.Sistema;
import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Sistema sys = new Sistema().readSistema(null);
        new Login(sys).setVisible(true);
        System.out.println(sys.getListaUtilizadoresRegistados());
    }

}
