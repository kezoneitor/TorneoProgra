/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Kezo
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    char tipo = 'N';
    Administrador logeado;
    Metodos met = new Metodos();

    /**
     * Creates new form ventanaPrincipal
     */
    public ventanaPrincipal() {
        initComponents();
        //Componentes y sus iniciaciones por defecto
        //tbdPrincipal.setEnabledAt(1, false);
        //tbdPrincipal.setEnabledAt(2, false);
        //tbdPrincipal.setEnabledAt(3, false);
        //tbdRegistrar.setEnabledAt(0, true);
        //tbdRegistrar.setEnabledAt(1, false);
        //tbdRegistrar.setEnabledAt(2, false);

    }

    //Metodo para verificar si el valor puede convertirse en numero
    private static boolean esNumero(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbdPrincipal = new javax.swing.JTabbedPane();
        panelLogin = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblContraApellido = new javax.swing.JLabel();
        txtNLogin = new javax.swing.JTextField();
        txtCLogin = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        rbtnAdmin = new javax.swing.JRadioButton();
        rbtnEntrenador = new javax.swing.JRadioButton();
        rbtnJugador = new javax.swing.JRadioButton();
        panelRegistrar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbRegistro = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        tbdRegistrar = new javax.swing.JTabbedPane();
        panelAdmin = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNAdmin = new javax.swing.JTextField();
        txtCAdmin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        panelEntrenador = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNEntrenador = new javax.swing.JTextField();
        txtAEntrenador = new javax.swing.JTextField();
        panelJugdor = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblUsuarioActual = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setText("Nombre Usuario:");

        lblContraApellido.setText("Contraseña:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        rbtnAdmin.setText("Administrador");
        rbtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAdminActionPerformed(evt);
            }
        });

        rbtnEntrenador.setText("Entrenador");
        rbtnEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEntrenadorActionPerformed(evt);
            }
        });

        rbtnJugador.setText("Jugador");
        rbtnJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnLogin))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                    .addComponent(rbtnAdmin)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(panelLoginLayout.createSequentialGroup()
                                    .addComponent(lblNombre)
                                    .addGap(11, 11, 11)))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(lblContraApellido)
                                .addGap(33, 33, 33)))
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCLogin)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelLoginLayout.createSequentialGroup()
                                    .addComponent(rbtnEntrenador)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbtnJugador))
                                .addComponent(txtNLogin)))))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAdmin)
                    .addComponent(rbtnEntrenador)
                    .addComponent(rbtnJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraApellido)
                    .addComponent(txtCLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        tbdPrincipal.addTab("Login", panelLogin);

        panelRegistrar.setEnabled(false);
        panelRegistrar.setName(""); // NOI18N
        panelRegistrar.setRequestFocusEnabled(false);

        jLabel4.setText("Tipo a registrar:");

        cmbRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Entrenador", "Jugador" }));
        cmbRegistro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbRegistroItemStateChanged(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        panelAdmin.setEnabled(false);

        jLabel6.setText("Nombre de usuario:");

        jLabel7.setText("Contraseña:");

        jLabel8.setText("Su dinero por defecto será $0");

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelAdminLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelAdminLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtNAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(427, Short.MAX_VALUE))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        tbdRegistrar.addTab("Administrador", panelAdmin);
        panelAdmin.getAccessibleContext().setAccessibleParent(panelRegistrar);

        jLabel9.setText("Nombre: ");

        jLabel10.setText("Apellido:");

        javax.swing.GroupLayout panelEntrenadorLayout = new javax.swing.GroupLayout(panelEntrenador);
        panelEntrenador.setLayout(panelEntrenadorLayout);
        panelEntrenadorLayout.setHorizontalGroup(
            panelEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntrenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntrenadorLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelEntrenadorLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(1, 1, 1)))
                .addGroup(panelEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNEntrenador)
                    .addComponent(txtAEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(489, Short.MAX_VALUE))
        );
        panelEntrenadorLayout.setVerticalGroup(
            panelEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntrenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(318, Short.MAX_VALUE))
        );

        tbdRegistrar.addTab("Entrenador", panelEntrenador);

        javax.swing.GroupLayout panelJugdorLayout = new javax.swing.GroupLayout(panelJugdor);
        panelJugdor.setLayout(panelJugdorLayout);
        panelJugdorLayout.setHorizontalGroup(
            panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelJugdorLayout.setVerticalGroup(
            panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tbdRegistrar.addTab("Jugador", panelJugdor);

        javax.swing.GroupLayout panelRegistrarLayout = new javax.swing.GroupLayout(panelRegistrar);
        panelRegistrar.setLayout(panelRegistrarLayout);
        panelRegistrarLayout.setHorizontalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tbdRegistrar)
        );
        panelRegistrarLayout.setVerticalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbdRegistrar))
        );

        tbdPrincipal.addTab("Registrar", panelRegistrar);

        jPanel3.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        tbdPrincipal.addTab("tab3", jPanel3);

        jPanel2.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        tbdPrincipal.addTab("tab2", jPanel2);

        jLabel3.setText("Usuario actual: ");

        lblUsuarioActual.setText("No hay");

        jLabel5.setText("Estado:");

        lblEstado.setText("Desconectado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbdPrincipal)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarioActual)
                .addGap(113, 113, 113)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblUsuarioActual)
                    .addComponent(jLabel5)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbdPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Boton para logearse en el sistema
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //Validar que el boton diga login
        if (btnLogin.getText().equals("Login")) {
            //Validar que se allá escrito un nombre y marcado algun campo
            if (!txtNLogin.getText().isEmpty() & (rbtnAdmin.isEnabled() | rbtnEntrenador.isEnabled() | rbtnJugador.isEnabled())) {
                //Validar que el campo contraseña este lleno
                if (!txtCLogin.getText().isEmpty()) {
                    //Realizar este codigo si esta selecionado el radiobutton admin
                    if (rbtnAdmin.isSelected()) {
                        Administrador admin = met.buscarAdmin(txtNLogin.getText(), txtCLogin.getText());
                        //Verificar que exista ese admin
                        if (admin != null) {
                            this.tipo = 'A';
                            this.logeado = admin;
                            lblUsuarioActual.setText(this.logeado.nombre);
                            lblEstado.setText("Conectado");
                            btnLogin.setText("Logout");
                            //Habilitar los paneles para el administrador
                            tbdPrincipal.setEnabledAt(1, true);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontro usuario administrador");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor introduzca su contraseña");
                    }
                    //Realizar este codigo si esta selecionado el radiobutton entrenador
                } else if (rbtnEntrenador.isSelected()) {
                    Entrenador entrenador = met.buscarEntrenador(txtNLogin.getText(), txtCLogin.getText());
                    //Verificar que exista ese entrenador
                    if (entrenador != null) {
                        this.tipo = 'B';
                        lblUsuarioActual.setText(this.logeado.nombre);
                        lblEstado.setText("Conectado");
                        btnLogin.setText("Logout");
                        //Habilitar los paneles para el entrenador
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro usuario entrenador");
                    }
                    //Realizar este codigo si esta selecionado el radiobutton jugador
                } else if (rbtnJugador.isSelected()) {
                    Jugador jugador = met.buscarJugador(txtNLogin.getText(), txtCLogin.getText());
                    //Verificar que exista ese jugador
                    if (jugador != null) {
                        this.tipo = 'C';
                        lblUsuarioActual.setText(this.logeado.nombre);
                        lblEstado.setText("Conectado");
                        btnLogin.setText("Logout");
                        //Habilitar los paneles para el Jugador
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro usuario jugador");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Se debe marcar una opción.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los campos que le corresponden deben estar llenos");
            }
            //Validar que el boton diga logout y realizar el codigo
        } else if (btnLogin.getText().equals("Logout")) {
            this.tipo = 'N';
            this.logeado = null;
            lblUsuarioActual.setText("No hay");
            lblEstado.setText("onectado");
            btnLogin.setText("Login");
            //Desabilitar todos los paneles
            tbdPrincipal.setEnabledAt(1, false);
            tbdPrincipal.setEnabledAt(2, false);
            tbdPrincipal.setEnabledAt(3, false);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    
//RadioButtons para que solo este seleccionado 1 de ellos|||Inicio 
    private void rbtnEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEntrenadorActionPerformed
        lblContraApellido.setText("Apellido:");
        lblNombre.setText("Nombre:");
        rbtnJugador.setSelected(false);
        rbtnAdmin.setSelected(false);

    }//GEN-LAST:event_rbtnEntrenadorActionPerformed

    private void rbtnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAdminActionPerformed
        lblContraApellido.setText("Contraseña:");
        lblNombre.setText("Nombre Usuario:");
        rbtnJugador.setSelected(false);
        rbtnEntrenador.setSelected(false);

    }//GEN-LAST:event_rbtnAdminActionPerformed

    private void rbtnJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnJugadorActionPerformed
        lblContraApellido.setText("Apellido:");
        lblNombre.setText("Nombre:");
        rbtnEntrenador.setSelected(false);
        rbtnAdmin.setSelected(false);
    }//GEN-LAST:event_rbtnJugadorActionPerformed
