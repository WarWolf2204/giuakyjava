package model;

import view.ManagerView;

import java.util.List;

// CRUD
public interface StaffDao {

    // Create
    void insertStaff(Staff student);

    // Read

    Staff getStaffById(int id);

    List<Staff> getAllStaff();

    // Update

    // Delete

    void Delete(int id);


}
