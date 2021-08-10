import java.util.ArrayList;
import java.util.Date;

//This class represents a customer with an account number, deposit and withdraw lists, a checking balance, a savings balance, a saving rate, and a Name.
public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //constructor to create a customer object with no parameters
    Customer(){
      this.name = "not assigned";
      this.accountNumber = 0;
      this.checkBalance = 0.0d;
      this.savingBalance = 0.0d;
      this.savingRate = 0.05;
      this.deposits = new ArrayList<Deposit>();
      this.withdraws = new ArrayList<Withdraw>();
    }

    //Constructor to create ach customer with parameters of a name, account number, checking deposit, and saving deposit.
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.savingRate = 0.05;
        this.deposits = new ArrayList<Deposit>();
        this.withdraws = new ArrayList<Withdraw>();



    }
    //requires: double for amt, Date, String as Account type
    //modifies: this
    //effects: creates a new Deposit object and adds it to the list of deposits, adds amt to the balance
    public double deposit(double amt, Date date, String account){
        if (amt <= 0){
            System.out.println("Invalid Amount Entered");
            return 0;
        }
        if(account == CHECKING){
            checkBalance += amt;
            deposits.add(new Deposit(amt, date, account));
            return checkBalance;
        }
        else if(account == SAVING){
            savingBalance += amt;
            deposits.add(new Deposit(amt, date, account));
            return savingBalance;
        }
        else {
            System.out.println("Invalid Account type");
            return 0;
        }
    }
    //requires: double for amt, Date, String as Account type
    //modifies: this
    //effects: creates a new Withdraw object and adds it to the list of withdraws, subtracts amt from the balance
    public double withdraw(double amt, Date date, String account){
        if (amt <= 0){
            System.out.println("Invalid Amount Entered");
            return 0;
        }
        if (!checkOverdraft(amt, account)) {
            System.out.println("Amount Entered Exceeds overdraft amount, Please Try again");
            return 0;
        }
        if(account == CHECKING){
            checkBalance -= amt;
            withdraws.add(new Withdraw(amt, date, account));
            return checkBalance;
        }
        else if(account == SAVING){
            savingBalance -= amt;
            withdraws.add(new Withdraw(amt, date, account));
            return savingBalance;
        }
        else {
            System.out.println("Invalid Account type");
            return 0;
        }
    }
    //requires: double for amt, String for account type
    //modifies: nothing
    //effects: checks if withdrawal amt is within overdraft threshold
    private boolean checkOverdraft(double amt, String account){
        if(account == CHECKING){
            double tempBalance = checkBalance - amt;
            if(tempBalance < OVERDRAFT){
                return false;
            }
            else{
                return true;
            }
        }
        else if(account == SAVING){
            double tempBalance = savingBalance - amt;
            if(tempBalance < OVERDRAFT){
                return false;
            }
            else{
                return true;
            }
        }
        else {
            System.out.println("Invalid Account type");
            return true;
        }
    }


    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
