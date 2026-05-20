package Database;

import Models.Employee;
import java.util.ArrayList;

public class EmployeeDatabase {

    public static ArrayList<Employee> employees =
            new ArrayList<>();

    static {

        addEmployee(
                "EMP2001",
                "Juan Dela Cruz",
                "juan.delacruz@summitphilbank.com",
                "901234567890",
                "2023-01-15",
                "Employee",
                "juandelacruz01",
                "juan123"
        );

        addEmployee(
                "EMP2002",
                "Maria Santos",
                "maria.santos@summitphilbank.com",
                "902345678901",
                "2022-11-08",
                "Employee",
                "maria02",
                "maria123"
        );

        addEmployee(
                "EMP2003",
                "Carlos Reyes",
                "carlos.reyes@summitphilbank.com",
                "903456789012",
                "2021-06-21",
                "Employee",
                "carlos03",
                "carlos123"
        );

        addEmployee(
                "EMP2004",
                "Ana Lopez",
                "ana.lopez@summitphilbank.com",
                "904567890123",
                "2023-03-10",
                "Employee",
                "ana04",
                "ana123"
        );

        addEmployee(
                "EMP2005",
                "Mark Bautista",
                "mark.bautista@summitphilbank.com",
                "905678901234",
                "2020-09-05",
                "Employee",
                "mark05",
                "mark123"
        );

        addEmployee(
                "EMP2006",
                "Liza Gomez",
                "liza.gomez@summitphilbank.com",
                "906789012345",
                "2022-07-19",
                "Employee",
                "liza06",
                "liza123"
        );

        addEmployee(
                "EMP2007",
                "Paul Navarro",
                "paul.navarro@summitphilbank.com",
                "907890123456",
                "2021-12-01",
                "Employee",
                "paul07",
                "paul123"
        );

        addEmployee(
                "EMP2008",
                "Karla Mendoza",
                "karla.mendoza@summitphilbank.com",
                "908901234567",
                "2023-05-25",
                "Employee",
                "karla08",
                "karla123"
        );

        addEmployee(
                "EMP2009",
                "Ryan Castillo",
                "ryan.castillo@summitphilbank.com",
                "909012345678",
                "2022-02-14",
                "Employee",
                "ryan09",
                "ryan123"
        );

        addEmployee(
                "EMP2010",
                "Sophia Ramos",
                "sophia.ramos@summitphilbank.com",
                "910123456789",
                "2023-08-30",
                "Employee",
                "sophia10",
                "sophia123"
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
            String password
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
    
    public static Employee getEmployeeByUsername(String username){
        
        for(Employee emp : employees){
            if(emp.getUsername().equalsIgnoreCase(username)){
                return emp;
            }
        }
        return null;
    }
    
    public static Employee currentEmployee;
}