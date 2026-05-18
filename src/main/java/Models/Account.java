package Models;


/**
 *
 * @author Ruell
 */


public class Account {


    private String accNo;
    private String name;
    private String fatherName;
    private String email;
    private String idType;
    private String idNumber;
    private String date;
    private String accType;
    private double accBal;

    // GETTERS
    public String getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getEmail() {
        return email;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getDate() {
        return date;
    }

    public String getAccType() {
        return accType;
    }

    public double getAccBal() {
        return accBal;
    }

    // SETTERS
    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public void setAccBal(double accBal) {
        this.accBal = accBal;
    }
}