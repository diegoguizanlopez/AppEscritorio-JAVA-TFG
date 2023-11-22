/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Connector.ConexionSQL;
import Consultas.EmpresaSQL;
import Consultas.Server_FTP;
import Consultas.GenerosSQL;
import Consultas.VideoJuegosSQL;
import Interfaces.Interfaz;
import Modelo.Empresas;
import Modelo.GeneralClass;
import Modelo.Generos;
import Modelo.PersonalizedExc;
import Modelo.VideoJuegos;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Útil.BoundsPopupMenuListener;
import Útil.FileChooser;
import Útil.GetIconFromAssets;
import Útil.HiloGestorNotificaciones;
import Útil.InputStreamToImageIcon;
import Útil.LengthRestrictedDocument;
import Útil.PropertiesCache;

/**
 *
 * @author diegogl
 */
public class frmPadre extends javax.swing.JFrame {

    CardLayout cardLayout;
    Generos LocalGenero;
    VideoJuegos LocalVideoJuego;
    Empresas LocalEmpresa;
    InputStream VideoJuegoImagen, EmpresaImagen;

    public void setLocalVideoJuego(VideoJuegos LocalVideoJuego) {
        this.LocalVideoJuego = LocalVideoJuego;
        if (LocalVideoJuego != null && LocalVideoJuego.getId() != -1) {
            btmEliminarV.setEnabled(true);
        } else {
            btmEliminarV.setEnabled(false);
        }
    }

    public void setLocalGenero(Generos LocalGenero) {
        this.LocalGenero = LocalGenero;
        if (LocalGenero != null && LocalGenero.getId() != -1) {
            btmEliminarG.setEnabled(true);
        } else {
            btmEliminarG.setEnabled(false);
        }
    }

    public void setLocalEmpresa(Empresas LocalEmpresa) {
        this.LocalEmpresa = LocalEmpresa;
        if (LocalEmpresa != null && LocalEmpresa.getId() != -1) {
            btmEliminarE.setEnabled(true);
        } else {
            btmEliminarE.setEnabled(false);
        }
    }

    /**
     * Creates new form frmPadre
     */
    public frmPadre() {
        //-Duser.language=en -Duser.country=GB
        initComponents();
        if (Locale.getDefault().toLanguageTag().equals("es-ES")) {
            btmEspañol.setSelected(true);
            Locale l = new Locale("es", "ES");
            Locale.setDefault(l);
        } else {
            btmIngles.setSelected(true);
            Locale l = new Locale("en", "GB");
            Locale.setDefault(l);
        }
        cardLayout = (CardLayout) pnController.getLayout();
        ConexionSQL.Conectar(PropertiesCache.getInstance().getProperty("ip"), PropertiesCache.getInstance().getProperty("puerto"), "VideoJuegos", "escritorio", "escritorio");
        if (!ConexionSQL.IsConected()) {
            dgAjustes frm = new dgAjustes(this, true);
            frm.setVisible(true);
            this.setVisible(false);
        }
        if (!ConexionSQL.IsConected()) {
            System.exit(1);
        }
        this.setVisible(true);
        try {
            InitScreens();
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
        }
        HelpSet help = new HelpSet();
        HelpBroker hb;
        BoundsPopupMenuListener listener
                = new BoundsPopupMenuListener(true, false);
        cmbVideoJuegos_Generos.addPopupMenuListener(listener);
        cmbVideoJuegos_Generos.setMaximumRowCount(5);
        URL hsURL = this.getClass().getResource("/Ayuda/help_set.hs");
        try {
            help = new HelpSet(getClass().getClassLoader(), hsURL);
        } catch (HelpSetException ex) {
            Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocalVideoJuego(null);
        setLocalEmpresa(null);
        setLocalGenero(null);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        setVisible(true);
        hb = help.createHelpBroker();
        hb.enableHelpOnButton(btmAyuda, "Ayuda", help);
        hb.enableHelpKey(this.getContentPane(), "Ayuda", help);
        I18N();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btmGroupIdiomas = new javax.swing.ButtonGroup();
        pnController = new javax.swing.JPanel();
        pnDefault = new javax.swing.JPanel();
        txtMain = new javax.swing.JLabel();
        pnAñadirV = new javax.swing.JPanel();
        pnBajo = new javax.swing.JPanel();
        btmEliminarV = new javax.swing.JButton();
        cmbVideoJuegos_Generos = new javax.swing.JComboBox<>();
        lblVResult = new javax.swing.JLabel();
        btmLimpiarV = new javax.swing.JButton();
        btmGuardarV = new javax.swing.JButton();
        pnCentro = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIdV = new javax.swing.JTextField();
        txtNombreV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtImageV = new javax.swing.JLabel();
        btmNuevaImagen = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsInsertE = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lsSelectE = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDescV = new javax.swing.JTextArea();
        pnAñadirG = new javax.swing.JPanel();
        pnBajoG = new javax.swing.JPanel();
        btmEliminarG = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        lblGResult = new javax.swing.JLabel();
        btmLimpiarG = new javax.swing.JButton();
        btmGuardarG = new javax.swing.JButton();
        pnCentroG = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdG = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreG = new javax.swing.JTextField();
        pnAñadirE = new javax.swing.JPanel();
        pnBajoE = new javax.swing.JPanel();
        btmEliminarE = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        lblEResult = new javax.swing.JLabel();
        btmLimpiarE = new javax.swing.JButton();
        btmGuardarE = new javax.swing.JButton();
        pnCentroE = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtIdE = new javax.swing.JTextField();
        txtNombreE = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtImageE = new javax.swing.JLabel();
        btmNuevaImagenE = new javax.swing.JButton();
        txtDescE = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsInsertV = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        lsSelectV = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnVideoJuegos = new javax.swing.JMenu();
        btmAñadirV = new javax.swing.JMenuItem();
        btmBuscarV = new javax.swing.JMenuItem();
        mnGéneros = new javax.swing.JMenu();
        btmAñadirG = new javax.swing.JMenuItem();
        btmBuscarG = new javax.swing.JMenuItem();
        mnEmpresas = new javax.swing.JMenu();
        btmAñadirE = new javax.swing.JMenuItem();
        btmBuscarE = new javax.swing.JMenuItem();
        mnAjustes = new javax.swing.JMenu();
        btmAbrirAjustes = new javax.swing.JMenuItem();
        btmEspañol = new javax.swing.JCheckBoxMenuItem();
        btmIngles = new javax.swing.JCheckBoxMenuItem();
        mnAyuda = new javax.swing.JMenu();
        btmAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1500, 750));
        setMinimumSize(new java.awt.Dimension(1000, 500));

        pnController.setBackground(new java.awt.Color(255, 255, 255));
        pnController.setLayout(new java.awt.CardLayout());

