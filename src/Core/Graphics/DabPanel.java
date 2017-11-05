package Core.Graphics;

import javax.swing.*;
import java.awt.*;

public class DabPanel extends JPanel {

    private int width;
    private int height;
    private boolean state;
    private int red;
    private int green;
    private int blue;

    public DabPanel(int width, int height, int red, int green, int blue, boolean state) {
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(state);
        this.setBackground(new Color(red, green, blue));
    }
}
