package Model;



import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class OperationTableModel extends AbstractTableModel {

    public String []  titreTab = {"Numéro Opération", "Numéro de Compte", "Type Opération", "Montant de l'opération", "Date"};
    public ArrayList<OperationModel> operationList = new ArrayList<OperationModel>();


    public OperationTableModel(ArrayList<OperationModel> operationList) {
        this.operationList = operationList;
    }

    @Override
    public int getRowCount() {
        return this.operationList.size();
    }

    @Override
    public int getColumnCount() {
        return titreTab.length;
    }

    @Override
    public String getColumnName( int column) {

        return titreTab[column];
    }
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return operationList.get(row).getOperationID();
            case 1:
                return operationList.get(row).getOperationAccountNumber();
            case 2:
                return operationList.get(row).getOperationType();
            case 3:
                return operationList.get(row).getOperationAmount();
            case 4:
                return operationList.get(row).getOperationDate();
            default:
                return null;
        }
    }
}