        pnDefault.setBackground(new java.awt.Color(255, 255, 255));
        pnDefault.setLayout(new java.awt.GridBagLayout());

        txtMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 330;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(120, 330, 127, 324);
        pnDefault.add(txtMain, gridBagConstraints);

        pnController.add(pnDefault, "D");

        pnAñadirV.setBackground(new java.awt.Color(204, 204, 204));
        pnAñadirV.setLayout(new java.awt.BorderLayout());

        pnBajo.setMinimumSize(new java.awt.Dimension(30, 30));
        pnBajo.setPreferredSize(new java.awt.Dimension(30, 30));
        pnBajo.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btmEliminarV.setBackground(new java.awt.Color(102, 102, 102));
        btmEliminarV.setForeground(new java.awt.Color(0, 0, 0));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Ajustes/Idiomas"); // NOI18N
        btmEliminarV.setText(bundle.getString("frmPadre.btmEliminarV.text")); // NOI18N
        btmEliminarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmEliminarVActionPerformed(evt);
            }
        });
        pnBajo.add(btmEliminarV);

        cmbVideoJuegos_Generos.setMinimumSize(new java.awt.Dimension(10, 10));
        cmbVideoJuegos_Generos.setPreferredSize(new java.awt.Dimension(10, 10));
        cmbVideoJuegos_Generos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVideoJuegos_GenerosActionPerformed(evt);
            }
        });
        pnBajo.add(cmbVideoJuegos_Generos);

        lblVResult.setText(bundle.getString("frmPadre.lblVResult.text")); // NOI18N
        lblVResult.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnBajo.add(lblVResult);

        btmLimpiarV.setBackground(new java.awt.Color(102, 102, 102));
        btmLimpiarV.setForeground(new java.awt.Color(0, 0, 0));
        btmLimpiarV.setText(bundle.getString("frmPadre.btmLimpiarV.text")); // NOI18N
        btmLimpiarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimpiarVActionPerformed(evt);
            }
        });
        pnBajo.add(btmLimpiarV);

        btmGuardarV.setBackground(new java.awt.Color(102, 102, 102));
        btmGuardarV.setForeground(new java.awt.Color(0, 0, 0));
        btmGuardarV.setText(bundle.getString("frmPadre.btmGuardarV.text")); // NOI18N
        btmGuardarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmGuardarVActionPerformed(evt);
            }
        });
        pnBajo.add(btmGuardarV);

        pnAñadirV.add(pnBajo, java.awt.BorderLayout.PAGE_END);

        pnCentro.setLayout(new java.awt.GridBagLayout());

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText(bundle.getString("frmPadre.jLabel4.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 110, 0, 0);
        pnCentro.add(jLabel4, gridBagConstraints);

        txtIdV.setBackground(new java.awt.Color(102, 102, 102));
        txtIdV.setForeground(new java.awt.Color(0, 0, 0));
        txtIdV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdVKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 40, 0, 0);
        pnCentro.add(txtIdV, gridBagConstraints);

        txtNombreV.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreV.setForeground(new java.awt.Color(0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 185;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 40, 0, 0);
        pnCentro.add(txtNombreV, gridBagConstraints);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(bundle.getString("frmPadre.jLabel5.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 110, 0, 0);
        pnCentro.add(jLabel5, gridBagConstraints);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText(bundle.getString("frmPadre.jLabel6.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 110, 0, 0);
        pnCentro.add(jLabel6, gridBagConstraints);

        txtImageV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 0, 0);
        pnCentro.add(txtImageV, gridBagConstraints);

        btmNuevaImagen.setBackground(new java.awt.Color(102, 102, 102));
        btmNuevaImagen.setForeground(new java.awt.Color(0, 0, 0));
        btmNuevaImagen.setText(bundle.getString("frmPadre.btmNuevaImagen.text")); // NOI18N
        btmNuevaImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmNuevaImagenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 0, 0);
        pnCentro.add(btmNuevaImagen, gridBagConstraints);

        lsInsertE.setBackground(new java.awt.Color(102, 102, 102));
        lsInsertE.setForeground(new java.awt.Color(0, 0, 0));
        lsInsertE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsInsertE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsInsertEMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lsInsertE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 90, 30, 10);
        pnCentro.add(jScrollPane3, gridBagConstraints);

        lsSelectE.setBackground(new java.awt.Color(102, 102, 102));
        lsSelectE.setForeground(new java.awt.Color(0, 0, 0));
        lsSelectE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsSelectE.setToolTipText(bundle.getString("frmPadre.lsSelectE.toolTipText")); // NOI18N
        lsSelectE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsSelectEMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lsSelectE);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 30, 50);
        pnCentro.add(jScrollPane4, gridBagConstraints);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(bundle.getString("frmPadre.jLabel7.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(-20, 80, 0, 0);
        pnCentro.add(jLabel7, gridBagConstraints);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(bundle.getString("frmPadre.jLabel8.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(-20, 45, 0, 0);
        pnCentro.add(jLabel8, gridBagConstraints);

        txtDescV.setBackground(new java.awt.Color(102, 102, 102));
        txtDescV.setColumns(20);
        txtDescV.setForeground(new java.awt.Color(0, 0, 0));
        txtDescV.setLineWrap(true);
        txtDescV.setRows(5);
        txtDescV.setWrapStyleWord(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 40, 30, 0);
        pnCentro.add(txtDescV, gridBagConstraints);

        pnAñadirV.add(pnCentro, java.awt.BorderLayout.CENTER);

        pnController.add(pnAñadirV, "V");

        pnAñadirG.setBackground(new java.awt.Color(204, 204, 204));
        pnAñadirG.setLayout(new java.awt.BorderLayout());

        pnBajoG.setMinimumSize(new java.awt.Dimension(30, 30));
        pnBajoG.setName(""); // NOI18N
        pnBajoG.setPreferredSize(new java.awt.Dimension(30, 30));
        pnBajoG.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btmEliminarG.setBackground(new java.awt.Color(102, 102, 102));
        btmEliminarG.setForeground(new java.awt.Color(0, 0, 0));
        btmEliminarG.setText(bundle.getString("frmPadre.btmEliminarG.text")); // NOI18N
        btmEliminarG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmEliminarGActionPerformed(evt);
            }
        });
        pnBajoG.add(btmEliminarG);
        pnBajoG.add(filler1);

        lblGResult.setText(bundle.getString("frmPadre.lblGResult.text")); // NOI18N
        lblGResult.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnBajoG.add(lblGResult);

        btmLimpiarG.setBackground(new java.awt.Color(102, 102, 102));
        btmLimpiarG.setForeground(new java.awt.Color(0, 0, 0));
        btmLimpiarG.setText(bundle.getString("frmPadre.btmLimpiarG.text")); // NOI18N
        btmLimpiarG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimpiarGActionPerformed(evt);
            }
        });
        pnBajoG.add(btmLimpiarG);

        btmGuardarG.setBackground(new java.awt.Color(102, 102, 102));
        btmGuardarG.setForeground(new java.awt.Color(0, 0, 0));
        btmGuardarG.setText(bundle.getString("frmPadre.btmGuardarG.text")); // NOI18N
        btmGuardarG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmGuardarGActionPerformed(evt);
            }
        });
        pnBajoG.add(btmGuardarG);

        pnAñadirG.add(pnBajoG, java.awt.BorderLayout.PAGE_END);

        pnCentroG.setLayout(new java.awt.GridBagLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(bundle.getString("frmPadre.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 300, 0, 0);
        pnCentroG.add(jLabel1, gridBagConstraints);

        txtIdG.setBackground(new java.awt.Color(102, 102, 102));
        txtIdG.setForeground(new java.awt.Color(0, 0, 0));
        txtIdG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdGKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 500);
        pnCentroG.add(txtIdG, gridBagConstraints);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(bundle.getString("frmPadre.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 300, 0, 0);
        pnCentroG.add(jLabel2, gridBagConstraints);

        txtNombreG.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreG.setForeground(new java.awt.Color(0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 150);
        pnCentroG.add(txtNombreG, gridBagConstraints);

        pnAñadirG.add(pnCentroG, java.awt.BorderLayout.CENTER);

        pnController.add(pnAñadirG, "G");

        pnAñadirE.setBackground(new java.awt.Color(204, 204, 204));
        pnAñadirE.setLayout(new java.awt.BorderLayout());

        pnBajoE.setMinimumSize(new java.awt.Dimension(30, 30));
        pnBajoE.setPreferredSize(new java.awt.Dimension(30, 30));
        pnBajoE.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btmEliminarE.setBackground(new java.awt.Color(102, 102, 102));
        btmEliminarE.setForeground(new java.awt.Color(0, 0, 0));
        btmEliminarE.setText(bundle.getString("frmPadre.btmEliminarE.text")); // NOI18N
        btmEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmEliminarEActionPerformed(evt);
            }
        });
        pnBajoE.add(btmEliminarE);
        pnBajoE.add(filler3);

        lblEResult.setText(bundle.getString("frmPadre.lblEResult.text")); // NOI18N
        lblEResult.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnBajoE.add(lblEResult);

        btmLimpiarE.setBackground(new java.awt.Color(102, 102, 102));
        btmLimpiarE.setForeground(new java.awt.Color(0, 0, 0));
        btmLimpiarE.setText(bundle.getString("frmPadre.btmLimpiarE.text")); // NOI18N
        btmLimpiarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimpiarEActionPerformed(evt);
            }
        });
        pnBajoE.add(btmLimpiarE);

        btmGuardarE.setBackground(new java.awt.Color(102, 102, 102));
        btmGuardarE.setForeground(new java.awt.Color(0, 0, 0));
        btmGuardarE.setText(bundle.getString("frmPadre.btmGuardarE.text")); // NOI18N
        btmGuardarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmGuardarEActionPerformed(evt);
            }
        });
        pnBajoE.add(btmGuardarE);

        pnAñadirE.add(pnBajoE, java.awt.BorderLayout.PAGE_END);

        pnCentroE.setLayout(new java.awt.GridBagLayout());

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText(bundle.getString("frmPadre.jLabel9.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 110, 0, 0);
        pnCentroE.add(jLabel9, gridBagConstraints);

        txtIdE.setBackground(new java.awt.Color(102, 102, 102));
        txtIdE.setForeground(new java.awt.Color(0, 0, 0));
        txtIdE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdEKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 0, 0);
        pnCentroE.add(txtIdE, gridBagConstraints);

        txtNombreE.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreE.setForeground(new java.awt.Color(0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 185;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 0, 0);
        pnCentroE.add(txtNombreE, gridBagConstraints);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText(bundle.getString("frmPadre.jLabel10.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 110, 0, 0);
        pnCentroE.add(jLabel10, gridBagConstraints);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText(bundle.getString("frmPadre.jLabel11.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 110, 0, 0);
        pnCentroE.add(jLabel11, gridBagConstraints);

        txtImageE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 0, 0);
        pnCentroE.add(txtImageE, gridBagConstraints);

        btmNuevaImagenE.setBackground(new java.awt.Color(102, 102, 102));
        btmNuevaImagenE.setForeground(new java.awt.Color(0, 0, 0));
        btmNuevaImagenE.setText(bundle.getString("frmPadre.btmNuevaImagenE.text")); // NOI18N
        btmNuevaImagenE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmNuevaImagenEActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 0, 0);
        pnCentroE.add(btmNuevaImagenE, gridBagConstraints);

        txtDescE.setBackground(new java.awt.Color(102, 102, 102));
        txtDescE.setColumns(20);
        txtDescE.setForeground(new java.awt.Color(0, 0, 0));
        txtDescE.setLineWrap(true);
        txtDescE.setRows(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 30, 0);
        pnCentroE.add(txtDescE, gridBagConstraints);

        lsInsertV.setBackground(new java.awt.Color(102, 102, 102));
        lsInsertV.setForeground(new java.awt.Color(0, 0, 0));
        lsInsertV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsInsertV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsInsertVMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(lsInsertV);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 80, 30, 20);
        pnCentroE.add(jScrollPane5, gridBagConstraints);

        lsSelectV.setBackground(new java.awt.Color(102, 102, 102));
        lsSelectV.setForeground(new java.awt.Color(0, 0, 0));
        lsSelectV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsSelectV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsSelectVMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(lsSelectV);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 30, 20);
        pnCentroE.add(jScrollPane6, gridBagConstraints);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(bundle.getString("frmPadre.jLabel12.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 80, 0, 20);
        pnCentroE.add(jLabel12, gridBagConstraints);

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(bundle.getString("frmPadre.jLabel13.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pnCentroE.add(jLabel13, gridBagConstraints);

        pnAñadirE.add(pnCentroE, java.awt.BorderLayout.CENTER);

        pnController.add(pnAñadirE, "E");

        getContentPane().add(pnController, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        mnVideoJuegos.setText(bundle.getString("frmPadre.mnVideoJuegos.text")); // NOI18N

        btmAñadirV.setText(bundle.getString("frmPadre.btmAñadirV.text")); // NOI18N
        btmAñadirV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmAñadirVActionPerformed(evt);
            }
        });
        mnVideoJuegos.add(btmAñadirV);

        btmBuscarV.setText(bundle.getString("frmPadre.btmBuscarV.text")); // NOI18N
        btmBuscarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmBuscarVActionPerformed(evt);
            }
        });
        mnVideoJuegos.add(btmBuscarV);

        jMenuBar1.add(mnVideoJuegos);

        mnGéneros.setText(bundle.getString("frmPadre.mnGéneros.text")); // NOI18N

        btmAñadirG.setText(bundle.getString("frmPadre.btmAñadirG.text")); // NOI18N
        btmAñadirG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmAñadirGActionPerformed(evt);
            }
        });
        mnGéneros.add(btmAñadirG);

        btmBuscarG.setText(bundle.getString("frmPadre.btmBuscarG.text")); // NOI18N
        btmBuscarG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmBuscarGActionPerformed(evt);
            }
        });
        mnGéneros.add(btmBuscarG);

        jMenuBar1.add(mnGéneros);

        mnEmpresas.setText(bundle.getString("frmPadre.mnEmpresas.text")); // NOI18N

        btmAñadirE.setText(bundle.getString("frmPadre.btmAñadirE.text")); // NOI18N
        btmAñadirE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmAñadirEActionPerformed(evt);
            }
        });
        mnEmpresas.add(btmAñadirE);

        btmBuscarE.setText(bundle.getString("frmPadre.btmBuscarE.text")); // NOI18N
        btmBuscarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmBuscarEActionPerformed(evt);
            }
        });
        mnEmpresas.add(btmBuscarE);

        jMenuBar1.add(mnEmpresas);

        mnAjustes.setText(bundle.getString("frmPadre.mnAjustes.text")); // NOI18N

        btmAbrirAjustes.setText(bundle.getString("frmPadre.btmAbrirAjustes.text")); // NOI18N
        btmAbrirAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmAbrirAjustesActionPerformed(evt);
            }
        });
        mnAjustes.add(btmAbrirAjustes);

        btmGroupIdiomas.add(btmEspañol);
        btmEspañol.setText(bundle.getString("frmPadre.btmEspañol.text")); // NOI18N
        btmEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmEspañolActionPerformed(evt);
            }
        });
        mnAjustes.add(btmEspañol);

        btmGroupIdiomas.add(btmIngles);
        btmIngles.setText(bundle.getString("frmPadre.btmIngles.text")); // NOI18N
        btmIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmInglesActionPerformed(evt);
            }
        });
        mnAjustes.add(btmIngles);

        jMenuBar1.add(mnAjustes);

        mnAyuda.setText(bundle.getString("frmPadre.mnAyuda.text")); // NOI18N

        btmAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        btmAyuda.setText(bundle.getString("frmPadre.btmAyuda.text")); // NOI18N
        mnAyuda.add(btmAyuda);

        jMenuBar1.add(mnAyuda);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1000, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btmAñadirVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmAñadirVActionPerformed
        cardLayout.show(pnController, "V");
    }//GEN-LAST:event_btmAñadirVActionPerformed

    private void btmBuscarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmBuscarVActionPerformed
        if (!Interfaz.WindowChecker.get(0)) {
            dgBuscador buscador = new dgBuscador(this, false, LocalVideoJuego == null ? new VideoJuegos() : LocalVideoJuego, cardLayout, pnController);
            Interfaz.WindowChecker.set(0, true);
            buscador.setVisible(true);
        }
    }//GEN-LAST:event_btmBuscarVActionPerformed

    private void btmBuscarGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmBuscarGActionPerformed
        if (!Interfaz.WindowChecker.get(1)) {
            dgBuscador buscador = new dgBuscador(this, false, LocalGenero == null ? new Generos() : LocalGenero, cardLayout, pnController);
            Interfaz.WindowChecker.set(1, true);
            buscador.setVisible(true);
        }
    }//GEN-LAST:event_btmBuscarGActionPerformed

    private void btmAñadirGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmAñadirGActionPerformed
        cardLayout.show(pnController, "G");

    }//GEN-LAST:event_btmAñadirGActionPerformed

    private void txtIdGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdGKeyPressed
        if (evt.getKeyCode() == 10) {
            Generos g = GenerosSQL.BuscarGenero("Id", txtIdG.getText(), "Id").stream().findFirst().orElse(null);
            if (g != null) {
                SetGenero(g);
            } else {
                JOptionPane.showMessageDialog(null, PropertiesCache.Idiomas.getString("NoEncontrado"));
                txtNombreG.setText("");
                txtIdG.setText("");
                setLocalGenero(null);
            }
        }
    }//GEN-LAST:event_txtIdGKeyPressed

    private void btmEliminarGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmEliminarGActionPerformed
        ArrayList<VideoJuegos> list = new ArrayList<>();
        try {
            if (LocalGenero == null) {
                throw new PersonalizedExc(PropertiesCache.Idiomas.getString("IdVaciaG"));
            }
            ConexionSQL.getBD().setAutoCommit(false);
            list = VideoJuegosSQL.BuscarVideoJuego(null, "Genero", LocalGenero.getId().toString(), null);
            GenerosSQL.BorrarVideoJuegos("Genero", LocalGenero.getId().toString());
            GenerosSQL.BorrarGenero("Id", LocalGenero.getId().toString(), list);
            HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblGResult, GetString("Eliminado"), false);
            h.start();
            ConexionSQL.getBD().commit();
        } catch (PersonalizedExc personalizedExc) {
            personalizedExc.GetError(personalizedExc.getMessage());
        } catch (Exception e) {
            try {
                JOptionPane.showMessageDialog(null, GetString("AlgoSalioMal"));
                ConexionSQL.getBD().rollback();
                list.forEach((t) -> {
                    Interfaz.modelV.add(Interfaz.modelV.getSize(), t);
                });
            } catch (SQLException ex) {
                Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                ConexionSQL.getBD().setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtIdG.setText("");
        txtNombreG.setText("");
        setLocalGenero(null);
        RecargarGenerosCMB();
    }//GEN-LAST:event_btmEliminarGActionPerformed

    private void btmGuardarGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmGuardarGActionPerformed
        try {
            if (LocalGenero == null) {
                if (LocalGenero == null && !txtIdG.getText().isEmpty() && JOptionPane.showConfirmDialog(null, PropertiesCache.Idiomas.getString("CodNoSirve")) != 0) {
                    return;
                }
                if (txtNombreG.getText().isEmpty()) {
                    throw new PersonalizedExc(PropertiesCache.Idiomas.getString("DatosVaciosG"));
                }
                GenerosSQL.Anhadir(txtNombreG.getText());
                setLocalGenero(GenerosSQL.BuscarGenero(null, null, "Auth_CreadoFecha desc").stream().findFirst().get());
                HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblGResult, GetString("Guardado"), true);
                h.start();
            } else {
                GenerosSQL.Update(LocalGenero.getId(), txtNombreG.getText());
                setLocalGenero(GenerosSQL.BuscarGenero("Id", LocalGenero.getId().toString(), "Id asc").stream().findFirst().get());
                HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblGResult, GetString("Actualizado"), true);
                h.start();
            }
            RecargarGenerosCMB();
            txtIdG.setText(LocalGenero.getId().toString());
        } catch (PersonalizedExc personalizedExc) {
            personalizedExc.GetError(personalizedExc.getMessage());
        }
        RecargarGenerosCMB();
    }//GEN-LAST:event_btmGuardarGActionPerformed

    private void btmAbrirAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmAbrirAjustesActionPerformed
        dgAjustes frm = new dgAjustes(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_btmAbrirAjustesActionPerformed

    private void txtIdVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdVKeyPressed
        if (evt.getKeyCode() == 10) {
            VideoJuegos v = VideoJuegosSQL.BuscarVideoJuego("1", "Id", txtIdV.getText(), "Auth_CreadoFecha desc").stream().findFirst().orElse(null);
            if (v != null) {
                try {
                    SetVideoJuego(v);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, PropertiesCache.Idiomas.getString("NoEncontrado"));
                LimpiarVideojuego();
            }
        }
    }//GEN-LAST:event_txtIdVKeyPressed

    private void btmGuardarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmGuardarVActionPerformed
        try {
            if (txtNombreV.getText().isEmpty() || txtDescV.getText().isEmpty() || cmbVideoJuegos_Generos.getSelectedItem() == null) {
                throw new PersonalizedExc(PropertiesCache.Idiomas.getString("DatosVaciosG"));
            }
            if (LocalVideoJuego == null && !txtIdV.getText().isEmpty() && JOptionPane.showConfirmDialog(null, PropertiesCache.Idiomas.getString("CodNoSirve")) != 0) {
                return;
            }
            if (Interfaz.modelE_Insert.getAll().isEmpty() && JOptionPane.showConfirmDialog(null, PropertiesCache.Idiomas.getString("EmpresaVacia")) != 0) {
                return;
            }
            if (LocalVideoJuego == null) {
                VideoJuegosSQL.Anhadir(txtNombreV.getText(), txtDescV.getText(), VideoJuegoImagen, (Generos) cmbVideoJuegos_Generos.getSelectedItem());
                this.setLocalVideoJuego(VideoJuegosSQL.BuscarVideoJuego("1", null, null, "Auth_CreadoFecha desc").stream().findFirst().get());
                txtIdV.setText(LocalVideoJuego.getId().toString());
                ArrayList<Empresas> values = (ArrayList<Empresas>) (Object) Interfaz.modelE_Insert.getAll();
                if (!values.isEmpty()) {
                    VideoJuegosSQL.InsertarVideoJuegos_Empresa(LocalVideoJuego, Collections.enumeration(values));
                }
                Interfaz.modelV.addList(Interfaz.modelV.size(), LocalVideoJuego);
                HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblVResult, GetString("Guardado"), true);
                h.start();
            } else {
                VideoJuegosSQL.Update(LocalVideoJuego.getId(), txtNombreV.getText(), txtDescV.getText(), ((Generos) cmbVideoJuegos_Generos.getSelectedItem()).getId(), VideoJuegoImagen);
                this.setLocalVideoJuego(VideoJuegosSQL.BuscarVideoJuego("1", null, null, "Auth_ActualizadoFecha desc").stream().findFirst().get());
                ArrayList<Empresas> values = (ArrayList<Empresas>) (Object) Interfaz.modelE_Insert.getAll();
                ArrayList<Empresas> deleteValues = (ArrayList<Empresas>) (Object) Interfaz.modelE.getAll();
                if (!deleteValues.isEmpty()) {
                    VideoJuegosSQL.BorrarEmpresa(LocalVideoJuego, Collections.enumeration(deleteValues));
                }
                if (!values.isEmpty()) {
                    VideoJuegosSQL.InsertarVideoJuegos_Empresa(LocalVideoJuego, Collections.enumeration(values));
                }
                Interfaz.modelV.update(LocalVideoJuego);
                Interfaz.modelV_Insert.update(LocalVideoJuego);
                HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblVResult, GetString("Actualizado"), true);
                h.start();
            }
        } catch (PersonalizedExc per) {
            per.GetError(per.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btmGuardarVActionPerformed

    private void btmNuevaImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmNuevaImagenActionPerformed
        VideoJuegoImagen = InputStreamToImageIcon.bufferedImageToInputStream(FileChooser.SetNewIcon(txtImageV, this));
    }//GEN-LAST:event_btmNuevaImagenActionPerformed

    private void btmEliminarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmEliminarVActionPerformed
        try {
            if (LocalVideoJuego == null) {
                throw new PersonalizedExc(PropertiesCache.Idiomas.getString("IdVacia"));
            }
            ConexionSQL.getBD().setAutoCommit(false);
            VideoJuegosSQL.BorrarRelacion("IdV", null, LocalVideoJuego.getId().toString(), null, null, null);
            VideoJuegosSQL.BorrarVideoJuego("Id", LocalVideoJuego.getId().toString());
            Server_FTP.BorrarImage("VideoJuegos", LocalVideoJuego.getId().toString());
            Interfaz.modelV.remove(LocalVideoJuego);
            Interfaz.modelV_Insert.remove(LocalVideoJuego);
            LimpiarVideojuego();
            ConexionSQL.getBD().commit();
            HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblVResult, GetString("Eliminado"), false);
            h.start();
            ConexionSQL.getBD().commit();
        } catch (PersonalizedExc per) {
            per.GetError(per.getMessage());
        } catch (Exception e) {
            try {
                ConexionSQL.getBD().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                ConexionSQL.getBD().setAutoCommit(true);
            } catch (Exception ex) {
                Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btmEliminarVActionPerformed

    private void btmLimpiarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimpiarVActionPerformed
        LimpiarVideojuego();
    }//GEN-LAST:event_btmLimpiarVActionPerformed

    private void btmLimpiarGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimpiarGActionPerformed
        setLocalGenero(null);
        txtIdG.setText("");
        txtNombreG.setText("");
    }//GEN-LAST:event_btmLimpiarGActionPerformed

    private void lsSelectEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsSelectEMouseClicked
        if (evt.getClickCount() > 2) {
            if (!Interfaz.modelE_Insert.contains(lsSelectE.getSelectedValue())) {
                Interfaz.modelE_Insert.addList(Interfaz.modelE_Insert.size(), lsSelectE.getSelectedValue());
            }
        }
    }//GEN-LAST:event_lsSelectEMouseClicked

    private void lsInsertEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsInsertEMouseClicked
        if (evt.getClickCount() > 2) {
            if (Interfaz.modelE_Insert.contains(lsInsertE.getSelectedValue())) {
                Interfaz.modelE_Insert.removeList(lsInsertE.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_lsInsertEMouseClicked

    private void btmBuscarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmBuscarEActionPerformed
        if (!Interfaz.WindowChecker.get(2)) {
            dgBuscador buscador = new dgBuscador(this, false, LocalEmpresa == null ? new Empresas() : LocalEmpresa, cardLayout, pnController);
            Interfaz.WindowChecker.set(2, true);
            buscador.setVisible(true);
        }
    }//GEN-LAST:event_btmBuscarEActionPerformed

    private void txtIdEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdEKeyPressed
        if (evt.getKeyCode() == 10) {
            try {
                Empresas e = EmpresaSQL.BuscarEmpresa("Id", txtIdE.getText(), "Auth_CreadoFecha desc").stream().findFirst().orElseThrow();
                if (e != null) {
                    SetEmpresa(e);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, PropertiesCache.Idiomas.getString("NoEncontrado"));
                LimpiarEmpresa();
            }
        }
    }//GEN-LAST:event_txtIdEKeyPressed

    private void btmEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmEliminarEActionPerformed
        if (LocalEmpresa == null) {
            JOptionPane.showMessageDialog(null, PropertiesCache.Idiomas.getString("IdVacia"));
            return;
        }
        try {
            ConexionSQL.getBD().setAutoCommit(false);
            ResultSet rs = VideoJuegosSQL.BuscarEmpresa("IdE", txtIdE.getText(), null);
            if (rs.next()) {
                if (JOptionPane.showConfirmDialog(null, PropertiesCache.Idiomas.getString("TieneVideojuegos")) != 0) {
                    return;
                }
                VideoJuegosSQL.BorrarRelacion(null, null, null, "IdE", null, txtIdE.getText());
            }
            EmpresaSQL.BorrarEmpresa("Id", txtIdE.getText());
            ConexionSQL.getBD().commit();
            Interfaz.modelE.remove(LocalEmpresa);
            Interfaz.modelE_Insert.remove(LocalEmpresa);
            Server_FTP.BorrarImage("Empresas", LocalEmpresa.getId().toString());
            LimpiarEmpresa();
            HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblEResult, GetString("Eliminado"), false);
            h.start();
            ConexionSQL.getBD().commit();
        } catch (Exception e) {
            try {
                ConexionSQL.getBD().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                ConexionSQL.getBD().setAutoCommit(true);
            } catch (Exception ex) {
                Logger.getLogger(frmPadre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btmEliminarEActionPerformed

    private void btmLimpiarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimpiarEActionPerformed
        LimpiarEmpresa();
    }//GEN-LAST:event_btmLimpiarEActionPerformed

    private void btmGuardarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmGuardarEActionPerformed
        try {
            if (txtNombreE.getText().isEmpty() || txtDescE.getText().isEmpty()) {
                throw new PersonalizedExc(PropertiesCache.Idiomas.getString("DatosVaciosG"));
            }
            if (LocalEmpresa == null && !txtIdE.getText().isEmpty() && JOptionPane.showConfirmDialog(null, PropertiesCache.Idiomas.getString("CodNoSirve")) != 0) {
                return;
            }
            ConexionSQL.getBD().setAutoCommit(false);
            if (LocalEmpresa == null) {
                EmpresaSQL.Anhadir(txtNombreE.getText(), txtDescE.getText(), EmpresaImagen);
                setLocalEmpresa(EmpresaSQL.BuscarEmpresa(null, null, "Auth_CreadoFecha desc").stream().findFirst().get());
                Interfaz.modelE.addList(Interfaz.modelE.getSize(), LocalEmpresa);
                ArrayList<VideoJuegos> values = (ArrayList<VideoJuegos>) (Object) Interfaz.modelV_Insert.getAll();
                if (!values.isEmpty()) {
                    EmpresaSQL.AnhadirVideoJuego(LocalEmpresa, Collections.enumeration(values));
                }
                HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblEResult, GetString("Guardado"), true);
                h.start();
            } else {
                Interfaz.modelE_Insert.removeElement(LocalEmpresa);
                EmpresaSQL.Update(txtNombreE.getText(), txtDescE.getText(), LocalEmpresa.getId(), EmpresaImagen);
                setLocalEmpresa(EmpresaSQL.BuscarEmpresa(null, null, "Auth_ActualizadoFecha desc").stream().findFirst().get());
                ArrayList<GeneralClass> values = Interfaz.modelV_Insert.getAll();
                ArrayList<GeneralClass> deleteValues = Interfaz.modelV.getAll();
                if (!deleteValues.isEmpty()) {
                    VideoJuegosSQL.BorrarRelacion(null, null, null, "IdE", "=", LocalEmpresa.getId().toString());
                }
                if (!values.isEmpty()) {
                    ResultSet rs = VideoJuegosSQL.BuscarEmpresa("IdE", LocalEmpresa.getId().toString(), null);
                    while (rs.next()) {
                        int value = rs.getInt(1);
                        boolean canBeRemoved = false;
                        VideoJuegos v = null;
                        for (GeneralClass videoJuegos : values) {
                            if (videoJuegos.getId() == value) {
                                canBeRemoved = true;
                                v = (VideoJuegos) videoJuegos;
                            }
                        }
                        if (canBeRemoved) {
                            values.remove(v);
                        }
                    }
                    ArrayList<VideoJuegos> valuesUpdate = new ArrayList<>();
                    for (GeneralClass deleteValue : values) {
                        valuesUpdate.add((VideoJuegos) deleteValue);
                    }
                    EmpresaSQL.AnhadirVideoJuego(LocalEmpresa, Collections.enumeration(valuesUpdate));
                }
                Interfaz.modelE.update(LocalEmpresa);
                Interfaz.modelE_Insert.update(LocalEmpresa);
                HiloGestorNotificaciones h = new HiloGestorNotificaciones(lblEResult, GetString("Actualizado"), true);
                h.start();
            }
            SetEmpresa(LocalEmpresa);
        } catch (PersonalizedExc per) {
            per.GetError(per.getMessage());
        } catch (Exception e) {
            try {
                e.printStackTrace();
                ConexionSQL.getBD().rollback();

            } catch (SQLException ex) {
                Logger.getLogger(frmPadre.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                ConexionSQL.getBD().setAutoCommit(true);

            } catch (SQLException ex) {
                Logger.getLogger(frmPadre.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btmGuardarEActionPerformed

    private void btmNuevaImagenEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmNuevaImagenEActionPerformed
        EmpresaImagen = InputStreamToImageIcon.bufferedImageToInputStream(FileChooser.SetNewIcon(txtImageE, this));
    }//GEN-LAST:event_btmNuevaImagenEActionPerformed

    private void btmAñadirEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmAñadirEActionPerformed
        cardLayout.show(pnController, "E");
    }//GEN-LAST:event_btmAñadirEActionPerformed

    private void lsInsertVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsInsertVMouseClicked
        if (evt.getClickCount() > 2) {
            if (Interfaz.modelV_Insert.contains(lsInsertV.getSelectedValue())) {
                Interfaz.modelV_Insert.remove(lsInsertV.getSelectedValue());
            }
        }
    }//GEN-LAST:event_lsInsertVMouseClicked

    private void lsSelectVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsSelectVMouseClicked
        if (evt.getClickCount() > 2) {
            if (!Interfaz.modelV_Insert.contains(lsSelectV.getSelectedValue())) {
                Interfaz.modelV_Insert.addList(Interfaz.modelV_Insert.size(), lsSelectV.getSelectedValue());
            }
        }
    }//GEN-LAST:event_lsSelectVMouseClicked

    private void btmEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmEspañolActionPerformed
        btmEspañol.setSelected(true);
        Locale l = new Locale("es", "ES");
        Locale.setDefault(l);
        I18N();
    }//GEN-LAST:event_btmEspañolActionPerformed

    private void btmInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmInglesActionPerformed
        btmIngles.setSelected(true);
        Locale l = new Locale("en", "GB");
        Locale.setDefault(l);
        I18N();
    }//GEN-LAST:event_btmInglesActionPerformed

    private void cmbVideoJuegos_GenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVideoJuegos_GenerosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVideoJuegos_GenerosActionPerformed

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
            java.util.logging.Logger.getLogger(frmPadre.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPadre.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPadre.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPadre.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPadre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btmAbrirAjustes;
    private javax.swing.JMenuItem btmAyuda;
    private javax.swing.JMenuItem btmAñadirE;
    private javax.swing.JMenuItem btmAñadirG;
    private javax.swing.JMenuItem btmAñadirV;
    private javax.swing.JMenuItem btmBuscarE;
    private javax.swing.JMenuItem btmBuscarG;
    private javax.swing.JMenuItem btmBuscarV;
    private javax.swing.JButton btmEliminarE;
    private javax.swing.JButton btmEliminarG;
    private javax.swing.JButton btmEliminarV;
    private javax.swing.JCheckBoxMenuItem btmEspañol;
    private javax.swing.ButtonGroup btmGroupIdiomas;
    private javax.swing.JButton btmGuardarE;
    private javax.swing.JButton btmGuardarG;
    private javax.swing.JButton btmGuardarV;
    private javax.swing.JCheckBoxMenuItem btmIngles;
    private javax.swing.JButton btmLimpiarE;
    private javax.swing.JButton btmLimpiarG;
    private javax.swing.JButton btmLimpiarV;
    private javax.swing.JButton btmNuevaImagen;
    private javax.swing.JButton btmNuevaImagenE;
    private javax.swing.JComboBox<Generos> cmbVideoJuegos_Generos;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblEResult;
    private javax.swing.JLabel lblGResult;
    private javax.swing.JLabel lblVResult;
    private javax.swing.JList<Empresas> lsInsertE;
    private javax.swing.JList<VideoJuegos> lsInsertV;
    private javax.swing.JList<Empresas> lsSelectE;
    private javax.swing.JList<VideoJuegos> lsSelectV;
    private javax.swing.JMenu mnAjustes;
    private javax.swing.JMenu mnAyuda;
    private javax.swing.JMenu mnEmpresas;
    private javax.swing.JMenu mnGéneros;
    private javax.swing.JMenu mnVideoJuegos;
    private javax.swing.JPanel pnAñadirE;
    private javax.swing.JPanel pnAñadirG;
    private javax.swing.JPanel pnAñadirV;
    private javax.swing.JPanel pnBajo;
    private javax.swing.JPanel pnBajoE;
    private javax.swing.JPanel pnBajoG;
    private javax.swing.JPanel pnCentro;
    private javax.swing.JPanel pnCentroE;
    private javax.swing.JPanel pnCentroG;
    private javax.swing.JPanel pnController;
    private javax.swing.JPanel pnDefault;
    private javax.swing.JTextArea txtDescE;
    private javax.swing.JTextArea txtDescV;
    private javax.swing.JTextField txtIdE;
    private javax.swing.JTextField txtIdG;
    private javax.swing.JTextField txtIdV;
    private javax.swing.JLabel txtImageE;
    private javax.swing.JLabel txtImageV;
    private javax.swing.JLabel txtMain;
    private javax.swing.JTextField txtNombreE;
    private javax.swing.JTextField txtNombreG;
    private javax.swing.JTextField txtNombreV;
    // End of variables declaration//GEN-END:variables

    private void InitScreens() throws URISyntaxException {
        this.setIconImage(new ImageIcon(this.getClass().getResource("/Assets/Mando.png")).getImage());

        txtImageV.setIcon(GetIconFromAssets.GetIcon(this.getClass().getResourceAsStream("/Assets/NoImage.png")));
        VideoJuegoImagen = this.getClass().getResourceAsStream("/Assets/NoImage.png");

        txtImageE.setIcon(GetIconFromAssets.GetIcon(this.getClass().getResourceAsStream("/Assets/NoImageE.png")));
        EmpresaImagen = this.getClass().getResourceAsStream("/Assets/NoImageE.png");

        txtMain.setIcon(GetIconFromAssets.GetIcon(this.getClass().getResourceAsStream("/Assets/MandoPNG.png")));

        ArrayList<Empresas> list = EmpresaSQL.BuscarEmpresa(null, null, null);
        lsSelectE.setModel(Interfaz.modelE);
        lsInsertE.setModel(Interfaz.modelE_Insert);
        for (Empresas empresas : list) {
            Interfaz.modelE.addList(Interfaz.modelE.size(), empresas);
        }

        ArrayList<VideoJuegos> listV = VideoJuegosSQL.BuscarVideoJuego(null, null, null, null);
        lsSelectV.setModel(Interfaz.modelV);
        lsInsertV.setModel(Interfaz.modelV_Insert);
        for (VideoJuegos videoJuegos : listV) {
            Interfaz.modelV.addList(Interfaz.modelV.size(), videoJuegos);
        }
        RecargarGenerosCMB();

        txtIdV.setDocument(new LengthRestrictedDocument(10));
        txtNombreV.setDocument(new LengthRestrictedDocument(50));
        txtDescV.setDocument(new LengthRestrictedDocument(100));

        txtNombreE.setDocument(new LengthRestrictedDocument(50));
        txtDescE.setDocument(new LengthRestrictedDocument(100));
        txtIdE.setDocument(new LengthRestrictedDocument(10));

        txtIdG.setDocument(new LengthRestrictedDocument(10));
        txtNombreG.setDocument(new LengthRestrictedDocument(50));
    }

    private void RecargarGenerosCMB() {
        cmbVideoJuegos_Generos.removeAllItems();
        ArrayList<Generos> listG = GenerosSQL.BuscarGenero(null, null, null);
        for (Generos generos : listG) {
            cmbVideoJuegos_Generos.addItem(generos);
        }
    }

    private void LimpiarVideojuego() {
        txtIdV.setText("");
        txtDescV.setText("");
        txtImageV.setIcon(GetIconFromAssets.GetIcon(this.getClass().getResourceAsStream("/Assets/NoImage.png")));
        txtNombreV.setText("");
        Interfaz.modelE_Insert.removeAllElements();
        this.setLocalVideoJuego(null);
        VideoJuegoImagen = this.getClass().getResourceAsStream("/Assets/NoImage.png");
    }

    public void SetEmpresa(Empresas e) throws Exception {
        if (e != null) {
            txtNombreE.setText(e.getNombre());
            txtDescE.setText(e.getDescripcion());
            txtIdE.setText(e.getId().toString());
            Server_FTP.GetImage("Empresas", e.getId().toString(), txtImageE, this);
            EmpresaImagen = new FileInputStream(new File("./TempE.png"));
            Interfaz.modelV_Insert.removeAllElements();
            try (ResultSet rs = VideoJuegosSQL.BuscarEmpresa("IdE", e.getId().toString(), null)) {
                while (rs.next()) {
                    Interfaz.modelV.getAll().forEach((t)
                            -> {
                        try {
                            if (rs.getInt(1) == ((VideoJuegos) t).getId()) {
                                Interfaz.modelV_Insert.addList(Interfaz.modelV_Insert.getSize(), (VideoJuegos) t);

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(frmPadre.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
            setLocalEmpresa(e);
        }
    }

    public void SetVideoJuego(VideoJuegos v) throws Exception {
        if (v != null) {
            txtNombreV.setText(v.getNombre());
            txtDescV.setText(v.getDescripcion());
            txtIdV.setText(v.getId().toString());
            Server_FTP.GetImage("VideoJuegos", v.getId().toString(), txtImageV, this);
            VideoJuegoImagen = new FileInputStream(new File("./TempV.png"));
            this.setLocalVideoJuego(v);
            for (int i = 0; i < cmbVideoJuegos_Generos.getItemCount(); i++) {
                if (Objects.equals(cmbVideoJuegos_Generos.getItemAt(i).getId(), LocalVideoJuego.getGenero().getId())) {
                    cmbVideoJuegos_Generos.setSelectedItem(cmbVideoJuegos_Generos.getItemAt(i));
                }
            }
            try (ResultSet rs = VideoJuegosSQL.BuscarEmpresa("IdV", v.getId().toString(), null)) {
                Interfaz.modelE_Insert.removeAllElements();
                while (rs.next()) {
                    Interfaz.modelE.getAll().forEach((t) -> {
                        try {
                            if (rs.getInt(2) == t.getId()) {
                                Interfaz.modelE_Insert.addList(Interfaz.modelE_Insert.getSize(), t);

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(frmPadre.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        }
    }

    public void SetGenero(Generos g) {
        if (g != null) {
            txtNombreG.setText(g.getNombre());
            setLocalGenero(g);
            txtIdG.setText(g.getId().toString());
        }
    }

    private void LimpiarEmpresa() {
        txtIdE.setText("");
        txtDescE.setText("");
        txtImageE.setIcon(GetIconFromAssets.GetIcon(this.getClass().getResourceAsStream("/Assets/NoImageE.png")));
        txtNombreE.setText("");
        Interfaz.modelV_Insert.removeAllElements();
        setLocalEmpresa(null);
        EmpresaImagen = this.getClass().getResourceAsStream("/Assets/NoImageE.png");
    }

    private void I18N() {
        PropertiesCache.Idiomas = ResourceBundle.getBundle("Ajustes.Idiomas");
        mnAyuda.setText(GetString("frmPadre.mnAyuda.text"));
        mnAjustes.setText(GetString("frmPadre.mnAjustes.text"));
        mnEmpresas.setText(GetString("frmPadre.mnEmpresas.text"));
        mnGéneros.setText(GetString("frmPadre.mnGéneros.text"));
        mnVideoJuegos.setText(GetString("frmPadre.mnVideoJuegos.text"));

        btmAñadirE.setText(GetString("frmPadre.btmAñadirE.text"));
        btmBuscarE.setText(GetString("frmPadre.btmBuscarE.text"));
        btmAñadirG.setText(GetString("frmPadre.btmAñadirG.text"));
        btmBuscarG.setText(GetString("frmPadre.btmBuscarG.text"));
        btmAñadirV.setText(GetString("frmPadre.btmAñadirV.text"));
        btmBuscarV.setText(GetString("frmPadre.btmBuscarV.text"));

        btmEspañol.setText(GetString("frmPadre.btmEspañol.text"));
        btmIngles.setText(GetString("frmPadre.btmIngles.text"));

        jLabel5.setText(GetString("frmPadre.jLabel5.text"));
        jLabel4.setText(GetString("frmPadre.jLabel4.text"));

        btmGuardarG.setText(GetString("frmPadre.btmGuardarG.text"));
        btmAbrirAjustes.setText(GetString("frmPadre.btmAbrirAjustes.text"));

        btmNuevaImagenE.setText(GetString("frmPadre.btmNuevaImagenE.text"));
        btmGuardarE.setText(GetString("frmPadre.btmGuardarE.text"));
        btmNuevaImagen.setText(GetString("frmPadre.btmNuevaImagen.text"));
        btmGuardarV.setText(GetString("frmPadre.btmGuardarV.text"));
        btmLimpiarE.setText(GetString("frmPadre.btmLimpiarE.text"));
        btmLimpiarV.setText(GetString("frmPadre.btmLimpiarV.text"));
        btmEliminarE.setText(GetString("frmPadre.btmEliminarE.text"));
        btmEliminarV.setText(GetString("frmPadre.btmEliminarV.text"));
        btmEliminarG.setText(GetString("frmPadre.btmEliminarG.text"));
        btmLimpiarG.setText(GetString("frmPadre.btmLimpiarG.text"));
        jLabel2.setText(GetString("frmPadre.jLabel2.text"));
        jLabel1.setText(GetString("frmPadre.jLabel1.text"));
        jLabel8.setText(GetString("frmPadre.jLabel8.text"));
        jLabel7.setText(GetString("frmPadre.jLabel7.text"));
        jLabel13.setText(GetString("frmPadre.jLabel13.text"));
        jLabel12.setText(GetString("frmPadre.jLabel12.text"));
        jLabel11.setText(GetString("frmPadre.jLabel11.text"));
        jLabel13.setText(GetString("frmPadre.jLabel13.text"));
        jLabel6.setText(GetString("frmPadre.jLabel6.text"));
        jLabel10.setText(GetString("frmPadre.jLabel10.text"));
        jLabel9.setText(GetString("frmPadre.jLabel9.text"));
        btmAyuda.setText(GetString("frmPadre.btmAyuda.text"));
    }

    private String GetString(String v) {
        return PropertiesCache.Idiomas.getString(v);
    }
}
