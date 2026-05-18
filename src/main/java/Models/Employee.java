package Models;

public class Employee {

    private String empID;
    private String empName;
    private String fatherName;
    private String email;
    private String idNumber;
    private String date;
    private String empType;

    // GETTERS

    public String getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmail() {
        return email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getDate() {
        return date;
    }

    public String getEmpType() {
        return empType;
    }

    // SETTERS

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }
}