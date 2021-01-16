package BackEnd;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

public class AtendedorContactos extends UnicastRemoteObject implements InterfaceContactos {

    private ArrayList<UserInfo> contactos = new ArrayList<UserInfo>();

    public AtendedorContactos() throws RemoteException {
        super();
    }

    public void putContacto(User user) throws RemoteException {

        long tempoAtual = new Date().getTime();

        synchronized (this) {
            if (containsUserInfo(contactos, user)) {
                getUserInfo(user).getUser().setIp(user.getIp());
                getUserInfo(user).setLastSeen(tempoAtual);
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

    /* private Vector<String> getIPList() {
        Vector<String> result = new Vector<String>();
        for (Enumeration<IPInfo> e = presentIPs.elements(); e.hasMoreElements();) {
            IPInfo element = e.nextElement();
            if (!element.timeOutPassed(180 * 1000)) {
                result.add(element.getIP());
            }
        }
        return result;
    } */
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
            arrayContactos.getUsers().add(contacto.getUser());
        }
        return arrayContactos;
    }

    private ListaUsers getArrayListContactos(String stringProcura) {
        ListaUsers arrayContactos = new ListaUsers();
        for (UserInfo contacto : contactos) {
            if (procurarString(stringProcura, contacto.getUser().getNickname()) || procurarString(stringProcura, contacto.getUser().getEmail()) || procurarString(stringProcura, contacto.getUser().getCurso())) {
                arrayContactos.getUsers().add(contacto.getUser());
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

class UserInfo {

    private User user;
    private long lastSeen;

    public UserInfo(User user, long lastSeen) {
        this.user = user;
        this.lastSeen = lastSeen;
    }

    public User getUser() {
        return user;
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public boolean timeOutPassed(int timeout) {
        boolean result = false;
        long timePassedSinceLastSeen = new Date().getTime() - this.lastSeen;
        if (timePassedSinceLastSeen >= timeout) {
            result = true;
        }
        return result;
    }
}
