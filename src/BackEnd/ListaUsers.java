package BackEnd;



import java.io.Serializable;
import java.util.ArrayList;

public class ListaUsers implements Serializable {

    private ArrayList<User> listaUsers;

    public ListaUsers() {
        listaUsers = new ArrayList<User>();
    }

    public ArrayList<User> getUsers() {
        return listaUsers;
    }

    @Override
    public String toString() {
        return "ListaUsers{" + "listaContactos=" + listaUsers + '}';
    }

    
}
