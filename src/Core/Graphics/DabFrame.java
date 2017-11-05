package Core.Graphics;

import javax.swing.*;
import java.awt.*;

public class DabFrame extends JFrame {

    protected String title;
    protected int width;
    protected int height;
    protected int red;
    protected int green;
    protected int blue;

    public DabFrame(String title, int width, int height, int red, int green, int blue) throws HeadlessException {
        this.setTitle(title);
        this.setSize(width, height);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(red, green, blue));
    }
}
