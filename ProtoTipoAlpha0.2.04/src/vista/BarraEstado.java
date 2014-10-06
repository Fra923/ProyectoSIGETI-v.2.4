

package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 prototipo Alpha 
 13-08/09-2014
 Proyecto SIGETI
 */
public class BarraEstado extends JPanel{// clase BarraEstado, donde se crea la barra inferior informativa 
    
    private static final Font TIPO_LETRA = new Font("Courier", Font.PLAIN, 10);
    private JLabel lbMensaje;
    private String mensajeAnterior;
    private Color colorAnterior;
    
    public BarraEstado(String txt) {//constructor
        super(true);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBorder(BorderFactory.createRaisedBevelBorder());
        lbMensaje = new JLabel(txt);
        lbMensaje.setFont(TIPO_LETRA);
        add(lbMensaje);
        mensajeAnterior = "";
        colorAnterior = Color.BLACK;
    }//----------------------------------------------------------END_Constructor

    public void cambiarEstado(String txt, Color color) {//ingresaun nuevo mensaje
        mensajeAnterior = lbMensaje.getText();
        colorAnterior = color;
        lbMensaje.setForeground(color);
        //setBackground(Color.LIGHT_GRAY);
        //setBackground(Color.LIGHT_GRAY.brighter());        
        lbMensaje.setText(txt);
    }//--------------------------------------------------------END_cambiarEstado

    public void cambiarEstado(String txt) {//ingresaun nuevo mensaje sin indicar el color
        cambiarEstado(txt, Color.BLACK);
    }//--------------------------------------------------------END_cambiarEstado

    public void mostrarError(String txt) {//muestra mensaje en rojo
        cambiarEstado(txt, Color.RED);
    }//--------------------------------------------------------END_MOSTRAR_ERROR

    public void mostrarWarning(String txt) {//indica mensaje de alerta en color amarillo
        cambiarEstado(txt,  new Color(255, 215, 0).brighter());
    }//--------------------------------------------------------------END_Warning

//    public void mostrarEnVerde(String txt) {
//        cambiarEstado(txt, new Color(76, 187, 23));
//    }//-------------------------------------------------------------------------
//
//    public void mostrarEnAzul(String txt) {
//        cambiarEstado(txt, Color.BLUE);
//    }//-------------------------------------------------------------------------

    public String getEstado() {//regresa string con el texto que se muestra
        return lbMensaje.getText();
    }//------------------------------------------------------------END_getEstado

    public void MensajeAnterior() {//vuelve a poner el mensaje anterior, incluye el color
        cambiarEstado(mensajeAnterior, colorAnterior);
    }//------------------------------------------------------END_MensajeAnterior
    
}//____________________________________________________________________END_CLASS
