package Dao;

import java.sql.*;

public class CardDao extends CardModel {


    public CardDao(Connection connexion, Statement statement, ResultSet resultSet, int cardNumber, double cardMaxAmount) {
        super(connexion, statement, resultSet, cardNumber, cardMaxAmount);
    }

    public CardDao() {

    }

    public double manageCard(int accountNumber) {
        OperationDao operationDao = new OperationDao();
        double newAmount = 0;
        try {
            this.statement = connexion.createStatement();
            this.resultSet = statement.executeQuery("SELECT cardMaxAmount FROM card INNER JOIN account ON account.accountId = card.account_accountId WHERE account.accountNumber = " + accountNumber + "");
            ResultSetMetaData meta = this.resultSet.getMetaData();

            double currentMaxAmount = this.getCardMaxAmount();
            while (this.resultSet.next()) {

                this.setCardNumber(accountNumber);
                newAmount = this.resultSet.getDouble("cardMaxAmount") - operationDao.removeMoneyTotal(accountNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(newAmount);
        return newAmount;
    }
}
