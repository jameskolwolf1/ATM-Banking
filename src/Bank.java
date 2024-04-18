import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static ArrayList<Account>dataBase = new ArrayList<>();
    private static ArrayList<Account> copyDatabase = dataBase;
    private static ArrayList<String>accNumsSortKey = new ArrayList<>();
    private static ArrayList<String>ssnSortKey = new ArrayList<>();
    private static ArrayList<String>nameSortKey = new ArrayList<>();

    public Bank(){}

// LATER
//    public TransactionReceipt openNewAcct(TransactionTicket transactionTicket){}
//    public TransactionReceipt deleteAcct(TransactionTicket transactionTicket){}

    public int findAcct(String accountNumber){

    for(int i = 0; i < getCopyAccountt().size(); i++) {

//            String data = getDataBase().get(i);
//            String [] dataslip = data.split(" ");
//
//            if(dataslip[3].equals(accountNumber)){
//
//                return i;
//            }
        Account account = getCopyAccountt().get(i);
        if (account.getAccountNumber().equals(accountNumber)) {

            return i;
        }
    }
        return -1;
    }
    public void readData(Scanner read){

        while (read.hasNextLine()){

            String data = read.nextLine();
            String [] slipData = data.split(" ");
            Name name = new Name(slipData[0], slipData[1]);
            Depositor depositor = new Depositor(name, slipData[2]);
            String accountNum = slipData[3];
            String accountType = slipData[4];
            Account account;

            if(accountType.equals("CD")){

                String balance = slipData[5];
                String cdTerm = slipData[6];
                account = new Account(depositor,accountNum,accountType,balance,cdTerm, true);
                getDataBase().add(account);
            }

            String balance = slipData[5];
            account = new Account(depositor, accountNum, accountType,balance,null, true);
            getDataBase().add(account);

        }


    }
    public Account getAcct(String accountNumber){

        Account account;
        account = getCopyAccountt().get(findAcct(accountNumber));
//        //System.out.println(data);
//        String [] dataslip = data.split(" ");
//
//        Name name = new Name();
//        name.setFirstName(dataslip[0]);
//        name.setLastName(dataslip[1]);
//
//        Depositor depositor = new Depositor();
//        depositor.setName(name);
//        depositor.setSocialSecurity(dataslip[2]);
//
//        if(getCopyAccountt().size() == 6){
//
//            account.setDepositor(depositor);
//            account.setAccountNumber(dataslip[3]);
//            account.setAccountType(dataslip[4]);
//            account.setAccountBalance(dataslip[5]);
//            return account;
//
//        }
//
//        account.setDepositor(depositor);
//        account.setAccountNumber(dataslip[3]);
//        account.setAccountType(dataslip[4]);
//        account.setAccountBalance(dataslip[5]);
        return account; 
    }
    public boolean checkingSSNAndAccountNum(String ssn, String accounttype){

        for(Account account : getCopyAccountt()){

            if(account.getDepositor().getSocialSecurity() == ssn && account.getAccountType() == accounttype){

                return true;
            }
        }
        return false;
    }
    public int getNumAccts(){


        return getCopyAccountt().size();
    }
//    public void sortbyAccountNum_QuickSort(ArrayList<String>data, int lowIndex, int highIndex){
//
//        if(lowIndex < highIndex){
//
//            int pivot = QiuckSort(data,lowIndex,highIndex);
//
//            sortbyAccountNum_QuickSort(data, lowIndex, pivot - 1);
//            sortbyAccountNum_QuickSort(data, pivot + 1, highIndex);
//        }
//
//    }
//    public int QiuckSort(ArrayList<String>data, int lowIndex, int highIndex){
//
//        String line = data.get(highIndex);
//        String [] lineSlip = line.split(" ");
//        String pivot = lineSlip[3];
//        int i = lowIndex - 1;
//
//        for(int k = i; k < highIndex; k++){
//
//            String data1 = data.get(k);
//            String [] data1Slip = data1.split(" ");
//            String comparing = data1Slip[3];
//
//            if(comparing.compareTo(pivot) == 1){
//                k++;
//
//                String temp
//            }
//        }
//
//    }
    public static String totalAmountInSavingsAccts(){

        double amount = 0.0;
        for(int i = 0; 0 < copyDatabase.size(); i++){

            Account account = copyDatabase.get(i);

            if(account.getAccountType().equals("Savings")){

                amount = amount + Double.parseDouble(account.getAccountBalance());
            }
        }

        return Double.toString(amount);
    }
    public static String totalAmountInCheckingAccts(){

        double amount = 0;
        for(int i = 0; 0 < copyDatabase.size(); i++){

            Account account = copyDatabase.get(i);

            if(account.getAccountType().equals("Checking")){

                amount = amount + Double.parseDouble(account.getAccountBalance());
            }
        }

        return Double.toString(amount);
    }
    public static String totalAmountInCDAccts(){

        double amount = 0.0;
        for(int i = 0; 0 < copyDatabase.size(); i++){

            Account account = copyDatabase.get(i);

            if(account.getAccountType().equals("CD")){

                amount = amount + Double.parseDouble(account.getAccountBalance());
            }
        }

        return Double.toString(amount);
    }
    public static String totalAmountInAllAccts(){

        double amount = 0.0;
        for(int i = 0; 0 < copyDatabase.size(); i++){

            Account account = copyDatabase.get(i);

            amount = amount + Double.parseDouble(account.getAccountBalance());

        }
        return Double.toString(amount);
    }
    public ArrayList<Account> getDataBase() {
        return dataBase;
    }
    public void setAccount(ArrayList<Account> dataBase) {
        Bank.dataBase = dataBase;
    }
    public ArrayList<Account> getCopyAccountt() {
        return copyDatabase;
    }
    public void setCopyAccount(ArrayList<Account> copyDatabase) {
        Bank.copyDatabase = copyDatabase;
    }

//    public ArrayList<Integer> getAccNumsSortKey() {
//        return accNumsSortKey;
//    }
//    public void setAccNumsSortKey(ArrayList<Integer> accNumsSortKey) {
//        Bank.accNumsSortKey = accNumsSortKey;
//    }
//    public  ArrayList<Integer> getSsnSortKey() {
//        return ssnSortKey;
//    }
//    public void setSsnSortKey(ArrayList<Integer> ssnSortKey) {
//        Bank.ssnSortKey = ssnSortKey;
//    }
//
//    public ArrayList<Integer> getNameSortKey() {
//        return nameSortKey;
//    }
//
//    public static void setNameSortKey(ArrayList<Integer> nameSortKey) {
//        Bank.nameSortKey = nameSortKey;
//    }
}
