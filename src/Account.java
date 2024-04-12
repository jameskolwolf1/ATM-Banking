import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Account {

    private Depositor depositor;
    private String accountNumber;
    private String accountType;
    private boolean accountStatus = true;
    private String accountBalance;
    private String cdDate;
    private ArrayList<TransactionReceipt> transactionReceipts = new ArrayList<TransactionReceipt>();

    public Account(Depositor depositor, String accountNumber, String accountType,
                   String accountBalance, String cdDate) {
        this.depositor = depositor;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.cdDate = cdDate;
    }
    public Account(){}

//    public Account(Depositor depositor, String accountNumber, String accountType,
//                   String accountBalance) {
//        this.depositor = depositor;
//        this.accountNumber = accountNumber;
//        this.accountType = accountType;
//        this.accountStatus = accountStatus;
//        this.accountBalance = accountBalance;
//        this.cdDate = cdDate;
//        this.transactionReceipts = transactionReceipts;
//    }
//
//    public Account(Depositor depositor, String accountNumber, String accountType, boolean accountStatus, String accountBalance, String cdDate, ArrayList<TransactionReceipt> transactionReceipts) {
//        this.depositor = depositor;
//        this.accountNumber = accountNumber;
//        this.accountType = accountType;
//        this.accountStatus = accountStatus;
//        this.accountBalance = accountBalance;
//        this.cdDate = cdDate;
//        this.transactionReceipts = transactionReceipts;
//    }

    public TransactionReceipt getBalance(TransactionTicket transactionTicket){


        if(!isAccountStatus()){

            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket,false,
                    "The account is closed", null, null,
                    null);

            getTransactionReceipts().add(transactionReceipt);
            transactionReceipts.toString();
            return transactionReceipt;

        }
        if(getAccountType().equals("CD")){

            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, true,
                    null, null, getAccountBalance(),getCdDate());
            
            getTransactionReceipts().add(transactionReceipt);
            System.out.println(transactionReceipt.toString());
            return transactionReceipt;
        }

        TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket,true,
                null, null,getAccountBalance(),null);

        getTransactionReceipts().add(transactionReceipt);
        System.out.println("Hello3");

        System.out.println(transactionReceipts.toString());
    
        return transactionReceipt;
    }
    public TransactionReceipt makeDeposit(TransactionTicket transactionTicket, String amount, int newDate){

        double convAmount = Double.parseDouble(amount);
        double convBalance = Double.parseDouble(getAccountBalance());
        double newAmount = convAmount + convBalance;
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String dateTrans = formatter.format(date); 

        transactionTicket.setTypeOfTransaction("Deposit");
        transactionTicket.setAmountOfTransaction(amount);
        transactionTicket.setAccountNumber(getAccountNumber());
        transactionTicket.setDateOfTransaction(dateTrans);

        if(!isAccountStatus()){

            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket,false,
                    "The account is closed", null, null,
                    null);

            getTransactionReceipts().add(transactionReceipt);
            System.out.println(transactionReceipt.toString());

            return transactionReceipt;

        }
        if(getAccountType().equals("CD")){

            Calendar userDate = Calendar.getInstance();
            String [] userCDDate = getCdDate().split("/");
            userDate.set(Calendar.MONTH, Integer.parseInt(userCDDate[0]));
            userDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(userCDDate[1]));
            userDate.set(Calendar.YEAR, Integer.parseInt(userCDDate[2]));
            userDate.set(Calendar.HOUR, 0);
            userDate.set(Calendar.MINUTE, 0);
            userDate.set(Calendar.SECOND, 0);
            userDate.set(Calendar.MILLISECOND, 0);

            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            if(userDate.after(calendar) || userDate.equals(calendar)){

                calendar.add(Calendar.MONTH, newDate);

                String mouth = String.valueOf(calendar.get(Calendar.MONTH));
                String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
                String year = String.valueOf(calendar.get(Calendar.YEAR));

                String newCDdate = mouth + "/" + day + "/" + year;

                TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, true,
                        null, getAccountBalance(), Double.toString(newAmount),newCDdate);

                setAccountBalance(Double.toString(newAmount));

                getTransactionReceipts().add(transactionReceipt);
                System.out.println(transactionReceipt.toString());
                return transactionReceipt;
            }

            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                    "Maturity Date has not pass", null, getAccountBalance(),getCdDate());

            getTransactionReceipts().add(transactionReceipt);
            System.out.println(transactionReceipt.toString());
            return transactionReceipt;
        }

        
        TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket,true,
                null, getAccountBalance(),Double.toString(newAmount),null);

        setAccountBalance(Double.toString(newAmount));

        getTransactionReceipts().add(transactionReceipt);
        System.out.println(transactionReceipt.toString());
        return transactionReceipt;
    }
    public TransactionReceipt makeWithdrawal(TransactionTicket transactionTicket, String amount, int newDate){

        double convAmount = Double.parseDouble(amount);
        double convBalance = Double.parseDouble(getAccountBalance());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String dateTrans = formatter.format(date); 

        transactionTicket.setTypeOfTransaction("Withdraw");
        transactionTicket.setAmountOfTransaction(amount);
        transactionTicket.setAccountNumber(getAccountNumber());
        transactionTicket.setDateOfTransaction(dateTrans);

        if(!isAccountStatus()){

            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket,false,
                    "The account is closed", null, null,
                    null);

            getTransactionReceipts().add(transactionReceipt);
            System.out.println(transactionReceipt.toString());

            return transactionReceipt;

        }
        if(getAccountType().equals("CD")){

            Calendar userDate = Calendar.getInstance();
            String [] userCDDate = getCdDate().split("/");
            userDate.set(Calendar.MONTH, Integer.parseInt(userCDDate[0]));
            userDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(userCDDate[1]));
            userDate.set(Calendar.YEAR, Integer.parseInt(userCDDate[2]));
            userDate.set(Calendar.HOUR, 0);
            userDate.set(Calendar.MINUTE, 0);
            userDate.set(Calendar.SECOND, 0);
            userDate.set(Calendar.MILLISECOND, 0);

            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            if(userDate.after(calendar) || userDate.equals(calendar)){

                if(convBalance - convAmount >= 0) {

                    double newAmount = convBalance - convAmount;
                    calendar.add(Calendar.MONTH, newDate);

                    String mouth = String.valueOf(calendar.get(Calendar.MONTH));
                    String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
                    String year = String.valueOf(calendar.get(Calendar.YEAR));

                    String newCDdate = mouth + "/" + day + "/" + year;

                    TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, true,
                            null, getAccountBalance(), Double.toString(newAmount), newCDdate);

                    setAccountBalance(Double.toString(newAmount));

                    getTransactionReceipts().add(transactionReceipt);
                    System.out.println(transactionReceipt.toString());
                    return transactionReceipt;
                }

                TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                        "Low Balance ", getAccountBalance(), null, null);
                
                getTransactionReceipts().add(transactionReceipt);
                System.out.println(transactionReceipt.toString());

                return transactionReceipt;
            }


            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                    "Maturity Date has not pass", null, getAccountBalance(),getCdDate());

            getTransactionReceipts().add(transactionReceipt);
            System.out.println(transactionReceipt.toString());
            return transactionReceipt;
        }

        double newAmount = convBalance - convAmount;
        if (convBalance - convAmount >= 0) {


            
            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, true,
                    null, getAccountBalance(), Double.toString(newAmount), null);

            setAccountBalance(Double.toString(newAmount));

            getTransactionReceipts().add(transactionReceipt);
            System.out.println(transactionReceipt.toString());
            return transactionReceipt;
        }

        TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                "Low Balance", null, getAccountBalance(), null);

        getTransactionReceipts().add(transactionReceipt);
        System.out.println(transactionReceipt.toString());

        return transactionReceipt;
    }
    public TransactionReceipt clearCheck(TransactionTicket transactionTicket, String amount, String accountNum,
                                         String dateCheck) throws ParseException{

        if(getAccountType().equals("Checking")) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/dd/yyyy");
            Date date1 = simpleDateFormat.parse(dateCheck);
            Calendar calDate1 = Calendar.getInstance();
            calDate1.setTime(date1);

            Calendar today = Calendar.getInstance();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();

            transactionTicket.setTypeOfTransaction("Clear Check");
            transactionTicket.setAmountOfTransaction(amount);
            transactionTicket.setAccountNumber(getAccountNumber());
            transactionTicket.setDateOfTransaction(dtf.format(now));

            today.set(Calendar.HOUR, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);

            Calendar dateChackCalPlus = calDate1;
            dateChackCalPlus.add(Calendar.MONTH, 6);  

            if (calDate1.equals(today) || (calDate1.after(today) && today.before(dateChackCalPlus)) ||
                    today.equals(dateChackCalPlus)) {

                double amountNum = Double.parseDouble(amount);
                double accountAmount = Double.parseDouble(getAccountBalance());
                double withdrawFromAccount = Double.parseDouble(getAccountBalance());

                if (withdrawFromAccount > amountNum) {

                    double newBalance = accountAmount + amountNum;
                    String newBalanceString = Double.toString(newBalance);
                    TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, true,
                            null, getAccountBalance(), newBalanceString, dtf.format(now));
                    setAccountBalance(newBalanceString);
                    getTransactionReceipts().add(transactionReceipt);

                    //Might have to double check this logic
                    System.out.println(transactionReceipt.toString());
                    return transactionReceipt;
                }


                TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                        "Check Bounce", null, getAccountBalance(), dtf.format(now));

                getTransactionReceipts().add(transactionReceipt);

                transactionTicket.setAmountOfTransaction("2.50");
                double newBalance = withdrawFromAccount - 2.50;
                String newBlanaceString = Double.toString(newBalance);

                TransactionReceipt transactionReceipt1 = new TransactionReceipt(transactionTicket, false,
                        "Check Bounce",getAccountBalance(), newBlanaceString,dtf.format(now));

                makeWithdrawal(transactionTicket,"2.50",0);

                System.out.println(transactionReceipt.toString());
                return transactionReceipt;

            }

            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                    "Old Check", null, getAccountBalance(), dtf.format(now));
            getTransactionReceipts().add(transactionReceipt);

            System.out.println(transactionReceipt.toString());
              return transactionReceipt;
        }

        System.out.println("Not a checking Account");
        return null;
    }
    public TransactionReceipt closeAcct(TransactionTicket transactionTicket){

        Calendar today = Calendar.getInstance();
        if(isAccountStatus()) {
            double accountBal = Double.parseDouble(getAccountBalance());
            if(accountBal == 0) {

                setAccountStatus(false);
                TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, true,
                        null, null, null, today.toString());
                getTransactionReceipts().add(transactionReceipt);
                return transactionReceipt;
            }
            System.out.println("Account is not empty");
            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                    "Account is not empty", null, null, today.toString());
            getTransactionReceipts().add(transactionReceipt);
            return transactionReceipt;
        }
        TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, false,
                "Account is already closed", null, null, today.toString());
        System.out.println("Account is closed");
        getTransactionReceipts().add(transactionReceipt);
        return transactionReceipt;
    }
    public TransactionReceipt reopenAcct(TransactionTicket transactionTicket){

        Calendar today = Calendar.getInstance();

        if(!isAccountStatus()){

            setAccountStatus(true);
            TransactionReceipt transactionReceipt = new TransactionReceipt(transactionTicket, true, null,
                    null, null, today.toString());

        }

        //TESTING
        System.out.println("account already open");

        return null;
    }
    public Depositor getDepositor() {
        return depositor;
    }
    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public boolean isAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
    public String getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
    public String getCdDate() {
        return cdDate;
    }
    public void setCdDate(String cdDate) {
        this.cdDate = cdDate;
    }
    public ArrayList<TransactionReceipt> getTransactionReceipts() {
        return transactionReceipts;
    }

    public void setTransactionReceipts(ArrayList<TransactionReceipt> transactionReceipts) {
        this.transactionReceipts = transactionReceipts;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return isAccountStatus() == account.isAccountStatus() && Objects.equals(getDepositor(), account.getDepositor()) && Objects.equals(getAccountNumber(), account.getAccountNumber()) && Objects.equals(getAccountType(), account.getAccountType()) && Objects.equals(getAccountBalance(), account.getAccountBalance()) && Objects.equals(getCdDate(), account.getCdDate()) && Objects.equals(getTransactionReceipts(), account.getTransactionReceipts());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDepositor(), getAccountNumber(), getAccountType(), isAccountStatus(), getAccountBalance(), getCdDate(), getTransactionReceipts());
    }
    @Override
    public String toString() {

        String info = "Account Information\n";
        info = info + depositor.toString();
        info = info + "Account Number: " + accountNumber + "\n";
        info = info + "Account Type: " + accountType + "\n";
        
        if(accountStatus == true){

            info = info + "Account Status: Open \n";
        } else {

            info = info + "Account Status: Closed \n";
        }

        info = info + "Account Balance: " + accountBalance + "\n";
        
        if(cdDate != null){

            info = info + "CD Date: " + cdDate + "\n";
        }

        info = info + "\n Transaction History\n";
        info = info + "--------------------------------\n";
        
        if(getTransactionReceipts().isEmpty()){

            info = info + "Currently No Transcation has been \n made on this account yet";

            return info;
        }
        for(int i = getTransactionReceipts().size() - 1; i >= 0; i--){

            info = info + getTransactionReceipts().get(i) + "\n";
        }

        return info;
    }
    public String accountInfo(){

        String info = "Account Information\n";
        info = info + depositor.toString();
        info = info + "Account Number: " + accountNumber + "\n";
        info = info + "Account Type: " + accountType + "\n";
        
        if(accountStatus == true){

            info = info + "Account Status: Open \n";
        } else {

            info = info + "Account Status: Closed \n";
        }

        info = info + "Account Balance: " + accountBalance + "\n";
        
        if(cdDate != null){

            info = info + "CD Date: " + cdDate + "\n";
        }

        return info;
    }
}
