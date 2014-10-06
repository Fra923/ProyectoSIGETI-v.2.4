
package vista.standard;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import vista.CountryTreeCellRenderer;
import vista.Informacion;
import vista.Ventana;

public class ArbolStandard extends JPanel{//Arbol para usuario standard
    
    private static ArbolStandard instancia = null;
    //--o--        
    private JTree arbol;
    //--o--
    private JScrollPane panelArbol;
    
    private ArbolStandard() {//arbol donde se encuentra las opciones del usuario       
        ajustarComponentes();
        ajustarEventos();
        repaint();
    }//----------------------------------------------------------END_Constructor

    public static ArbolStandard obtenerInstancia() {//para garantizar hay solo un arbol
        if (instancia == null) {
            instancia = new ArbolStandard();
        }
        return instancia;
    }//-----------------------------------------------------END_obtenerInstancia
    public static void previeneError(){
        instancia = null;
        instancia = new ArbolStandard();
    }//---------------------------------------------------------------------END_
    private void ajustarComponentes() {//
        armarArbol();
        arbol.setCellRenderer(new CountryTreeCellRenderer());
        panelArbol = new JScrollPane(arbol);
        panelArbol.setBorder(null);
        this.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(panelArbol);
        this.setBackground(Color.WHITE);
        repaint();
    }//---------------------------------------------------END_ajustarComponentes
    
    private void armarArbol() {//inicializa y arma el jTree
        Informacion infSigeti = new Informacion("SIGETI", "src/img/SIGETI-icon16.png"); //abuelo            
        Informacion infTicket = new Informacion("Gestión Tickets               ", "src/img/Carpeta-tickets16.png");//padre 1   
        Informacion infCrear = new Informacion("Crear", "src/img/ticket16.png");
        Informacion infConsultas = new Informacion("Consultas", "src/img/Carpeta-Search16.png");//padre 2
        Informacion infConsultarUltimo = new Informacion("Consultar Ultimo", "src/img/Search-16.png");
        Informacion infConsultarUno = new Informacion("Consultar Uno", "src/img/Search216.png");
        Informacion infConsultarTodos = new Informacion("Consultar Todos", "src/img/Search316.png");
        Informacion infCambioClave = new Informacion("Cambiar Clave", "src/img/clave-iconx16.png");
        Informacion infConf = new Informacion("Configuracion", "src/img/Conf-iconx16.png");
        Informacion infCerrarSeccion = new Informacion("Cerrar Sesion", "src/img/user-login-iconx16.png");
        //--o--
        DefaultMutableTreeNode nodoSigeti = new DefaultMutableTreeNode(infSigeti);
        DefaultMutableTreeNode nodoTicket = new DefaultMutableTreeNode(infTicket);
        DefaultMutableTreeNode nodoCrear = new DefaultMutableTreeNode(infCrear);
        DefaultMutableTreeNode nodoConsultas = new DefaultMutableTreeNode(infConsultas);
        DefaultMutableTreeNode nodoConsultarUltimo = new DefaultMutableTreeNode(infConsultarUltimo);
        DefaultMutableTreeNode nodoConsultarUno = new DefaultMutableTreeNode(infConsultarUno);
        DefaultMutableTreeNode nodoConsultarTodos = new DefaultMutableTreeNode(infConsultarTodos);
        DefaultMutableTreeNode nodoCambioClave = new DefaultMutableTreeNode(infCambioClave);
        DefaultMutableTreeNode nodoConf = new DefaultMutableTreeNode(infConf);
        DefaultMutableTreeNode nodoCerrar = new DefaultMutableTreeNode(infCerrarSeccion);
        //--o--
        nodoTicket.add(nodoCrear);
        nodoConsultas.add(nodoConsultarUltimo);
        nodoConsultas.add(nodoConsultarUno);
        nodoConsultas.add(nodoConsultarTodos);
        nodoConf.add(nodoCambioClave);
        nodoConf.add(nodoCerrar);
        nodoSigeti.add(nodoTicket);
        nodoSigeti.add(nodoConsultas);
        nodoSigeti.add(nodoConf);
        //--o--
        DefaultTreeModel modelo = new DefaultTreeModel(nodoSigeti);
        //--o--
        arbol = new JTree(modelo);
    }//-----------------------------------------------------------END_armarArbol
    
    private void ajustarEventos() {//ajusta los eventos del arbol
        arbol.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent tse) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
                String opc = selectedNode.getUserObject().toString();
                redireccionar(opc);
            }
        });
    }//-------------------------------------------------------END_AjustarEventos
    
    public void redireccionar(String opc) {
        System.out.println("Selecciono:--> " + opc);
        switch (opc) {
            case "SIGETI":
                Ventana.obtenerInstancia().ventanaPrincipalStandard();
                System.out.println(" Ventana Principal");
                break;
            case "Crear":
                Ventana.obtenerInstancia().crearTicket();
                System.out.println(" Crear Ticket");
                break;
            case "Consultar Ultimo":
                Ventana.obtenerInstancia().buscarUltimoTicketStandard();
                System.out.println(" Buscar Ultimo");
                break;
            case "Consultar Uno":
                Ventana.obtenerInstancia().buscarUnTicketStandard();
                System.out.println(" Buscar uno");
                break;
            case "Consultar Todos":
                Ventana.obtenerInstancia().historialTicketsStandard();
                System.out.println(" Ver Historial");
                break;
            case "Cambiar Clave":
                Ventana.obtenerInstancia().cambiarClave();
                System.out.println("Cambiar Clave");
                break;
            case "Cerrar Sesion":
                Ventana.obtenerInstancia().cerrarSesion();
                System.out.println("Cerrar Sesion");
                break;
        }//end switch

    }//-------------------------------------------------------------END_selected
    
}//____________________________________________________________________END_CLASS
