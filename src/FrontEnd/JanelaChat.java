package FrontEnd;

import BackEnd.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class JanelaChat extends javax.swing.JFrame {
    
    Sistema sistema;
    DefaultListModel dlm1;
    DefaultListModel dlm2;
    
    public JanelaChat(Sistema sistema) throws IOException, ClassNotFoundException {
        initComponents();
        setTitle("Rede Social - " +  "Utilizador :" + sistema.getCurrentUser().getNickname() + ", Porta: " + sistema.getCurrentUser().getPorta());
        this.sistema = sistema;
        jTextArea1.setEditable(false);
        dlm1 = new DefaultListModel<String>();
        dlm2 = new DefaultListModel<String>();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        atualizarlistaAmigos();
        atualizarListaPedidos();
        atualizarButton();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {  //Adiciona um listener da janela a fcher

                try {
                    limparJanelas();
                    sistema.setJanela(null);
                    sistema.setCurrentUser(null);
                    sistema.getServidorSocket().fecharSocket();
                    sistema.setServidorSocket(null);
                    sistema.writeSistema(null);
                    
                } catch (IOException ex) {
                    Logger.getLogger(JanelaChat.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    System.exit(1);
                }
            }
        });
        
    }
    
    public void atualizarlistaAmigos() {
        dlm1.clear();
        for (User user : sistema.getCurrentUser().getListaAmigos().getUsers()) {
            dlm1.addElement(user.getNickname() + " - " + user.getEmail() + " - (" + user.getCurso() + ")");
        }
        jList1.setModel(dlm1);
    }
    
    public void atualizarListaPedidos() {
        dlm2.clear();
        for (User user : sistema.getCurrentUser().getListaPedidos().getUsers()) {
            dlm2.addElement(user.getNickname() + " - " + user.getEmail() + " - (" + user.getCurso() + ")");
        }
        jList2.setModel(dlm2);
    }
    
    public void atualizarButton() {
        if (jTabbedPane1.getSelectedIndex() == 0) {
            jButton4.setEnabled(true);
            jButton5.setEnabled(false);
        } else {
            jButton4.setEnabled(false);
            jButton5.setEnabled(true);
        }
    }
    
    public JTextArea getChat() {
        return jTextArea1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        jTabbedPane1.addTab("Lista de Amigos", jScrollPane2);

        jScrollPane3.setViewportView(jList2);

        jTabbedPane1.addTab("Pedidos de amizade", jScrollPane3);

        jButton5.setText("Aceitar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("contactos");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)))
                                .addGap(32, 32, 32)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField1.getText().isBlank()) {
            SimpleDateFormat formatadorTempo = new SimpleDateFormat("HH:mm:ss");
            Date data = new Date();
            String tempo = "<" + formatadorTempo.format(data) + "> ";
            jTextArea1.append(tempo + "Enviada: " + jTextField1.getText() + "\n");
            for (User destino : sistema.getCurrentUser().getListaAmigos().getUsers()) {
                Cliente cliente = new Cliente(sistema.getCurrentUser(), destino, jTextField1.getText(), "enviar");
                cliente.start();
            }
            jTextField1.setText("");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limparJanelas();
        sistema.setJanela(null);
        sistema.setCurrentUser(null);
        sistema.getServidorSocket().fecharSocket();
        sistema.setServidorSocket(null);
        try {
            sistema.writeSistema(null);
        } catch (IOException ex) {
            Logger.getLogger(JanelaChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Login(sistema).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (sistema.getCurrentUser().getListaAmigos().getUsers().size() > 0 && !jList1.isSelectionEmpty() && jList1.getSelectedIndices().length == 1) {
            Cliente cliente = new Cliente(sistema.getCurrentUser(), sistema.getCurrentUser().getListaAmigos().getUsers().get(jList1.getSelectedIndex()), "", "remover");
            sistema.getCurrentUser().getListaAmigos().getUsers().remove(jList1.getSelectedIndex());
            cliente.start();
            atualizarlistaAmigos();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jList2.getSelectedIndices().length == 1 && sistema.getCurrentUser().getListaPedidos().containsUser(sistema.getCurrentUser().getListaPedidos().getUsers().get(jList2.getSelectedIndex()).getNickname())) {
            Cliente cliente = new Cliente(sistema.getCurrentUser(), sistema.getCurrentUser().getListaPedidos().getUsers().get(jList2.getSelectedIndex()), "", "aceitar");
            cliente.run();
            sistema.getCurrentUser().addAmigo(sistema.getCurrentUser().getListaPedidos().getUsers().get(jList2.getSelectedIndex()));
            sistema.getCurrentUser().removePedido(sistema.getCurrentUser().getListaPedidos().getUsers().get(jList2.getSelectedIndex()).getNickname());
            atualizarListaPedidos();
            atualizarlistaAmigos();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        atualizarButton();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new Contactos(sistema).setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed
    public void limparJanelas() {
        System.gc();//garbage collection
        java.awt.Window win[] = java.awt.Window.getWindows();//faz dispose de todas as janelas abertas
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
            win[i] = null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
