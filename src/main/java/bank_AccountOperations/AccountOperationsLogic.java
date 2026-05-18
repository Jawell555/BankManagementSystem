package bank_AccountOperations;

import Database.AccountDatabase;
import Models.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountOperationsLogic {
    
    //Function to search account using account number
    public Account searchAccount(String accountNumber) {
        for (Account acc : AccountDatabase.accounts) {
            if (acc != null && acc.getAccNo() != null) {
                if (acc.getAccNo().equals(accountNumber)) {
                    return acc;
                }
            }
        }
        return null; 
    }
}