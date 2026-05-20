package Models;

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
    private String accTitle;
    private String accStatus;
    private String dob;
    private String gender;
    private String mobileNumber;
    private String postalCode;
    private String homeAddress;
    private String city;

    public Account() {
    }

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
    
    public String getAccTitle(){
            return accTitle;
    }
    
    public String getAccStatus(){
            return accStatus;
    }
    
    public String getDob() {
    return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getCity() {
        return city;
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
    
    public void setAccTitle(String accTitle) {
        this.accTitle = accTitle;
    }
    
    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }
    
    public void setDob(String dob) {
    this.dob = dob;
}

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
