package Dao;

import Model.CustomerModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDao extends CustomerModel {

    public CustomerDao() {
    }

    public CustomerDao(Connection connexion, Statement statement, ResultSet resultSet, int customerId, String customerName, String customerSurname, String customerAdress, String customerZip, String customerCity) {
        super(connexion, statement, resultSet, customerId, customerName, customerSurname, customerAdress, customerZip, customerCity);
    }

}
