package Model;

import Core.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerModel extends Model {

    private int customerId;
    private String customerName;
    private String customerSurname;
    private String customerAdress;
    private String customerZip;
    private String customerCity;

    public CustomerModel() {
    }

    public CustomerModel(Connection connexion, Statement statement, ResultSet resultSet, int customerId, String customerName, String customerSurname, String customerAdress, String customerZip, String customerCity) {
        super(connexion, statement, resultSet);
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerAdress = customerAdress;
        this.customerZip = customerZip;
        this.customerCity = customerCity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }
}
