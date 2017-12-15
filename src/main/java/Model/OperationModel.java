package Model;

import Core.Model;
import Dao.OperationDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OperationModel extends Model {

    public int operationID;
    public int operationAccountNumber;
    public int operationType;
    public double operationAmount;
    public Date operationDate;
    public int operationPaymentType;
    ArrayList<OperationDao> operationList = new ArrayList<OperationDao>();

    public OperationModel() {
    }

    public OperationModel(Connection connexion, Statement statement, ResultSet resultSet, int operationID, int operationAccountNumber, int operationType, double operationAmount, Date operationDate, int operationPaymentType) {
        super(connexion, statement, resultSet);
        this.operationID = operationID;
        this.operationAccountNumber = operationAccountNumber;
        this.operationType = operationType;
        this.operationAmount = operationAmount;
        this.operationDate = operationDate;
        this.operationPaymentType = operationPaymentType;
    }

    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public int getOperationAccountNumber() {
        return operationAccountNumber;
    }

    public void setOperationAccountNumber(int operationAccountNumber) {
        this.operationAccountNumber = operationAccountNumber;
    }

    public String getOperationType() {
        switch (this.operationType) {
            case 0:
                return "Retrait";
            case 1:
                return "Dépot";
        }

        return Integer.toString(operationType);
    }

    public void setOperationType(int operationType) {

        this.operationType = operationType;
    }

    public double getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(double operationAmount) {
        this.operationAmount = operationAmount;
    }

    public String getOperationDate() {
        DateFormat df = new SimpleDateFormat("d-MM-y");
        String date = df.format(this.operationDate);
        return date;
    }

    public void setOperationDate(Date operationDate) {

        this.operationDate = operationDate;
    }

    public String getOperationPaymentType() {
        switch (this.operationPaymentType) {
            case 0:
                return "Chéque";
            case 1:
                return "Carte Bancaire";
        }

        return Integer.toString(operationPaymentType);
    }

    public void setOperationPaymentType(int operationPaymentType) {
        this.operationPaymentType = operationPaymentType;
    }
}
