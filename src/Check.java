import java.util.Calendar;
import java.util.Objects;

public class Check {

    private String accountNumber;
    private String checkAmount;
    private Calendar calendar;
    private String dataCheck;

    public Check(String accountNumber, String checkAmount, Calendar calendar, String dataCheck) {
        this.accountNumber = accountNumber;
        this.checkAmount = checkAmount;
        this.calendar = calendar;
        this.dataCheck = dataCheck;
    }
    public Check(){}

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(String checkAmount) {
        this.checkAmount = checkAmount;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getDataCheck() {
        return dataCheck;
    }

    public void setDataCheck(String dataCheck) {
        this.dataCheck = dataCheck;
    }

    @Override
    public String toString() {
        return "Check{" +
                "accountNumber='" + accountNumber + '\'' +
                ", checkAmount='" + checkAmount + '\'' +
                ", calendar=" + calendar +
                ", dataCheck='" + dataCheck + '\'' +
                '}';
    }
}