//RadioButtons para que solo este seleccionado 1 de ellos|||Final
    
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int index = cmbRegistro.getSelectedIndex();
        switch (index) {
            case 0:
                if (!txtNAdmin.getText().isEmpty() & !txtCAdmin.getText().isEmpty()) {
                    met.InsertarAdmin(txtNAdmin.getText(), txtCAdmin.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Los espacios de administrador deben estar llenos");
                }
                break;
            case 1:
                if (!txtNEntrenador.getText().isEmpty() & !txtAEntrenador.getText().isEmpty()) {
                    met.InsertarEntrenador(txtNEntrenador.getText(), txtAEntrenador.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Los espacios de administrador deben estar llenos");
                }
                break;
            case 2:
                break;
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cmbRegistroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbRegistroItemStateChanged
        int index = cmbRegistro.getSelectedIndex();
        switch (index) {
            case 0:
                tbdRegistrar.setEnabledAt(1, false);
                tbdRegistrar.setEnabledAt(2, false);
                break;
            case 1:
                tbdRegistrar.setEnabledAt(0, false);
                tbdRegistrar.setEnabledAt(2, false);
                break;
            case 2:
                tbdRegistrar.setEnabledAt(0, false);
                tbdRegistrar.setEnabledAt(1, false);
                break;
        }
        tbdRegistrar.setEnabledAt(index, true);
        tbdRegistrar.setSelectedIndex(index);
    }//GEN-LAST:event_cmbRegistroItemStateChanged

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
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbRegistro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblContraApellido;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelEntrenador;
    private javax.swing.JPanel panelJugdor;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegistrar;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JRadioButton rbtnEntrenador;
    private javax.swing.JRadioButton rbtnJugador;
    private javax.swing.JTabbedPane tbdPrincipal;
    private javax.swing.JTabbedPane tbdRegistrar;
    private javax.swing.JTextField txtAEntrenador;
    private javax.swing.JTextField txtCAdmin;
    private javax.swing.JTextField txtCLogin;
    private javax.swing.JTextField txtNAdmin;
    private javax.swing.JTextField txtNEntrenador;
    private javax.swing.JTextField txtNLogin;
    // End of variables declaration//GEN-END:variables
}
