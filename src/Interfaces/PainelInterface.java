package Interfaces;

import javax.swing.JPanel;

public abstract class PainelInterface extends JPanel {
    public abstract void clear();
    public abstract InterfaceDTO getData();
    public abstract void setDados(InterfaceDTO dto);
}
