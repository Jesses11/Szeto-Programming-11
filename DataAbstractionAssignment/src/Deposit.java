import java.util.Date;

//This class represents the deposit object with an amount, a date, and an account type.
public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //constructor to create the deposit object
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //requires: nothing
    //modifies: nothing
    //effects: description of the deposit object
    public String toString(){
        String description = "Deposit of: " + amount + " Date: " + date + " into Account: " + account;

        return description;
    }
}
