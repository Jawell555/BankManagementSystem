package Models;

public class ExternalBankAccount {

    private String accountNumber;
    private String accountName;
    private String bankName;
    private String status;

    public ExternalBankAccount(
            String accountNumber,
            String accountName,
            String bankName,
            String status) {

        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.bankName = bankName;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getStatus() {
        return status;
    }
}