package View;

import Controller.AppController;
import Core.Graphics.DabBtn;
import Core.Graphics.DabPanel;
import Core.Graphics.DabTextField;
import Dao.CustomerDao;
import Dao.OperationDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveMoneyView extends JFrame implements ActionListener {

    private DabPanel dabPanel;
    private DabTextField dabRemoveMoney;
    private DabBtn dabRemoveMoneyBtn;
    private DabBtn dabReturnHomeBtn;
    private GridBagConstraints gc;
    private AppController appController;
    private OperationDao operationDao;
    private int accountNumber;

    public RemoveMoneyView(int accountNumber) throws HeadlessException {
        this.accountNumber = accountNumber;
        this.setTitle("Distributeur");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);

        // Container
        this.dabPanel = new DabPanel(800, 600,  238, 239, 247, true);
        this.dabPanel.setLayout(new GridBagLayout());
        this.gc = new GridBagConstraints();
        this.setContentPane(dabPanel);
        this.dabRemoveMoney = new DabTextField(250, 50, 30);
        this.dabRemoveMoneyBtn = new DabBtn("Retirer de l'argent", 200, 50, true);
        this.dabReturnHomeBtn = new DabBtn("retour à l'accueil", 200, 50, true);
        this.dabPanel.add(dabRemoveMoney);
        this.dabPanel.add(dabRemoveMoneyBtn);
        this.dabPanel.add(dabReturnHomeBtn);
        this.dabRemoveMoneyBtn.addActionListener(this);
        this.dabReturnHomeBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dabRemoveMoneyBtn) {

            this.operationDao = new OperationDao();
            CustomerDao customerDao = new CustomerDao();
            System.out.println(customerDao.getCustomerName());
            this.operationDao.manageMoney(this.accountNumber,0, Double.parseDouble(this.dabRemoveMoney.getText()));
        }

        if (e.getSource() == dabReturnHomeBtn) {
            //this.appController = new AppController(true);
            this.setVisible(false);
        }
    }
}

