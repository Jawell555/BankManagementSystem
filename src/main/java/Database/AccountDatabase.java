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
            "Juan Dela Cruz",
            "Active",
            25000.00,
            "1998-05-14",
            "Male",
            "09123456789",
            "4024",
            "Purok 1 Brgy. San Isidro",
            "Cabuyao City",
            "profile_images/SPB1000000001.png"
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
            "Maria Santos",
            "Active",
            150000.00,
            "1995-08-22",
            "Female",
            "09187654321",
            "4026",
            "Block 12 San Pedro Homes",
            "San Pedro City",
            "profile_images/SPB1000000002.png"
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
            "Carlos Reyes ITF Nathan Reyes",
            "Inactive",
            8900.50,
            "1990-11-03",
            "Male",
            "09234567891",
            "4027",
            "Phase 2 Green Village",
            "Calamba City",
            "profile_images/SPB1000000003.png"
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
            "Ana Lopez",
            "Active",
            45600.00,
            "1997-01-17",
            "Female",
            "09345678123",
            "4028",
            "Villa Rosario Subdivision",
            "Santa Rosa City",
            "profile_images/SPB1000000004.png"
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
            "Mark Bautista",
            "Dormant",
            98000.00,
            "1988-07-09",
            "Male",
            "09456781234",
            "4000",
            "Barangay Mabuhay",
            "Cabuyao City",
            "profile_images/SPB1000000005.png"
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
            "Liza Gomez ITF Sophia Gomez",
            "Active",
            12340.75,
            "1993-09-10",
            "Female",
            "09567812345",
            "4025",
            "Rosewood Village",
            "Biñan City",
            "profile_images/SPB1000000006.png"
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
            "Paul Navarro",
            "Active",
            78500.00,
            "1996-12-01",
            "Male",
            "09678123456",
            "4029",
            "Sunshine Homes",
            "Santa Rosa City",
            "profile_images/SPB1000000007.png"
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
            "Karla Mendoza",
            "Active",
            33210.90,
            "1999-06-27",
            "Female",
            "09781234567",
            "4001",
            "Lakeside Residences",
            "Calamba City",
            "profile_images/SPB1000000008.png"
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
            String accTitle,
            String accStatus,
            double balance,
            String dob,
            String gender,
            String mobileNumber,
            String postalCode,
            String homeAddress,
            String city,
            String profileImage
          
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
        acc.setAccTitle(accTitle);
        acc.setAccStatus(accStatus);
        acc.setAccBal(balance);
        acc.setDob(dob);
        acc.setGender(gender);
        acc.setMobileNumber(mobileNumber);
        acc.setPostalCode(postalCode);
        acc.setHomeAddress(homeAddress);
        acc.setCity(city);
        acc.setProfileImage(profileImage);

        accounts.add(acc);
    }
    
    public static Account getAccountByNumber(String accNo) {

   for (Account acc : accounts) {
            if (acc != null && acc.getAccNo() != null) {
                if (acc.getAccNo().equals(accNo)) {
                    return acc;
                }
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
