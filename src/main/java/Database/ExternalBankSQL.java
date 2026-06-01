package Database;

import Models.ExternalBankAccount;
import java.sql.*;

public class ExternalBankSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static ExternalBankAccount getExternalAccount(String accNo) {
        
        String sql =
            "SELECT * FROM external_bank_accounts WHERE account_number=?";

        try (
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pst = con.prepareStatement(sql)
        ) {

            pst.setString(1, accNo);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                return new ExternalBankAccount(
                    rs.getString("account_number"),
                    rs.getString("account_name"),
                    rs.getString("bank_name"),
                    rs.getString("status")
                );
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}