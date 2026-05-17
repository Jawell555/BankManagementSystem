package bank_AccountOperations;

import Models.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountOperationsLogic {
    
    //In-memory list of accounts
    private List<Account> accountList;

    public AccountOperationsLogic() {
        accountList = new ArrayList<>();
        
        //Dummy customer accounts  
        Account acc1 = new Account();
        acc1.setAccNo("SPB1000000001");
        acc1.setName("Juan Dela Cruz");
        acc1.setAccTitle("JUAN DELA CRUZ");
        acc1.setAccBal(25000.00);
        acc1.setAccType("Savings");
        acc1.setAccStatus("ACTIVE");
        
        Account acc2 = new Account();
        acc2.setAccNo("SPB1000000002");
        acc2.setName("Maria Santos");
        acc2.setAccTitle("MARIA SANTOS");
        acc2.setAccBal(5000.00);
        acc2.setAccType("Current");
        acc2.setAccStatus("ACTIVE");
        
        Account acc3 = new Account();
        acc3.setAccNo("SPB1000000003");
        acc3.setName("Carlos Reyes");
        acc3.setAccTitle("CARLOS REYES");
        acc3.setAccBal(12500.00);
        acc3.setAccType("Savings");
        acc3.setAccStatus("ACTIVE");

        Account acc4 = new Account();
        acc4.setAccNo("SPB1000000004");
        acc4.setName("Ana Lopez");
        acc4.setAccTitle("ANA LOPEZ");
        acc4.setAccBal(3200.00);
        acc4.setAccType("Savings");
        acc4.setAccStatus("ACTIVE");

        Account acc5 = new Account();
        acc5.setAccNo("SPB1000000005");
        acc5.setName("Mark Bautista");
        acc5.setAccTitle("MARK BAUTISTA");
        acc5.setAccBal(50000.00);
        acc5.setAccType("Current");
        acc5.setAccStatus("ACTIVE");

        Account acc6 = new Account();
        acc6.setAccNo("SPB1000000006");
        acc6.setName("Liza Gomez");
        acc6.setAccTitle("LIZA GOMEZ");
        acc6.setAccBal(7800.00);
        acc6.setAccType("Savings");
        acc6.setAccStatus("ACTIVE");

        Account acc7 = new Account();
        acc7.setAccNo("SPB1000000007");
        acc7.setName("Paul Navarro");
        acc7.setAccTitle("PAUL NAVARRO");
        acc7.setAccBal(18000.00);
        acc7.setAccType("Current");
        acc7.setAccStatus("ACTIVE");

        Account acc8 = new Account();
        acc8.setAccNo("SPB1000000008");
        acc8.setName("Karla Mendoza");
        acc8.setAccTitle("KARLA MENDOZA");
        acc8.setAccBal(2500.00);
        acc8.setAccType("Savings");
        acc8.setAccStatus("ACTIVE");

        // Add to list
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
        accountList.add(acc4);
        accountList.add(acc5);
        accountList.add(acc6);
        accountList.add(acc7);
        accountList.add(acc8);
    }

    //Function to search account using account number
    public Account searchAccount(String accountNumber) {
        for (Account acc : accountList) {
            if (acc != null && acc.getAccNo() != null) {
                if (acc.getAccNo().equals(accountNumber)) {
                    return acc;
                }
            }
        }
        return null; 
    }
}