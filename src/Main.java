import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException, InvalidMenuSelectionException {


        Bank bank = new Bank();
        readAccts(bank);
        Scanner sc = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("result.txt");
        Boolean isOff = false;
      
       while(isOff == false){

        menu();
        String chose = sc.next();
        switch (chose) {
            case "w":
                withdrawal(bank, printWriter, sc);
                break;
            case "d":
                deposit(bank, printWriter, sc);
                break;
            case "c":
                clearCheck(bank, printWriter, sc);
                break;
            case "n":
                newAcct(bank, printWriter, sc);
               break;
            case "b":
                balance(bank, printWriter, sc);
                break;
            case "i":
                accountInfo(bank, printWriter, sc);
                break;
            case "h":
                accountInoWithHistory(bank, printWriter, sc);
                break;
            case "s":
                closeAcct(bank, printWriter, sc);
                break;
            case "r":
                reopenAcct(bank, printWriter, sc);
                break;
            case "x":
                deleteAcct(bank, printWriter, sc);
                break;
            case "q":
                isOff = true;
                break;
            default:
                throw  new InvalidMenuSelectionException(chose);

        }
       }
    }

    public static void readAccts(Bank bank) throws FileNotFoundException{

      Scanner sc = new Scanner(new File("data.txt"));
      bank.readData(sc);

    }
    public static void menu(){

        System.out.println("Welcome to WowWow Bank");
        System.out.println("----------------------------");
        System.out.println("Please a button");
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("W - Withdrawal");
        System.out.println("D - Deposit");
        System.out.println("C - Clear Check");
        System.out.println("B - Balance");
        System.out.println("I - Account Info");
        System.out.println("H - Account Info plus Account Transaction History");
        System.out.println("S - Close Account");
        System.out.println("R - Reopen a closed account");
        System.out.println("X - Delete Account");
        System.out.println("Q - Quit");
    }
    public static void balance(Bank bank, PrintWriter outFile, Scanner inFile){

        System.out.println("Type in your bank account");
        Scanner input = new Scanner(System.in);
        String userAcctNum = input.next();
        Account account = bank.getAcct(userAcctNum);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String dateTrans = formatter.format(date); 

        TransactionTicket transactionTicket = new TransactionTicket(dateTrans, "Balance",
        account.getAccountNumber(), account.getAccountBalance(), 0);
        account.getBalance(transactionTicket);

    }
    public static void deposit(Bank bank, PrintWriter outFile, Scanner inFIle){

        System.out.println("Type in your bank account");
        Scanner input = new Scanner(System.in);
        String userAcctNum = input.next();
        System.out.println("What the amount you want to Deposit");
        String amount = input.next();
        Account account = bank.getAcct(userAcctNum);

        TransactionTicket transactionTicket = new TransactionTicket();

        if(account.getCdDate() == null) {

            account.makeDeposit(transactionTicket, amount, 0);
            
        } else {

        System.out.println("How many mouth u want to add to your maturity date");
        System.out.println("You can add 6,  12, or 18");
        String adding = input.next();
        //Try Catch
        int convadding = Integer.parseInt(adding);
        account.makeDeposit(transactionTicket, amount, convadding);
        }
    }
    public static void withdrawal(Bank bank, PrintWriter outFile, Scanner inFile){

        System.out.println("Type in your bank account");
        Scanner input = new Scanner(System.in);
        String userAcctNum = input.next();
        System.out.println("What the amount you want to withdrawal");
        String amount = input.next();
        Account account = bank.getAcct(userAcctNum);

        TransactionTicket transactionTicket = new TransactionTicket();

        if(account.getCdDate() == null) {

            account.makeWithdrawal(transactionTicket, amount, 0);

        } else {

        System.out.println("How many mouth u want to add to your maturity date");
        System.out.println("You can add 6,  12, or 18");
        String adding = input.next();
        //Try Catch
        int convadding = Integer.parseInt(adding);
        account.makeWithdrawal(transactionTicket, amount, convadding);
        }

        
    }
    public static void clearCheck(Bank bank, PrintWriter outFile, Scanner inFile) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the account number you sending it?");
        String accountCheck = sc.next();
        System.out.println("What is the amount?");
        String checkAmount = sc.next();
        System.out.println("WHat the date of the check");
        System.out.println("Please in a formate 01/12/1997");
        String checkDate = sc.next();

        Account account = bank.getAcct(accountCheck);
        
        TransactionTicket transactionTicket = new TransactionTicket();
        
            account.clearCheck(transactionTicket, checkAmount, accountCheck, checkDate);

    }
    public static void accountInfo(Bank bank, PrintWriter outFile, Scanner inFile){

        System.out.println("What's you account Number");
        Scanner sc = new Scanner(System.in);
        String accountNum = sc.next();

        Account account = bank.getAcct(accountNum);
        TransactionTicket transactionTicket = new TransactionTicket();
        System.out.println("What is your SSN");
        String ssn = sc.next();
        account.accountInfo(transactionTicket, ssn);
    }
    public static void accountInoWithHistory(Bank bank, PrintWriter outFile, Scanner inFile){

        System.out.println("What's you account Number");
        Scanner sc = new Scanner(System.in);
        String accountNum = sc.next();

        Account account = bank.getAcct(accountNum);

        System.out.println(account.toString());
    }
    public static void newAcct(Bank bank, PrintWriter outFile, Scanner inFile){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");
        String calToStringF = simpleDateFormat.format(date);


        System.out.println("What is your First Name");
        Scanner sc = new Scanner(System.in);
        String newCustFirstName = sc.next();

        System.out.println("What is your last name");
        String newCustLastName = sc.next();

        System.out.println("What is your social number");
        String newCustSocialNum = sc.next();

        System.out.print("What type of account you want to have?");
        System.out.println("Press 1 for Checking, Press 2 for Savings, Press 3 for CD");
        Random random = new Random();
        boolean isacount = true;
        int rand = 0;
        String accountNum = "";
        Double amount = 0.0;
        String addToDatabase = "";
        TransactionTicket transactionTicket = new TransactionTicket();
        TransactionReceipt transactionReceipt = new TransactionReceipt();


        int userChose = sc.nextInt();

        switch(userChose){
            case(1):
                String checking = "Checking";
                isacount = bank.checkingSSNAndAccountNum(newCustSocialNum, checking);
                if(isacount){

                    System.out.println("You already have a " + checking + "account");
                    return;
                }


                rand = random.nextInt(1, 1000000);
                accountNum = Integer.toString(rand);

                System.out.println("How to do u want to input into this account?");
                amount = sc.nextDouble();

                addToDatabase = newCustFirstName + " " + newCustLastName + " " + newCustSocialNum + " "
                        + accountNum + " " + checking + " " + Double.toString(amount);

                addToDatabase.trim();

                Name name = new Name(newCustFirstName, newCustLastName);
                Depositor depositor = new Depositor(name, newCustSocialNum);
                Account account = new Account(depositor,accountNum,checking,Double.toString(amount),
                        null, true);

                bank.getCopyAccountt().add(account);
                transactionTicket = new TransactionTicket();
                transactionReceipt = new TransactionReceipt();

                transactionTicket.setAccountNumber(accountNum);
                transactionTicket.setTermOfCD(0);
                transactionTicket.setAmountOfTransaction(Double.toString(amount));
                transactionTicket.setTypeOfTransaction("New Account");
                transactionTicket.setDateOfTransaction(calToStringF);
                transactionReceipt.setTransactionTicket(transactionTicket);
                transactionReceipt.setSuccessIndicatorFlag(true);
                transactionReceipt.setPreTransactionBalance(Double.toString(amount));
                transactionReceipt.setPostTransactionBalance(Double.toString(amount));
                transactionReceipt.setPostTransactionMaturityDate(null);
                transactionReceipt.toString();

                break;

            case(2):

                String savings = "Savings";
                isacount = bank.checkingSSNAndAccountNum(newCustSocialNum, savings);
                if(isacount){

                    System.out.println("You already have a " + savings + "account");
                    return;
                }

                random = new Random();
                rand = random.nextInt(1, 1000000);
                accountNum = Integer.toString(rand);

                System.out.println("How to do u want to input into this account?");
                amount = sc.nextDouble();

                addToDatabase = newCustFirstName + " " + newCustLastName + " " + newCustSocialNum + " " + accountNum +
                        " " + savings + " " + Double.toString(amount);

                addToDatabase.trim();

                name = new Name(newCustFirstName, newCustLastName);
                depositor = new Depositor(name, newCustSocialNum);
                account = new Account(depositor,accountNum,savings,Double.toString(amount),
                        null, true);

                bank.getCopyAccountt().add(account);

                transactionTicket = new TransactionTicket();
                transactionReceipt = new TransactionReceipt();

                transactionTicket.setAccountNumber(accountNum);
                transactionTicket.setTermOfCD(0);
                transactionTicket.setAmountOfTransaction(Double.toString(amount));
                transactionTicket.setTypeOfTransaction("New Account");
                transactionTicket.setDateOfTransaction(calToStringF);
                transactionReceipt.setTransactionTicket(transactionTicket);
                transactionReceipt.setSuccessIndicatorFlag(true);
                transactionReceipt.setPreTransactionBalance(Double.toString(amount));
                transactionReceipt.setPostTransactionBalance(Double.toString(amount));
                transactionReceipt.setPostTransactionMaturityDate(null);
                transactionReceipt.toString();
                break;

            case(3):
                String cd = "CD";
                isacount = bank.checkingSSNAndAccountNum(newCustSocialNum, cd);
                if(isacount){

                    System.out.println("You already have a " + cd + "account");
                    return;
                }

                random = new Random();
                rand = random.nextInt(1, 1000000);
                accountNum = Integer.toString(rand);

                System.out.println("How to do u want to input into this account?");
                amount = sc.nextDouble();

                System.out.println("What do your next maturity date will it be");
                System.out.println("You can add 3, 6, or 9 mouths to todays date to be your next maturity month");
                System.out.println("Press 1 for 3 months for today");
                System.out.println("Press 2 for 6 months for today");
                System.out.println("Press 3 for 9 months for today");
                int chose = sc.nextInt();

                Date matuirtyDate = new Date();
                switch(chose){
                    case(1):
                        matuirtyDate.setMonth(date.getMonth() + 3);
                        break;

                    case(2):
                        matuirtyDate.setMonth(date.getMonth() + 6);
                        break;

                    case(3):
                        matuirtyDate.setMonth(date.getMonth() + 9);
                        break;
                }

                String stringMaturityDate = simpleDateFormat.format(matuirtyDate);

                addToDatabase = newCustFirstName + " " + newCustLastName + " " + newCustSocialNum + " " + accountNum +
                        " " + cd + " " + Double.toString(amount) + " " + matuirtyDate;

                addToDatabase.trim();

                name = new Name(newCustFirstName, newCustLastName);
                depositor = new Depositor(name, newCustSocialNum);
                account = new Account(depositor,accountNum,cd,Double.toString(amount),
                        matuirtyDate.toString(), true);

                bank.getCopyAccountt().add(account);

                transactionTicket = new TransactionTicket();
                transactionReceipt = new TransactionReceipt();

                transactionTicket.setAccountNumber(accountNum);
                transactionTicket.setTermOfCD(0);
                transactionTicket.setAmountOfTransaction(Double.toString(amount));
                transactionTicket.setTypeOfTransaction("New Account");
                transactionTicket.setDateOfTransaction(calToStringF);
                transactionReceipt.setTransactionTicket(transactionTicket);
                transactionReceipt.setSuccessIndicatorFlag(true);
                transactionReceipt.setPreTransactionBalance(Double.toString(amount));
                transactionReceipt.setPostTransactionBalance(Double.toString(amount));
                transactionReceipt.setPostTransactionMaturityDate(matuirtyDate.toString());
                transactionReceipt.toString();
                break;
        }
    }
    public static void deleteAcct(Bank bank, PrintWriter outFile, Scanner inFile){

        System.out.println("What is your Account Number?");
        Scanner sc = new Scanner(System.in);
        String accountLooking = sc.next();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");
        String dateToString = simpleDateFormat.format(date);

        Account account = bank.getAcct(accountLooking);

        TransactionTicket transactionTicket = new TransactionTicket();
        TransactionReceipt transactionReceipt = new TransactionReceipt();

        if(account.isAccountStatus() == true){

            System.out.println("Your account need to be closed");

        }
        if (account.isAccountStatus() == false){

            double amount = Double.parseDouble(account.getAccountBalance());
            if(amount == 0.00){

                int index = bank.findAcct(accountLooking);
                transactionTicket.setDateOfTransaction(dateToString);
                transactionTicket.setTypeOfTransaction("Deleting Account");
                transactionTicket.setAccountNumber(account.getAccountNumber());
                transactionTicket.setTermOfCD(0);
                transactionTicket.setAmountOfTransaction(null);
                transactionReceipt.setTransactionTicket(transactionTicket);
                transactionReceipt.setSuccessIndicatorFlag(true);
                transactionReceipt.setPreTransactionBalance("");
                transactionReceipt.setPostTransactionBalance("");
                transactionReceipt.setPreTransactionBalance("");
                transactionReceipt.toString();

            } else {

                System.out.println("Your account balances need to be empty");
            }
        }
    }
    public static void closeAcct(Bank bank, PrintWriter printWriter, Scanner inFile){

        System.out.println("What is your Account Number?");
        Scanner sc = new Scanner(System.in);

        String accountLooking = sc.next();
        Account account =  bank.getAcct(accountLooking);

        TransactionTicket transactionTicket = new TransactionTicket();

        account.closeAcct(transactionTicket);
    }
    public static void reopenAcct(Bank bank, PrintWriter printWriter, Scanner inFile){

        System.out.println("What is your Account Number?");
        Scanner sc = new Scanner(System.in);
        String accountLooking = sc.next();

        Account account = bank.getAcct(accountLooking);
        TransactionTicket transactionTicket = new TransactionTicket();

        account.reopenAcct(transactionTicket);

    }
    public static void printAccts(Bank bank, PrintWriter printWriter){

        System.out.println("|     First Name     |     Last Name     |     SSN     |     Account Number     |" +
                "     Account Type     |     Balance     |     Maturity Date     |");

        for(int i = 0; i < bank.getCopyAccountt().size(); i++){

            System.out.println(bank.getCopyAccountt().get(i));
        }
    }

}

