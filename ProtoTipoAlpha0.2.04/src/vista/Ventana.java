package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vista.standard.ArbolStandard;
import vista.standard.PanelCrearTicket;
import vista.standard.PanelCambioContraseña;
import vista.standard.PanelConsultaTodos;
import vista.standard.PanelConsultaUno;
/*
 * prototipo Alpha 08/09/10-2014 Proyecto SIGETI
 */

public class Ventana extends JFrame {//la venta a mostrarse en la interface

    private BarraEstado barraEstado;
    //--o--    
    private final int sizeY = Toolkit.getDefaultToolkit().getScreenSize().height - 50;
    private final int sizeX = Toolkit.getDefaultToolkit().getScreenSize().width - 1;
    //--o--    
    private static Ventana instancia = null;
    //--o--
    private JPanel panelPrincipal;
    //--o--    
    private JMenuBar menu;

    private Ventana() {
        super("SIGETI prototipo Alpha0.2.04 ");
        ajustarConfiguracionInicial();
        ajustarMenu();
        ajustarComponentes(getContentPane());
        ajustarEventos();
    }//----------------------------------------------------------END_Constructor
    
    public void ventanaPrincipal() {
        panelPrincipal.removeAll();
        setBarraEstado("Pantalla principal");
        ArbolStandard arbol = ArbolStandard.obtenerInstancia();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        pack();
        repaint();
    }//---------------------------------------------------------------------END_

    public static Ventana obtenerInstancia() {//asi garantizamos que solo aya una ventana
        if (instancia == null) {
            instancia = new Ventana();
        }
        return instancia;
    }//-----------------------------------------------------END_obtenerInstancia

    public void setTipoUsuario(String tipoUsuario) {
        switch (tipoUsuario){
            case "standard":
                menuStandard();
                ArbolStandard.previeneError();
                ventanaPrincipalStandard();
                break;
        }                
    }//---------------------------------------------------------------------END_

    public void mostrar() {//para mostar el JFRAME
        this.setVisible(true);
        repaint();
    }//--------------------------------------------------------------END_MOSTRAR

    public void ocultar() {// oculta la ventana de ser necesario
        this.setVisible(false);
    }//--------------------------------------------------------------END_OCULTAR

    private void setBarraEstado(String txt) {//cambia el texto de la barra de estado
        barraEstado.cambiarEstado(txt);
    }//-------------------------------------------------------END_SETBARRAESTADO

    public void setWarning(String txt) {//muestra un Warning en la barra de estado
        barraEstado.mostrarWarning(txt);
    }//------------------------------------------------------------END_SETWARNIG

    public void setError(String txt) {//Muestra un error en la barra de estado
        barraEstado.mostrarError(txt);
    }//-------------------------------------------------------------END_SETERROR

    public void setBarraEstadoMensajeAnterior() {//cambia el texto de la barra de estado por el mensaje anterior
        barraEstado.MensajeAnterior();
    }//-----------------------------------------------------END_MENSAJE ANTERIOR

    public String getBarraEstado() {// retorna el texto de la barra de estado
        return barraEstado.getEstado();
    }//------------------------------------------------------------END_GETESTADO

