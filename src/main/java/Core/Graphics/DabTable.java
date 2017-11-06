package Core.Graphics;

import Dao.OperationDao;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Vector;

public class DabTable extends JTable {

    public DabTable() {
    }

    public DabTable(TableModel dm) {
        super(dm);
    }

    public DabTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    public DabTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    public DabTable(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    public DabTable(Vector<? extends Vector> rowData, Vector<?> columnNames) {
        super(rowData, columnNames);
    }

    public DabTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }


}
