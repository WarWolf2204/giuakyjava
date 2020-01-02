package model;

import view.ManagerView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class StaffDaoImpl implements StaffDao {

    ManagerView managerView;

    public StaffDaoImpl() {

        Database db = new Database();
        String SQL_CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS StaffTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    FullName text NOT NULL,\n"
                + "    GenDer text \n"
                + ");";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_STUDENTS_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void insertStaff(Staff staff) {

        Database db = new Database();
        final String SQL_CREATE_STUDENT = "INSERT INTO StaffTable(FullName,Gender)" +
                "VALUES(?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_STUDENT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, staff.getFullName());
            ps.setString(2,staff.getGender());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                staff.setId(id);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public Staff getStaffById(int id) {

        Staff staff = null;

        Database db = new Database();

        final String SQL_SELECT_STAFF_BY_ID = "SELECT * FROM StaffTable WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_STAFF_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int studentId = rs.getInt(1);
                String fullName = rs.getString(2);
                String gender = rs.getString(3);
                staff = new Staff();

                System.out.println("ID: " + studentId + ", Full name: " + fullName + ", " + gender +", Gender:");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return staff;
    }

    @Override
    public List<Staff> getAllStaff() {

        List<Staff> staffList = new Vector<>();

        Database db = new Database();

        final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM StaffTable";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_EMPLOYEES);
            while (rs.next()) {

                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String gender = rs.getString(3);
                Staff staff = new Staff(id,fullName,gender);

                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();

        return staffList;
    }



    @Override
    public void Delete(int id) {
        Database db = new Database();
        final String SQL_DELETE_EMPLOYEE_BY_ID = "DELETE FROM StaffTable WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = db.getConnection().prepareStatement(SQL_DELETE_EMPLOYEE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();
    }

}
