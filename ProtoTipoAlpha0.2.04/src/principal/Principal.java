package principal;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Ventana;
import vista.VentanaLogin;
/*
 prototipo Alpha 
 08/09/10-2014
 Proyecto SIGETI
 */

public class Principal {// clase principal donde se encuentra el main

    public static void main(String[] args) {//unico main del proyecto
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Principal principal = new Principal();
                principal.mostrarInterfaz();
            }
        });
    }//-----------------------------------------------------------------END_MAIN

    private void mostrarInterfaz() {//donde se ejecuta el MVC
        //1. aun no se implementa modelo
        //2. aun no se implementa control
        //3.          
        VentanaLogin ventana = VentanaLogin.obtenerInstancia();
        ventana.mostrar();
    }//------------------------------------------------------END_mostrarInterfaz

}//____________________________________________________________________END_CLASS
