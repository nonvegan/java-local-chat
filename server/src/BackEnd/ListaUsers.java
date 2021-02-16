<<<<<<< HEAD
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

    public boolean containsUser(String nickname) {
        boolean value = false;
        for (User user : this.listaUsers) {
            if (user.getNickname().equals(nickname)) {
                value = true;
            }
        }
        return value;
    }

    public User getUser(String nickname) {
        User user = null;
        for (User u : this.listaUsers) {
            if (u.getNickname().equals(nickname)) {
                user = u;
            }
        }
        return user;
    }

    @Override
    public String toString() {
        return "ListaUsers{" + "listaContactos=" + listaUsers + '}';
    }

}
=======
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

    public boolean containsUser(String nickname) {
        boolean value = false;
        for (User user : this.listaUsers) {
            if (user.getNickname().equals(nickname)) {
                value = true;
            }
        }
        return value;
    }

    public User getUser(String nickname) {
        User user = null;
        for (User u : this.listaUsers) {
            if (u.getNickname().equals(nickname)) {
                user = u;
            }
        }
        return user;
    }

    @Override
    public String toString() {
        return "ListaUsers{" + "listaContactos=" + listaUsers + '}';
    }

}
>>>>>>> cc0b55b0f272b57bd005af34d401f6a89f2354d0
