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
        this.model = model;
        this.model.registerObserver(this);

        setTitle("Staff Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);

        staffTabModel = new StaffTabModel();
        table.setModel(staffTabModel);


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
        List<Staff> staff = this.model.getAllStaff();
        staffTabModel.updateStaff(staff);
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
            staffTabModel.updateStaff(staff);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
