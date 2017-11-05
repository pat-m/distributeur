package View;

import Controller.AppController;
import Core.Graphics.DabBtn;
import Core.Graphics.DabPanel;
import Core.Graphics.DabTextField;
import Dao.AccountDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceView extends JFrame implements ActionListener {

    private DabPanel dabPanel;
    private DabBtn dabReturnHomeBtn;
    private JLabel dabLabelBalance;
    private GridBagConstraints gc;
    private AppController appController;
    private int accountNumber;
    private AccountDao accountDao;

    public BalanceView(int accountNumber) throws HeadlessException {
        this.accountNumber = accountNumber;
        this.setTitle("Distributeur");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);

        // Container
        this.dabPanel = new DabPanel(800, 600,  238, 239, 247, true);
        //this.dabPanel.setLayout(new GridBagLayout());
        this.gc = new GridBagConstraints();
        this.setContentPane(dabPanel);
        this.accountDao = new AccountDao();
        this.dabLabelBalance = new JLabel("Le solde de votre compte est de: " + String.valueOf(this.accountDao.getCurrentBalance(accountNumber)));
        this.dabPanel.add(dabLabelBalance);
        dabLabelBalance.setFont(new Font("Roboto", Font.BOLD, 20));
        this.dabReturnHomeBtn = new DabBtn("retour à l'accueil", 200, 50, true);
        this.dabPanel.add(dabReturnHomeBtn);
        this.dabReturnHomeBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dabReturnHomeBtn) {
            this.appController = new AppController(true);
            this.setVisible(false);
        }
    }
}
