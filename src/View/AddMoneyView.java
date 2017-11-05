package View;

import Controller.AppController;
import Core.Graphics.DabBtn;
import Core.Graphics.DabPanel;
import Core.Graphics.DabTextField;
import Dao.AccountDao;
import Dao.CustomerDao;
import Dao.OperationDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMoneyView extends JFrame implements ActionListener {

    private DabPanel dabPanel;
    private DabTextField dabAddMoney;
    private DabBtn dabAddMoneyBtn;
    private DabBtn dabReturnHomeBtn;
    private GridBagConstraints gc;
    private AppController appController;
    private OperationDao operationDao;
    private AccountDao accountDao;
    private int accountNumber;

    public AddMoneyView(int accountNumber) throws HeadlessException {
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
        this.dabAddMoney = new DabTextField(250, 50, 30);
        this.dabAddMoneyBtn = new DabBtn("Déposer de l'argent", 200, 50, true);
        this.dabReturnHomeBtn = new DabBtn("retour à l'accueil", 200, 50, true);
        this.dabPanel.add(dabAddMoney);
        this.dabPanel.add(dabAddMoneyBtn);
        this.dabPanel.add(dabReturnHomeBtn);
        this.dabAddMoneyBtn.addActionListener(this);
        this.dabReturnHomeBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == dabAddMoneyBtn) {

            this.operationDao = new OperationDao();
            CustomerDao customerDao = new CustomerDao();
            System.out.println(customerDao.getCustomerName());
            this.operationDao.manageMoney(this.accountNumber,1, Double.parseDouble(this.dabAddMoney.getText()));
        }

        if (e.getSource() == dabReturnHomeBtn) {
            this.appController = new AppController(true);
            this.appController.ReturnHome(this.accountNumber);
            this.setVisible(false);
        }
    }
}
