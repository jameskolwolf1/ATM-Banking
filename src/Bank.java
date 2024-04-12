import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static ArrayList<String>account = new ArrayList<>();
    private static ArrayList<String> copyAccount = account;
    private static ArrayList<String>accNumsSortKey = new ArrayList<>();
    private static ArrayList<String>ssnSortKey = new ArrayList<>();
    private static ArrayList<String>nameSortKey = new ArrayList<>();

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
        //System.out.println(data);
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
    public boolean checkingSSNAndAccountNum(String ssn, String accounttype){

        for(String looking : getCopyAccount()){

            String [] dataslip = looking.split(" ");
            if(dataslip[2].equals(ssn) && dataslip[4].equals(accounttype)){

                return true;
            }
        }
        return false;
    }
    public int getNumAccts(){


        return getCopyAccount().size();
    }
    public void sortbyAccountNum_QuickSort(ArrayList<String>data, int lowIndex, int highIndex){

        if(lowIndex < highIndex){

            int pivot = QiuckSort(data,lowIndex,highIndex);

            sortbyAccountNum_QuickSort(data, lowIndex, pivot - 1);
            sortbyAccountNum_QuickSort(data, pivot + 1, highIndex);
        }

    }
    public int QiuckSort(ArrayList<String>data, int lowIndex, int highIndex){

        String line = data.get(highIndex);
        String [] lineSlip = line.split(" ");
        String pivot = lineSlip[3];
        int i = lowIndex - 1;

        for(int k = i; k < highIndex; k++){

            String data1 = data.get(k);
            String [] data1Slip = data1.split(" ");
            String comparing = data1Slip[3];

            if(comparing.compareTo(pivot) == 1){
                k++;

                String temp
            }
        }

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
    public ArrayList<String> getAccount() {
        return account;
    }
    public void setAccount(ArrayList<String> account) {
        Bank.account = account;
    }
    public ArrayList<String> getCopyAccount() {
        return copyAccount;
    }
    public void setCopyAccount(ArrayList<String> copyAccount) {
        Bank.copyAccount = copyAccount;
    }

    public ArrayList<Integer> getAccNumsSortKey() {
        return accNumsSortKey;
    }
    public void setAccNumsSortKey(ArrayList<Integer> accNumsSortKey) {
        Bank.accNumsSortKey = accNumsSortKey;
    }
    public  ArrayList<Integer> getSsnSortKey() {
        return ssnSortKey;
    }
    public void setSsnSortKey(ArrayList<Integer> ssnSortKey) {
        Bank.ssnSortKey = ssnSortKey;
    }

    public ArrayList<Integer> getNameSortKey() {
        return nameSortKey;
    }

    public static void setNameSortKey(ArrayList<Integer> nameSortKey) {
        Bank.nameSortKey = nameSortKey;
    }
}
