package View;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class AlertView {

    private String message;
    private String title;
    private int type;
    private ImageIcon img;

    public AlertView(String message, String title, int type) {

        JOptionPane alert = new JOptionPane();
        switch (type) {
            case 1:
                this.type = JOptionPane.INFORMATION_MESSAGE;
                this.img = new ImageIcon("images/information.png");
                break;
            case 2:
                this.type = JOptionPane.WARNING_MESSAGE;
                this.img = new ImageIcon("images/information.png");
                break;
            case 3:
                this.type = JOptionPane.ERROR_MESSAGE;
                this.img = new ImageIcon("images/information.png");
                break;
        }

        showMessageDialog(null, message, title, type, img);

    }
}
