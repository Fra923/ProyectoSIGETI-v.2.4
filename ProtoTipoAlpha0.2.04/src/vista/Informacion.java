
package vista;

public class Informacion {//clase para poder asignar la imagen diferente y un nombre a los arboles
    
    private String name;
    private String flagIcon;

    public Informacion(String name, String flagIcon) {
        this.name = name;
        this.flagIcon = flagIcon;
    }//----------------------------------------------------------------------END

    public String getName() {
        return name;
    }//----------------------------------------------------------------------END

    public void setName(String name) {
        this.name = name;
    }//----------------------------------------------------------------------END

    public String getFlagIcon() {
        return flagIcon;
    }//----------------------------------------------------------------------END

    public void setFlagIcon(String flagIcon) {
        this.flagIcon = flagIcon;
    }//----------------------------------------------------------------------END

    @Override
    public String toString() {
        return getName();
    }//----------------------------------------------------------------------END
}//____________________________________________________________________END_CLASS
