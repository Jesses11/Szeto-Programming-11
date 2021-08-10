import java.util.Date;

//This class represents the withdraw object with an amount, a date, and an account type.
public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //constructor to create withdraw object
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //requires: nothing
    //modifies: nothing
    //effects: description of the withdraw object
    public String toString(){
        String description = "Withdrawal of: " + amount + " Date: " + date + " from Account: " + account;

        return description;
    }
}
