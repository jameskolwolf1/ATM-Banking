import java.util.Objects;

public class TransactionTicket {

    private String dateOfTransaction;
    private String typeOfTransaction;
    private String accountNumber;
    private String amountOfTransaction;
    private int termOfCD;

    public TransactionTicket(String dateOfTransaction, String typeOfTransaction, String accountNumber,
                             String amountOfTransaction, int termOfCD) {
        this.dateOfTransaction = dateOfTransaction;
        this.typeOfTransaction = typeOfTransaction;
        this.accountNumber = accountNumber;
        this.amountOfTransaction = amountOfTransaction;
        this.termOfCD = termOfCD;
    }
    public TransactionTicket(){}

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmountOfTransaction() {
        return amountOfTransaction;
    }

    public void setAmountOfTransaction(String amountOfTransaction) {
        this.amountOfTransaction = amountOfTransaction;
    }

    public int getTermOfCD() {
        return termOfCD;
    }

    public void setTermOfCD(int termOfCD) {
        this.termOfCD = termOfCD;
    }

    @Override
    public String toString() {


        String returningTicket =
        "Todays Date: " + dateOfTransaction + "\n"+
        "Type Of Transaction: " + typeOfTransaction + "\n" + 
        "Account Number: " + accountNumber + "\n" +
        "Transaction Amount: " + amountOfTransaction + "\n";

        if(termOfCD != 0){
            returningTicket = returningTicket + "CD Term: " + termOfCD;
        }

        return returningTicket;        
    }
}
