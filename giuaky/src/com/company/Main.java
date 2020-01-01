package com.company;

import controller.StaffController;
import controller.StaffControllerImpl;
import model.StaffModelImpl;
import model.StaffsModel;

public class Main {

    public static void main(String[] args) {
        StaffsModel staffsModel = new StaffModelImpl();
        StaffController controller = new StaffControllerImpl(staffsModel);
    }
}