    private void ajustarConfiguracionInicial() {//configuracion basica de la ventana
        setSize((sizeX - sizeX / 4), (sizeY - sizeY / 4));
        setResizable(true);
        setMinimumSize(new Dimension((sizeX - sizeX / 4), (sizeY - sizeY / 4)));
        setMaximumSize(new Dimension(sizeX, sizeY));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });
        cambioIcono();
    }//------------------------------------------END_ajustarConfiguracionInicial

    private void ajustarMenu() {//ajusta el menu de la ventana
        menu = new JMenuBar();
        this.setJMenuBar(menu);
        desAbilitarMenu();
    }//----------------------------------------------------------END_ajustarMenu

    public void desAbilitarMenu() {//desabilita las funciones del menu en caso de no tener acceso
        menu.removeAll();
        repaint();
    }//------------------------------------------------------END_desAbilitarMenu     

    public void menuStandard() {
        desAbilitarMenu();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuOpciones = new JMenu("Opciones");        
        JMenu menuLogin = new JMenu("Login");
        JMenu menuAyuda = new JMenu("Ayuda");
        //--o--
        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenuItem itemCrearTicket = new JMenuItem("Crear Ticket");
        JMenuItem itemBuscarUnTicket = new JMenuItem("Buscar Un Ticket");
        JMenuItem itemBuscarUltimoTicket = new JMenuItem("Buscar Ultimo Ticket");
        JMenuItem itemHistorialTicket = new JMenuItem("Historial Tickets");
        JMenuItem itemDesLoggeo = new JMenuItem("Cerrar Sesion");
        JMenuItem itemRegistrar = new JMenuItem("Registrar");
        JMenuItem itemAyuda = new JMenuItem("Ayuda");
        JMenuItem itemCambioClave = new JMenuItem("Cambiar Clave");
        //--o--
        Icon icon = new ImageIcon(getClass().getResource("../img/ticket16.png"));
        itemCrearTicket.setIcon(icon);
        Icon icon2 = new ImageIcon(getClass().getResource("../img/Search-16.png"));
        itemBuscarUltimoTicket.setIcon(icon2);
        Icon icon3 = new ImageIcon(getClass().getResource("../img/Search216.png"));
        itemBuscarUnTicket.setIcon(icon3);
        Icon icon4 = new ImageIcon(getClass().getResource("../img/Search316.png"));
        itemHistorialTicket.setIcon(icon4);
        Icon icon5 = new ImageIcon(getClass().getResource("../img/support-iconx16.png"));
        itemAyuda.setIcon(icon5);
        Icon icon6 = new ImageIcon(getClass().getResource("../img/Delete-2-iconx16.png"));
        itemSalir.setIcon(icon6);
        Icon icon9 = new ImageIcon(getClass().getResource("../img/user-login-iconx16.png"));
        itemDesLoggeo.setIcon(icon9);
        Icon icon10 = new ImageIcon(getClass().getResource("../img/registrar-iconx16.png"));
        itemRegistrar.setIcon(icon10);
        Icon icon11 = new ImageIcon(getClass().getResource("../img/clave-iconx16.png"));
        itemCambioClave.setIcon(icon11);
        //--o--
        menuArchivo.add(itemSalir);
        menuOpciones.add(itemCrearTicket);
        menuAyuda.add(itemAyuda);
        menuOpciones.add(itemBuscarUltimoTicket);
        menuOpciones.add(itemBuscarUnTicket);
        menuOpciones.add(itemHistorialTicket);
        menuLogin.add(itemRegistrar);
        menuLogin.add(itemDesLoggeo);        
        menuLogin.add(itemCambioClave);
        //--o--
        menu.add(menuArchivo);
        menu.add(menuOpciones);        
        menu.add(menuLogin);
        menu.add(menuAyuda);
        //--o--
        repaint();
    }//---------------------------------------------------------END_MenuStandard

    private void ajustarComponentes(Container c) {//coloca lo que debe estar en la ventana        
        barraEstado = new BarraEstado("Bienvenido");
        if (panelPrincipal == null) {
            panelPrincipal = new JPanel();
        }
        c.add(panelPrincipal, BorderLayout.CENTER);
        c.add(barraEstado, BorderLayout.PAGE_END);
        repaint();
    }//---------------------------------------------------END_ajustarComponentes

    private void ajustarEventos() {
    }//-------------------------------------------------------END_ajustarEventos

    public void cerrarAplicacion() {//mensaje de confirmacion para dar fin a la ejecucion de la aplicacion
        setBarraEstado("¿Realmente desea cerrar la aplicación? ");
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea cerrar la aplicación?", "Cerrar", JOptionPane.YES_NO_OPTION)) {
            System.exit(0);
        }
        setBarraEstadoMensajeAnterior();
    }//-----------------------------------------------------END_cerrarAplicacion

    public void cambioIcono() {//establece el icono de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/SIGETI-icon128.png"));
        setIconImage(icon);
    }//----------------------------------------------------------END_cambioIcono

    public void cerrarSesion() {
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Real"
                + "mente desea cerrar la sesión?", null, JOptionPane.YES_NO_OPTION)) {
            VentanaLogin.obtenerInstancia().mostrar();
            ocultar();            
            this.desAbilitarMenu();
            panelPrincipal.removeAll();            
        }
    }//---------------------------------------------------------------------END_

    public void cambiarClave() {
        panelPrincipal.removeAll();  
        setBarraEstado("Cambiar clave");
        ArbolStandard arbol = ArbolStandard.obtenerInstancia();
        PanelCambioContraseña panelClave= PanelCambioContraseña.obtenerInstancia();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        panelPrincipal.add(panelClave, BorderLayout.CENTER);
        repaint();
    }

    public void historialTicketsStandard() {
        panelPrincipal.removeAll();
        setBarraEstado("Historial de tickets");
        ArbolStandard arbol = ArbolStandard.obtenerInstancia();
        PanelConsultaTodos panelCentral = PanelConsultaTodos.obtenerInstancia();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        pack();
        repaint();
    }

    public void buscarUnTicketStandard() {
        panelPrincipal.removeAll();
        setBarraEstado("Consulta de ticket");
        ArbolStandard arbol = ArbolStandard.obtenerInstancia();
        PanelConsultaUno panel = PanelConsultaUno.obtenerInstancia();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        panelPrincipal.add(panel, BorderLayout.CENTER);
        pack();
        repaint();
    }

    public void buscarUltimoTicketStandard() {
    
    }

    public void crearTicket() {
        panelPrincipal.removeAll();
        setBarraEstado("Creación de ticket");
        ArbolStandard arbol = ArbolStandard.obtenerInstancia();
        PanelCrearTicket panelCentral = PanelCrearTicket.obtenerInstancia();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        repaint();
    }

    public void ventanaPrincipalStandard() {
        panelPrincipal.removeAll();
        setBarraEstado("Pantalla principal");
        ArbolStandard arbol= ArbolStandard.obtenerInstancia();
        PanelConFondo imagen= new PanelConFondo("/img/2014-10-05_1533.png");
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(arbol, BorderLayout.WEST);
        panelPrincipal.add(imagen);
        pack();
        repaint();
    }//----------------------------------------------------------------------END

    void registrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//____________________________________________________________________END_CLASS
