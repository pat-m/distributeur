package Core.Graphics;

import javax.swing.*;
import java.awt.*;

public class DabTextField extends JTextField {

    private int width;
    private int height;
    private int columns;

    public DabTextField(int width, int height, int columns) {
        this.setPreferredSize(new Dimension(width, height));
        this.setColumns(columns);
    }
}
