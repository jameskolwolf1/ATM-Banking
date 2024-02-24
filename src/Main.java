import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Bank bank = new Bank();
        readAccts(bank);
        Scanner sc = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter("receipt.txt");
        Boolean isOff = false;
      
      while(isOff == false){

        menu();
        String chose = sc.next();
        switch (chose) {
            case "w":
                break;
            case "d":
                break;
            case "c":
                break;
            case "n":
               break;
            case "b":
                balance(bank, printWriter, sc);
                break;
            case "i":
                break;
            case "h":
                break;
            case "s":
                break;
            case "r":
                break;
            case "x":
                break;
            case "q":
                isOff = true;
                break;
            default:;
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

        System.out.println("Type in your bank account);
         Scanner input = new Scanner(System.in);
        String userAcctNum = input.next();
        Account account = bank.getAcct(userAcctNum);

        TransactionTicket transactionTicket = new TransactionTicket();

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

        if(account.getCdDate().equals(null)) {

            account.makeDeposit(transactionTicket, amount, 0);
        }

        System.out.println("How many mouth u want to add to your maturity date");
        System.out.println("You can add 6,  12, or 18");
        String adding = input.next();
        //Try Catch
        int convadding = Integer.parseInt(adding);
        account.makeDeposit(transactionTicket, amount, convadding);
    }
    public static void withdrawal(Bank bank, PrintWriter outFile, Scanner inFile){

        System.out.println("Type in your bank account");
        Scanner input = new Scanner(System.in);
        String userAcctNum = input.next();
        System.out.println("What the amount you want to withdrawal");
        String amount = input.next();
        Account account = bank.getAcct(userAcctNum);

        TransactionTicket transactionTicket = new TransactionTicket();

        if(account.getCdDate().equals(null)) {

            account.makeWithdrawal(transactionTicket, amount, 0);
        }

        System.out.println("How many mouth u want to add to your maturity date");
        System.out.println("You can add 6,  12, or 18");
        String adding = input.next();
        //Try Catch
        int convadding = Integer.parseInt(adding);
        account.makeWithdrawal(transactionTicket, amount, convadding);
    }
    public static void clearCheck(Bank bank, PrintWriter outFile, Scanner inFile){

        Scanner sc = new Scanner(System.in);
        System.out.println("What is the account number");
        String accountCheckNum = sc.next();
        int convoAccountCheckNum = Integer.parseInt(accountCheckNum);

        System.out.println("");
    }
}
