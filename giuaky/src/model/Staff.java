package model;

public class Staff {
    int id;
    String FullName;
    String gender;


    public Staff() {

    }

    public Staff(int id, String fullName, String gender) {
        this.id = id;
        this.FullName = fullName;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getFullName() {
        return FullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
