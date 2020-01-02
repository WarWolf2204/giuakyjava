package view;

import controller.NewStaffController;
import controller.NewStaffControllerImpl;
import controller.StaffController;
import controller.StaffControllerImpl;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ManagerView extends JFrame  implements TableObserver {
    private JPanel panel;
    private JButton DELButton;
    private JButton ADDButton;
    private JTable table;
    StaffTabModel staffTabModel;
    StaffsModel model;

    StaffDao staffDao;



    public ManagerView(StaffsModel model)
    {

        setTitle("Staff Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);

        this.model = model;

        StaffTabModel modelTable = new StaffTabModel(model.getAllStaff());

        model.registerObserver(modelTable);

        table.setModel(modelTable);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               onAddStaff(e);
            }
        });

        DELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();

                if (index != -1){
                    int id = (int) table.getValueAt(index,0);
                    delete(id);
                }
            }
        });

    }


    private void delete(int id)
    {
        StaffController del = new StaffControllerImpl(model);
        del.deleteStaff(id);
    }

    private void onAddStaff(ActionEvent e) {
        NewStaffController controller = new NewStaffControllerImpl(this, model, new AddNew());
        controller.AddNew();
    }
    @Override
    public void updateTable(List<Staff> staff) {
            staffTabModel.updateTable(staff);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
