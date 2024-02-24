import java.util.Objects;

public class TransactionReceipt {

    private TransactionTicket transactionTicket = new TransactionTicket();
    private boolean successIndicatorFlag = true;
    private String reasonForFailure = "";
    private String preTransactionBalance = "";
    private String postTransactionBalance = "";
    private String postTransactionMaturityDate = "";

    public TransactionReceipt(TransactionTicket transactionTicket, boolean successIndicatorFlag,
                              String reasonForFailure, String preTransactionBalance, String postTransactionBalance,
                              String postTransactionMaturityDate) {
        this.transactionTicket = transactionTicket;
        this.successIndicatorFlag = successIndicatorFlag;
        this.reasonForFailure = reasonForFailure;
        this.preTransactionBalance = preTransactionBalance;
        this.postTransactionBalance = postTransactionBalance;
        this.postTransactionMaturityDate = postTransactionMaturityDate;
    }
    public TransactionReceipt(){}

    public TransactionTicket getTransactionTicket() {
        return transactionTicket;
    }

    public void setTransactionTicket(TransactionTicket transactionTicket) {
        this.transactionTicket = transactionTicket;
    }

    public boolean isSuccessIndicatorFlag() {
        return successIndicatorFlag;
    }

    public void setSuccessIndicatorFlag(boolean successIndicatorFlag) {
        this.successIndicatorFlag = successIndicatorFlag;
    }

    public String getReasonForFailure() {
        return reasonForFailure;
    }

    public void setReasonForFailure(String reasonForFailure) {
        this.reasonForFailure = reasonForFailure;
    }

    public String getPreTransactionBalance() {
        return preTransactionBalance;
    }

    public void setPreTransactionBalance(String preTransactionBalance) {
        this.preTransactionBalance = preTransactionBalance;
    }

    public String getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public void setPostTransactionBalance(String postTransactionBalance) {
        this.postTransactionBalance = postTransactionBalance;
    }

    public String getPostTransactionMaturityDate() {
        return postTransactionMaturityDate;
    }

    public void setPostTransactionMaturityDate(String postTransactionMaturityDate) {
        this.postTransactionMaturityDate = postTransactionMaturityDate;
    }

    @Override
    public String toString() {
        return "TransactionReceipt{" +
                "transactionTicket=" + transactionTicket.getDateOfTransaction() + " " + 
                transactionTicket.getTypeOfTransaction() + " " +
                transactionTicket.getAccountNumber() + " " +
                transactionTicket.getAmountOfTransaction() + " " +
                transactionTicket.getTermOfCD() + " " +
                ", successIndicatorFlag=" + successIndicatorFlag + 
                ", reasonForFailure='" + reasonForFailure + '\'' +
                ", preTransactionBalance='" + preTransactionBalance + '\'' +
                ", postTransactionBalance='" + postTransactionBalance + '\'' +
                ", postTransactionMaturityDate='" + postTransactionMaturityDate + '\'' +
                '}';
    }
}
