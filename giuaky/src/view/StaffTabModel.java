package view;

import model.Staff;
import model.TableObserver;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class StaffTabModel extends AbstractTableModel implements TableObserver {

     List<Staff> staffList = new Vector<>();

    private static final String[] COLUMN_NAMES = {"ID", "Full Name","Gen Der"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int GEN_DER =2;

    public StaffTabModel(List<Staff> allStaff) {
        this.staffList = allStaff;
    }

    @Override
    public int getRowCount() {
        return staffList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Staff staff = staffList.get(rowIndex);
        if (columnIndex == ID) {
            return staff.getId();
        } else if (columnIndex == FULL_NAME) {
            return staff.getFullName();
        }else if (columnIndex == GEN_DER )
        {
            return staff.getGender();
        }
        return null;
    }

    @Override
    public void updateTable(List<Staff> staff) {
        this.staffList.clear();
        this.staffList.addAll(staff);
        fireTableDataChanged();
    }
}
