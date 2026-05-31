package Database;

import Models.Employee;
import java.util.ArrayList;

public class EmployeeDatabase {

    public static ArrayList<Employee> employees = new ArrayList<>();

    static {

        addEmployee(
                "EMP2001",
                "Juan Dela Cruz",
                "juan.delacruz@summitphilbank.com",
                "812345678901",
                "2023-01-15",
                "Employee",
                "juandelacruz01",
                "juan123",
                "1998-05-14",
                "Male",
                "Single",
                "09123456789",
                "4024",
                "Purok 1 Brgy. San Isidro",
                "Cabuyao",
                "BS Information Technology",
                "Bank Staff",
                "3 Years",
                "Active",
                "profile_images/EMP2001.png"
        );

        addEmployee(
                "EMP2002",
                "Angela Villanueva",
                "angela.villanueva@summitphilbank.com",
                "823456789012",
                "2022-10-11",
                "Employee",
                "angela02",
                "angela123",
                "1997-03-22",
                "Female",
                "Married",
                "09187654321",
                "4102",
                "Block 12 San Pedro Homes",
                "San Pedro",
                "BS Business Administration",
                "Customer Service Representative",
                "5 Years",
                "Active",
                "profile_images/EMP2002.png"
        );

        addEmployee(
                "EMP2003",
                "Michael Torres",
                "michael.torres@summitphilbank.com",
                "834567890123",
                "2021-06-08",
                "Employee",
                "michael03",
                "michael123",
                "1995-11-09",
                "Male",
                "Single",
                "09234567891",
                "4114",
                "Phase 2 Green Village",
                "Calamba",
                "BS Accountancy",
                "Accounting Assistant",
                "4 Years",
                "Active",
                "profile_images/EMP2003.png"
        );

        addEmployee(
                "EMP2004",
                "Patricia Gomez",
                "patricia.gomez@summitphilbank.com",
                "845678901234",
                "2020-09-15",
                "Employee",
                "patricia04",
                "patricia123",
                "1996-01-17",
                "Female",
                "Single",
                "09345678123",
                "4009",
                "Villa Rosario Subdivision",
                "Santa Rosa",
                "BS Financial Management",
                "Loan Officer",
                "6 Years",
                "Active",
                "profile_images/EMP2004.png"
        );

        addEmployee(
                "EMP2005",
                "Daniel Navarro",
                "daniel.navarro@summitphilbank.com",
                "856789012345",
                "2023-02-28",
                "Employee",
                "daniel05",
                "daniel123",
                "1999-07-05",
                "Male",
                "Single",
                "09456781234",
                "4027",
                "Barangay Mabuhay",
                "Cabuyao",
                "BS Information Systems",
                "IT Support Staff",
                "2 Years",
                "Active",
                "profile_images/EMP2005.png"
        );

        addEmployee(
                "EMP2006",
                "Nicole Reyes",
                "nicole.reyes@summitphilbank.com",
                "867890123456",
                "2021-04-18",
                "Employee",
                "nicole06",
                "nicole123",
                "1994-09-10",
                "Female",
                "Married",
                "09567812345",
                "4012",
                "Rosewood Village",
                "Biñan",
                "BS Marketing Management",
                "Marketing Associate",
                "7 Years",
                "Active",
                "profile_images/EMP2006.png"
        );

        addEmployee(
                "EMP2007",
                "Kevin Ramirez",
                "kevin.ramirez@summitphilbank.com",
                "878901234567",
                "2022-08-03",
                "Employee",
                "kevin07",
                "kevin123",
                "1997-12-01",
                "Male",
                "Single",
                "09678123456",
                "4005",
                "Sunshine Homes",
                "Santa Rosa",
                "BS Computer Science",
                "System Administrator",
                "4 Years",
                "Active",
                "profile_images/EMP2007.png"
        );

        addEmployee(
                "EMP2008",
                "Sophia Mendoza",
                "sophia.mendoza@summitphilbank.com",
                "889012345678",
                "2020-11-25",
                "Employee",
                "sophia08",
                "sophia123",
                "1993-06-27",
                "Female",
                "Married",
                "09781234567",
                "4030",
                "Lakeside Residences",
                "Calamba",
                "BS Human Resource Management",
                "HR Officer",
                "8 Years",
                "Active",
                "profile_images/EMP2008.png"
        );

        addEmployee(
                "EMP2009",
                "Ethan Cruz",
                "ethan.cruz@summitphilbank.com",
                "890123456789",
                "2023-01-09",
                "Employee",
                "ethan09",
                "ethan123",
                "2000-02-15",
                "Male",
                "Single",
                "09812345678",
                "4021",
                "Greenfield Estate",
                "San Pablo",
                "BS Entrepreneurship",
                "Sales Associate",
                "1 Year",
                "Active",
                "profile_images/EMP2009.png"
        );

        addEmployee(
                "EMP2010",
                "Camille Bautista",
                "camille.bautista@summitphilbank.com",
                "901234567891",
                "2021-09-14",
                "Employee",
                "camille10",
                "camille123",
                "1995-04-30",
                "Female",
                "Single",
                "09923456789",
                "4018",
                "Golden Meadows",
                "Los Baños",
                "BS Office Administration",
                "Administrative Assistant",
                "5 Years",
                "Active",
                "profile_images/EMP2010.png"
        );
    }

    private static void addEmployee(
            String empID,
            String empName,
            String email,
            String idNumber,
            String date,
            String empType,
            String username,
            String password,
            String dob,
            String gender,
            String maritalStatus,
            String mobileNumber,
            String postalCode,
            String homeAddress,
            String city,
            String educationLevel,
            String currentJob,
            String yearsExperience,
            String status,
            String profileImage
    ) {

        Employee emp = new Employee();

        emp.setEmpID(empID);
        emp.setEmpName(empName);
        emp.setEmail(email);
        emp.setIdNumber(idNumber);
        emp.setDate(date);
        emp.setEmpType(empType);
        emp.setUsername(username);
        emp.setPassword(password);
        emp.setDob(dob);
        emp.setGender(gender);
        emp.setMaritalStatus(maritalStatus);
        emp.setMobileNumber(mobileNumber);
        emp.setPostalCode(postalCode);
        emp.setHomeAddress(homeAddress);
        emp.setCity(city);
        emp.setEducationLevel(educationLevel);
        emp.setCurrentJob(currentJob);
        emp.setYearsExperience(yearsExperience);
        emp.setStatus(status);
        emp.setProfileImage(profileImage);

        employees.add(emp);
    }

    // GET EMPLOYEE BY ID
    public static Employee getEmployeeByID(String empID) {

        for (Employee emp : employees) {

            if (emp.getEmpID().equalsIgnoreCase(empID)) {
                return emp;
            }
        }

        return null;
    }

    // GET EMPLOYEE BY USERNAME
    public static Employee getEmployeeByUsername(String username) {

        for (Employee emp : employees) {

            if (emp.getUsername().equalsIgnoreCase(username)) {
                return emp;
            }
        }

        return null;
    }

    public static Employee currentEmployee;
}