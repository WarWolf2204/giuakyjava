package model;

import java.util.List;
import java.util.Vector;

public class StaffModelImpl implements StaffsModel {

    private List<TableObserver> tableObservers = new Vector<>();

    @Override
    public List<Staff> getAllStaff() {
        StaffDao dao = new StaffDaoImpl();
        return dao.getAllStaff();
    }

    @Override
    public void addStaff(Staff staff) {
        StaffDao dao = new StaffDaoImpl();
        dao.insertStaff(staff);
        notifyObservers();
    }

    @Override
    public void deleteStaff(int id) {
       StaffDao dao = new StaffDaoImpl();
       dao.Delete(id);

    }

    @Override
    public void registerObserver(TableObserver observer) {
        if (!tableObservers.contains(observer))
            tableObservers.add(observer);
    }

    @Override
    public void unregisterObserver(TableObserver observer) {
        tableObservers.remove(observer);
    }

    @Override
    public void registerObserver() {

    }

    private void notifyObservers() {
        List<Staff> allStaff = getAllStaff();
        for (TableObserver observer: tableObservers) {
            observer.updateTable(allStaff);
        }
    }
}
