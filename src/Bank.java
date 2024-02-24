import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static ArrayList<String>account = new ArrayList<>();
    private static ArrayList<String> copyAccount = getAccount();
    public Bank(){}

    // LATER
//    public TransactionReceipt openNewAcct(TransactionTicket transactionTicket){}
//    public TransactionReceipt deleteAcct(TransactionTicket transactionTicket){}

    public int findAcct(String accountNumber){

    for(int i =0; i <= getAccount().size(); i++){

            String data = getCopyAccount().get(i);
            String [] dataslip = data.split(" ");

            if(dataslip[3].equals(accountNumber)){

                return i;
            }
        }
        return -1;
    }

    public void readData(Scanner read){

        while (read.hasNextLine()){

            String data = read.nextLine();
            account.add(data);
        }
    }
    public Account getAcct(String accountNumber){

        Account account = new Account();
        String data = getAccount().get(findAcct(accountNumber));
        System.out.println(data);
        String [] dataslip = data.split(" ");

        Name name = new Name();
        name.setFirstName(dataslip[0]);
        name.setLastName(dataslip[1]);
        
        Depositor depositor = new Depositor();
        depositor.setName(name);
        depositor.setSocialSecurity(dataslip[2]);

        if(getCopyAccount().size() == 6){
          
            account.setDepositor(depositor);
            account.setAccountNumber(dataslip[3]);
            account.setAccountType(dataslip[4]);
            account.setAccountBalance(dataslip[5]);
            return account;

        }
        
        account.setDepositor(depositor);
        account.setAccountNumber(dataslip[3]);
        account.setAccountType(dataslip[4]);
        account.setAccountBalance(dataslip[5]);
        return account; 
    }
    public int getNumAccts(){

        return getCopyAccount().size();
    }
    public static String totalAmountInSavingsAccts(){

        double amount = 0.0;
        for(int i = 0; 0 < copyAccount.size(); i++){

            String data = copyAccount.get(i);
            String [] dataSlip = data.split(" ");
            if(dataSlip[4].equals("Savings")){

                amount = amount + Double.parseDouble(dataSlip[5]);
            }
        }

        return Double.toString(amount);
    }
    public static String totalAmountInCheckingAccts(){

        double amount = 0;
        for(int i = 0; 0 < copyAccount.size(); i++){

            String data = copyAccount.get(i);
            String [] dataSlip = data.split(" ");
            if(dataSlip[4].equals("Checking")){

                amount = amount + Double.parseDouble(dataSlip[5]);
            }
        }

        return Double.toString(amount);
    }
    public static String totalAmountInCDAccts(){

        double amount = 0.0;
        for(int i = 0; 0 < copyAccount.size(); i++){

            String data = copyAccount.get(i);
            String [] dataSlip = data.split(" ");
            if(dataSlip[4].equals("CD")){

                amount = amount + Double.parseDouble(dataSlip[5]);
            }
        }

        return Double.toString(amount);
    }
    public static String totalAmountInAllAccts(){

        double amount = 0.0;
        for(int i = 0; 0 < copyAccount.size(); i++){

            String data = copyAccount.get(i);
            String [] dataSlip = data.split(" ");

            amount = amount + Double.parseDouble(dataSlip[5]);

        }
        return Double.toString(amount);
    }
    public static ArrayList<String> getAccount() {
        return account;
    }
    public static void setAccount(ArrayList<String> account) {
        Bank.account = account;
    }
    public static ArrayList<String> getCopyAccount() {
        return copyAccount;
    }
    public static void setCopyAccount(ArrayList<String> copyAccount) {
        Bank.copyAccount = copyAccount;
    }
}
