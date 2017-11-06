package Dao;

import Model.AccountModel;
import Model.CustomerModel;
import Model.OperationModel;

import java.sql.*;
import java.util.ArrayList;

public class OperationDao extends OperationModel {

    public ArrayList<OperationModel> operationDetails;
    public ArrayList<OperationModel> operationAddMoney;
    public AccountDao accountDao;
    public ArrayList<Object> operationPdfDetails;

    public OperationDao() {

    }

    public OperationDao(Connection connexion, Statement statement, ResultSet resultSet, int operationID, int operationAccountNumber, int operationType, double operationAmount, Date operationDate) {
        super(connexion, statement, resultSet, operationID, operationAccountNumber, operationType, operationAmount, operationDate);
    }

    public ArrayList <OperationModel> operationDetails(int number) {
        this.getConnexion();
        this.operationDetails = new ArrayList<OperationModel>();


        try {
            this.statement = connexion.createStatement();
            this.resultSet = statement.executeQuery("SELECT operation.operationId, operation.operationAccountNumber, operation.operationType,  operation.operationAmount, operation.operationDate FROM operation WHERE operation.operationAccountNumber =" + number);
            ResultSetMetaData meta = this.resultSet.getMetaData();
            while ( this.resultSet.next() ) {

                OperationModel operationList = new OperationModel();
                int operationID = this.resultSet.getInt("operationId");
                operationList.setOperationID(operationID);
                int operationAccountNumber = this.resultSet.getInt("operationAccountNumber");
                operationList.setOperationAccountNumber(operationAccountNumber);
                int operationType = this.resultSet.getInt("operationType");
                operationList.setOperationType(operationType);
                double operationAmount = this.resultSet.getInt("operationAmount");
                operationList.setOperationAmount(operationAmount);
                Date operationDate = this.resultSet.getDate("operationDate");
                operationList.setOperationDate(operationDate);

                operationDetails.add(operationList);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return operationDetails;
    }

    public void manageMoney(int accountNumber,int type, double amount) {

        this.getConnexion();

        try {
            this.statement = connexion.createStatement();
            this.statement.executeUpdate("INSERT INTO operation (operation.operationAccountNumber, operation.operationType, operation.operationAmount, operation.operationDate)  VALUES (" + accountNumber + ", " + type + ", " + amount + ", NOW())");

            this.accountDao = new AccountDao();
            if (type == 0) {
                double currentBalance = this.accountDao.getCurrentBalance(accountNumber);
                double newBalance = currentBalance - amount;
                this.accountDao.setNewBalance(accountNumber, newBalance);

            } else {
                double currentBalance = this.accountDao.getCurrentBalance(accountNumber);
                double newBalance = currentBalance + amount;
                this.accountDao.setNewBalance(accountNumber, newBalance);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
