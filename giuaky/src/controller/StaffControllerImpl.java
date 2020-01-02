package controller;

import model.Staff;
import model.StaffsModel;

import view.AddNew;
import view.ManagerView;

import javax.swing.*;
import java.awt.*;


public class StaffControllerImpl implements StaffController {

    Component parent;

    StaffsModel model;

    ManagerView view;

    AddNew addNew;
    public StaffControllerImpl (Component parent, StaffsModel model, ManagerView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    public StaffControllerImpl(StaffsModel model) {

      this.model =model;
    }

    @Override
    public void deleteStaff(int id) {
       model.deleteStaff(id);
       model.NotifyStaff();
    }

    }


