package View;

import Controller.AppController;
import Core.Graphics.*;
import Dao.AccountDao;
import Dao.CustomerDao;
import Dao.OperationDao;
import Model.OperationTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeView extends JFrame implements ActionListener {

    private DabPanel dabPanel;
    private DabPanel dabTop;
    private DabPanel dabCenter;
    private DabPanel dabWelcome;
    private JLabel dabLabelWelcome;
    private DabPanel dabCustomer;
    private DabTable dabOpeList;
    private DabPanel dabBottom;
    private GridBagConstraints gc;
    private DabTextField dabSearchField;
    private DabBtn dabSearchBtn;
    private DabBtn dabBottomBtn1;
    private DabBtn dabBottomBtn2;
    private DabBtn dabBottomBtn3;
    private DabBtn dabBottomBtn4;
    private AlertView alertView;
    private AccountDao accountDao;
    private CustomerDao customerDao;
    private JLabel dabLabelCustomerName;
    private JLabel dabLabelCustomerSurname;
    private JLabel dabLabelCustomerNumber;
    private JLabel dabLabelHello;
    private JTable tableOperation = new JTable();
    private OperationDao operationDao;
    private OperationTableModel operationTableModel;
    private AppController appController;
    private boolean state;

    public HomeView(boolean state) throws HeadlessException {

        this.setTitle("Distributeur");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.gc = new GridBagConstraints();

        // Container
        this.dabPanel = new DabPanel(800, 600,  238, 239, 247, true);
        this.setContentPane(dabPanel);

        // Top
        this.dabTop = new DabPanel(800, 60,  200, 218, 247, true);
        this.dabSearchBtn = new DabBtn("Rechercher un compte", 200, 50, true);
        this.dabSearchField = new DabTextField(250, 50, 30);
        this.dabPanel.add(dabTop);
        this.dabTop.add(dabSearchField);
        this.dabTop.add(dabSearchBtn);
        this.dabSearchBtn.addActionListener(this);

        // Center
        this.dabCenter = new DabPanel(800, 390,  255, 255, 255, false);
        this.dabWelcome = new DabPanel(800, 390,  255, 255, 255, true);
        this.dabPanel.add(dabWelcome);
        this.dabPanel.add(dabCenter);
        //this.dabCenter.setLayout(new GridBagLayout());
        this.dabCustomer = new DabPanel(200, 385,  255, 255, 255, true);
        this.dabCenter.add(dabCustomer);
        this.dabCustomer.setBorder(BorderFactory.createLineBorder(new Color(28,29,33)));
        this.dabLabelCustomerName = new JLabel();
        this.dabLabelCustomerSurname = new JLabel();
        this.dabLabelCustomerNumber = new JLabel();
        this.dabLabelCustomerName.setFont(new Font("Roboto", Font.BOLD, 20));
        this.dabLabelCustomerSurname.setFont(new Font("Roboto", Font.BOLD, 20));
        this.dabLabelCustomerNumber.setFont(new Font("Roboto", Font.BOLD, 16));
        this.dabLabelHello = new JLabel();
        this.dabLabelHello.setText("Bonjour");
        this.dabLabelHello.setFont(new Font("Roboto", Font.BOLD, 30));
        this.dabLabelWelcome = new JLabel();
        this.dabLabelWelcome.setText("Bienvenue");
        this.dabLabelWelcome.setFont(new Font("Roboto", Font.BOLD, 40));
        this.dabWelcome.add(dabLabelWelcome);
        this.dabCustomer.add(dabLabelHello);
        this.dabCustomer.add(dabLabelCustomerName);
        this.dabCustomer.add(dabLabelCustomerSurname);
        this.dabCustomer.add(dabLabelCustomerNumber);

        this.dabOpeList = new DabTable();
        JScrollPane scrollPane = new JScrollPane(dabOpeList);
        this.dabCenter.add(scrollPane);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(28,29,33)));
        scrollPane.setPreferredSize(new Dimension(580,385));

        // Bottom
        this.dabBottom = new DabPanel(800, 110,  49, 53, 61, true);
        this.dabPanel.add(dabBottom);
        this.dabBottomBtn1 = new DabBtn("Depot", 195, 100, false);
        this.dabBottomBtn2 = new DabBtn("Retrait", 195, 100, false);
        this.dabBottomBtn3 = new DabBtn("Solde", 195, 100, false);
        this.dabBottomBtn4 = new DabBtn("Quitter", 195, 100, true);
        this.dabBottomBtn1.addActionListener(this);
        this.dabBottomBtn2.addActionListener(this);
        this.dabBottomBtn3.addActionListener(this);
        this.dabBottomBtn4.addActionListener(this);
        this.dabBottom.add(dabBottomBtn1);
        this.dabBottom.add(dabBottomBtn2);
        this.dabBottom.add(dabBottomBtn3);
        this.dabBottom.add(dabBottomBtn4);

        this.setVisible(state);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.accountDao = new AccountDao();
            int cptNum = Integer.parseInt(this.dabSearchField.getText());
            this.customerDao = this.accountDao.findAccount(cptNum);
            this.dabLabelCustomerNumber.setText("Compte:" + Integer.toString(this.accountDao.getAccountNumber()));
            this.dabLabelCustomerName.setText("Nom:" + this.customerDao.getCustomerName());
            this.dabLabelCustomerSurname.setText("Prénom:" + this.customerDao.getCustomerSurname());

            this.operationDao = new OperationDao();
            this.dabOpeList.setModel(this.operationTableModel = new OperationTableModel(this.operationDao.operationDetails(cptNum)));

            this.dabCenter.setVisible(true);
            this.dabWelcome.setVisible(false);
            this.dabBottomBtn1.setVisible(true);
            this.dabBottomBtn2.setVisible(true);
            this.dabBottomBtn3.setVisible(true);


            if (e.getSource() == dabBottomBtn1) {
                this.appController = new AppController(false);
                this.appController.addMoneyView(cptNum);
            }
            if (e.getSource() == dabBottomBtn2) {
                this.appController = new AppController(false);
                this.appController.removeMoneyView(cptNum);
            }
            if (e.getSource() == dabBottomBtn3) {
                this.appController = new AppController(false);
                this.appController.balanceView(cptNum);
            }
            if (e.getSource() == dabBottomBtn4) {
                this.dispose();
            }

        } catch(NumberFormatException errorNumber) {
            //this.alertView = new AlertView("Veuillez saisir un numéro de compte", "Erreur", 3);
        }
    }
}
