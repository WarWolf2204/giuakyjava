package controller;

import model.StaffsModel;

import view.ManagerView;

import java.awt.*;


public class StaffControllerImpl implements StaffController {

    Component parent;

    StaffsModel model;

    ManagerView view;

    public StaffControllerImpl (Component parent, StaffsModel model, ManagerView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    public StaffControllerImpl(StaffsModel model) {

        this.view = new ManagerView(model);
    }

    @Override
    public void deleteStaff(int id) {
       model.deleteStaff(id);
    }
}
