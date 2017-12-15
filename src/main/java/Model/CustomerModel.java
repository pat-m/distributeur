package Model;

import Core.Model;

public class CustomerModel extends Model {

    private int customerId;
    private String customerName;
    private String customerSurname;
    private String customerAdress;
    private String customerZip;
    private String customerCity;

    public CustomerModel(int customerId, String customerName, String customerSurname, String customerAdress, String customerZip, String customerCity) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerAdress = customerAdress;
        this.customerZip = customerZip;
        this.customerCity = customerCity;
    }
}
