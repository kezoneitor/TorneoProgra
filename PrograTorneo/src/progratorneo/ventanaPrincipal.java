/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.red;
import static java.awt.Color.white;
import static java.awt.EventQueue.invokeLater;
import java.awt.Graphics;
import java.awt.Image;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Math.random;
import static java.lang.String.valueOf;
import static java.lang.String.valueOf;
import static java.lang.String.valueOf;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.Vector;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kezo
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    char tipo = 'N';
    Administrador logeado;
    Metodos met = new Metodos();
    DataDefecto data = new DataDefecto();
    DefaultTableModel tabla = new DefaultTableModel();

    /**
     * Creates new form ventanaPrincipal
     */
    public ventanaPrincipal() {
        initComponents();

        //Componentes y sus iniciaciones por defecto|||Inicio
        //tbdPrincipal.setEnabledAt(1, false);
        //tbdPrincipal.setEnabledAt(2, false);
        //tbdPrincipal.setEnabledAt(3, false);
        //tbdRegistrar.setEnabledAt(0, true);
        //tbdRegistrar.setEnabledAt(1, false);
        //tbdRegistrar.setEnabledAt(2, false);
        //Componentes y sus iniciaciones por defecto|||final
        met.InsertarAdmin("kezo", "123");
        met.InsertarAdmin("julio", "123");

        data.AgregarNombreApellido();
        data.CrearJugadores();
        insertarJugadores();
    }

    //Metodo para verificar si el valor puede convertirse en numero
    private static boolean esNumero(String texto) {
        try {
            parseInt(texto);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    //Pintar una imagen en una ventana
    private void dibujarCamisa(Graphics g, Image camisa, Image estam) {
        super.paint(g);
        g.drawRect(0, 0, 240, 240);
        g.setColor(white);
        g.fillRect(0, 0, 240, 240);
        g.drawImage(camisa, 0, 0, null);
        if (estam != null) {
            g.drawImage(estam, 0, 0, null);
        }
    }

    //insertar los jugadores en el puntero de jugadores
    private void insertarJugadores() {
        for (int i = 0; i < data.Jugadores.size(); i++) {
            String nombre = (String) data.Jugadores.get(i).get(0);
            String apellido = (String) data.Jugadores.get(i).get(1);
            int[] habilidades = (int[]) data.Jugadores.get(i).get(2);
            int precio = (int) data.Jugadores.get(i).get(3);
            String posicion = (String) data.Jugadores.get(i).get(4);
            met.InsertarJugador(nombre, apellido, habilidades, precio, posicion);
        }
        met.imprimirJugador();
    }

    //LLenar la jTable con informacion
    private void llenarTabla() {
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Habilidades");
        tabla.addColumn("Precio");
        tabla.addColumn("Posicion");
        ArrayList<ArrayList> respaldo = data.Jugadores;
        while (respaldo.size() != 0) {
            Vector datos = new Vector();
            int i = (int) (random() * (respaldo.size() - 1));
            datos.addElement(respaldo.get(i).get(0));
            datos.addElement(respaldo.get(i).get(1));
            int[] habilidades = (int[]) respaldo.get(i).get(2);
            String habi = "Fis: " + habilidades[0] + "  Def: " + habilidades[1] + "  Dri: " + habilidades[2] + "  Dis: " + habilidades[3];
            datos.addElement(habi);
            datos.addElement(respaldo.get(i).get(3));
            datos.addElement(respaldo.get(i).get(4));
            tabla.addRow(datos);

            respaldo.remove(i);
        }
        jTable1.setModel(tabla);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNJugador = new javax.swing.JTextField();
        txtAJugador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbPosicion = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbFisico = new javax.swing.JComboBox<>();
        cmbDefensa = new javax.swing.JComboBox<>();
        cmbDribbling = new javax.swing.JComboBox<>();
        cmbDisparo = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        panelEstadio = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNEstadio = new javax.swing.JTextField();
        txtUEstadio = new javax.swing.JTextField();
        txtCEstadio = new javax.swing.JTextField();
        panelEquipo = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmbColorCamisa = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        cmbEstampadoColor = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cmbEstampado = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txtNEquipo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelCamisa = new javax.swing.JPanel();
        panelModificar = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        cmbModificar = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        tbdModificar = new javax.swing.JTabbedPane();
        panelAdminModi = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtNAdminModi = new javax.swing.JTextField();
        txtCAdminModi = new javax.swing.JTextField();
        panelEntrenadorModi = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtNEntrenadorModi = new javax.swing.JTextField();
        txtAEntrenadorModi = new javax.swing.JTextField();
        panelJugdorModi = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtNJugadorModi = new javax.swing.JTextField();
        txtAJugadorModi = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        cmbPosicionModi = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cmbFisicoModi = new javax.swing.JComboBox<>();
        cmbDefensaModi = new javax.swing.JComboBox<>();
        cmbDribblingModi = new javax.swing.JComboBox<>();
        cmbDisparoModi = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        lblPrecioModi = new javax.swing.JLabel();
        panelEstadioModi = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtNEstadioModi = new javax.swing.JTextField();
        txtUEstadioModi = new javax.swing.JTextField();
        txtCEstadioModi = new javax.swing.JTextField();
        panelEquipoModi = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        cmbColorCamisaModi = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        cmbEstampadoColorModi = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        cmbEstampadoModi = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        txtNEquipoModi = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        panelCamisaModi = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        txtDineroEquipo = new javax.swing.JTextField();
        lblBuscarModi = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnGenerarJ = new javax.swing.JButton();
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
                    .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rbtnAdmin, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelLoginLayout.createSequentialGroup()
                            .addComponent(lblNombre)
                            .addGap(11, 11, 11)))
                    .addComponent(lblContraApellido)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnLogin)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCLogin)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLoginLayout.createSequentialGroup()
                        .addComponent(rbtnEntrenador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnJugador))
                    .addComponent(txtNLogin, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(785, Short.MAX_VALUE))
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

        cmbRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Entrenador", "Jugador", "Estadio", "Equipo" }));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdRegistrar.addTab("Entrenador", panelEntrenador);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel11.setText("Posición:");

        cmbPosicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "portero", "defensa", "medio", "delantero" }));

        jLabel12.setText("Habilidades");

        jLabel13.setText("Físico:");

        jLabel14.setText("Defensa:");

        jLabel15.setText("Dribbling:");

        jLabel16.setText("Disparo:");

        cmbFisico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbFisico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFisicoItemStateChanged(evt);
            }
        });

        cmbDefensa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbDefensa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDefensaItemStateChanged(evt);
            }
        });

        cmbDribbling.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbDribbling.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDribblingItemStateChanged(evt);
            }
        });

        cmbDisparo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbDisparo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDisparoItemStateChanged(evt);
            }
        });

        jLabel17.setText("Este jugador empezará con 0 goles");

        jLabel18.setText("Precio: $");

        lblPrecio.setText("185000 (Precio mínimo)");

        javax.swing.GroupLayout panelJugdorLayout = new javax.swing.GroupLayout(panelJugdor);
        panelJugdor.setLayout(panelJugdorLayout);
        panelJugdorLayout.setHorizontalGroup(
            panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugdorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJugdorLayout.createSequentialGroup()
                        .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelJugdorLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDribbling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDisparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addGroup(panelJugdorLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecio)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelJugdorLayout.createSequentialGroup()
                        .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelJugdorLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNJugador))
                            .addGroup(panelJugdorLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJugdorLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAJugador))
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelJugdorLayout.setVerticalGroup(
            panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugdorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(cmbFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDribbling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDisparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelJugdorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdRegistrar.addTab("Jugador", panelJugdor);

        jLabel19.setText("Nombre:");

        jLabel20.setText("Ubicación:");

        jLabel21.setText("capacidad:");

        javax.swing.GroupLayout panelEstadioLayout = new javax.swing.GroupLayout(panelEstadio);
        panelEstadio.setLayout(panelEstadioLayout);
        panelEstadioLayout.setHorizontalGroup(
            panelEstadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEstadioLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtNEstadio))
                    .addGroup(panelEstadioLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUEstadio))
                    .addGroup(panelEstadioLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEstadioLayout.setVerticalGroup(
            panelEstadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtNEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtUEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtCEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdRegistrar.addTab("Estadio", panelEstadio);

        panelEquipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel22.setText("Camisa");

        jLabel23.setText("Color");

        cmbColorCamisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarilla", "Anaranjada", "Azul", "Blanca", "Celeste", "Morada", "Negra", "Roja", "Verde", "Violeta" }));
        cmbColorCamisa.setSelectedIndex(3);
        cmbColorCamisa.setToolTipText("");
        cmbColorCamisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbColorCamisaItemStateChanged(evt);
            }
        });

        jLabel24.setText("Estampado");

        cmbEstampadoColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarilla", "Anaranjada", "Azul", "Blanca", "Celeste", "Morada", "Negra", "Roja", "Verde", "Violeta" }));
        cmbEstampadoColor.setSelectedIndex(6);
        cmbEstampadoColor.setToolTipText("");
        cmbEstampadoColor.setEnabled(false);
        cmbEstampadoColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstampadoColorItemStateChanged(evt);
            }
        });

        jLabel25.setText("Color");

        cmbEstampado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Cruz", "Rayada", "Tres Lineas" }));
        cmbEstampado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstampadoItemStateChanged(evt);
            }
        });

        jLabel26.setText("Nombre:");

        jLabel27.setText("El equipo empezará con $ 3 000 000");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelCamisa.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCamisaLayout = new javax.swing.GroupLayout(panelCamisa);
        panelCamisa.setLayout(panelCamisaLayout);
        panelCamisaLayout.setHorizontalGroup(
            panelCamisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        panelCamisaLayout.setVerticalGroup(
            panelCamisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelEquipoLayout = new javax.swing.GroupLayout(panelEquipo);
        panelEquipo.setLayout(panelEquipoLayout);
        panelEquipoLayout.setHorizontalGroup(
            panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquipoLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27))
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbEstampadoColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEstampado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbColorCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(panelCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365))
        );
        panelEquipoLayout.setVerticalGroup(
            panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquipoLayout.createSequentialGroup()
                        .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtNEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelEquipoLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
            .addGroup(panelEquipoLayout.createSequentialGroup()
                .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquipoLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbColorCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(cmbEstampado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(cmbEstampadoColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEquipoLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(panelCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 117, Short.MAX_VALUE))
        );

        tbdRegistrar.addTab("Equipo", panelEquipo);

        javax.swing.GroupLayout panelRegistrarLayout = new javax.swing.GroupLayout(panelRegistrar);
        panelRegistrar.setLayout(panelRegistrarLayout);
        panelRegistrarLayout.setHorizontalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(44, 44, 44))
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

        panelModificar.setEnabled(false);
        panelModificar.setName(""); // NOI18N
        panelModificar.setRequestFocusEnabled(false);

        jLabel28.setText("Tipo a modificar:");

        cmbModificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Entrenador", "Jugador", "Estadio", "Equipo" }));
        cmbModificar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbModificarItemStateChanged(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        panelAdminModi.setEnabled(false);

        jLabel29.setText("Nombre de usuario:");

        jLabel30.setText("Contraseña:");

        javax.swing.GroupLayout panelAdminModiLayout = new javax.swing.GroupLayout(panelAdminModi);
        panelAdminModi.setLayout(panelAdminModiLayout);
        panelAdminModiLayout.setHorizontalGroup(
            panelAdminModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAdminModiLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCAdminModi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAdminModiLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(txtNAdminModi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(805, Short.MAX_VALUE))
        );
        panelAdminModiLayout.setVerticalGroup(
            panelAdminModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtNAdminModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAdminModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtCAdminModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(313, Short.MAX_VALUE))
        );

        tbdModificar.addTab("Administrador", panelAdminModi);

        jLabel32.setText("Nombre: ");

        jLabel33.setText("Apellido:");

        javax.swing.GroupLayout panelEntrenadorModiLayout = new javax.swing.GroupLayout(panelEntrenadorModi);
        panelEntrenadorModi.setLayout(panelEntrenadorModiLayout);
        panelEntrenadorModiLayout.setHorizontalGroup(
            panelEntrenadorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntrenadorModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntrenadorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntrenadorModiLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelEntrenadorModiLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(1, 1, 1)))
                .addGroup(panelEntrenadorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNEntrenadorModi)
                    .addComponent(txtAEntrenadorModi, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEntrenadorModiLayout.setVerticalGroup(
            panelEntrenadorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntrenadorModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntrenadorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtNEntrenadorModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEntrenadorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtAEntrenadorModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdModificar.addTab("Entrenador", panelEntrenadorModi);

        jLabel34.setText("Nombre:");

        jLabel35.setText("Apellido:");

        jLabel36.setText("Posición:");

        cmbPosicionModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "portero", "defensa", "medio", "delantero" }));

        jLabel37.setText("Habilidades");

        jLabel38.setText("Físico:");

        jLabel39.setText("Defensa:");

        jLabel40.setText("Dribbling:");

        jLabel41.setText("Disparo:");

        cmbFisicoModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbFisicoModi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFisicoModiItemStateChanged(evt);
            }
        });

        cmbDefensaModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbDefensaModi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDefensaModiItemStateChanged(evt);
            }
        });

        cmbDribblingModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbDribblingModi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDribblingModiItemStateChanged(evt);
            }
        });

        cmbDisparoModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbDisparoModi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDisparoModiItemStateChanged(evt);
            }
        });

        jLabel43.setText("Precio: $");

        lblPrecioModi.setText("0");

        javax.swing.GroupLayout panelJugdorModiLayout = new javax.swing.GroupLayout(panelJugdorModi);
        panelJugdorModi.setLayout(panelJugdorModiLayout);
        panelJugdorModiLayout.setHorizontalGroup(
            panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugdorModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJugdorModiLayout.createSequentialGroup()
                        .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelJugdorModiLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFisicoModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDefensaModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDribblingModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDisparoModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJugdorModiLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecioModi)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelJugdorModiLayout.createSequentialGroup()
                        .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelJugdorModiLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNJugadorModi))
                            .addGroup(panelJugdorModiLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPosicionModi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelJugdorModiLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAJugadorModi))
                            .addComponent(jLabel37))
                        .addGap(489, 863, Short.MAX_VALUE))))
        );
        panelJugdorModiLayout.setVerticalGroup(
            panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugdorModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtNJugadorModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtAJugadorModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPosicionModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(cmbFisicoModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDefensaModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDribblingModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDisparoModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelJugdorModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(lblPrecioModi))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        tbdModificar.addTab("Jugador", panelJugdorModi);

        jLabel44.setText("Nombre:");

        jLabel45.setText("Ubicación:");

        jLabel46.setText("capacidad:");

        javax.swing.GroupLayout panelEstadioModiLayout = new javax.swing.GroupLayout(panelEstadioModi);
        panelEstadioModi.setLayout(panelEstadioModiLayout);
        panelEstadioModiLayout.setHorizontalGroup(
            panelEstadioModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadioModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadioModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEstadioModiLayout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addComponent(txtNEstadioModi))
                    .addGroup(panelEstadioModiLayout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUEstadioModi))
                    .addGroup(panelEstadioModiLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCEstadioModi, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEstadioModiLayout.setVerticalGroup(
            panelEstadioModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadioModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadioModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtNEstadioModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstadioModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtUEstadioModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstadioModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtCEstadioModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdModificar.addTab("Estadio", panelEstadioModi);

        panelEquipoModi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel47.setText("Camisa");

        jLabel48.setText("Color");

        cmbColorCamisaModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarilla", "Anaranjada", "Azul", "Blanca", "Celeste", "Morada", "Negra", "Roja", "Verde", "Violeta" }));
        cmbColorCamisaModi.setSelectedIndex(3);
        cmbColorCamisaModi.setToolTipText("");
        cmbColorCamisaModi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbColorCamisaModiItemStateChanged(evt);
            }
        });

        jLabel49.setText("Estampado");

        cmbEstampadoColorModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarilla", "Anaranjada", "Azul", "Blanca", "Celeste", "Morada", "Negra", "Roja", "Verde", "Violeta" }));
        cmbEstampadoColorModi.setSelectedIndex(6);
        cmbEstampadoColorModi.setToolTipText("");
        cmbEstampadoColorModi.setEnabled(false);
        cmbEstampadoColorModi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstampadoColorModiItemStateChanged(evt);
            }
        });

        jLabel50.setText("Color");

        cmbEstampadoModi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Cruz", "Rayada", "Tres Lineas" }));
        cmbEstampadoModi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstampadoModiItemStateChanged(evt);
            }
        });

        jLabel51.setText("Nombre:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelCamisaModi.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCamisaModiLayout = new javax.swing.GroupLayout(panelCamisaModi);
        panelCamisaModi.setLayout(panelCamisaModiLayout);
        panelCamisaModiLayout.setHorizontalGroup(
            panelCamisaModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        panelCamisaModiLayout.setVerticalGroup(
            panelCamisaModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jLabel52.setText("Dinero:");

        javax.swing.GroupLayout panelEquipoModiLayout = new javax.swing.GroupLayout(panelEquipoModi);
        panelEquipoModi.setLayout(panelEquipoModiLayout);
        panelEquipoModiLayout.setHorizontalGroup(
            panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquipoModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquipoModiLayout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNEquipoModi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEquipoModiLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDineroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbEstampadoColorModi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEstampadoModi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbColorCamisaModi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(panelCamisaModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365))
        );
        panelEquipoModiLayout.setVerticalGroup(
            panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquipoModiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquipoModiLayout.createSequentialGroup()
                        .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtNEquipoModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(txtDineroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelEquipoModiLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())))
            .addGroup(panelEquipoModiLayout.createSequentialGroup()
                .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquipoModiLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbColorCamisaModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(cmbEstampadoModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEquipoModiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(cmbEstampadoColorModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEquipoModiLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(panelCamisaModi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 117, Short.MAX_VALUE))
        );

        tbdModificar.addTab("Equipo", panelEquipoModi);

        lblBuscarModi.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblBuscarModi.setText("Buscar Administrador para modificar");
        lblBuscarModi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarModiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuscarModiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBuscarModiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelModificarLayout = new javax.swing.GroupLayout(panelModificar);
        panelModificar.setLayout(panelModificarLayout);
        panelModificarLayout.setHorizontalGroup(
            panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(lblBuscarModi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(44, 44, 44))
            .addComponent(tbdModificar)
        );
        panelModificarLayout.setVerticalGroup(
            panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cmbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar)
                    .addComponent(lblBuscarModi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbdModificar))
        );

        tbdPrincipal.addTab("Modificar", panelModificar);

        jPanel3.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Habilidades", "Precio", "Posicion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnGenerarJ.setText("Generar J");
        BtnGenerarJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnGenerarJMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BtnGenerarJ)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnGenerarJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        tbdPrincipal.addTab("tab3", jPanel3);

        jPanel2.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
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
            .addComponent(tbdPrincipal)
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
                        showMessageDialog(null, "No se encontro usuario administrador");
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
                        showMessageDialog(null, "No se encontro usuario entrenador");
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
                        showMessageDialog(null, "No se encontro usuario jugador");
                    }
                } else {
                    showMessageDialog(null, "Se debe marcar una opción.");
                }
            } else {
                showMessageDialog(null, "Los campos que le corresponden deben estar llenos");
            }
            //Validar que el boton diga logout y realizar el codigo
        } else if (btnLogin.getText().equals("Logout")) {
            this.tipo = 'N';
            this.logeado = null;
            lblUsuarioActual.setText("No hay");
            lblEstado.setText("Desconectado");
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
                    showMessageDialog(null, "Administrador insertado exitosamente");
                } else {
                    showMessageDialog(null, "Los espacios de administrador deben estar llenos");
                }
                break;
            case 1:
                if (!txtNEntrenador.getText().isEmpty() & !txtAEntrenador.getText().isEmpty()) {
                    met.InsertarEntrenador(txtNEntrenador.getText(), txtAEntrenador.getText());
                    showMessageDialog(null, "Entrenador insertado exitosamente");
                } else {
                    showMessageDialog(null, "Los espacios de entrenador deben estar llenos");
                }
                break;
            case 2:
                if (!txtNJugador.getText().isEmpty() & !txtAJugador.getText().isEmpty()) {
                    int precio = parseInt(lblPrecio.getText());
                    int fisico = parseInt((String) cmbFisico.getSelectedItem());
                    int defensa = parseInt((String) cmbDefensa.getSelectedItem());
                    int dribbling = parseInt((String) cmbDribbling.getSelectedItem());
                    int disparo = parseInt((String) cmbDisparo.getSelectedItem());
                    int[] habilidades = {fisico, defensa, dribbling, disparo};
                    met.InsertarJugador(txtNJugador.getText(), txtAJugador.getText(), habilidades, precio, (String) cmbPosicion.getSelectedItem());
                    showMessageDialog(null, "Jugador insertado exitosamente");
                } else {
                    showMessageDialog(null, "Los espacios de jugador deben estar llenos");
                }
                break;
            case 3:
                if (!txtNEstadio.getText().isEmpty() & !txtUEstadio.getText().isEmpty() & !txtCEstadio.getText().isEmpty()) {
                    if (esNumero(txtCEstadio.getText())) {
                        int capacidad = parseInt(txtCEstadio.getText());
                        met.InsertarEstadio(txtNEstadio.getText(), txtUEstadio.getText(), capacidad);
                        showMessageDialog(null, "Estadio insertado exitosamente");
                    } else {
                        showMessageDialog(null, "El espacio capacidad deben ser números");
                    }
                } else {
                    showMessageDialog(null, "Los espacios de estadio deben estar llenos");
                }
                break;
            case 4:
                if (!txtNEquipo.getText().isEmpty()) {
                    String ubicacionCamisa = "/progratorneo/camisas/color" + data.colores[cmbColorCamisa.getSelectedIndex()];
                    String[] camisa = {ubicacionCamisa, ubicacionCamisa};
                    if (cmbEstampado.getSelectedIndex() != 0) {
                        String ubicacionEstampado = "/progratorneo/camisas" + data.estampado[cmbEstampado.getSelectedIndex() - 1] + data.colores[cmbEstampadoColor.getSelectedIndex()];
                        camisa[1] = ubicacionEstampado;
                    } else {
                        showMessageDialog(null, "Los espacios de Equipo deben estar llenos");
                    }
                    met.InsertarEquipo(txtNEquipo.getText(), camisa);
                    showMessageDialog(null, "Equipo insertado exitosamente");
                }
                break;
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cmbRegistroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbRegistroItemStateChanged
        int index = cmbRegistro.getSelectedIndex();
        switch (index) {
            case 0:
                tbdRegistrar.setEnabledAt(1, false);
                tbdRegistrar.setEnabledAt(2, false);
                tbdRegistrar.setEnabledAt(3, false);
                tbdRegistrar.setEnabledAt(4, false);
                break;
            case 1:
                tbdRegistrar.setEnabledAt(0, false);
                tbdRegistrar.setEnabledAt(2, false);
                tbdRegistrar.setEnabledAt(3, false);
                tbdRegistrar.setEnabledAt(4, false);
                break;
            case 2:
                tbdRegistrar.setEnabledAt(0, false);
                tbdRegistrar.setEnabledAt(1, false);
                tbdRegistrar.setEnabledAt(3, false);
                tbdRegistrar.setEnabledAt(4, false);
                break;
            case 3:
                tbdRegistrar.setEnabledAt(0, false);
                tbdRegistrar.setEnabledAt(1, false);
                tbdRegistrar.setEnabledAt(2, false);
                tbdRegistrar.setEnabledAt(4, false);
                break;
            case 4:
                tbdRegistrar.setEnabledAt(0, false);
                tbdRegistrar.setEnabledAt(1, false);
                tbdRegistrar.setEnabledAt(2, false);
                tbdRegistrar.setEnabledAt(3, false);
                break;
        }
        tbdRegistrar.setEnabledAt(index, true);
        tbdRegistrar.setSelectedIndex(index);
    }//GEN-LAST:event_cmbRegistroItemStateChanged

    private void sacarPrecioJugador(JLabel label) {
        int fisico = parseInt((String) cmbFisico.getSelectedItem());
        int defensa = parseInt((String) cmbDefensa.getSelectedItem());
        int dribbling = parseInt((String) cmbDribbling.getSelectedItem());
        int disparo = parseInt((String) cmbDisparo.getSelectedItem());
        int[] habilidades = {fisico, defensa, dribbling, disparo};
        int precio = data.precio(habilidades);
        label.setText(valueOf(precio));
    }

    //Sacar Precio y mostrarlo en un label||| inicio
    private void cmbFisicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFisicoItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbFisicoItemStateChanged

    private void cmbDefensaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDefensaItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbDefensaItemStateChanged

    private void cmbDribblingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDribblingItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbDribblingItemStateChanged

    private void cmbDisparoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDisparoItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbDisparoItemStateChanged
    //Sacar Precio y mostrarlo en un label||| final

    private void BtnGenerarJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnGenerarJMouseClicked
        llenarTabla();
    }//GEN-LAST:event_BtnGenerarJMouseClicked

    private void imprimirCamisa(JPanel panel) {
        String ubicacionCamisa = "/progratorneo/camisas/color" + data.colores[cmbColorCamisa.getSelectedIndex()];
        Image camisa = (new javax.swing.ImageIcon(getClass().getResource(ubicacionCamisa))).getImage();
        Image estam = null;
        if (cmbEstampado.getSelectedIndex() != 0) {
            cmbEstampadoColor.setEnabled(true);
            String ubicacionEstampado = "/progratorneo/camisas" + data.estampado[cmbEstampado.getSelectedIndex() - 1] + data.colores[cmbEstampadoColor.getSelectedIndex()];
            estam = (new javax.swing.ImageIcon(getClass().getResource(ubicacionEstampado))).getImage();
        } else {
            cmbEstampadoColor.setEnabled(false);
        }
        dibujarCamisa(panel.getGraphics(), camisa, estam);
    }

    //Elegir la comida|||Inicio
    private void cmbColorCamisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbColorCamisaItemStateChanged
        imprimirCamisa(panelCamisa);
    }//GEN-LAST:event_cmbColorCamisaItemStateChanged

    private void cmbEstampadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoItemStateChanged
        imprimirCamisa(panelCamisa);
    }//GEN-LAST:event_cmbEstampadoItemStateChanged

    private void cmbEstampadoColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoColorItemStateChanged
        imprimirCamisa(panelCamisa);
    }//GEN-LAST:event_cmbEstampadoColorItemStateChanged

    private void cmbModificarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbModificarItemStateChanged
        int index = cmbModificar.getSelectedIndex();
        switch (index) {
            case 0:
                tbdModificar.setEnabledAt(1, false);
                tbdModificar.setEnabledAt(2, false);
                tbdModificar.setEnabledAt(3, false);
                tbdModificar.setEnabledAt(4, false);
                break;
            case 1:
                tbdModificar.setEnabledAt(0, false);
                tbdModificar.setEnabledAt(2, false);
                tbdModificar.setEnabledAt(3, false);
                tbdModificar.setEnabledAt(4, false);
                break;
            case 2:
                tbdModificar.setEnabledAt(0, false);
                tbdModificar.setEnabledAt(1, false);
                tbdModificar.setEnabledAt(3, false);
                tbdModificar.setEnabledAt(4, false);
                break;
            case 3:
                tbdModificar.setEnabledAt(0, false);
                tbdModificar.setEnabledAt(1, false);
                tbdModificar.setEnabledAt(2, false);
                tbdModificar.setEnabledAt(4, false);
                break;
            case 4:
                tbdModificar.setEnabledAt(0, false);
                tbdModificar.setEnabledAt(1, false);
                tbdModificar.setEnabledAt(2, false);
                tbdModificar.setEnabledAt(3, false);
                break;
        }
        tbdModificar.setEnabledAt(index, true);
        tbdModificar.setSelectedIndex(index);
        lblBuscarModi.setText("Buscar " + cmbModificar.getSelectedItem() + " para modificar");
    }//GEN-LAST:event_cmbModificarItemStateChanged

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int index = cmbModificar.getSelectedIndex();
        switch (index) {
            case 0:
                if (!txtNAdminModi.getText().isEmpty() & !txtCAdminModi.getText().isEmpty()) {
                    met.modificarAdmin(this.adminModi.nombre, this.adminModi.clave, txtNAdminModi.getText(), txtCAdminModi.getText());
                    showMessageDialog(null, "Administrador modificado exitosamente");
                    this.adminModi = null;
                } else {
                    showMessageDialog(null, "Los espacios de administrador deben estar llenos");
                }
                break;
            case 1:
                if (!txtNEntrenadorModi.getText().isEmpty() & !txtAEntrenadorModi.getText().isEmpty()) {
                    met.modificarEntrenador(this.entreModi.nombre, this.entreModi.nombre, txtNEntrenadorModi.getText(), txtAEntrenadorModi.getText());
                    showMessageDialog(null, "Entrenador modificado exitosamente");
                    this.entreModi = null;
                } else {
                    showMessageDialog(null, "Los espacios de entrenador deben estar llenos");
                }
                break;
            case 2:
                if (!txtNJugadorModi.getText().isEmpty() & !txtAJugadorModi.getText().isEmpty()) {
                    int precio = parseInt(lblPrecioModi.getText());
                    int fisico = parseInt((String) cmbFisicoModi.getSelectedItem());
                    int defensa = parseInt((String) cmbDefensaModi.getSelectedItem());
                    int dribbling = parseInt((String) cmbDribblingModi.getSelectedItem());
                    int disparo = parseInt((String) cmbDisparoModi.getSelectedItem());
                    int[] habilidades = {fisico, defensa, dribbling, disparo};
                    met.modificarJugador(this.jugaModi.nombre, txtNJugadorModi.getText(), txtAJugadorModi.getText(), habilidades, precio, (String) cmbPosicionModi.getSelectedItem());
                    showMessageDialog(null, "Jugador modificado exitosamente");
                    this.jugaModi = null;
                } else {
                    showMessageDialog(null, "Los espacios de jugador deben estar llenos");
                }

                break;
            case 3:
                if (!txtNEstadioModi.getText().isEmpty() & !txtUEstadioModi.getText().isEmpty() & !txtCEstadioModi.getText().isEmpty()) {
                    if (esNumero(txtCEstadioModi.getText())) {
                        int capacidad = parseInt(txtCEstadioModi.getText());
                        met.modificarEstadio(this.estaModi.nombre, txtUEstadioModi.getText(), txtNEstadioModi.getText(), capacidad);
                        showMessageDialog(null, "Estadio modificado exitosamente");
                        this.estaModi = null;
                    } else {
                        showMessageDialog(null, "El espacio capacidad deben ser números");
                    }
                } else {
                    showMessageDialog(null, "Los espacios de estadio deben estar llenos");
                }
                break;
            case 4:
                if (!txtNEquipoModi.getText().isEmpty()) {
                    if (esNumero(txtDineroEquipo.getText())) {
                        String ubicacionCamisa = "/progratorneo/camisas/color" + data.colores[cmbColorCamisaModi.getSelectedIndex()];
                        String[] camisa = {ubicacionCamisa, ubicacionCamisa};
                        if (cmbEstampadoModi.getSelectedIndex() != 0) {
                            String ubicacionEstampado = "/progratorneo/camisas" + data.estampado[cmbEstampadoModi.getSelectedIndex() - 1] + data.colores[cmbEstampadoColorModi.getSelectedIndex()];
                            camisa[1] = ubicacionEstampado;
                        } else {
                            showMessageDialog(null, "Los espacios de Equipo deben estar llenos");
                        }
                        int dinero = parseInt(txtDineroEquipo.getText());
                        met.modificarEquipo(this.equiModi.nombre, dinero, camisa, txtNEquipoModi.getText());
                        showMessageDialog(null, "Equipo modificado exitosamente");
                        this.equiModi = null;
                    } else {
                        showMessageDialog(null, "En el espacio dinero deben ir solo números");
                    }
                }
                break;
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void sacarPrecioJugadorModi(JLabel label) {
        int fisico = parseInt((String) cmbFisicoModi.getSelectedItem());
        int defensa = parseInt((String) cmbDefensaModi.getSelectedItem());
        int dribbling = parseInt((String) cmbDribblingModi.getSelectedItem());
        int disparo = parseInt((String) cmbDisparoModi.getSelectedItem());
        int[] habilidades = {fisico, defensa, dribbling, disparo};
        int precio = data.precio(habilidades);
        label.setText(valueOf(precio));
    }
    
    private void cmbFisicoModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFisicoModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbFisicoModiItemStateChanged

    private void cmbDefensaModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDefensaModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbDefensaModiItemStateChanged

    private void cmbDribblingModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDribblingModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbDribblingModiItemStateChanged

    private void cmbDisparoModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDisparoModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbDisparoModiItemStateChanged

    private void cmbColorCamisaModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbColorCamisaModiItemStateChanged
        imprimirCamisa(panelCamisaModi);
    }//GEN-LAST:event_cmbColorCamisaModiItemStateChanged

    private void cmbEstampadoColorModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoColorModiItemStateChanged
        imprimirCamisa(panelCamisaModi);
    }//GEN-LAST:event_cmbEstampadoColorModiItemStateChanged

    private void cmbEstampadoModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoModiItemStateChanged
        imprimirCamisa(panelCamisaModi);
    }//GEN-LAST:event_cmbEstampadoModiItemStateChanged

    boolean mostrarMsj = true;
    Administrador adminModi = null;
    Entrenador entreModi = null;
    Jugador jugaModi = null;
    Estadio estaModi = null;
    Equipo equiModi = null;
    private void lblBuscarModiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarModiMouseClicked
        lblBuscarModi.setForeground(blue);
        switch (cmbModificar.getSelectedIndex()) {
            //Si es el administrador
            case 0:
                //pedir datos
                String nombreAdmin = showInputDialog(null, "Introduzca el nombre de usuario.");
                String clave = showInputDialog(null, "Introduzca el nombre la clave.");
                this.adminModi = met.buscarAdmin(nombreAdmin, clave);
                //Mostrar datos
                if (this.adminModi != null) {
                    txtNAdminModi.setText(this.adminModi.nombre);
                    txtCAdminModi.setText(this.adminModi.clave);
                } else {
                    showMessageDialog(null, "No se encontro administrador");
                }
                break;
            //Si es el entrenador
            case 1:
                //pedir datos
                String nombreEntre = showInputDialog(null, "Introduzca el nombre.");
                String apellidoEntre = showInputDialog(null, "Introduzca el apellido.");
                this.entreModi = met.buscarEntrenador(nombreEntre, apellidoEntre);
                //Mostrar datos
                if (this.entreModi != null) {
                    txtNEntrenadorModi.setText(this.entreModi.nombre);
                    txtAEntrenadorModi.setText(this.entreModi.apellido);
                } else {
                    showMessageDialog(null, "No se encontro entrenador");
                }
                break;
            //Si es un jugador
            case 2:
                //pedir datos
                String nombreJuga = showInputDialog(null, "Introduzca el nombre.");
                String ApellidoJuga = showInputDialog(null, "Introduzca el apellido.");
                this.jugaModi = met.buscarJugador(nombreJuga, ApellidoJuga);
                //Mostrar datos
                if (this.jugaModi != null) {
                    txtNJugadorModi.setText(this.jugaModi.nombre);
                    txtAJugadorModi.setText(this.jugaModi.apellido);
                    int i = 0;
                    switch (this.jugaModi.posicion) {
                        case "defensa":
                            i = 1;
                            break;
                        case "medio":
                            i = 2;
                            break;
                        case "delantero":
                            i = 3;
                            break;
                    }
                    cmbPosicionModi.setSelectedIndex(i);
                    cmbFisicoModi.setSelectedIndex(this.jugaModi.habilidades[0] - 1);
                    cmbDefensaModi.setSelectedIndex(this.jugaModi.habilidades[1] - 1);
                    cmbDribblingModi.setSelectedIndex(this.jugaModi.habilidades[2] - 1);
                    cmbDisparoModi.setSelectedIndex(this.jugaModi.habilidades[3] - 1);
                    lblPrecioModi.setText(valueOf(this.jugaModi.precio));
                } else {
                    showMessageDialog(null, "No se encontro jugador");
                }
                break;
            case 3:
                //pedir datos
                String nombreEstadio = showInputDialog(null, "Introduzca el nombre.");
                this.estaModi = met.buscarEstadio(nombreEstadio);
                //Mostrar datos
                if (this.estaModi != null) {
                    txtNEstadioModi.setText(this.estaModi.nombre);
                    txtUEstadioModi.setText(this.estaModi.ubicacion);
                    txtCEstadioModi.setText(valueOf(this.estaModi.capacidad));
                } else {
                    showMessageDialog(null, "No se encontro estadio");
                }
                break;
            case 4:
                //pedir datos
                String nombreEquipo = showInputDialog(null, "Introduzca el nombre.");
                this.equiModi = met.buscarEquipo(nombreEquipo);
                //Mostrar datos
                if (this.equiModi != null) {
                    txtNEquipoModi.setText(this.equiModi.nombre);
                    txtDineroEquipo.setText(valueOf(this.equiModi.dinero));
                    String ubicacionCamisa = "/progratorneo/camisas/color" + data.colores[cmbColorCamisa.getSelectedIndex()];
                    Image camisa = (new javax.swing.ImageIcon(getClass().getResource(ubicacionCamisa))).getImage();
                    Image estam = null;
                    if (cmbEstampado.getSelectedIndex() != 0) {
                        cmbEstampadoColor.setEnabled(true);
                        String ubicacionEstampado = "/progratorneo/camisas" + data.estampado[cmbEstampado.getSelectedIndex() - 1] + data.colores[cmbEstampadoColor.getSelectedIndex()];
                        estam = (new javax.swing.ImageIcon(getClass().getResource(ubicacionEstampado))).getImage();
                    } else {
                        cmbEstampadoColor.setEnabled(false);
                    }
                    dibujarCamisa(panelCamisaModi.getGraphics(), camisa, estam);
                } else {
                    showMessageDialog(null, "No se encontro equipo");
                }
                break;
        }
        if (mostrarMsj) {
            int value = showConfirmDialog(null, "Al encontrar lo que buscaba aparecerán los campos llenos.\n"
                    + "Solo debe cambiar los que desea modificar y presionar el botón modificar\n"
                    + "¿Quiere dejar de ver este mensaje?");
            if (value == 0) {
                mostrarMsj = false;
            }
        }
        lblBuscarModi.setForeground(black);
    }//GEN-LAST:event_lblBuscarModiMouseClicked

    private void lblBuscarModiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarModiMouseEntered
        lblBuscarModi.setForeground(red);
    }//GEN-LAST:event_lblBuscarModiMouseEntered

    private void lblBuscarModiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarModiMouseExited
        lblBuscarModi.setForeground(black);
    }//GEN-LAST:event_lblBuscarModiMouseExited
    //Elegir la comida|||Final

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
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(ventanaPrincipal.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGenerarJ;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbColorCamisa;
    private javax.swing.JComboBox<String> cmbColorCamisaModi;
    private javax.swing.JComboBox<String> cmbDefensa;
    private javax.swing.JComboBox<String> cmbDefensaModi;
    private javax.swing.JComboBox<String> cmbDisparo;
    private javax.swing.JComboBox<String> cmbDisparoModi;
    private javax.swing.JComboBox<String> cmbDribbling;
    private javax.swing.JComboBox<String> cmbDribblingModi;
    private javax.swing.JComboBox<String> cmbEstampado;
    private javax.swing.JComboBox<String> cmbEstampadoColor;
    private javax.swing.JComboBox<String> cmbEstampadoColorModi;
    private javax.swing.JComboBox<String> cmbEstampadoModi;
    private javax.swing.JComboBox<String> cmbFisico;
    private javax.swing.JComboBox<String> cmbFisicoModi;
    private javax.swing.JComboBox<String> cmbModificar;
    private javax.swing.JComboBox<String> cmbPosicion;
    private javax.swing.JComboBox<String> cmbPosicionModi;
    private javax.swing.JComboBox<String> cmbRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBuscarModi;
    private javax.swing.JLabel lblContraApellido;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioModi;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelAdminModi;
    private javax.swing.JPanel panelCamisa;
    private javax.swing.JPanel panelCamisaModi;
    private javax.swing.JPanel panelEntrenador;
    private javax.swing.JPanel panelEntrenadorModi;
    private javax.swing.JPanel panelEquipo;
    private javax.swing.JPanel panelEquipoModi;
    private javax.swing.JPanel panelEstadio;
    private javax.swing.JPanel panelEstadioModi;
    private javax.swing.JPanel panelJugdor;
    private javax.swing.JPanel panelJugdorModi;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPanel panelRegistrar;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JRadioButton rbtnEntrenador;
    private javax.swing.JRadioButton rbtnJugador;
    private javax.swing.JTabbedPane tbdModificar;
    private javax.swing.JTabbedPane tbdPrincipal;
    private javax.swing.JTabbedPane tbdRegistrar;
    private javax.swing.JTextField txtAEntrenador;
    private javax.swing.JTextField txtAEntrenadorModi;
    private javax.swing.JTextField txtAJugador;
    private javax.swing.JTextField txtAJugadorModi;
    private javax.swing.JTextField txtCAdmin;
    private javax.swing.JTextField txtCAdminModi;
    private javax.swing.JTextField txtCEstadio;
    private javax.swing.JTextField txtCEstadioModi;
    private javax.swing.JTextField txtCLogin;
    private javax.swing.JTextField txtDineroEquipo;
    private javax.swing.JTextField txtNAdmin;
    private javax.swing.JTextField txtNAdminModi;
    private javax.swing.JTextField txtNEntrenador;
    private javax.swing.JTextField txtNEntrenadorModi;
    private javax.swing.JTextField txtNEquipo;
    private javax.swing.JTextField txtNEquipoModi;
    private javax.swing.JTextField txtNEstadio;
    private javax.swing.JTextField txtNEstadioModi;
    private javax.swing.JTextField txtNJugador;
    private javax.swing.JTextField txtNJugadorModi;
    private javax.swing.JTextField txtNLogin;
    private javax.swing.JTextField txtUEstadio;
    private javax.swing.JTextField txtUEstadioModi;
    // End of variables declaration//GEN-END:variables
}
