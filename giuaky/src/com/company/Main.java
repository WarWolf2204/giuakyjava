package com.company;

import controller.StaffController;
import controller.StaffControllerImpl;
import model.StaffModelImpl;
import model.StaffsModel;
import view.ManagerView;

public class Main {

    public static void main(String[] args) {

        StaffsModel staffsModel = new StaffModelImpl();
        ManagerView managerView = new ManagerView(staffsModel);
        managerView.setVisible(true);
    }
}
