package vista.Area;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import vista.CountryTreeCellRenderer;
import vista.Informacion;

public class ArbolArea extends JPanel {//Arbol para usuario de Area

    private static ArbolArea instancia = null;
    //--o--
    private JTree arbol;
    //--o--
    private JScrollPane panelArbol;

    public ArbolArea() {//arbol donde se encuentra las opciones del usuario de area       
        ajustarComponentes();
        ajustarEventos();
        repaint();
    }//----------------------------------------------------------END_Constructor

    public static ArbolArea obtenerInstancia() {//para garantizar hay solo un arbol
        if (instancia == null) {
            instancia = new ArbolArea();
        }
        return instancia;
    }//-----------------------------------------------------END_obtenerInstancia

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
        Informacion infTicketsDelArea = new Informacion("Crear", "src/img/ticket16.png");
        Informacion infNuevos = new Informacion("Crear", "src/img/ticket16.png");
        Informacion infTodos = new Informacion("Crear", "src/img/ticket16.png");
        Informacion infEnProceso = new Informacion("Crear", "src/img/ticket16.png");
        Informacion infAsignados = new Informacion("Crear", "src/img/ticket16.png");
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

        }//end switch

    }//-------------------------------------------------------------END_selected

}//____________________________________________________________________END_CLASS
