package BackEnd;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Servidor extends Thread {

    Sistema sistema;
    boolean continuar;
    ServerSocket servidor;

    public Servidor(Sistema sistema) {
        this.sistema = sistema;
        continuar = true;
        servidor = null;
    }

    @Override
    public void run() {
        try {
            servidor = new ServerSocket(sistema.getCurrentUser().getPorta());
        } catch (BindException e) {
            JOptionPane.showMessageDialog(sistema.getJanela(), "A porta " + sistema.getCurrentUser().getPorta() + " já se encontra em uso, por favor feche aplicação aberta.", "Porta em uso", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        sistema.getJanela().setVisible(true);

        while (continuar) {
            try {
                Socket ligacao = servidor.accept();
                AtendedorPedidos handler = new AtendedorPedidos(ligacao, sistema);
                handler.start();
            } catch (SocketException ex) {
                System.out.println("Socket encerrada");
            } catch (IOException ex) {
                System.out.println("Erro do servidor: " + ex);
                System.exit(1);
            }

        }
    }

    public void fecharSocket() {
        continuar = false;
        try {
            servidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
