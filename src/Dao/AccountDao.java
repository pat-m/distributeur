package Dao;


import Model.AccountModel;

import java.sql.*;

public class AccountDao extends AccountModel {

    public AccountDao() {

    }

    public AccountDao(Connection connexion, Statement statement, ResultSet resultSet, int accountId, int accountNumber, double accountBalance, int accountOwner) {
        super(connexion, statement, resultSet, accountId, accountNumber, accountBalance, accountOwner);
    }

    public CustomerDao findAccount(int number) {
        this.getConnexion();
        CustomerDao customer = new CustomerDao();
        try {
            this.statement = this.connexion.createStatement();
            this.resultSet = this.statement.executeQuery("SELECT account.accountNumber, customer.customerName, customer.customerSurname, customer.customerAddress, customer.customerZip, customer.customerCity FROM account INNER JOIN customer ON account.accountOwner = customer.customerId WHERE account.accountNumber LIKE '%" + number + "%' ");
            ResultSetMetaData meta = resultSet.getMetaData();
            while (resultSet.next()) {

                int accountNumber = resultSet.getInt("accountNumber");
                this.setAccountNumber(accountNumber);
                String customerName = resultSet.getString("customerName");
                customer.setCustomerName(customerName);
                String customerSurname = resultSet.getString("customerSurname");
                customer.setCustomerSurname(customerSurname);
                String customerAdress = resultSet.getString("customerAddress");
                customer.setCustomerAdress(customerAdress);
                String customerZip = resultSet.getString("customerZip");
                customer.setCustomerZip(customerZip);
                String customerCity = resultSet.getString("customerCity");
                customer.setCustomerCity(customerCity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public double getCurrentBalance(int number) {
        this.getConnexion();
        double accountBalance = 0;
        try {

            statement = connexion.createStatement();
            ResultSet req = statement.executeQuery("SELECT account.accountBalance FROM `account` WHERE accountNumber = " + number + "");
            ResultSetMetaData meta = req.getMetaData();
            while ( req.next() ) {
                accountBalance = req.getDouble("accountBalance");
                this.setAccountBalance(accountBalance);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return accountBalance;
    }

    public double setNewBalance(int number, double newBalance) {
        this.getConnexion();
        double accountBalance = 0;

        try {
            this.statement = connexion.createStatement();
            this.statement.executeUpdate("UPDATE account SET account.accountBalance = " + newBalance +" WHERE account.accountNumber = " + number + "");
            ResultSetMetaData meta = this.resultSet.getMetaData();
            while ( this.resultSet.next() ) {
                accountBalance = this.resultSet.getDouble("accountBalance");
                this.setAccountBalance(accountBalance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountBalance;
    }

}
