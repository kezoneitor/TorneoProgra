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
import javax.swing.DefaultListModel;
import javax.swing.Icon;
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
import javax.swing.table.TableModel;

/**
 *
 * @author Kezo
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    char tipo = 'N';
    Administrador logeadoA;
    Entrenador logeadoE;
    Jugador logeadoJ;
    Metodos met = new Metodos();
    DataDefecto data = new DataDefecto();
    DefaultTableModel tabla = new DefaultTableModel();
    Jugador auxJContratarAnt;
    Jugador auxJContratar;
    ArrayList<JLabel> octavos;
    ArrayList<JLabel> cuartos;
    ArrayList<JLabel> semifinales;

    /**
     * Creates new form ventanaPrincipal
     */
    public ventanaPrincipal() {
        initComponents();

        //Componentes y sus iniciaciones por defecto|||Inicio
        tbdPrincipal.setEnabledAt(1, false);
        tbdPrincipal.setEnabledAt(2, false);
        tbdPrincipal.setEnabledAt(3, false);
        tbdPrincipal.setEnabledAt(4, false);
        tbdPrincipal.setEnabledAt(5, false);
        tbdPrincipal.setEnabledAt(6, false);
        tbdPrincipal.setEnabledAt(7, false);
        tbdRegistrar.setEnabledAt(0, true);
        tbdRegistrar.setEnabledAt(1, false);
        tbdRegistrar.setEnabledAt(2, false);
        tbdRegistrar.setEnabledAt(3, false);
        tbdRegistrar.setEnabledAt(4, false);
        tbdModificar.setEnabledAt(0, true);
        tbdModificar.setEnabledAt(1, false);
        tbdModificar.setEnabledAt(2, false);
        tbdModificar.setEnabledAt(3, false);
        tbdModificar.setEnabledAt(4, false);
        //Componentes y sus iniciaciones por defecto|||final
        met.InsertarAdmin("kezo", "123");
        met.InsertarAdmin("julio", "123");

        data.AgregarNombreApellido();
        data.CrearJugadores();
        data.crearEquipo();//Este metodo tambien crea a los entrenadores
        data.CrearEstadioPorDefecto();

        insertarJugadores();
        insertarEquipos();
        insertarEstadios();
        insertarEntrenadores();

        octavos = new ArrayList();
        cuartos = new ArrayList();
        semifinales = new ArrayList();
        listasTorneos();

        asignarEntrenadorYEquipo();
        asignarEqJu();

        llenarTablaEquipos();
        llenarTablaEstadios();
        llenarListEntrenadores();
        llenarComboEquipo();

        //Buscar Jugadores para contratar||inicio
        this.auxJContratarAnt = met.inicioJ;
        this.auxJContratar = met.inicioJ;

        //Mostrar jugador en labels para hacer tratos como entrenador
        lblNombreContratar.setText(auxJContratar.nombre);
        lblApellidoContratar.setText(auxJContratar.apellido);
        lblEstadoContratar.setText(auxJContratar.estado);
        lblEquipoContratar.setText(auxJContratar.equipo.nombre);
        lblPrecioContratar.setText(String.valueOf(auxJContratar.precio));

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

    private void listasTorneos() {
        octavos.add(this.lblPartido0);
        octavos.add(this.lblPartido1);
        octavos.add(this.lblPartido2);
        octavos.add(this.lblPartido3);
        octavos.add(this.lblPartido4);
        octavos.add(this.lblPartido5);
        octavos.add(this.lblPartido6);
        octavos.add(this.lblPartido7);

        cuartos.add(this.lblPartido8);
        cuartos.add(this.lblPartido9);
        cuartos.add(this.lblPartidoA);
        cuartos.add(this.lblPartidoB);

        semifinales.add(this.lblPartidoC);
        semifinales.add(this.lblPartidoD);
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
    }

    private void insertarEquipos() {
        for (int i = 0; i < data.listaEquiposG.size(); i++) {
            met.InsertarEquipo(data.listaEquiposG.get(i).nombre, data.listaEquiposG.get(i).camisa);
        }
    }

    private void insertarEstadios() {
        for (int i = 0; i < data.listaEstadioG.size(); i++) {
            String nombre = data.listaEstadioG.get(i).nombre;
            String ubicacion = data.listaEstadioG.get(i).ubicacion;
            int capacidad = data.listaEstadioG.get(i).capacidad;
            met.InsertarEstadio(nombre, ubicacion, capacidad);
        }
    }

    private void insertarEntrenadores() {
        for (int i = 0; i < data.listaEntrenadorG.size(); i++) {
            String nombre = data.listaEntrenadorG.get(i).nombre;
            String apellido = data.listaEntrenadorG.get(i).apellido;
            met.InsertarEntrenador(nombre, apellido);
        }
    }

    private void asignarEntrenadorYEquipo() {
        Equipo auxEq = met.inicioEq;
        Entrenador auxEn = met.inicioEn;
        while (auxEq != null) {
            auxEq.entrenador = auxEn;
            auxEn.equipo = auxEq;
            if (auxEq == met.finalEq) {
                break;
            }
            auxEq = auxEq.sig;
            auxEn = auxEn.sig;
        }
    }

    private void asignarEqJu() {
        Equipo auxEq = met.inicioEq;
        Jugador auxJ;
        while (auxEq != null) {
            int por = 1;
            int def = 4;
            int med = 4;
            int del = 2;
            auxJ = met.inicioJ;
            while (auxJ != null & (por != 0 | def != 0 | med != 0 | del != 0)) {
                if (por != 0 & auxJ.posicion.equals("portero") & auxJ.equipo == null) {
                    auxJ.equipo = auxEq;
                    auxJ.estado = "contratado";
                    auxEq.jugadores.add(auxJ);
                    por--;
                } else if (def != 0 & auxJ.posicion.equals("defensa") & auxJ.equipo == null) {
                    auxJ.equipo = auxEq;
                    auxJ.estado = "contratado";
                    auxEq.jugadores.add(auxJ);
                    def--;
                } else if (med != 0 & auxJ.posicion.equals("medio") & auxJ.equipo == null) {
                    auxJ.equipo = auxEq;
                    auxJ.estado = "contratado";
                    auxEq.jugadores.add(auxJ);
                    med--;
                } else if (del != 0 & auxJ.posicion.equals("delantero") & auxJ.equipo == null) {
                    auxJ.equipo = auxEq;
                    auxJ.estado = "contratado";
                    auxEq.jugadores.add(auxJ);
                    del--;
                } else if (por == 0 & def == 0 & med == 0 & del == 0) {
                    break;
                }
                auxJ = auxJ.sig;
            }
            auxEq.dinero = 0;
            if (auxEq == met.finalEq) {
                break;
            }
            auxEq = auxEq.sig;
        }
    }

    private void asignarJugadoresAEquipos() {
        Equipo auxEq = met.inicioEq;
        Jugador auxJ;
        while (auxEq != null) {
            auxJ = met.inicioJ;
            while (auxJ != null) {
                if (auxJ.posicion.equals("portero")) {
                    auxJ.equipo = auxEq;
                    auxEq.jugadores.add(auxJ);
                    break;
                }
                auxJ = auxJ.sig;
            }
            for (int i = 0; i < 4;) {
                auxJ = met.inicioJ;
                while (auxJ != null) {
                    if (auxJ.posicion.equals("defensa")) {
                        auxJ.equipo = auxEq;
                        auxEq.jugadores.add(auxJ);
                        break;
                    }
                    auxJ = auxJ.sig;
                }
            }
            if (auxEq == met.finalEq) {
                break;
            }
            auxEq = auxEq.sig;
        }
    }

    private void llenarTablaEquipos() {
        TableModel tabla = tablaEquipos.getModel();
        Equipo auxEq = met.inicioEq;
        int i = 0;
        while (auxEq != null) {
            tabla.setValueAt(auxEq.nombre, i, 0);
            tabla.setValueAt(auxEq.jugadores.size(), i, 1);
            //Para saber si esta en un torneo
            if (auxEq.posicionTorneo != 0) {
                tabla.setValueAt(true, i, 2);
            } else {
                tabla.setValueAt(false, i, 2);
            }
            if (auxEq == met.finalEq) {
                break;
            }
            auxEq = auxEq.sig;
            i++;
        }
    }

    private void llenarTablaEstadios() {
        TableModel tabla = tablaEstadios.getModel();
        Estadio auxEs = met.inicioEs;
        int i = 0;
        while (auxEs != null) {
            tabla.setValueAt(auxEs.nombre, i, 0);
            tabla.setValueAt(auxEs.ubicacion, i, 1);
            tabla.setValueAt(auxEs.capacidad, i, 2);
            auxEs = auxEs.sig;
            i++;
        }
    }

    private void llenarListEntrenadores() {
        Entrenador auxEn = met.inicioEn;
        DefaultListModel list = new DefaultListModel();
        listEntrenadorAsig.removeAll();
        while (auxEn != null) {
            list.addElement(auxEn.nombre + " " + auxEn.apellido);
            auxEn = auxEn.sig;
            if (auxEn == met.finalEn) {
                break;
            }
        }
        listEntrenadorAsig.setModel(list);
    }

    private void llenarComboEquipo() {
        Equipo auxEq = met.inicioEq;
        cmbEquipoAsig.removeAllItems();
        while (auxEq != null) {
            cmbEquipoAsig.addItem(auxEq.nombre);
            if (auxEq == met.finalEq) {
                break;
            }
            auxEq = auxEq.sig;
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
        panelEliminar = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        cmbEliminar = new javax.swing.JComboBox<>();
        lblNombreEliminar = new javax.swing.JLabel();
        lblClaveEliminar = new javax.swing.JLabel();
        txtClaveEliminar = new javax.swing.JTextField();
        txtNombreEliminar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        panelTorneo = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtNombreTorneo = new javax.swing.JTextField();
        lblPremios = new javax.swing.JLabel();
        lblCuarPre = new javax.swing.JLabel();
        txtPremioCu = new javax.swing.JTextField();
        txtPremioSe = new javax.swing.JTextField();
        lblSePre = new javax.swing.JLabel();
        lblFiPre = new javax.swing.JLabel();
        txtPremioFi = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblGenerarPartidos = new javax.swing.JLabel();
        rBtnAleatorio = new javax.swing.JRadioButton();
        rBtnManual = new javax.swing.JRadioButton();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEstadios = new javax.swing.JTable();
        btnCrearTorneo = new javax.swing.JButton();
        cmbOpcionesTorneo = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        spnEntrada = new javax.swing.JSpinner();
        panelAsignarEntrenador = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        btnAsignarEntrenador = new javax.swing.JButton();
        cmbEquipoAsig = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listEntrenadorAsig = new javax.swing.JList<>();
        txtNombreAsig = new javax.swing.JTextField();
        txtApellidoAsig = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTablaContratarSig = new javax.swing.JButton();
        btnTrato = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        lblApellidoContratar = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        lblEquipoContratar = new javax.swing.JLabel();
        lblPrecioContratar = new javax.swing.JLabel();
        lblNombreContratar5 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        lblEstadoContratar = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        lblNombreContratar = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        btnTablaContratarAnt = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        cmbTratoEntrenador = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        rbtnManuTorneo = new javax.swing.JRadioButton();
        rbtnAutoTorneo = new javax.swing.JRadioButton();
        lblBuscarTorneo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPartido0 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        lblPartido1 = new javax.swing.JLabel();
        lblPartido3 = new javax.swing.JLabel();
        lblPartido2 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        lblPartido5 = new javax.swing.JLabel();
        lblPartido4 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        lblPartido7 = new javax.swing.JLabel();
        lblPartido6 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        lblPartidoB = new javax.swing.JLabel();
        lblPartidoA = new javax.swing.JLabel();
        lblPartido9 = new javax.swing.JLabel();
        lblPartido8 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        lblPartidoC = new javax.swing.JLabel();
        lblPartidoD = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        lblPartidoE = new javax.swing.JLabel();
        btnAutoTorneo = new javax.swing.JButton();
        lblNombreTorneo = new javax.swing.JLabel();
        panelConsultas = new javax.swing.JPanel();
        lblReporte1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaReportes = new javax.swing.JList<>();
        lblReporte2 = new javax.swing.JLabel();
        lblReporte3 = new javax.swing.JLabel();
        lblReporte4 = new javax.swing.JLabel();
        lblReporte5 = new javax.swing.JLabel();
        lblReporte6 = new javax.swing.JLabel();
        lblReporte7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblUsuarioActual = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();

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
                .addContainerGap(1072, Short.MAX_VALUE))
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
                .addContainerGap(330, Short.MAX_VALUE))
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
                .addContainerGap(1092, Short.MAX_VALUE))
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
                .addContainerGap(290, Short.MAX_VALUE))
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
                .addGap(0, 119, Short.MAX_VALUE))
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
                .addContainerGap(1092, Short.MAX_VALUE))
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
                .addContainerGap(315, Short.MAX_VALUE))
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
                        .addGap(489, 1150, Short.MAX_VALUE))))
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
                .addContainerGap(211, Short.MAX_VALUE))
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
                .addGap(0, 119, Short.MAX_VALUE))
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

        panelEliminar.setEnabled(false);

        jLabel31.setText("Tipo a Eliminar:");

        cmbEliminar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Entrenador", "Jugador", "Estadio", "Equipo" }));
        cmbEliminar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEliminarItemStateChanged(evt);
            }
        });

        lblNombreEliminar.setText("Nombre Usuario: ");

        lblClaveEliminar.setText("Clave:");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEliminarLayout = new javax.swing.GroupLayout(panelEliminar);
        panelEliminar.setLayout(panelEliminarLayout);
        panelEliminarLayout.setHorizontalGroup(
            panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEliminarLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEliminarLayout.createSequentialGroup()
                        .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreEliminar)
                            .addComponent(lblClaveEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClaveEliminar)
                            .addGroup(panelEliminarLayout.createSequentialGroup()
                                .addComponent(txtNombreEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelEliminarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnEliminar)))
                .addContainerGap(1111, Short.MAX_VALUE))
        );
        panelEliminarLayout.setVerticalGroup(
            panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cmbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEliminar)
                    .addComponent(txtNombreEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClaveEliminar)
                    .addComponent(txtClaveEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        tbdPrincipal.addTab("Eliminar", panelEliminar);

        jLabel42.setText("Nombre: ");

        lblPremios.setText("Premios");

        lblCuarPre.setText("Cuartos:");

        lblSePre.setText("Semifinales:");

        lblFiPre.setText("Finales:");

        lblGenerarPartidos.setText("Generar partidos");

        rBtnAleatorio.setText("aleatoriamente");
        rBtnAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnAleatorioActionPerformed(evt);
            }
        });

        rBtnManual.setText("manualmente");
        rBtnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnManualActionPerformed(evt);
            }
        });

        jLabel58.setText("Escoger equipos");

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "cantidad Jugadores", "En torneo", "Agregar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEquipos.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tablaEquipos);
        tablaEquipos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaEquipos.getColumnModel().getColumnCount() > 0) {
            tablaEquipos.getColumnModel().getColumn(1).setHeaderValue("cantidad Jugadores");
            tablaEquipos.getColumnModel().getColumn(2).setResizable(false);
            tablaEquipos.getColumnModel().getColumn(2).setHeaderValue("En torneo");
        }

        jLabel59.setText("Un equipo en torneo no puede entrar");

        jLabel60.setText(" a otro torneo.");

        jLabel61.setText("Estadios");

        tablaEstadios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Ubicacion", "Capacidad", "Agregar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaEstadios);
        tablaEstadios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnCrearTorneo.setText("Crear");
        btnCrearTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTorneoActionPerformed(evt);
            }
        });

        cmbOpcionesTorneo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crear", "Modificar", "Eliminar" }));
        cmbOpcionesTorneo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOpcionesTorneoItemStateChanged(evt);
            }
        });

        jLabel70.setText("Precio Entrada:   $");

        javax.swing.GroupLayout panelTorneoLayout = new javax.swing.GroupLayout(panelTorneo);
        panelTorneo.setLayout(panelTorneoLayout);
        panelTorneoLayout.setHorizontalGroup(
            panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTorneoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGenerarPartidos)
                    .addComponent(rBtnManual)
                    .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelTorneoLayout.createSequentialGroup()
                            .addComponent(lblPremios)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTorneoLayout.createSequentialGroup()
                            .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel42)
                                .addComponent(jLabel70))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelTorneoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSePre)
                            .addComponent(lblCuarPre)
                            .addComponent(lblFiPre))
                        .addGap(18, 18, 18)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPremioCu)
                            .addComponent(txtPremioFi)
                            .addComponent(txtPremioSe, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cmbOpcionesTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCrearTorneo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rBtnAleatorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTorneoLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(57, 57, 57)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(jLabel59))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTorneoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );
        panelTorneoLayout.setVerticalGroup(
            panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTorneoLayout.createSequentialGroup()
                .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTorneoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbOpcionesTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txtNombreTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(spnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPremios)
                            .addGroup(panelTorneoLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCuarPre)
                            .addComponent(txtPremioCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSePre)
                            .addComponent(txtPremioSe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPremioFi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFiPre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGenerarPartidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnAleatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnManual)
                        .addGap(18, 18, 18)
                        .addComponent(btnCrearTorneo))
                    .addGroup(panelTorneoLayout.createSequentialGroup()
                        .addGroup(panelTorneoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTorneoLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTorneoLayout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTorneoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        tbdPrincipal.addTab("Torneo", panelTorneo);

        jLabel53.setText("Entrenador:");

        jLabel54.setText("Equipo:");

        btnAsignarEntrenador.setText("Asignar");
        btnAsignarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEntrenadorActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(listEntrenadorAsig);

        txtApellidoAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoAsigActionPerformed(evt);
            }
        });

        jLabel55.setText("Apellido:");

        jLabel56.setText("Nombre:");

        javax.swing.GroupLayout panelAsignarEntrenadorLayout = new javax.swing.GroupLayout(panelAsignarEntrenador);
        panelAsignarEntrenador.setLayout(panelAsignarEntrenadorLayout);
        panelAsignarEntrenadorLayout.setHorizontalGroup(
            panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsignarEntrenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addGroup(panelAsignarEntrenadorLayout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(27, 27, 27)
                        .addComponent(txtNombreAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAsignarEntrenadorLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(32, 32, 32)
                                .addComponent(cmbEquipoAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelAsignarEntrenadorLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnAsignarEntrenador)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsignarEntrenadorLayout.createSequentialGroup()
                            .addComponent(jLabel55)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidoAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(868, Short.MAX_VALUE))
        );
        panelAsignarEntrenadorLayout.setVerticalGroup(
            panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsignarEntrenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelAsignarEntrenadorLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(14, 14, 14)
                        .addGroup(panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addGap(37, 37, 37)
                        .addGroup(panelAsignarEntrenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(cmbEquipoAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAsignarEntrenador)
                        .addContainerGap(257, Short.MAX_VALUE))))
        );

        tbdPrincipal.addTab("Asignar Entrenador", panelAsignarEntrenador);

        btnTablaContratarSig.setText(">>");
        btnTablaContratarSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaContratarSigActionPerformed(evt);
            }
        });

        btnTrato.setText("Contratar");
        btnTrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTratoActionPerformed(evt);
            }
        });

        jLabel65.setText("Apellido");

        lblApellidoContratar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellidoContratar.setText("jLabel69");

        jLabel67.setText("Equipo");

        lblEquipoContratar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEquipoContratar.setText("jLabel69");

        lblPrecioContratar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPrecioContratar.setText("jLabel69");

        lblNombreContratar5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombreContratar5.setText("$");

        jLabel68.setText("Precio");

        lblEstadoContratar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEstadoContratar.setText("jLabel69");

        jLabel66.setText("Estado");

        lblNombreContratar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombreContratar.setText("jLabel69");

        jLabel64.setText("Nombre");

        jLabel63.setText("Jugadores Disponibles");

        jLabel62.setText("0");

        jLabel57.setText("Dinero: $");

        btnTablaContratarAnt.setText("<<");
        btnTablaContratarAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaContratarAntActionPerformed(evt);
            }
        });

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        jLabel69.setText("Tipo de trato:");

        cmbTratoEntrenador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contratar", "Despedir", "Vender" }));
        cmbTratoEntrenador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTratoEntrenadorItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTratoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTrato))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTablaContratarAnt)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel66)
                                            .addComponent(lblNombreContratar)
                                            .addComponent(jLabel64)
                                            .addComponent(lblEstadoContratar))
                                        .addGap(147, 147, 147)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApellidoContratar)
                                            .addComponent(jLabel65)
                                            .addComponent(jLabel67)
                                            .addComponent(lblEquipoContratar)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel68)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNombreContratar5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPrecioContratar)))))
                        .addGap(156, 156, 156)
                        .addComponent(btnTablaContratarSig)))
                .addContainerGap(794, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel62)
                    .addComponent(jLabel69)
                    .addComponent(cmbTratoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel63)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel64)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblNombreContratar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel66)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblEstadoContratar)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel68)
                                        .addComponent(lblPrecioContratar)
                                        .addComponent(lblNombreContratar5)))
                                .addComponent(btnTablaContratarAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel65)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblApellidoContratar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel67)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblEquipoContratar)
                            .addGap(35, 35, 35)))
                    .addComponent(btnTablaContratarSig, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicio)
                    .addComponent(btnTrato))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        tbdPrincipal.addTab("Entrenador", jPanel1);

        rbtnManuTorneo.setText("Manual");
        rbtnManuTorneo.setToolTipText("Esta en desarrollo");
        rbtnManuTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnManuTorneoActionPerformed(evt);
            }
        });

        rbtnAutoTorneo.setText("Automático");
        rbtnAutoTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAutoTorneoActionPerformed(evt);
            }
        });

        lblBuscarTorneo.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblBuscarTorneo.setText("Buscar Torneo");
        lblBuscarTorneo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarTorneoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuscarTorneoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBuscarTorneoMouseExited(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblPartido0.setText("___ vs ___");
        lblPartido0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido0MouseClicked(evt);
            }
        });

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/llaves cuartos.png"))); // NOI18N
        jLabel71.setText("jLabel71");

        lblPartido1.setText("___ vs ___");
        lblPartido1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido1MouseClicked(evt);
            }
        });

        lblPartido3.setText("___ vs ___");
        lblPartido3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido3MouseClicked(evt);
            }
        });

        lblPartido2.setText("___ vs ___");
        lblPartido2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido2MouseClicked(evt);
            }
        });

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/llaves cuartos.png"))); // NOI18N
        jLabel75.setText("jLabel71");

        lblPartido5.setText("___ vs ___");
        lblPartido5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido5MouseClicked(evt);
            }
        });

        lblPartido4.setText("___ vs ___");
        lblPartido4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido4MouseClicked(evt);
            }
        });

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/llaves cuartos.png"))); // NOI18N
        jLabel78.setText("jLabel71");

        lblPartido7.setText("___ vs ___");
        lblPartido7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido7MouseClicked(evt);
            }
        });

        lblPartido6.setText("___ vs ___");
        lblPartido6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido6MouseClicked(evt);
            }
        });

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/llaves cuartos.png"))); // NOI18N
        jLabel81.setText("jLabel71");

        lblPartidoB.setText("___ vs ___");
        lblPartidoB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartidoBMouseClicked(evt);
            }
        });

        lblPartidoA.setText("___ vs ___");
        lblPartidoA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartidoAMouseClicked(evt);
            }
        });

        lblPartido9.setText("___ vs ___");
        lblPartido9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido9MouseClicked(evt);
            }
        });

        lblPartido8.setText("___ vs ___");
        lblPartido8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartido8MouseClicked(evt);
            }
        });

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/llaves Semifinal.png"))); // NOI18N
        jLabel86.setText("jLabel86");

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/llaves Semifinal.png"))); // NOI18N
        jLabel87.setText("jLabel86");

        lblPartidoC.setText("___ vs ___");
        lblPartidoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartidoCMouseClicked(evt);
            }
        });

        lblPartidoD.setText("___ vs ___");
        lblPartidoD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartidoDMouseClicked(evt);
            }
        });

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/llave Finales.png"))); // NOI18N
        jLabel90.setText("jLabel90");

        lblPartidoE.setText("___ vs ___");
        lblPartidoE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPartidoEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(481, 481, 481)
                .addComponent(lblPartidoE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPartido0)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPartido1))
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPartido2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPartido3))
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPartido8)
                                .addGap(213, 213, 213)
                                .addComponent(lblPartido9))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPartidoC)
                                .addGap(275, 275, 275)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblPartido4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPartido5))
                                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(75, 75, 75)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblPartido6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPartido7))
                                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblPartidoA)
                                                .addGap(200, 200, 200)
                                                .addComponent(lblPartidoB))
                                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(187, 187, 187)
                                        .addComponent(lblPartidoD)))))))
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPartido0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPartido3)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPartido2)
                                            .addComponent(lblPartido1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPartido8)
                            .addComponent(lblPartido9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPartidoC))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPartido4)
                                    .addComponent(lblPartido5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPartido6)
                                    .addComponent(lblPartido7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPartidoA)
                            .addComponent(lblPartidoB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPartidoD)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPartidoE)
                .addGap(140, 140, 140))
        );

        btnAutoTorneo.setText("Campeón");
        btnAutoTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoTorneoActionPerformed(evt);
            }
        });

        lblNombreTorneo.setText("Nombre del torneo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreTorneo)
                .addGap(136, 136, 136)
                .addComponent(lblBuscarTorneo)
                .addGap(107, 107, 107)
                .addComponent(rbtnManuTorneo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnAutoTorneo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAutoTorneo)
                .addGap(337, 337, 337))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnManuTorneo)
                    .addComponent(rbtnAutoTorneo)
                    .addComponent(lblBuscarTorneo)
                    .addComponent(btnAutoTorneo)
                    .addComponent(lblNombreTorneo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbdPrincipal.addTab("Tabla de torneo", jPanel2);

        panelConsultas.setEnabled(false);

        lblReporte1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReporte1.setText("Mostrar Equipo de un Jugador");
        lblReporte1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReporte1MouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(listaReportes);

        lblReporte2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReporte2.setText("Mostrar Jugadores de un Equipo");
        lblReporte2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReporte2MouseClicked(evt);
            }
        });

        lblReporte3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReporte3.setText("Mostrar Entrenador de un Equipo");
        lblReporte3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReporte3MouseClicked(evt);
            }
        });

        lblReporte4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReporte4.setText("Mostrar Equipo ganador de un torneo");
        lblReporte4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReporte4MouseClicked(evt);
            }
        });

        lblReporte5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReporte5.setText("Mostrar Jugadores de un Precio");
        lblReporte5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReporte5MouseClicked(evt);
            }
        });

        lblReporte6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReporte6.setText("Mostrar Equipos de un Torneo");
        lblReporte6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReporte6MouseClicked(evt);
            }
        });

        lblReporte7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReporte7.setText("Mostrar Goleador");
        lblReporte7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReporte7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelConsultasLayout = new javax.swing.GroupLayout(panelConsultas);
        panelConsultas.setLayout(panelConsultasLayout);
        panelConsultasLayout.setHorizontalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReporte1)
                    .addComponent(lblReporte2)
                    .addComponent(lblReporte3)
                    .addComponent(lblReporte4)
                    .addComponent(lblReporte5)
                    .addComponent(lblReporte6)
                    .addComponent(lblReporte7))
                .addGap(102, 102, 102)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        panelConsultasLayout.setVerticalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultasLayout.createSequentialGroup()
                        .addComponent(lblReporte1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReporte2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReporte3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReporte4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReporte5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReporte6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReporte7)
                        .addContainerGap(277, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        tbdPrincipal.addTab("Reportes", panelConsultas);

        jLabel3.setText("Usuario actual: ");

        lblUsuarioActual.setText("No hay");

        jLabel5.setText("Estado:");

        lblEstado.setText("Desconectado");

        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/refresh1.png"))); // NOI18N
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRefreshMouseExited(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tbdPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblUsuarioActual)
                        .addComponent(jLabel5)
                        .addComponent(lblEstado))
                    .addComponent(lblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbdPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//RadioButtons para que solo este seleccionado 1 de ellos|||Final

    private void sacarPrecioJugador(JLabel label) {
        int fisico = parseInt((String) cmbFisico.getSelectedItem());
        int defensa = parseInt((String) cmbDefensa.getSelectedItem());
        int dribbling = parseInt((String) cmbDribbling.getSelectedItem());
        int disparo = parseInt((String) cmbDisparo.getSelectedItem());
        int[] habilidades = {fisico, defensa, dribbling, disparo};
        int precio = data.precio(habilidades);
        label.setText(valueOf(precio));
    }
    //Sacar Precio y mostrarlo en un label||| final

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

    private void sacarPrecioJugadorModi(JLabel label) {
        int fisico = parseInt((String) cmbFisicoModi.getSelectedItem());
        int defensa = parseInt((String) cmbDefensaModi.getSelectedItem());
        int dribbling = parseInt((String) cmbDribblingModi.getSelectedItem());
        int disparo = parseInt((String) cmbDisparoModi.getSelectedItem());
        int[] habilidades = {fisico, defensa, dribbling, disparo};
        int precio = data.precio(habilidades);
        label.setText(valueOf(precio));
    }

    boolean mostrarMsj = true;
    Administrador adminModi = null;
    Entrenador entreModi = null;
    Jugador jugaModi = null;
    Estadio estaModi = null;
    Equipo equiModi = null;

    private ArrayList<String> equiposTabla() {
        ArrayList<String> equipos = new ArrayList();
        for (int i = 0; i < met.lenEquipo(); i++) {
            boolean value = (boolean) tablaEquipos.getValueAt(i, 3);
            if (value) {
                equipos.add((String) tablaEquipos.getValueAt(i, 0));
            }
        }
        return equipos;
    }

    private ArrayList<String> estadiosTabla() {
        ArrayList<String> equipos = new ArrayList();
        for (int i = 0; i < met.lenEstadio(); i++) {
            boolean value = (boolean) tablaEstadios.getValueAt(i, 1);
            if (value) {
                equipos.add((String) tablaEquipos.getValueAt(i, 0));
            }
        }
        return equipos;
    }

    private Estadio sacarEstadioRandom() {
        int add = (int) (Math.random() * met.lenEstadio());
        Estadio auxEs = met.inicioEs;
        int i = 0;
        while (auxEs != null) {
            if (add == i) {
                return auxEs;
            }
            i++;
            auxEs = auxEs.sig;
        }
        return auxEs;
    }

    private void lblRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseEntered
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/refresh2.png")));
    }//GEN-LAST:event_lblRefreshMouseEntered

    private void lblRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseExited
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/refresh1.png")));
    }//GEN-LAST:event_lblRefreshMouseExited

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        llenarTablaEquipos();
        llenarTablaEstadios();
        llenarComboEquipo();
        llenarListEntrenadores();
        verJugadorContratar();
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progratorneo/images/refresh1.png")));
    }//GEN-LAST:event_lblRefreshMouseClicked

    private void txtApellidoAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoAsigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoAsigActionPerformed

    private void btnAsignarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEntrenadorActionPerformed
        Entrenador entrenador = met.buscarEntrenador(txtNombreAsig.getText(), txtApellidoAsig.getText());
        Equipo equipo = met.buscarEquipo((String) cmbEquipoAsig.getSelectedItem());
        String msj = met.asignarEntrenador(entrenador, equipo);
        JOptionPane.showMessageDialog(null, msj);
    }//GEN-LAST:event_btnAsignarEntrenadorActionPerformed

    private void cmbTratoEntrenadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTratoEntrenadorItemStateChanged
        btnTrato.setText((String) cmbTratoEntrenador.getSelectedItem());
    }//GEN-LAST:event_cmbTratoEntrenadorItemStateChanged

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        auxJContratar = met.inicioJ;

        verJugadorContratar();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnTablaContratarAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaContratarAntActionPerformed

        if (auxJContratar.sig == null) {
            auxJContratar = met.inicioJ;
        } else {
            auxJContratar = auxJContratarAnt;
        }
        verJugadorContratar();
    }//GEN-LAST:event_btnTablaContratarAntActionPerformed

    private void btnTratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTratoActionPerformed
        int trato = cmbTratoEntrenador.getSelectedIndex();
        Jugador jugador = met.buscarJugador(lblNombreContratar.getText(), lblApellidoContratar.getText());
        switch (trato) {
            case 0://Contratar
                if (!lblEstadoContratar.getText().equals("contratado") & !lblEquipoContratar.getText().equals(logeadoE.equipo.nombre)) {
                    int[] cantidad = contarTipoJugadores(logeadoE.equipo);
                    if (lblEstadoContratar.getText().equals("vender") & logeadoE.equipo.dinero >= jugador.precio & logeadoE.equipo.jugadores.size() < 11 & logeadoE.equipo.posicionTorneo == 0) {
                        if (cantidad[0] < 1 & jugador.posicion.equals("portero")) {
                            jugador.estado = "contratado";
                            jugador.equipo.dinero += jugador.precio;
                            jugador.equipo.jugadores.remove(jugador);
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");

                        } else if (cantidad[1] < 4 & jugador.posicion.equals("defensa")) {
                            jugador.estado = "contratado";
                            jugador.equipo.dinero += jugador.precio;
                            jugador.equipo.jugadores.remove(jugador);
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");

                        } else if (cantidad[2] < 4 & jugador.posicion.equals("medio")) {
                            jugador.estado = "contratado";
                            jugador.equipo.dinero += jugador.precio;
                            jugador.equipo.jugadores.remove(jugador);
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");

                        } else if (cantidad[3] < 2 & jugador.posicion.equals("delantero")) {
                            jugador.estado = "contratado";
                            jugador.equipo.dinero += jugador.precio;
                            jugador.equipo.jugadores.remove(jugador);
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");

                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede comprar este jugador");
                        }
                    } else if (lblEstadoContratar.getText().equals("libre") & logeadoE.equipo.dinero >= jugador.precio & logeadoE.equipo.jugadores.size() < 11 & logeadoE.equipo.posicionTorneo == 0) {
                        if (cantidad[0] < 1 & jugador.posicion.equals("portero")) {
                            jugador.estado = "contratado";
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");
                        } else if (cantidad[1] < 4 & jugador.posicion.equals("defensa")) {
                            jugador.estado = "contratado";
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");
                        } else if (cantidad[2] < 4 & jugador.posicion.equals("medio")) {
                            jugador.estado = "contratado";
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");
                        } else if (cantidad[3] < 2 & jugador.posicion.equals("delantero")) {
                            jugador.estado = "contratado";
                            jugador.equipo = logeadoE.equipo;
                            logeadoE.equipo.dinero -= jugador.precio;
                            JOptionPane.showMessageDialog(null, "Jugador comprado exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede comprar este jugador");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se a podido contratar este jugador");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede contratar este jugador.Puede que ya este contratado.");
                }
                break;
            case 1://Despedir
                if (logeadoE.equipo == jugador.equipo) {
                    jugador.equipo = null;
                    jugador.estado = "libre";
                    logeadoE.equipo.jugadores.remove(jugador.nombre);

                } else {
                    JOptionPane.showMessageDialog(null, "El jugador no concuerda con el equipo");
                }
                break;
            case 2://Vender
                if (logeadoE.equipo == jugador.equipo) {
                    jugador.estado = "vender";
                    JOptionPane.showMessageDialog(null, "El jugador fue puesto en venta");
                } else {
                    JOptionPane.showMessageDialog(null, "El jugador no concuerda con el equipo");
                }
                break;
        }
    }//GEN-LAST:event_btnTratoActionPerformed

    private void btnTablaContratarSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaContratarSigActionPerformed
        if (auxJContratar.sig == null) {
            auxJContratar = met.inicioJ;
        } else {
            auxJContratarAnt = auxJContratar;
            auxJContratar = auxJContratar.sig;
        }
        verJugadorContratar();
    }//GEN-LAST:event_btnTablaContratarSigActionPerformed

    private void cmbOpcionesTorneoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOpcionesTorneoItemStateChanged
        int index = cmbOpcionesTorneo.getSelectedIndex();
        switch (index) {
            case 0:
                txtPremioCu.setEnabled(true);
                txtPremioSe.setEnabled(true);
                txtPremioFi.setEnabled(true);
                rBtnAleatorio.setEnabled(true);
                rBtnManual.setEnabled(true);
                tablaEquipos.setEnabled(true);
                tablaEstadios.setEnabled(true);
                spnEntrada.setEnabled(true);
                break;
            case 1:
                txtPremioCu.setEnabled(true);
                txtPremioSe.setEnabled(true);
                txtPremioFi.setEnabled(true);
                spnEntrada.setEnabled(true);
                rBtnAleatorio.setEnabled(false);
                rBtnManual.setEnabled(false);
                tablaEquipos.setEnabled(false);
                tablaEstadios.setEnabled(false);
                break;
            case 2:
                txtPremioCu.setEnabled(false);
                txtPremioSe.setEnabled(false);
                txtPremioFi.setEnabled(false);
                rBtnAleatorio.setEnabled(false);
                rBtnManual.setEnabled(false);
                tablaEquipos.setEnabled(false);
                tablaEstadios.setEnabled(false);
                spnEntrada.setEnabled(false);
                break;
        }
        btnCrearTorneo.setText((String) cmbOpcionesTorneo.getSelectedItem());
    }//GEN-LAST:event_cmbOpcionesTorneoItemStateChanged

    private void btnCrearTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTorneoActionPerformed
        int index = cmbOpcionesTorneo.getSelectedIndex();
        String msj;
        switch (index) {
            case 0:
                if (!txtNombreTorneo.getText().isEmpty() & !txtPremioCu.getText().isEmpty() & !txtPremioFi.getText().isEmpty() & !txtPremioSe.getText().isEmpty()) {
                    if (esNumero(txtPremioCu.getText()) & esNumero(txtPremioFi.getText()) & esNumero(txtPremioSe.getText())) {
                        if (rBtnAleatorio.isEnabled()) {
                            ArrayList<String> equipos = met.equiposRandom();
                            int[] premios = {Integer.parseInt(txtPremioCu.getText()), Integer.parseInt(txtPremioSe.getText()), Integer.parseInt(txtPremioFi.getText())};
                            met.InsertarTorneo(logeadoA, txtNombreTorneo.getText(), premios, (int) spnEntrada.getValue());
                            ArrayList<String> equiposRandom = new ArrayList();
                            if (equipos != null) {
                                while (equipos.size() != 2) {
                                    int eq1 = (int) (Math.random() * (equipos.size() - 1));
                                    int eq2 = (int) (Math.random() * (equipos.size() - 1));
                                    if (eq1 != eq2) {
                                        equiposRandom.add(equipos.get(eq1));
                                        equiposRandom.add(equipos.get(eq2));
                                        String nomEq1 = equipos.get(eq1);
                                        String nomEq2 = equipos.get(eq2);
                                        equipos.remove(nomEq1);
                                        equipos.remove(nomEq2);
                                    }
                                }
                                equiposRandom.add(equipos.get(0));
                                equiposRandom.add(equipos.get(1));

                                for (int i = 0; i < equiposRandom.size(); i += 2) {
                                    Estadio estadio = sacarEstadioRandom();
                                    Equipo equipoA = met.buscarEquipo(equiposRandom.get(i));
                                    Equipo equipoB = met.buscarEquipo(equiposRandom.get(i + 1));
                                    met.insertarPartidoTorneo(txtNombreTorneo.getText(), equipoA, equipoB, estadio);
                                }
                                JOptionPane.showMessageDialog(null, "Torneo insertado");
                            } else {
                                JOptionPane.showMessageDialog(null, "No hay suficientes equipos para crear el torneo");
                            }
                        } else if (rBtnManual.isEnabled()) {
                            ArrayList<String> equipos = equiposTabla();
                            ArrayList<String> estadios = estadiosTabla();
                            if (equipos.size() == 16 & !estadios.isEmpty()) {
                                int[] premios = {Integer.parseInt(txtPremioCu.getText()), Integer.parseInt(txtPremioSe.getText()), Integer.parseInt(txtPremioFi.getText())};
                                met.InsertarTorneo(logeadoA, txtNombreTorneo.getText(), premios, (int) spnEntrada.getValue());
                                ArrayList<String> equiposRandom = new ArrayList();
                                while (equipos.size() != 2) {
                                    int eq1 = (int) (Math.random() * (equipos.size() - 1));
                                    int eq2 = (int) (Math.random() * (equipos.size() - 1));
                                    if (eq1 != eq2) {
                                        equiposRandom.add(equipos.get(eq1));
                                        equiposRandom.add(equipos.get(eq2));
                                        String nomEq1 = equipos.get(eq1);
                                        String nomEq2 = equipos.get(eq2);
                                        equipos.remove(nomEq1);
                                        equipos.remove(nomEq2);
                                    }
                                }
                                equiposRandom.add(equipos.get(0));
                                equiposRandom.add(equipos.get(1));
                                for (int i = 0; i < equiposRandom.size(); i += 2) {
                                    int idxEs = (int) (Math.random() * (estadios.size() - 1));
                                    Equipo equipoA = met.buscarEquipo(equiposRandom.get(i));
                                    Equipo equipoB = met.buscarEquipo(equiposRandom.get(i + 1));
                                    Estadio estadio = met.buscarEstadio(estadios.get(idxEs));
                                    met.insertarPartidoTorneo(txtNombreTorneo.getText(), equipoA, equipoB, estadio);
                                }
                                JOptionPane.showMessageDialog(null, "Torneo insertado");
                                met.imprimirTorneo();
                            } else {
                                JOptionPane.showMessageDialog(null, "Necesitas más equipos para iniciar un torneo y como minimo un estadio.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Marque una de las opciones");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Los espacios de premios deben ser números");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor llene los campos vacios.");
                }
                break;
            case 1:
                if (!txtNombreTorneo.getText().isEmpty() & !txtPremioCu.getText().isEmpty() & !txtPremioFi.getText().isEmpty() & !txtPremioSe.getText().isEmpty()) {
                    String nombre = JOptionPane.showInputDialog(this, "Digite el nombre del torneo que desea modificar");
                    int[] premios = {Integer.parseInt(txtPremioCu.getText()), Integer.parseInt(txtPremioSe.getText()), Integer.parseInt(txtPremioFi.getText())};
                    msj = met.modificarTorneo(logeadoA, nombre, txtNombreTorneo.getText(), premios, (int) spnEntrada.getValue());
                    JOptionPane.showMessageDialog(null, msj);
                }
                break;
            case 2:
                msj = met.eliminarTorneo(logeadoA, txtNombreTorneo.getText());
                JOptionPane.showMessageDialog(null, msj);
                break;
        }
    }//GEN-LAST:event_btnCrearTorneoActionPerformed

    private void rBtnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnManualActionPerformed
        rBtnAleatorio.setSelected(false);
        tablaEquipos.setEnabled(true);
    }//GEN-LAST:event_rBtnManualActionPerformed

    private void rBtnAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnAleatorioActionPerformed
        rBtnManual.setSelected(false);
        tablaEquipos.setEnabled(false);
    }//GEN-LAST:event_rBtnAleatorioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = cmbEliminar.getSelectedIndex();
        String msj = "";
        int value = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminarlo");
        if (value == 0) {
            switch (index) {
                case 0:
                    msj = met.eliminarAdmin(txtNombreEliminar.getText(), txtClaveEliminar.getText());
                    JOptionPane.showMessageDialog(null, msj);
                    break;
                case 1:
                    msj = met.eliminarEntrenador(txtNombreEliminar.getText(), txtClaveEliminar.getText());
                    JOptionPane.showMessageDialog(null, msj);
                    break;
                case 2:
                    msj = met.eliminarJugador(txtNombreEliminar.getText(), txtClaveEliminar.getText());
                    JOptionPane.showMessageDialog(null, msj);
                    break;
                case 3:
                    msj = met.EliminarEstadio(txtNombreEliminar.getText());
                    JOptionPane.showMessageDialog(null, msj);
                    break;
                case 4:
                    msj = met.EliminarEquipo(txtNombreEliminar.getText());
                    JOptionPane.showMessageDialog(null, msj);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbEliminarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEliminarItemStateChanged
        int index = cmbEliminar.getSelectedIndex();
        if (index == 0) {
            lblNombreEliminar.setText("Nombre Usuario: ");
            lblClaveEliminar.setText("Clave: ");
            lblClaveEliminar.setVisible(true);
            txtNombreEliminar.setVisible(true);
        } else if (index == 1 & index == 2) {
            lblNombreEliminar.setText("Nombre: ");
            lblClaveEliminar.setText("Apellido: ");
            lblClaveEliminar.setVisible(true);
            txtNombreEliminar.setVisible(true);
        } else if (index == 3 & index == 4) {
            lblNombreEliminar.setText("Nombre: ");
            lblClaveEliminar.setVisible(false);
            txtNombreEliminar.setVisible(false);
        }
    }//GEN-LAST:event_cmbEliminarItemStateChanged

    private void lblBuscarModiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarModiMouseExited
        lblBuscarModi.setForeground(black);
    }//GEN-LAST:event_lblBuscarModiMouseExited

    private void lblBuscarModiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarModiMouseEntered
        lblBuscarModi.setForeground(red);
    }//GEN-LAST:event_lblBuscarModiMouseEntered

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

    private void cmbEstampadoModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoModiItemStateChanged
        imprimirCamisa(panelCamisaModi);
    }//GEN-LAST:event_cmbEstampadoModiItemStateChanged

    private void cmbEstampadoColorModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoColorModiItemStateChanged
        imprimirCamisa(panelCamisaModi);
    }//GEN-LAST:event_cmbEstampadoColorModiItemStateChanged

    private void cmbColorCamisaModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbColorCamisaModiItemStateChanged
        imprimirCamisa(panelCamisaModi);
    }//GEN-LAST:event_cmbColorCamisaModiItemStateChanged

    private void cmbDisparoModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDisparoModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbDisparoModiItemStateChanged

    private void cmbDribblingModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDribblingModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbDribblingModiItemStateChanged

    private void cmbDefensaModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDefensaModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbDefensaModiItemStateChanged

    private void cmbFisicoModiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFisicoModiItemStateChanged
        sacarPrecioJugadorModi(lblPrecioModi);
    }//GEN-LAST:event_cmbFisicoModiItemStateChanged

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

    private void cmbEstampadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoItemStateChanged
        imprimirCamisa(panelCamisa);
    }//GEN-LAST:event_cmbEstampadoItemStateChanged

    private void cmbEstampadoColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstampadoColorItemStateChanged
        imprimirCamisa(panelCamisa);
    }//GEN-LAST:event_cmbEstampadoColorItemStateChanged

    //Elegir la comida|||Inicio
    private void cmbColorCamisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbColorCamisaItemStateChanged
        imprimirCamisa(panelCamisa);
    }//GEN-LAST:event_cmbColorCamisaItemStateChanged

    private void cmbDisparoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDisparoItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbDisparoItemStateChanged

    private void cmbDribblingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDribblingItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbDribblingItemStateChanged

    private void cmbDefensaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDefensaItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbDefensaItemStateChanged

    //Sacar Precio y mostrarlo en un label||| inicio
    private void cmbFisicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFisicoItemStateChanged
        sacarPrecioJugador(lblPrecio);
    }//GEN-LAST:event_cmbFisicoItemStateChanged

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

    private void rbtnJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnJugadorActionPerformed
        lblContraApellido.setText("Apellido:");
        lblNombre.setText("Nombre:");
        rbtnEntrenador.setSelected(false);
        rbtnAdmin.setSelected(false);
    }//GEN-LAST:event_rbtnJugadorActionPerformed

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
                        this.logeadoA = admin;
                        lblUsuarioActual.setText(this.logeadoA.nombre);
                        lblEstado.setText("Conectado");
                        btnLogin.setText("Logout");
                        //Habilitar los paneles para el administrador
                        tbdPrincipal.setEnabledAt(1, true);
                        tbdPrincipal.setEnabledAt(2, true);
                        tbdPrincipal.setEnabledAt(3, true);
                        tbdPrincipal.setEnabledAt(4, true);
                        tbdPrincipal.setEnabledAt(5, true);
                        tbdPrincipal.setEnabledAt(7, false);
                    } else {
                        showMessageDialog(null, "No se encontro usuario administrador");
                    }
                    //Realizar este codigo si esta selecionado el radiobutton entrenador
                } else if (rbtnEntrenador.isSelected()) {
                    Entrenador entrenador = met.buscarEntrenador(txtNLogin.getText(), txtCLogin.getText());
                    //Verificar que exista ese entrenador
                    if (entrenador != null) {
                        this.tipo = 'B';
                        this.logeadoE = entrenador;
                        lblUsuarioActual.setText(this.logeadoE.nombre);
                        lblEstado.setText("Conectado");
                        btnLogin.setText("Logout");
                        //Habilitar los paneles para el entrenador
                        tbdPrincipal.setEnabledAt(1, false);
                        tbdPrincipal.setEnabledAt(2, false);
                        tbdPrincipal.setEnabledAt(3, false);
                        tbdPrincipal.setEnabledAt(4, false);
                        tbdPrincipal.setEnabledAt(5, true);
                    } else {
                        showMessageDialog(null, "No se encontro usuario entrenador");
                    }
                    //Realizar este codigo si esta selecionado el radiobutton jugador
                } else if (rbtnJugador.isSelected()) {
                    Jugador jugador = met.buscarJugador(txtNLogin.getText(), txtCLogin.getText());
                    //Verificar que exista ese jugador
                    if (jugador != null) {
                        this.tipo = 'C';
                        this.logeadoJ = jugador;
                        lblUsuarioActual.setText(this.logeadoJ.nombre);
                        lblEstado.setText("Conectado");
                        btnLogin.setText("Logout");
                        //Habilitar los paneles para el Jugador
                        tbdPrincipal.setEnabledAt(6, true);
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
            this.logeadoA = null;
            this.logeadoE = null;
            this.logeadoJ = null;
            lblUsuarioActual.setText("No hay");
            lblEstado.setText("Desconectado");
            btnLogin.setText("Login");
            //Desabilitar todos los paneles
            tbdPrincipal.setEnabledAt(1, false);
            tbdPrincipal.setEnabledAt(2, false);
            tbdPrincipal.setEnabledAt(3, false);
            tbdPrincipal.setEnabledAt(4, false);
            tbdPrincipal.setEnabledAt(5, false);
            tbdPrincipal.setEnabledAt(6, false);
            tbdPrincipal.setEnabledAt(7, false);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void verLlave(Torneo auxT) {
        Partidos auxPA = auxT.SubPartidosA;
        int i = 0;
        while (auxPA != null) {
            octavos.get(i).setText(auxPA.equipoA.nombre.substring(0, 3) + " vs " + auxPA.equipoB.nombre.substring(0, 3));
            i++;
            auxPA = auxPA.sig;
        }
        auxPA = auxT.cuartosPA;
        i = 0;
        while (auxPA != null) {
            cuartos.get(i).setText(auxPA.equipoA.nombre.substring(0, 3) + " vs " + auxPA.equipoB.nombre.substring(0, 3));
            i++;
            auxPA = auxPA.sig;
        }
        auxPA = auxT.semifinalesPA;
        i = 0;
        while (auxPA != null) {
            semifinales.get(i).setText(auxPA.equipoA.nombre.substring(0, 3) + " vs " + auxPA.equipoB.nombre.substring(0, 3));
            i++;
            auxPA = auxPA.sig;
        }
        auxPA = auxT.semifinalesPA;
        i = 0;
        while (auxPA != null) {
            semifinales.get(i).setText(auxPA.equipoA.nombre.substring(0, 3) + " vs " + auxPA.equipoB.nombre.substring(0, 3));
            i++;
            auxPA = auxPA.sig;
        }
        auxPA = auxT.finalPA;
        if (auxPA != null) {
            lblPartidoE.setText(auxPA.equipoA.nombre.substring(0, 3) + " vs " + auxPA.equipoB.nombre.substring(0, 3));
        }

    }


    private void lblBuscarTorneoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarTorneoMouseClicked
        lblBuscarTorneo.setForeground(red);
        String nombreTorneo = JOptionPane.showInputDialog(null, "Escriba el nombre del torneo que desea ver");
        Torneo auxT = met.buscarTorneo(logeadoA.nombre, nombreTorneo);
        if (auxT != null) {
            lblNombreTorneo.setText(auxT.nombre);
            verLlave(auxT);
        }
        lblBuscarTorneo.setForeground(black);
    }//GEN-LAST:event_lblBuscarTorneoMouseClicked

    private void lblBuscarTorneoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarTorneoMouseEntered
        lblBuscarTorneo.setForeground(blue);
    }//GEN-LAST:event_lblBuscarTorneoMouseEntered

    private void lblBuscarTorneoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarTorneoMouseExited
        lblBuscarTorneo.setForeground(black);
    }//GEN-LAST:event_lblBuscarTorneoMouseExited

    private ArrayList<Jugador> buscarDelantero(ArrayList<Jugador> jugadores) {
        ArrayList<Jugador> delanteros = new ArrayList();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).posicion.equals("delantero")) {
                delanteros.add(jugadores.get(i));
            }
        }
        return delanteros;
    }


    private void btnAutoTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoTorneoActionPerformed
        Torneo auxT = met.buscarTorneo(logeadoA.nombre, lblNombreTorneo.getText());
        if (auxT != null) {
            if (auxT.torneoActivo) {
                Partidos auxPA = auxT.SubPartidosA;
                boolean eq = true;
                Equipo eqA = null;
                Equipo eqB = null;
                Estadio es = null;

                //Generar gandores de partidos para cuartos
                while (auxPA != null) {
                    boolean flag = true;
                    //Econtrar los aficionados con un random
                    int aficionados = (int) (Math.random() * auxPA.estadio.capacidad);
                    auxPA.aficion = aficionados;
                    int dineroPartido = aficionados * auxT.entrada;

                    //Sacar la cantidad de goles
                    while (flag) {
                        int golA = (int) (Math.random() * 5);
                        int golB = (int) (Math.random() * 5);
                        if (golA != golB) {
                            auxPA.equipoA.goles += golA;
                            auxPA.golesA = golA;
                            auxPA.equipoB.golesContra += golA;
                            auxPA.equipoB.goles += golB;
                            auxPA.golesB = golB;
                            auxPA.equipoA.golesContra += golB;

                            flag = false;
                        }

                        //Buscar los delanteros del equipoA
                        ArrayList<Jugador> delantero = buscarDelantero(auxPA.equipoA.jugadores);
                        for (int i = 0; i < golA; i++) {
                            int jugador = (int) (Math.random() * 6);
                            int tiempo = (int) (Math.random() * 89) + 1;
                            if (jugador <= 3) {
                                String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                                auxPA.equipoA.jugadores.get(0).goles += 1;
                                auxPA.goleadores.add(goleador);
                            } else {
                                String goleador = auxPA.equipoA.jugadores.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                                auxPA.equipoA.jugadores.get(1).goles += 1;
                                auxPA.goleadores.add(goleador);
                            }
                        }

                        //Buscar los auxPA.equipoA.jugadoress del equipoB  
                        delantero = buscarDelantero(auxPA.equipoB.jugadores);
                        for (int i = 0; i < golB; i++) {
                            int jugador = (int) (Math.random() * 6);
                            int tiempo = (int) (Math.random() * 89) + 1;
                            if (jugador <= 3) {
                                String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(0).goles += 1;
                                auxPA.goleadores.add(goleador);
                            } else {
                                String goleador = delantero.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(1).goles += 1;
                                auxPA.goleadores.add(goleador);
                            }
                        }
                    }

                    //Pasar a la siguiente fase el equipo ganador
                    if (eq) {
                        if (auxPA.golesA > auxPA.golesB) {
                            eqA = auxPA.equipoA;
                            es = auxPA.estadio;
                            auxPA.equipoA.dinero += dineroPartido * 0.20;
                            auxPA.equipoB.dinero += dineroPartido * 0.05;
                            eq = false;
                        } else {
                            eqA = auxPA.equipoB;
                            es = auxPA.estadio;
                            auxPA.equipoB.dinero += dineroPartido * 0.20;
                            auxPA.equipoA.dinero += dineroPartido * 0.05;
                            eq = false;
                        }
                        auxT.admin.dinero += dineroPartido * 0.75;
                        auxT.dineroAdmin += dineroPartido * 0.75;
                    } else {
                        if (auxPA.golesA > auxPA.golesB) {
                            eqB = auxPA.equipoA;
                            auxPA.equipoA.dinero += dineroPartido * 0.20;
                            auxPA.equipoB.dinero += dineroPartido * 0.05;
                            eq = true;
                        } else {
                            eqB = auxPA.equipoB;
                            auxPA.equipoB.dinero += dineroPartido * 0.20;
                            auxPA.equipoA.dinero += dineroPartido * 0.05;
                            eq = true;
                        }
                        auxT.admin.dinero += dineroPartido * 0.75;
                        auxT.dineroAdmin += dineroPartido * 0.75;
                        met.insertarPartidoTorneoCuartos(auxT, eqA, eqB, es);
                    }
                    auxPA = auxPA.sig;
                }
                //Generar ganadores de partidos semifinales
                auxPA = auxT.cuartosPA;
                eq = true;
                eqA = null;
                eqB = null;
                es = null;

                while (auxPA != null) {
                    boolean flag = true;
                    //Econtrar los aficionados con un random
                    int aficionados = (int) (Math.random() * auxPA.estadio.capacidad);
                    auxPA.aficion = aficionados;
                    int dineroPartido;
                    //Sacar la cantidad de goles
                    while (flag) {
                        int golA = (int) (Math.random() * 5);
                        int golB = (int) (Math.random() * 5);
                        if (golA != golB) {
                            auxPA.equipoA.goles += golA;
                            auxPA.golesA = golA;
                            auxPA.equipoB.golesContra += golA;
                            auxPA.equipoB.goles += golB;
                            auxPA.golesB = golB;
                            auxPA.equipoA.golesContra += golB;
                            flag = false;
                        }
                        //Buscar los delanteros del equipoA
                        ArrayList<Jugador> delantero = buscarDelantero(auxPA.equipoA.jugadores);
                        for (int i = 0; i < golA; i++) {
                            int jugador = (int) (Math.random() * 6);
                            int tiempo = (int) (Math.random() * 89) + 1;
                            if (jugador <= 3) {
                                String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(0).goles += 1;
                                auxPA.goleadores.add(goleador);
                            } else {
                                String goleador = delantero.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(1).goles += 1;
                                auxPA.goleadores.add(goleador);
                            }
                        }
                        //Buscar los delanteros del equipoB 
                        delantero = buscarDelantero(auxPA.equipoB.jugadores);
                        for (int i = 0; i < golB; i++) {
                            int jugador = (int) (Math.random() * 6);
                            int tiempo = (int) (Math.random() * 89) + 1;
                            if (jugador <= 3) {
                                String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(0).goles += 1;
                                auxPA.goleadores.add(goleador);
                            } else {
                                String goleador = delantero.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(1).goles += 1;
                                auxPA.goleadores.add(goleador);
                            }
                        }
                    }
                    dineroPartido = (int) (aficionados * (auxT.entrada + (auxT.entrada * 0.20)));
                    //Pasar a la siguiente fase el equipo ganador
                    if (eq) {
                        if (auxPA.golesA > auxPA.golesB) {
                            eqA = auxPA.equipoA;
                            es = auxPA.estadio;
                            auxPA.equipoA.dinero += dineroPartido * 0.20;
                            auxPA.equipoB.dinero += dineroPartido * 0.05;
                            eq = false;
                        } else {
                            eqA = auxPA.equipoB;
                            es = auxPA.estadio;
                            auxPA.equipoB.dinero += dineroPartido * 0.20;
                            auxPA.equipoA.dinero += dineroPartido * 0.05;
                            eq = false;
                        }
                        auxT.admin.dinero += dineroPartido * 0.75;
                        auxT.dineroAdmin += dineroPartido * 0.75;
                    } else {
                        if (auxPA.golesA > auxPA.golesB) {
                            eqB = auxPA.equipoA;
                            auxPA.equipoA.dinero += dineroPartido * 0.20;
                            auxPA.equipoB.dinero += dineroPartido * 0.05;
                            eq = true;
                        } else {
                            eqB = auxPA.equipoB;
                            auxPA.equipoB.dinero += dineroPartido * 0.20;
                            auxPA.equipoA.dinero += dineroPartido * 0.05;
                            eq = true;
                        }
                        auxT.admin.dinero += dineroPartido * 0.75;
                        auxT.dineroAdmin += dineroPartido * 0.75;
                        met.insertarPartidoTorneoSemifinales(auxT, eqA, eqB, es);
                    }
                    auxPA = auxPA.sig;
                }

                //Generar ganadores de partidos Finales
                auxPA = auxT.semifinalesPA;
                eqA = null;
                eqB = null;
                es = null;
                while (auxPA != null) {
                    boolean flag = true;
                    int aficionados = (int) (Math.random() * auxPA.estadio.capacidad);
                    int dineroPartido;
                    while (flag) {
                        int golA = (int) (Math.random() * 5);
                        int golB = (int) (Math.random() * 5);
                        if (golA != golB) {
                            auxPA.equipoA.goles += golA;
                            auxPA.golesA = golA;
                            auxPA.equipoB.golesContra += golA;
                            auxPA.equipoB.goles += golB;
                            auxPA.golesB = golB;
                            auxPA.equipoA.golesContra += golB;
                            flag = false;
                        }
                        ArrayList<Jugador> delantero = buscarDelantero(auxPA.equipoA.jugadores);
                        for (int i = 0; i < golA; i++) {
                            int jugador = (int) (Math.random() * 6);
                            int tiempo = (int) (Math.random() * 89) + 1;
                            if (jugador <= 3) {
                                String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(0).goles += 1;
                                auxPA.goleadores.add(goleador);
                            } else {
                                String goleador = delantero.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(1).goles += 1;
                                auxPA.goleadores.add(goleador);
                            }
                        }

                        delantero = buscarDelantero(auxPA.equipoB.jugadores);
                        for (int i = 0; i < golB; i++) {
                            int jugador = (int) (Math.random() * 6);
                            int tiempo = (int) (Math.random() * 89) + 1;
                            if (jugador <= 3) {
                                String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(0).goles += 1;
                                auxPA.goleadores.add(goleador);
                            } else {
                                String goleador = delantero.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                                delantero.get(1).goles += 1;
                                auxPA.goleadores.add(goleador);
                            }
                        }
                    }
                    dineroPartido = (int) (aficionados * (auxT.entrada + (auxT.entrada * 0.50)));
                    if (eq) {
                        if (auxPA.golesA > auxPA.golesB) {
                            eqA = auxPA.equipoA;
                            es = auxPA.estadio;
                            auxPA.equipoA.dinero += dineroPartido * 0.20;
                            auxPA.equipoB.dinero += dineroPartido * 0.05;
                            eq = false;
                        } else {
                            eqA = auxPA.equipoB;
                            es = auxPA.estadio;
                            auxPA.equipoB.dinero += dineroPartido * 0.20;
                            auxPA.equipoA.dinero += dineroPartido * 0.05;
                            eq = false;
                        }
                        auxT.admin.dinero += dineroPartido * 0.75;
                        auxT.dineroAdmin += dineroPartido * 0.75;
                    } else {
                        if (auxPA.golesA > auxPA.golesB) {
                            eqB = auxPA.equipoA;
                            auxPA.equipoA.dinero += dineroPartido * 0.20;
                            auxPA.equipoB.dinero += dineroPartido * 0.05;
                            eq = true;
                        } else {
                            eqB = auxPA.equipoB;
                            auxPA.equipoB.dinero += dineroPartido * 0.20;
                            auxPA.equipoA.dinero += dineroPartido * 0.05;
                            eq = true;
                        }
                        auxT.admin.dinero += dineroPartido * 0.75;
                        auxT.dineroAdmin += dineroPartido * 0.75;
                        met.insertarPartidoTorneoFinal(auxT, eqA, eqB, es);
                    }
                    auxPA = auxPA.sig;
                }

                //Escoger el campeon del torneo
                auxPA = auxT.finalPA;
                boolean flag = true;
                int aficionados = (int) (Math.random() * auxPA.estadio.capacidad);
                int dineroPartido;
                while (flag) {
                    int golA = (int) (Math.random() * 5);
                    int golB = (int) (Math.random() * 5);
                    if (golA != golB) {
                        auxPA.equipoA.goles += golA;
                        auxPA.golesA = golA;
                        auxPA.equipoB.golesContra += golA;
                        auxPA.equipoB.goles += golB;
                        auxPA.golesB = golB;
                        auxPA.equipoA.golesContra += golB;
                        flag = false;
                    }
                    ArrayList<Jugador> delantero = buscarDelantero(auxPA.equipoA.jugadores);
                    for (int i = 0; i < golA; i++) {
                        int jugador = (int) (Math.random() * 6);
                        int tiempo = (int) (Math.random() * 89) + 1;
                        if (jugador <= 3) {
                            String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                            delantero.get(0).goles += 1;
                            auxPA.goleadores.add(goleador);
                        } else {
                            String goleador = delantero.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                            delantero.get(1).goles += 1;
                            auxPA.goleadores.add(goleador);
                        }
                    }

                    delantero = buscarDelantero(auxPA.equipoB.jugadores);
                    for (int i = 0; i < golB; i++) {
                        int jugador = (int) (Math.random() * 6);
                        int tiempo = (int) (Math.random() * 89) + 1;
                        if (jugador <= 3) {
                            String goleador = delantero.get(0).nombre + " " + String.valueOf(tiempo) + "'";
                            delantero.get(0).goles += 1;
                            auxPA.goleadores.add(goleador);
                        } else {
                            String goleador = delantero.get(1).nombre + " " + String.valueOf(tiempo) + "'";
                            delantero.get(1).goles += 1;
                            auxPA.goleadores.add(goleador);
                        }
                    }
                }
                dineroPartido = (int) (aficionados * (auxT.entrada + (auxT.entrada * 0.80)));
                if (auxPA.golesA > auxPA.golesB) {
                    JOptionPane.showMessageDialog(null, auxPA.equipoA.nombre + " es el campeon del torneo " + auxT.nombre);
                    auxPA.equipoA.dinero += dineroPartido * 0.20;
                    auxPA.equipoB.dinero += dineroPartido * 0.05;

                } else {
                    JOptionPane.showMessageDialog(null, auxPA.equipoA.nombre + " es el campeon del torneo " + auxT.nombre);
                    auxPA.equipoB.dinero += dineroPartido * 0.20;
                    auxPA.equipoA.dinero += dineroPartido * 0.05;

                }
                auxT.admin.dinero += dineroPartido * 0.75;
                auxT.dineroAdmin += dineroPartido * 0.75;
                auxT.torneoActivo = false;
                //Dar premios a los participantes del torneo
                auxPA = auxT.SubPartidosA;
                while (auxPA != null) {
                    if (auxPA.equipoA.posicionTorneo == 8 | auxPA.equipoB.posicionTorneo == 8) {
                        if (auxPA.equipoA.posicionTorneo == 8) {
                            auxPA.equipoA.dinero += auxT.Premio[0];
                        } else if (auxPA.equipoB.posicionTorneo == 8) {
                            auxPA.equipoB.dinero += auxT.Premio[0];
                        }
                    }
                    if (auxPA.equipoA.posicionTorneo == 4 | auxPA.equipoB.posicionTorneo == 4) {
                        if (auxPA.equipoA.posicionTorneo == 8) {
                            auxPA.equipoA.dinero += auxT.Premio[1];
                        } else if (auxPA.equipoB.posicionTorneo == 8) {
                            auxPA.equipoB.dinero += auxT.Premio[1];
                        }
                    }
                    if (auxPA.equipoA.posicionTorneo == 2 | auxPA.equipoB.posicionTorneo == 2) {
                        if (auxPA.equipoA.posicionTorneo == 8) {
                            auxPA.equipoA.dinero += auxT.Premio[2];
                        } else if (auxPA.equipoB.posicionTorneo == 8) {
                            auxPA.equipoB.dinero += auxT.Premio[2];
                        }
                    }
                    auxPA.equipoA.posicionTorneo = 0;
                    auxPA.equipoB.posicionTorneo = 0;
                    auxPA = auxPA.sig;
                }
                verLlave(auxT);
            } else {
                JOptionPane.showMessageDialog(null, "Este torneo ya finalizó");
            }
        }
    }//GEN-LAST:event_btnAutoTorneoActionPerformed

    private void mostrarPartido(ventanaPartido parti, Partidos partido) {
        parti.lblEquipoA.setText(partido.equipoA.nombre);
        parti.lblEquipoB.setText(partido.equipoB.nombre);

        parti.lblGolesA.setText(String.valueOf(partido.golesB));
        parti.lblGolesB.setText(String.valueOf(partido.golesA));

        parti.lblEstadio.setText(partido.estadio.nombre);
        parti.lblEstadioUbicacion.setText(partido.estadio.ubicacion);

        parti.lblAficion.setText(String.valueOf(partido.aficion));
        DefaultListModel lista = new DefaultListModel();
        for (int i = 0; i < partido.goleadores.size(); i++) {
            lista.addElement(partido.goleadores.get(i));
        }
        parti.listaGoleadores.setModel(lista);
    }

    private void ventanaPartido(int i) {
        Partidos partido = met.buscarPartido(logeadoA.nombre, lblNombreTorneo.getText(), i);
        if (partido != null) {
            Image camisaA = (new javax.swing.ImageIcon(getClass().getResource("/" + partido.equipoA.camisa[0]))).getImage();
            Image stamA = (new javax.swing.ImageIcon(getClass().getResource("/" + partido.equipoA.camisa[1]))).getImage();

            Image camisaB = (new javax.swing.ImageIcon(getClass().getResource("/" + partido.equipoB.camisa[0]))).getImage();
            Image stamB = (new javax.swing.ImageIcon(getClass().getResource("/" + partido.equipoB.camisa[1]))).getImage();

            ventanaPartido parti = new ventanaPartido(camisaA, stamA, camisaB, stamB);
            mostrarPartido(parti, partido);
            parti.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No Hay partido");
        }
    }

    private void lblPartido0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido0MouseClicked
        ventanaPartido(1);
    }//GEN-LAST:event_lblPartido0MouseClicked

    private void rbtnManuTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnManuTorneoActionPerformed
        rbtnAutoTorneo.setSelected(false);
        btnAutoTorneo.setEnabled(false);
    }//GEN-LAST:event_rbtnManuTorneoActionPerformed

    private void rbtnAutoTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAutoTorneoActionPerformed
        rbtnManuTorneo.setSelected(false);
        if (logeadoA != null) {
            btnAutoTorneo.setEnabled(true);
        }
    }//GEN-LAST:event_rbtnAutoTorneoActionPerformed

    private void lblPartido1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido1MouseClicked
        ventanaPartido(2);
    }//GEN-LAST:event_lblPartido1MouseClicked

    private void lblPartido2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido2MouseClicked
        ventanaPartido(3);
    }//GEN-LAST:event_lblPartido2MouseClicked

    private void lblPartido3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido3MouseClicked
        ventanaPartido(4);
    }//GEN-LAST:event_lblPartido3MouseClicked

    private void lblPartido4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido4MouseClicked
        ventanaPartido(5);
    }//GEN-LAST:event_lblPartido4MouseClicked

    private void lblPartido5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido5MouseClicked
        ventanaPartido(6);
    }//GEN-LAST:event_lblPartido5MouseClicked

    private void lblPartido6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido6MouseClicked
        ventanaPartido(7);
    }//GEN-LAST:event_lblPartido6MouseClicked

    private void lblPartido7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido7MouseClicked
        ventanaPartido(8);
    }//GEN-LAST:event_lblPartido7MouseClicked

    private void lblPartido8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido8MouseClicked
        ventanaPartido(9);
    }//GEN-LAST:event_lblPartido8MouseClicked

    private void lblPartido9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartido9MouseClicked
        ventanaPartido(10);
    }//GEN-LAST:event_lblPartido9MouseClicked

    private void lblPartidoAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartidoAMouseClicked
        ventanaPartido(11);
    }//GEN-LAST:event_lblPartidoAMouseClicked

    private void lblPartidoBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartidoBMouseClicked
        ventanaPartido(12);
    }//GEN-LAST:event_lblPartidoBMouseClicked

    private void lblPartidoCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartidoCMouseClicked
        ventanaPartido(13);
    }//GEN-LAST:event_lblPartidoCMouseClicked

    private void lblPartidoDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartidoDMouseClicked
        ventanaPartido(14);
    }//GEN-LAST:event_lblPartidoDMouseClicked

    private void lblPartidoEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPartidoEMouseClicked
        ventanaPartido(15);
    }//GEN-LAST:event_lblPartidoEMouseClicked

    private void lblReporte1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReporte1MouseClicked
        String nombreJugador = JOptionPane.showInputDialog(null, "Digite el nombre del Jugador");
        String apellidoJugador = JOptionPane.showInputDialog(null, "Digite el apellido del Jugador");
        Jugador jugador = met.buscarJugador(nombreJugador, apellidoJugador);
        DefaultListModel lista = new DefaultListModel();
        listaReportes.removeAll();
        lista.addElement("Equipo: " + jugador.equipo.nombre);
        listaReportes.setModel(lista);
    }//GEN-LAST:event_lblReporte1MouseClicked

    private void lblReporte2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReporte2MouseClicked
        String nombreEquipo = JOptionPane.showInputDialog(null, "Digite el nombre del equipo");
        Equipo equipo = met.buscarEquipo(nombreEquipo);
        DefaultListModel lista = new DefaultListModel();
        listaReportes.removeAll();
        lista.addElement(met.imprmirListaJugadores(equipo));
        listaReportes.setModel(lista);
    }//GEN-LAST:event_lblReporte2MouseClicked

    private void lblReporte3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReporte3MouseClicked
        String nombreEquipo = JOptionPane.showInputDialog(null, "Digite el nombre del equipo");
        Equipo equipo = met.buscarEquipo(nombreEquipo);
        DefaultListModel lista = new DefaultListModel();
        listaReportes.removeAll();
        lista.addElement("Entrenador: " + equipo.entrenador.nombre + " " + equipo.entrenador.apellido);
        listaReportes.setModel(lista);
    }//GEN-LAST:event_lblReporte3MouseClicked

    private void lblReporte4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReporte4MouseClicked
        String nombreTorneo = JOptionPane.showInputDialog(null, "Digite el nombre del torneo");
        Torneo torneo = met.buscarTorneo(nombreTorneo);
        DefaultListModel lista = new DefaultListModel();
        listaReportes.removeAll();
        String equipo;
        if (torneo.finalPA.golesA > torneo.finalPA.golesB) {
            equipo = torneo.finalPA.equipoA.nombre;
        } else {
            equipo = torneo.finalPA.equipoB.nombre;
        }
        lista.addElement("Equipo ganador del torneo " + torneo.nombre + ": " + equipo);
        listaReportes.setModel(lista);
    }//GEN-LAST:event_lblReporte4MouseClicked

    private void lblReporte5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReporte5MouseClicked
        String validar = JOptionPane.showInputDialog(null, "Digite el Precio");
        if (esNumero(validar)) {
            int precio = Integer.parseInt(validar);
            ArrayList<Jugador> jugadores = met.buscarJugadorPrecio(precio, "=");
            DefaultListModel lista = new DefaultListModel();
            listaReportes.removeAll();
            for (int i = 0; i < jugadores.size(); i++) {
                int[] habi = jugadores.get(i).habilidades;
                lista.addElement("Nombre: " + jugadores.get(i).nombre + " " + jugadores.get(i).apellido + ", Posición" + jugadores.get(i).posicion + ", Habilidades( Fis: " + habi[0] + " Def: " + habi[1] + " Dri: " + habi[2] + "Dis: " + habi[3]+")" + ", Estado: "+ jugadores.get(i).estado );
            }
            listaReportes.setModel(lista);
        }else{
            JOptionPane.showMessageDialog(null, "Digite un número porfavor");
        }
    }//GEN-LAST:event_lblReporte5MouseClicked

    private void lblReporte6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReporte6MouseClicked
        String nombreTorneo = JOptionPane.showInputDialog(null, "Digite el nombre del torneo");
        Torneo torneo = met.buscarTorneo(nombreTorneo);
        DefaultListModel lista = new DefaultListModel();
        listaReportes.removeAll();
        lista.addElement(met.imprimirEquiposTorneo(torneo));
        listaReportes.setModel(lista);
    }//GEN-LAST:event_lblReporte6MouseClicked

    private void lblReporte7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReporte7MouseClicked
        String nombreEquipo = JOptionPane.showInputDialog(null, "Digite el nombre del equipo");
        Equipo equipo = met.buscarEquipo(nombreEquipo);
       if(equipo != null){
        Jugador goleador = met.buscarGoleador(equipo);
        String eq;
        if(goleador.equipo != null){
            eq = goleador.equipo.nombre;
        }else{
            eq = "libre";
        }
        DefaultListModel lista = new DefaultListModel();
        listaReportes.removeAll();
        lista.addElement("Goleador: " + goleador.nombre + " " + goleador.apellido + ", Goles: " + goleador.goles + "Equipo: " + eq);
        listaReportes.setModel(lista);
       }else{
           JOptionPane.showMessageDialog(null, "El equipo no existe");
       }
               
    }//GEN-LAST:event_lblReporte7MouseClicked

    private void verJugadorContratar() {
        if (logeadoE != null) {
            if (logeadoE.equipo != null) {
                jLabel62.setText(String.valueOf(logeadoE.equipo.dinero));
            }
            lblNombreContratar.setText(auxJContratar.nombre);
            lblApellidoContratar.setText(auxJContratar.apellido);
            lblEstadoContratar.setText(auxJContratar.estado);
            if (auxJContratar.equipo != null) {
                lblEquipoContratar.setText(auxJContratar.equipo.nombre);
            } else {
                lblEquipoContratar.setText("libre");
            }
            lblPrecioContratar.setText(String.valueOf(auxJContratar.precio));
        }
    }

    private int[] contarTipoJugadores(Equipo equipo) {
        int[] cantidad = {0, 0, 0, 0};
        for (int i = 0; i < equipo.jugadores.size(); i++) {
            Jugador jugador = equipo.jugadores.get(i);
            switch (jugador.posicion) {
                case "portero":
                    cantidad[0]++;
                    break;
                case "defensa":
                    cantidad[1]++;
                    break;
                case "medio":
                    cantidad[2]++;
                    break;
                case "delantero":
                    cantidad[3]++;
                    break;
            }
        }
        return cantidad;
    }

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
            getLogger(ventanaPrincipal.class
                    .getName()).log(SEVERE, null, ex);
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
    private javax.swing.JButton btnAsignarEntrenador;
    private javax.swing.JButton btnAutoTorneo;
    private javax.swing.JButton btnCrearTorneo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnTablaContratarAnt;
    private javax.swing.JButton btnTablaContratarSig;
    private javax.swing.JButton btnTrato;
    private javax.swing.JComboBox<String> cmbColorCamisa;
    private javax.swing.JComboBox<String> cmbColorCamisaModi;
    private javax.swing.JComboBox<String> cmbDefensa;
    private javax.swing.JComboBox<String> cmbDefensaModi;
    private javax.swing.JComboBox<String> cmbDisparo;
    private javax.swing.JComboBox<String> cmbDisparoModi;
    private javax.swing.JComboBox<String> cmbDribbling;
    private javax.swing.JComboBox<String> cmbDribblingModi;
    private javax.swing.JComboBox<String> cmbEliminar;
    private javax.swing.JComboBox<String> cmbEquipoAsig;
    private javax.swing.JComboBox<String> cmbEstampado;
    private javax.swing.JComboBox<String> cmbEstampadoColor;
    private javax.swing.JComboBox<String> cmbEstampadoColorModi;
    private javax.swing.JComboBox<String> cmbEstampadoModi;
    private javax.swing.JComboBox<String> cmbFisico;
    private javax.swing.JComboBox<String> cmbFisicoModi;
    private javax.swing.JComboBox<String> cmbModificar;
    private javax.swing.JComboBox<String> cmbOpcionesTorneo;
    private javax.swing.JComboBox<String> cmbPosicion;
    private javax.swing.JComboBox<String> cmbPosicionModi;
    private javax.swing.JComboBox<String> cmbRegistro;
    private javax.swing.JComboBox<String> cmbTratoEntrenador;
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
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblApellidoContratar;
    private javax.swing.JLabel lblBuscarModi;
    private javax.swing.JLabel lblBuscarTorneo;
    private javax.swing.JLabel lblClaveEliminar;
    private javax.swing.JLabel lblContraApellido;
    private javax.swing.JLabel lblCuarPre;
    private javax.swing.JLabel lblEquipoContratar;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoContratar;
    private javax.swing.JLabel lblFiPre;
    private javax.swing.JLabel lblGenerarPartidos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreContratar;
    private javax.swing.JLabel lblNombreContratar5;
    private javax.swing.JLabel lblNombreEliminar;
    private javax.swing.JLabel lblNombreTorneo;
    private javax.swing.JLabel lblPartido0;
    private javax.swing.JLabel lblPartido1;
    private javax.swing.JLabel lblPartido2;
    private javax.swing.JLabel lblPartido3;
    private javax.swing.JLabel lblPartido4;
    private javax.swing.JLabel lblPartido5;
    private javax.swing.JLabel lblPartido6;
    private javax.swing.JLabel lblPartido7;
    private javax.swing.JLabel lblPartido8;
    private javax.swing.JLabel lblPartido9;
    private javax.swing.JLabel lblPartidoA;
    private javax.swing.JLabel lblPartidoB;
    private javax.swing.JLabel lblPartidoC;
    private javax.swing.JLabel lblPartidoD;
    private javax.swing.JLabel lblPartidoE;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioContratar;
    private javax.swing.JLabel lblPrecioModi;
    private javax.swing.JLabel lblPremios;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JLabel lblReporte1;
    private javax.swing.JLabel lblReporte2;
    private javax.swing.JLabel lblReporte3;
    private javax.swing.JLabel lblReporte4;
    private javax.swing.JLabel lblReporte5;
    private javax.swing.JLabel lblReporte6;
    private javax.swing.JLabel lblReporte7;
    private javax.swing.JLabel lblSePre;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JList<String> listEntrenadorAsig;
    private javax.swing.JList<String> listaReportes;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelAdminModi;
    private javax.swing.JPanel panelAsignarEntrenador;
    private javax.swing.JPanel panelCamisa;
    private javax.swing.JPanel panelCamisaModi;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelEliminar;
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
    private javax.swing.JPanel panelTorneo;
    private javax.swing.JRadioButton rBtnAleatorio;
    private javax.swing.JRadioButton rBtnManual;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JRadioButton rbtnAutoTorneo;
    private javax.swing.JRadioButton rbtnEntrenador;
    private javax.swing.JRadioButton rbtnJugador;
    private javax.swing.JRadioButton rbtnManuTorneo;
    private javax.swing.JSpinner spnEntrada;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaEstadios;
    private javax.swing.JTabbedPane tbdModificar;
    private javax.swing.JTabbedPane tbdPrincipal;
    private javax.swing.JTabbedPane tbdRegistrar;
    private javax.swing.JTextField txtAEntrenador;
    private javax.swing.JTextField txtAEntrenadorModi;
    private javax.swing.JTextField txtAJugador;
    private javax.swing.JTextField txtAJugadorModi;
    private javax.swing.JTextField txtApellidoAsig;
    private javax.swing.JTextField txtCAdmin;
    private javax.swing.JTextField txtCAdminModi;
    private javax.swing.JTextField txtCEstadio;
    private javax.swing.JTextField txtCEstadioModi;
    private javax.swing.JTextField txtCLogin;
    private javax.swing.JTextField txtClaveEliminar;
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
    private javax.swing.JTextField txtNombreAsig;
    private javax.swing.JTextField txtNombreEliminar;
    private javax.swing.JTextField txtNombreTorneo;
    private javax.swing.JTextField txtPremioCu;
    private javax.swing.JTextField txtPremioFi;
    private javax.swing.JTextField txtPremioSe;
    private javax.swing.JTextField txtUEstadio;
    private javax.swing.JTextField txtUEstadioModi;
    // End of variables declaration//GEN-END:variables
}
