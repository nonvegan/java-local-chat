package BackEnd;


import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Serializable {

    private String nickname;
    private String email;
    private String curso;
    private ListaUsers listaAmigos;
    private String ip;
    private int porta;

    public User(String nickname, String email, String curso, String ip, int porta) {
        this.nickname = nickname;
        this.email = email;
        this.curso = curso;
        this.ip = ip;
        this.porta = porta;
        listaAmigos = new ListaUsers();
    }

    public String getNickname() {
        return nickname;
    }

    public void addAmigo(User user) {
        this.listaAmigos.getUsers().add(user);
    }

    public String getEmail() {
        return email;
    }

    public String getCurso() {
        return curso;
    }

    public String getIp() {
        return ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    public void atualizarIp() {
        try {
            setIp(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public ListaUsers getListaAmigos() {
        return listaAmigos;
    }

    @Override
    public String toString() {
        return "User{" + "nickname=" + nickname + ", email=" + email + ", curso=" + curso + ", ip=" + ip + ", porta=" + porta + '}';
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof User) {
            if (((User) o).nickname.equals(this.nickname) && ((User) o).email.equals(this.email) && ((User) o).curso.equals(this.curso)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + nickname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + curso.hashCode();
        return result;
    }

}
