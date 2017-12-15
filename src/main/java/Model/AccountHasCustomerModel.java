package Model;

public class AccountHasCustomerModel {

    private int account_accountId;
    private int customer_customerId;


    public AccountHasCustomerModel(int account_accountId, int customer_customerId) {
        this.account_accountId = account_accountId;
        this.customer_customerId = customer_customerId;
    }

    public int getAccount_accountId() {
        return account_accountId;
    }

    public void setAccount_accountId(int account_accountId) {
        this.account_accountId = account_accountId;
    }

    public int getCustomer_customerId() {
        return customer_customerId;
    }

    public void setCustomer_customerId(int customer_customerId) {
        this.customer_customerId = customer_customerId;
    }
}
