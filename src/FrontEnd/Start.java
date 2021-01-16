package FrontEnd;

import BackEnd.User;
import BackEnd.ListaUsers;
import BackEnd.Servidor;
import BackEnd.Sistema;
import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Sistema sys = new Sistema();
        User autor = new User("t", "t", "MI", "192.168.1.12", 2000);
        User autor2 = new User("p", "p", "MI", "192.168.1.12", 2001);
        User autor3 = new User("c", "c", "MI", "192.168.1.12", 2002);
        // autor.addAmigo(autor2);
        // autor2.addAmigo(autor);
        // autor2.addAmigo(autor3);
        //   autor3.addAmigo(autor2);

        sys.getListaUtilizadoresRegistados().getUsers().add(autor);
        sys.getListaUtilizadoresRegistados().getUsers().add(autor2);
        // sys.getListaUtilizadoresRegistados().getUsers().add(autor3);
        //sys.getListaContactosGlobal().getUsers().add(autor2);
        new Login(sys).setVisible(true);

        System.out.println(sys.getListaUtilizadoresRegistados());
    }

}
