package Database;

import Models.Employee;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeSQL {
    
    private static final String URL = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // ADD EMPLOYEE
    public static boolean addEmployee(Employee emp) {

        String sql = """
            INSERT INTO employees (
                emp_id,
                emp_name,
                email,
                id_number,
                date_hired,
                emp_type,
                username,
                password,
                dob,
                gender,
                marital_status,
                mobile_number,
                postal_code,
                home_address,
                city,
                education_level,
                current_job,
                years_experience,
                status,
                profile_image
            )
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
        """;

        try (
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, emp.getEmpID());
            ps.setString(2, emp.getEmpName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getIdNumber());
            ps.setString(5, emp.getDate());
            ps.setString(6, emp.getEmpType());
            ps.setString(7, emp.getUsername());
            ps.setString(8, emp.getPassword());
            ps.setString(9, emp.getDob());
            ps.setString(10, emp.getGender());
            ps.setString(11, emp.getMaritalStatus());
            ps.setString(12, emp.getMobileNumber());
            ps.setString(13, emp.getPostalCode());
            ps.setString(14, emp.getHomeAddress());
            ps.setString(15, emp.getCity());
            ps.setString(16, emp.getEducationLevel());
            ps.setString(17, emp.getCurrentJob());
            ps.setString(18, emp.getYearsExperience());
            ps.setString(19, emp.getStatus());
            ps.setString(20, emp.getProfileImage());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // UPDATE EMPLOYEE
    public static boolean updateEmployee(Employee emp) {

        String sql = """
            UPDATE employees
            SET emp_name=?,
                email=?,
                id_number=?,
                emp_type=?,
                username=?,
                password=?,
                dob=?,
                gender=?,
                marital_status=?,
                mobile_number=?,
                postal_code=?,
                home_address=?,
                city=?,
                education_level=?,
                current_job=?,
                years_experience=?,
                status=?,
                profile_image=?
            WHERE emp_id=?
        """;

        try (
           Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getIdNumber());
            ps.setString(4, emp.getEmpType());
            ps.setString(5, emp.getUsername());
            ps.setString(6, emp.getPassword());
            ps.setString(7, emp.getDob());
            ps.setString(8, emp.getGender());
            ps.setString(9, emp.getMaritalStatus());
            ps.setString(10, emp.getMobileNumber());
            ps.setString(11, emp.getPostalCode());
            ps.setString(12, emp.getHomeAddress());
            ps.setString(13, emp.getCity());
            ps.setString(14, emp.getEducationLevel());
            ps.setString(15, emp.getCurrentJob());
            ps.setString(16, emp.getYearsExperience());
            ps.setString(17, emp.getStatus());
            ps.setString(18, emp.getProfileImage());
            ps.setString(19, emp.getEmpID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE EMPLOYEE
    public static boolean deleteEmployee(String empID) {

        String sql = "DELETE FROM employees WHERE emp_id=?";

        try (
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, empID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET EMPLOYEE BY ID
    public static Employee getEmployeeByID(String empID) {

        String sql = "SELECT * FROM employees WHERE emp_id=?";

        try (
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, empID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return createEmployee(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // GET EMPLOYEE BY USERNAME
    public static Employee getEmployeeByUsername(String username) {

        String sql = "SELECT * FROM employees WHERE username=?";

        try (
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return createEmployee(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // GET ALL EMPLOYEES
    public static ArrayList<Employee> getAllEmployees() {

        ArrayList<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees ORDER BY emp_id";

        try (
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                employees.add(createEmployee(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // HELPER METHOD
    private static Employee createEmployee(ResultSet rs)
            throws SQLException {

        Employee emp = new Employee();

        emp.setEmpID(rs.getString("emp_id"));
        emp.setEmpName(rs.getString("emp_name"));
        emp.setEmail(rs.getString("email"));
        emp.setIdNumber(rs.getString("id_number"));
        emp.setDate(rs.getString("date_hired"));
        emp.setEmpType(rs.getString("emp_type"));
        emp.setUsername(rs.getString("username"));
        emp.setPassword(rs.getString("password"));
        emp.setDob(rs.getString("dob"));
        emp.setGender(rs.getString("gender"));
        emp.setMaritalStatus(rs.getString("marital_status"));
        emp.setMobileNumber(rs.getString("mobile_number"));
        emp.setPostalCode(rs.getString("postal_code"));
        emp.setHomeAddress(rs.getString("home_address"));
        emp.setCity(rs.getString("city"));
        emp.setEducationLevel(rs.getString("education_level"));
        emp.setCurrentJob(rs.getString("current_job"));
        emp.setYearsExperience(rs.getString("years_experience"));
        emp.setStatus(rs.getString("status"));
        emp.setProfileImage(rs.getString("profile_image"));

        return emp;
    }

    // CURRENT LOGGED-IN EMPLOYEE
    public static Employee currentEmployee;
    
    public static boolean changePassword(String empID, String newPassword) {

        String sql = """
            UPDATE employees
            SET password=?
            WHERE emp_id=?
        """;

        try (
            Connection conn = DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
            );
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, newPassword);
            ps.setString(2, empID);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}