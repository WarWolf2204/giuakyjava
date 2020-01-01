package controller;

import model.Staff;
import model.StaffsModel;
import view.AddNew;

import javax.swing.*;
import java.awt.*;

public class NewStaffControllerImpl implements NewStaffController {

             Component parent;

            StaffsModel model;

             AddNew view;

    public NewStaffControllerImpl(Component parent, StaffsModel model, AddNew view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }


    @Override
    public void AddNew() {
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootpanel(),
                "New Staff",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            String fullName = view.getName();
            String gender = view.getGender();

            Staff staff = new Staff();

            staff.setFullName(fullName);
            staff.setGender(gender);

            model.addStaff(staff);
        }
    }
}
