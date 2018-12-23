/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolists;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class DeleteUser extends javax.swing.JFrame {

    /**
     * Creates new form DoLists
     */
    public DeleteUser() throws ClassNotFoundException {
        initComponents();
        
        // Centrar pantalla
        this.setLocationRelativeTo(null);
        
        // Poner título
        this.setTitle("Eliminar Usuario - DoLists");
        
        // Obtengo usuarios
        OperacionesBD o = new OperacionesBD();
        ArrayList<String> usuarios = o.obtainUsersAutocomplete(0);
        
        // Creo autocompletado
        TextAutoCompleter autocomplete = new TextAutoCompleter(user);
        
        usuarios.forEach((u) -> {
            autocomplete.addItem(u);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_user = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        barra_menu = new javax.swing.JMenuBar();
        start = new javax.swing.JMenu();
        inicio = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        options = new javax.swing.JMenu();
        add_user = new javax.swing.JMenuItem();
        delete_user = new javax.swing.JMenuItem();
        modify_user = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_user.setText("Usuario:");

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        start.setText("Inicio");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        inicio.setText("Ir a Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        start.add(inicio);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        start.add(salir);

        barra_menu.add(start);

        options.setText("Opciones");

        add_user.setText("Añadir Usuario");
        add_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_userActionPerformed(evt);
            }
        });
        options.add(add_user);

        delete_user.setText("Eliminar Usuario");
        delete_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_userActionPerformed(evt);
            }
        });
        options.add(delete_user);

        modify_user.setText("Modificar Usuario");
        modify_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_userActionPerformed(evt);
            }
        });
        options.add(modify_user);

        barra_menu.add(options);

        setJMenuBar(barra_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btn_eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label_user)
                        .addGap(18, 18, 18)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btn_eliminar)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        DoLists d = null;
        try {
            d = new DoLists();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inicioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void add_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_userActionPerformed
        AddUser a = new AddUser();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_add_userActionPerformed

    private void delete_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_userActionPerformed
        DeleteUser d = null;
        try {
            d = new DeleteUser();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_delete_userActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        String u = user.getText();
        if(!u.isEmpty() && u.contains(" - ")) {
            OperacionesBD o = new OperacionesBD();
            try {
                String dni = u.split(" - ")[1];
                System.out.print(dni);
                String msg = o.deleteUser(dni);
                if(msg.equals("error")) JOptionPane.showMessageDialog(rootPane, "Error al eliminar el usuario.");
                else {
                    JOptionPane.showMessageDialog(rootPane, "Usuario eliminado con éxito.");
                    
                    // Una vez metido el usuario, me voy al inicio
                    DoLists dl = new DoLists();
                    dl.setVisible(true);
                    this.dispose();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else JOptionPane.showMessageDialog(rootPane, "No se debe modificar el autocompletado, tiene que introducir algún resultado del autocompletado.");
        
        user.setText("");
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed

    }//GEN-LAST:event_startActionPerformed

    private void modify_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify_userActionPerformed
        ModifyUser m = null;
        try {
            m = new ModifyUser();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modify_userActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DeleteUser().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem add_user;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JMenuItem delete_user;
    private javax.swing.JMenuItem inicio;
    private javax.swing.JLabel label_user;
    private javax.swing.JMenuItem modify_user;
    private javax.swing.JMenu options;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenu start;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}