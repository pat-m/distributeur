package Core.Graphics;

import javax.swing.*;
import java.awt.*;

public class DabBtn extends JButton {

    private String title;
    private int width;
    private int height;
    private int state;

    public DabBtn(String title, int width, int height, boolean state) {
        this.setText(title);
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(state);
    }

}
