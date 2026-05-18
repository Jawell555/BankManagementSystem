package Database;

import Models.Account;
import java.util.ArrayList;

public class AccountDatabase {

    public static ArrayList<Account> accounts = new ArrayList<>();

    static {

        addAccount(
                "SPB1000000001",
                "Juan Dela Cruz",
                "Pedro Dela Cruz",
                "juan.delacruz@mail.com",
                "National ID",
                "901234567890",
                "2023-01-15",
                "Savings",
                25000.00
        );

        addAccount(
                "SPB1000000002",
                "Maria Santos",
                "Jose Santos",
                "maria.santos@mail.com",
                "Passport",
                "P1234567",
                "2022-11-08",
                "Current",
                150000.00
        );

        addAccount(
                "SPB1000000003",
                "Carlos Reyes",
                "Antonio Reyes",
                "carlos.reyes@mail.com",
                "Driver's License",
                "D-987654321",
                "2021-06-21",
                "Savings",
                8900.50
        );

        addAccount(
                "SPB1000000004",
                "Ana Lopez",
                "Ricardo Lopez",
                "ana.lopez@mail.com",
                "National ID",
                "904567890123",
                "2023-03-10",
                "Savings",
                45600.00
        );

        addAccount(
                "SPB1000000005",
                "Mark Bautista",
                "Daniel Bautista",
                "mark.bautista@mail.com",
                "Passport",
                "P7654321",
                "2020-09-05",
                "Current",
                98000.00
        );

        addAccount(
                "SPB1000000006",
                "Liza Gomez",
                "Fernando Gomez",
                "liza.gomez@mail.com",
                "National ID",
                "906789012345",
                "2022-07-19",
                "Savings",
                12340.75
        );

        addAccount(
                "SPB1000000007",
                "Paul Navarro",
                "Victor Navarro",
                "paul.navarro@mail.com",
                "Driver's License",
                "D-123456789",
                "2021-12-01",
                "Current",
                78500.00
        );

        addAccount(
                "SPB1000000008",
                "Karla Mendoza",
                "Ernesto Mendoza",
                "karla.mendoza@mail.com",
                "National ID",
                "908901234567",
                "2023-05-25",
                "Savings",
                33210.90
        );
    }

    private static void addAccount(
            String accNo,
            String name,
            String fatherName,
            String email,
            String idType,
            String idNumber,
            String date,
            String accType,
            double balance
    ) {

        Account acc = new Account();

        acc.setAccNo(accNo);
        acc.setName(name);
        acc.setFatherName(fatherName);
        acc.setEmail(email);
        acc.setIdType(idType);
        acc.setIdNumber(idNumber);
        acc.setDate(date);
        acc.setAccType(accType);
        acc.setAccBal(balance);

        accounts.add(acc);
    }
    
    public static Account getAccountByNumber(String accNo) {

    for (Account acc : accounts) {

        if (acc.getAccNo().equalsIgnoreCase(accNo)) {
            return acc;
        }
    }

    return null;
    }
    public double getTotalBalance(){
        double total=0;
        for (Account acc : accounts){
            total+=acc.getAccBal();
        }
        return total;
    }
}