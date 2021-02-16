<<<<<<< HEAD
package BackEnd;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AtendedorContactos extends UnicastRemoteObject implements InterfaceContactos {

    private ArrayList<UserInfo> contactos;

    public AtendedorContactos() throws RemoteException, ClassNotFoundException, IOException {
        super();
        contactos = new ArrayList<UserInfo>();
    }

    public void putContacto(User user) throws RemoteException {

        long tempoAtual = new Date().getTime();

        synchronized (this) {
            if (containsUserInfo(contactos, user)) {
                getUserInfo(user).getUser().setIp(user.getIp());
                getUserInfo(user).setUltimoLogin();
                System.out.print("user nao novo ->");

            } else {
                contactos.add(new UserInfo(user, tempoAtual));
                System.out.print("user novo ->");
            }
            System.out.println(user.toString());
        }
    }

    public ListaUsers getContactos() throws RemoteException {
        return getArrayListContactos();
    }

    public ListaUsers getContactos(String stringProcura) throws RemoteException {
        return getArrayListContactos(stringProcura);
    }

    private boolean containsUserInfo(ArrayList<UserInfo> contactos, User user) {
        boolean contains = false;
        for (UserInfo contacto : contactos) {
            if (contacto.getUser().equals(user)) {
                contains = true;
            }
        }
        return contains;
    }

    private UserInfo getUserInfo(User user) {
        UserInfo novoUser = null;
        for (UserInfo contacto : contactos) {
            if (contacto.getUser().equals(user)) {
                novoUser = contacto;
            }
        }
        return novoUser;
    }

    private ListaUsers getArrayListContactos() {
        ListaUsers arrayContactos = new ListaUsers();
        for (UserInfo contacto : contactos) {
            if (!(contacto.tempoPassado() > 180 * 1000)) {
                arrayContactos.getUsers().add(contacto.getUser());
            }
        }
        return arrayContactos;
    }

    private ListaUsers getArrayListContactos(String stringProcura) {
        ListaUsers arrayContactos = new ListaUsers();
        for (UserInfo contacto : contactos) {
            if (procurarString(stringProcura, contacto.getUser().getNickname()) || procurarString(stringProcura, contacto.getUser().getEmail()) || procurarString(stringProcura, contacto.getUser().getCurso())) {
                if (!(contacto.tempoPassado() > 180 * 1000)) {
                    arrayContactos.getUsers().add(contacto.getUser());
                }
            }
        }
        return arrayContactos;
    }

    private boolean procurarString(String stringProcura, String stringProcurada) {
        int index = 0;
        boolean returnValue = true;
        if (stringProcura.length() > stringProcurada.length()) {
            return false;
        } else {
            index = stringProcura.length();
        }
        char[] arrayProcura = stringProcura.toLowerCase(Locale.ITALY).toCharArray();
        char[] arrayProcurado = stringProcurada.toLowerCase(Locale.ITALY).toCharArray();
        for (int i = 0; i < index; i++) {
            if (!(arrayProcura[i] == arrayProcurado[i])) {
                returnValue = false;
            }
        }
        return returnValue;
    }

}

class UserInfo implements Serializable {

    private User user;
    private long ultimoLogin;

    public UserInfo(User user, long ultimoLogin) {
        this.user = user;
        this.ultimoLogin = ultimoLogin;
    }

    public User getUser() {
        return user;
    }

    public long getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin() {
        long ultimo = new Date().getTime();
        this.ultimoLogin = ultimo;
    }

    public double tempoPassado() {
        double tempo = TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - ultimoLogin);
        return tempo * 1000;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "user=" + user + ", ultimaVisita=" + ultimoLogin + '}';
    }

}
=======
package BackEnd;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AtendedorContactos extends UnicastRemoteObject implements InterfaceContactos {

    private ArrayList<UserInfo> contactos;

    public AtendedorContactos() throws RemoteException, ClassNotFoundException, IOException {
        super();
        contactos = new ArrayList<UserInfo>();
    }

    public void putContacto(User user) throws RemoteException {

        long tempoAtual = new Date().getTime();

        synchronized (this) {
            if (containsUserInfo(contactos, user)) {
                getUserInfo(user).getUser().setIp(user.getIp());
                getUserInfo(user).setUltimoLogin();
                System.out.print("user nao novo ->");

            } else {
                contactos.add(new UserInfo(user, tempoAtual));
                System.out.print("user novo ->");
            }
            System.out.println(user.toString());
        }
    }

    public ListaUsers getContactos() throws RemoteException {
        return getArrayListContactos();
    }

    public ListaUsers getContactos(String stringProcura) throws RemoteException {
        return getArrayListContactos(stringProcura);
    }

    private boolean containsUserInfo(ArrayList<UserInfo> contactos, User user) {
        boolean contains = false;
        for (UserInfo contacto : contactos) {
            if (contacto.getUser().equals(user)) {
                contains = true;
            }
        }
        return contains;
    }

    private UserInfo getUserInfo(User user) {
        UserInfo novoUser = null;
        for (UserInfo contacto : contactos) {
            if (contacto.getUser().equals(user)) {
                novoUser = contacto;
            }
        }
        return novoUser;
    }

    private ListaUsers getArrayListContactos() {
        ListaUsers arrayContactos = new ListaUsers();
        for (UserInfo contacto : contactos) {
            if (!(contacto.tempoPassado() > 180 * 1000)) {
                arrayContactos.getUsers().add(contacto.getUser());
            }
        }
        return arrayContactos;
    }

    private ListaUsers getArrayListContactos(String stringProcura) {
        ListaUsers arrayContactos = new ListaUsers();
        for (UserInfo contacto : contactos) {
            if (procurarString(stringProcura, contacto.getUser().getNickname()) || procurarString(stringProcura, contacto.getUser().getEmail()) || procurarString(stringProcura, contacto.getUser().getCurso())) {
                if (!(contacto.tempoPassado() > 180 * 1000)) {
                    arrayContactos.getUsers().add(contacto.getUser());
                }
            }
        }
        return arrayContactos;
    }

    private boolean procurarString(String stringProcura, String stringProcurada) {
        int index = 0;
        boolean returnValue = true;
        if (stringProcura.length() > stringProcurada.length()) {
            return false;
        } else {
            index = stringProcura.length();
        }
        char[] arrayProcura = stringProcura.toLowerCase(Locale.ITALY).toCharArray();
        char[] arrayProcurado = stringProcurada.toLowerCase(Locale.ITALY).toCharArray();
        for (int i = 0; i < index; i++) {
            if (!(arrayProcura[i] == arrayProcurado[i])) {
                returnValue = false;
            }
        }
        return returnValue;
    }

}

class UserInfo implements Serializable {

    private User user;
    private long ultimoLogin;

    public UserInfo(User user, long ultimoLogin) {
        this.user = user;
        this.ultimoLogin = ultimoLogin;
    }

    public User getUser() {
        return user;
    }

    public long getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin() {
        long ultimo = new Date().getTime();
        this.ultimoLogin = ultimo;
    }

    public double tempoPassado() {
        double tempo = TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - ultimoLogin);
        return tempo * 1000;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "user=" + user + ", ultimaVisita=" + ultimoLogin + '}';
    }

}
>>>>>>> cc0b55b0f272b57bd005af34d401f6a89f2354d0
