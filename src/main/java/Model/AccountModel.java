package Model;

import Core.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountModel extends Model {

    private int accountId;
    private int accountNumber;
    private double accountBalance;

    public AccountModel(Connection connexion, Statement statement, ResultSet resultSet, int accountId, int accountNumber, double accountBalance) {
        super(connexion, statement, resultSet);
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
