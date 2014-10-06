package vista;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class CountryTreeCellRenderer implements TreeCellRenderer {//clase para modificar el Jtree de java en los arboles

    private JLabel label;

    public CountryTreeCellRenderer() {
        label = new JLabel();
    }//----------------------------------------------------------------------END

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Object o = ((DefaultMutableTreeNode) value).getUserObject();
        if (o instanceof Informacion) {
            Informacion country = (Informacion) o;
            label.setIcon(new ImageIcon(country.getFlagIcon()));
            label.setText(country.getName());
        } else {
            label.setIcon(null);
            label.setText("" + value);
        }
        return label;
    }//----------------------------------------------------------------------END
}//____________________________________________________________________END_CLASS
