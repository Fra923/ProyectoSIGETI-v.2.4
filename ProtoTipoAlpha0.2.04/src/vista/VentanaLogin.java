package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VentanaLogin extends JFrame {//miniVentana donde se ingresa a la aplicacion

    private JLabel lbTitulo;
    private JLabel lbIndicaciones;
    private JLabel lbCorreo;
    private JLabel lbDominioCorreo;
    private JLabel lbContraseña;
    private JLabel lbOlvidoClave;
    //--o--
    private JTextField txtCorreo;
    private JPasswordField txtContraseña;
    //--o--
    private JButton btnIngresar;
    private JButton btnRegistrarse;
    private JButton btnCancelar;
    //--o--
    private JCheckBox ckRecordar;
    //--o--
    private PanelConFondo panelPrincipal;    
    //--o--
    private static VentanaLogin instancia = null;

    private VentanaLogin() {
        super("Acceso SIGETI");
        ajustarConfiguracionInicial();        
        ajustarComponentes(getContentPane());
        ajustarEventos();
    }//----------------------------------------------------------END_Constructor

    public static VentanaLogin obtenerInstancia() {//asi garantizamos que solo aya una ventana
        if (instancia == null) {
            instancia = new VentanaLogin();
        }
        return instancia;
    }//-----------------------------------------------------END_obtenerInstancia

    private void ajustarConfiguracionInicial() {
        setSize(425, 279);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });
        cambioIcono();
    }//----------------------------------------------------------END_ConfInicial

    public void cambioIcono() {//establece el icono de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/user-login-iconx128.png"));
        setIconImage(icon);
    }//----------------------------------------------------------END_cambioIcono

    public void mostrar() {//para mostar el JFRAME
        this.setVisible(true);
        repaint();
    }//--------------------------------------------------------------END_MOSTRAR

    public void ocultar() {// oculta la ventana de ser necesario
        this.setVisible(false);
    }//--------------------------------------------------------------END_OCULTAR

    private void ajustarComponentes(Container c) {
        iniciarComponentes();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        JPanel panelCuadro = new JPanel();
        panelCuadro.setOpaque(false);
        panelCuadro.setLayout(new GridLayout(4, 3, 5, 5));

        panelCuadro.add(Box.createRigidArea(new Dimension(20, 2)));
        panelCuadro.add(Box.createRigidArea(new Dimension(0, 0)));
        panelCuadro.add(Box.createRigidArea(new Dimension(0, 0)));

        panelCuadro.add(lbCorreo);
        panelCuadro.add(txtCorreo);
        panelCuadro.add(lbDominioCorreo);

        panelCuadro.add(lbContraseña);
        panelCuadro.add(txtContraseña);
        panelCuadro.add(Box.createRigidArea(new Dimension(0, 0)));
        //panelCuadro.setBorder(new TitledBorder(""));
        //--o--
        JPanel panelOpciones = new JPanel();
        panelOpciones.setOpaque(false);
        panelOpciones.setLayout(new GridLayout(1, 4, 0, 0));
        panelOpciones.add(Box.createRigidArea(new Dimension(0, 0)));
        panelOpciones.add(ckRecordar);
        panelOpciones.add(lbOlvidoClave);
        panelOpciones.add(Box.createRigidArea(new Dimension(0, 0)));
        //--o--
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new FlowLayout());

        panelBotones.add(btnIngresar);
        panelBotones.add(btnRegistrarse);
        panelBotones.add(btnCancelar);
        //--o--
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(false);
        panelTitulo.add(lbTitulo, BorderLayout.CENTER);
        JPanel panelIndicaciones = new JPanel();
        panelIndicaciones.setOpaque(false);
        panelIndicaciones.add(lbIndicaciones, BorderLayout.CENTER);
        //--o--
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.add(panelCuadro);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(panelIndicaciones);
        panelPrincipal.add(p);
        panelPrincipal.add(panelOpciones);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(panelBotones);
        panelPrincipal.setBorder(new TitledBorder(""));
        c.add(panelPrincipal);
        pack();
        //--o--
    }//----------------------------------------------------------END_AjustarComp
    
    
    
    private void ajustarEventos() {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                cerrarAplicacion();
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana.obtenerInstancia().setTipoUsuario(txtCorreo.getText());
                limpiar();
                ocultar();
                Ventana.obtenerInstancia().mostrar();
                //validacion requerida a futuro                
            }
        });
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana.obtenerInstancia().setTipoUsuario(null);
                limpiar();                
                Ventana.obtenerInstancia().registrar();
                ocultar();
                Ventana.obtenerInstancia().mostrar();
            }
        });
        lbOlvidoClave.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("hizo Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("hizo Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("hizo Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("hizo Entered");
                lbOlvidoClave.setForeground(new Color(231, 174, 24));
                lbOlvidoClave.setFont(new Font("tahoma", Font.BOLD, 11));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("hizo Exited");
                lbOlvidoClave.setForeground(Color.WHITE);
                lbOlvidoClave.setFont(new Font("tahoma", Font.BOLD, 11));
            }
        });

    }//----------------------------------------------------------END_AjustarEven

    private void iniciarComponentes() {
        lbTitulo = new JLabel("Acceso de Usuario");
        lbIndicaciones = new JLabel("Ingrese los datos correspondientes");
        lbCorreo = new JLabel("Ingrese su Correo:");
        lbDominioCorreo = new JLabel("@castillo.cr");
        lbContraseña = new JLabel("Contraseña:");
        lbOlvidoClave = new JLabel("¿Olvidó su contraseña?");
        //--o--
        lbTitulo.setForeground(Color.WHITE);
        lbIndicaciones.setForeground(Color.WHITE);
        lbCorreo.setForeground(Color.WHITE);
        lbDominioCorreo.setForeground(Color.WHITE);
        lbContraseña.setForeground(Color.WHITE);
        lbOlvidoClave.setForeground(Color.WHITE);
        //--o--
        lbTitulo.setFont(new Font("tahoma", Font.BOLD, 18));
        lbIndicaciones.setFont(new Font("tahoma", Font.BOLD, 11));
        lbCorreo.setFont(new Font("tahoma", Font.BOLD, 11));
        lbDominioCorreo.setFont(new Font("tahoma", Font.BOLD, 11));
        lbContraseña.setFont(new Font("tahoma", Font.BOLD, 11));
        lbOlvidoClave.setFont(new Font("tahoma", Font.BOLD, 11));
        //--o--
        txtCorreo = new JTextField(10);
        txtContraseña = new JPasswordField(10);
        //--o--
        btnIngresar = new JButton("Accesar");
        btnRegistrarse = new JButton("Registrarme");
        btnCancelar = new JButton("Cancelar");
        //--o--
        ckRecordar = new JCheckBox("Recordarme");
        ckRecordar.setSelected(false);
        ckRecordar.setOpaque(false);
        ckRecordar.setFont(new Font("tahoma", Font.BOLD, 11));
        ckRecordar.setForeground(Color.WHITE);
        //--o--
        panelPrincipal = new PanelConFondo("/img/fondoLogin.jpg");
    }//----------------------------------------------------------END_InicairComp   

    public void cerrarAplicacion() {//mensaje de confirmacion para dar fin a la ejecucion de la aplicacion        
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea cerrar la aplicación?", "Cerrar", JOptionPane.YES_NO_OPTION)) {
            System.exit(0);
        }
    }//-----------------------------------------------------END_cerrarAplicacion
    private void limpiar(){
        if(!ckRecordar.isSelected()){
            txtCorreo.setText(null);
        }
        txtContraseña.setText(null);
    }//---------------------------------------------------------------------END_    

}//____________________________________________________________________END_CLASS
