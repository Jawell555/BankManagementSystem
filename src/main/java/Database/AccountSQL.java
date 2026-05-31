package Database;

import Models.Account;
import java.sql.*;
import java.util.ArrayList;

public class AccountSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static ArrayList<Account> getAllAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();

        String sql = "SELECT * FROM accounts";

        try (
                
             Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Account acc = new Account();

                acc.setAccNo(rs.getString("acc_no"));
                acc.setName(rs.getString("name"));
                acc.setFatherName(rs.getString("father_name"));
                acc.setEmail(rs.getString("email"));
                acc.setIdType(rs.getString("id_type"));
                acc.setIdNumber(rs.getString("id_number"));
                acc.setDate(rs.getString("date_created"));
                acc.setAccType(rs.getString("acc_type"));
                acc.setAccTitle(rs.getString("acc_title"));
                acc.setAccStatus(rs.getString("acc_status"));
                acc.setAccBal(rs.getDouble("acc_bal"));
                acc.setDob(rs.getString("dob"));
                acc.setGender(rs.getString("gender"));
                acc.setMobileNumber(rs.getString("mobile_number"));
                acc.setPostalCode(rs.getString("postal_code"));
                acc.setHomeAddress(rs.getString("home_address"));
                acc.setCity(rs.getString("city"));
                acc.setProfileImage(rs.getString("profile_image"));

                accounts.add(acc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return accounts;
    }

    // GET ACCOUNT BY NUMBER
    public static Account getAccountByNumber(String accNo) {

        String sql = "SELECT * FROM accounts WHERE acc_no = ?";

        try (Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, accNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Account acc = new Account();

                acc.setAccNo(rs.getString("acc_no"));
                acc.setName(rs.getString("name"));
                acc.setFatherName(rs.getString("father_name"));
                acc.setEmail(rs.getString("email"));
                acc.setIdType(rs.getString("id_type"));
                acc.setIdNumber(rs.getString("id_number"));
                acc.setDate(rs.getString("date_created"));
                acc.setAccType(rs.getString("acc_type"));
                acc.setAccTitle(rs.getString("acc_title"));
                acc.setAccStatus(rs.getString("acc_status"));
                acc.setAccBal(rs.getDouble("acc_bal"));
                acc.setDob(rs.getString("dob"));
                acc.setGender(rs.getString("gender"));
                acc.setMobileNumber(rs.getString("mobile_number"));
                acc.setPostalCode(rs.getString("postal_code"));
                acc.setHomeAddress(rs.getString("home_address"));
                acc.setCity(rs.getString("city"));
                acc.setProfileImage(rs.getString("profile_image"));

                return acc;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // TOTAL BALANCE
    public static double getTotalBalance() {

        String sql = "SELECT SUM(acc_bal) AS total FROM accounts";

        try (Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // INSERT ACCOUNT
    public static boolean addAccount(Account acc) {

        String sql = """
            INSERT INTO accounts (
                acc_no, name, father_name, email, id_type, id_number,
                date_created, acc_type, acc_title, acc_status,
                acc_bal, dob, gender, mobile_number,
                postal_code, home_address, city, profile_image
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, acc.getAccNo());
            stmt.setString(2, acc.getName());
            stmt.setString(3, acc.getFatherName());
            stmt.setString(4, acc.getEmail());
            stmt.setString(5, acc.getIdType());
            stmt.setString(6, acc.getIdNumber());
            stmt.setString(7, acc.getDate());
            stmt.setString(8, acc.getAccType());
            stmt.setString(9, acc.getAccTitle());
            stmt.setString(10, acc.getAccStatus());
            stmt.setDouble(11, acc.getAccBal());
            stmt.setString(12, acc.getDob());
            stmt.setString(13, acc.getGender());
            stmt.setString(14, acc.getMobileNumber());
            stmt.setString(15, acc.getPostalCode());
            stmt.setString(16, acc.getHomeAddress());
            stmt.setString(17, acc.getCity());
            stmt.setString(18, acc.getProfileImage());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public static boolean deleteAccount(String accNo) {

        String sql = "DELETE FROM accounts WHERE acc_no = ?";

        try (Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, accNo);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public static boolean updateAccount(Account acc) {

        String sql = """
            UPDATE accounts SET
                name=?, father_name=?, email=?, id_type=?,
                id_number=?, acc_type=?, acc_title=?, acc_status=?,
                dob=?, gender=?, mobile_number=?, postal_code=?,
                home_address=?, city=?, profile_image=?
            WHERE acc_no=?
        """;

        try (Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, acc.getName());
            stmt.setString(2, acc.getFatherName());
            stmt.setString(3, acc.getEmail());
            stmt.setString(4, acc.getIdType());
            stmt.setString(5, acc.getIdNumber());
            stmt.setString(6, acc.getAccType());
            stmt.setString(7, acc.getAccTitle());
            stmt.setString(8, acc.getAccStatus());
            stmt.setString(9, acc.getDob());
            stmt.setString(10, acc.getGender());
            stmt.setString(11, acc.getMobileNumber());
            stmt.setString(12, acc.getPostalCode());
            stmt.setString(13, acc.getHomeAddress());
            stmt.setString(14, acc.getCity());
            stmt.setString(15, acc.getProfileImage());
            stmt.setString(16, acc.getAccNo());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}