package model;

import java.util.List;

public interface StaffsModel {
    List<Staff> getAllStaff();

    void addStaff(Staff staff);


    void deleteStaff(int staff);

    void registerObserver(TableObserver observer);

    void unregisterObserver(TableObserver observer);

    void registerObserver();
}
