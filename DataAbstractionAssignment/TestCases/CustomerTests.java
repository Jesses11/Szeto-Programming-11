
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Class to test all the methods and other possible scenarios
public class CustomerTests {
    Customer emptyCustomer;
    Customer testCustomer;
    Customer richCustomer;
    Customer wealthyCustomer;

    @BeforeEach
    public void setup() {
        emptyCustomer = new Customer();
        testCustomer = new Customer("Jesse", 127466, 10.0d, 10.0d);
        richCustomer = new Customer("Paul", 11112, 1000.0d, 8.0d);
        wealthyCustomer = new Customer("Jacky", 11111, 42075.0d, 53.0d);

    }

    @Test
    public void testDeposit() {
        //test depositing method of a positive number to checking account for empty customer
        assertEquals(1000.0d, emptyCustomer.deposit(1000.0d, new Date(), "Checking"), 0.001);
        //test depositing method of a negative number to checking account for empty customer
        assertEquals(0.0d, emptyCustomer.deposit(-200.0d, new Date(), "Checking"), 0.001);
        //test depositing method of positive number for invalid account type for empty customer
        assertEquals(0.0d, emptyCustomer.deposit(1000.0d, new Date(), "Checkingg"), 0.001);

        //test depositing method of a positive number to checking account for test customer
        assertEquals(42075.0d, testCustomer.deposit(42065.0d, new Date(), "Checking"), 0.001);
        //test depositing method of a negative number to checking account for test customer
        assertEquals(0.0d, testCustomer.deposit(-78.0d, new Date(), "Checking"), 0.001);
        //test depositing method of positive number for invalid account type for empty customer
        assertEquals(0.0d, testCustomer.deposit(1000.0d, new Date(), "Checkingg"), 0.001);

        //test depositing method of a positive number to saving account for empty customer
        assertEquals(8.0d, emptyCustomer.deposit(8.0d, new Date(), "Saving"), 0.001);
        //test depositing method of a negative number to saving account
        assertEquals(0.0d, emptyCustomer.deposit(-2.0d, new Date(), "Saving"), 0.001);
        //test depositing method of positive number for invalid account type for empty customer
        assertEquals(0.0d, emptyCustomer.deposit(1000.0d, new Date(), "Savinng"), 0.001);

        //test depositing method of a positive number to saving account for test customer
        assertEquals(53.0d, testCustomer.deposit(43.0d, new Date(), "Saving"), 0.001);
        //test depositing method of a negative number to saving account
        assertEquals(0.0d, testCustomer.deposit(-20.0d, new Date(), "Saving"), 0.001);
        //test depositing method of positive number for invalid account type for empty customer
        assertEquals(0.0d, testCustomer.deposit(5.0d, new Date(), "Savinng"), 0.001);

    }

    @Test
    public void testWithdraw() {
        //test withdrawing method of a positive number from checking account for rich Customer
        assertEquals(100.0d, richCustomer.withdraw(900.0d, new Date(), "Checking"), 0.001);
        //test withdrawing method of a negative number from checking account for rich Customer
        assertEquals(0.0d, richCustomer.withdraw(-3.0d, new Date(), "Checking"), 0.001);
        //test withdrawing method of positive number for invalid account type for rich Customer
        assertEquals(0.0d, richCustomer.withdraw(6.0d, new Date(), "Checkingg"), 0.001);
        //test withdrawing method overdraft for rich Customer in checking account
        assertEquals(-100.0d, richCustomer.withdraw(200.0d, new Date(), "Checking"), 0.001);
        //test withdrawing method overdraft that exceeds threshold for rich Customer in checking account
        assertEquals(0.0d, richCustomer.withdraw(1.0d, new Date(), "Checking"), 0.001);

        //test withdrawing method of a positive number from checking account for wealthy Customer
        assertEquals(40075.0d, wealthyCustomer.withdraw(2000.0d, new Date(), "Checking"), 0.001);
        //test withdrawing method of a negative number from checking account for wealthy Customer
        assertEquals(0.0d, wealthyCustomer.withdraw(-78.0d, new Date(), "Checking"), 0.001);
        //test withdrawing method of positive number for invalid account type for rich Customer
        assertEquals(0.0d, wealthyCustomer.withdraw(1000.0d, new Date(), "Checkingg"), 0.001);
        //test withdrawing method overdraft for wealthy Customer in checking account
        assertEquals(-100.0d, wealthyCustomer.withdraw(40175.0d, new Date(), "Checking"), 0.001);
        //test withdrawing method overdraft that exceeds threshold for wealthy Customer in checking account
        assertEquals(0.0d, wealthyCustomer.withdraw(1.0d, new Date(), "Checking"), 0.001);

        //test withdrawing method of a positive number from saving account for rich Customer
        assertEquals(4.0d, richCustomer.withdraw(4.0d, new Date(), "Saving"), 0.001);
        //test withdrawing method of a negative number from saving account
        assertEquals(0.0d, richCustomer.withdraw(-2.0d, new Date(), "Saving"), 0.001);
        //test withdrawing method of positive number for invalid account type for rich Customer
        assertEquals(0.0d, richCustomer.withdraw(1000.0d, new Date(), "Savinng"), 0.001);
        //test withdrawing method overdraft for wealthy Customer in Savings Account
        assertEquals(-100.0d, richCustomer.withdraw(104.0d, new Date(), "Saving"), 0.001);
        //test withdrawing method overdraft that exceeds threshold for wealthy Customer in Savings account
        assertEquals(0.0d, richCustomer.withdraw(1.0d, new Date(), "Saving"), 0.001);

        //test withdrawing method of a positive number from saving account for rich Customer
        assertEquals(43.0d, wealthyCustomer.withdraw(10.0d, new Date(), "Saving"), 0.001);
        //test withdrawing method of a negative number from saving account
        assertEquals(0.0d, wealthyCustomer.withdraw(-20.0d, new Date(), "Saving"), 0.001);
        //test withdrawing method of positive number for invalid account type for rich Customer
        assertEquals(0.0d, wealthyCustomer.withdraw(5.0d, new Date(), "Savinng"), 0.001);
        //test withdrawing method overdraft for wealthy Customer in Savings Account
        assertEquals(-100.0d, wealthyCustomer.withdraw(143.0d, new Date(), "Saving"), 0.001);
        //test withdrawing method overdraft that exceeds threshold for wealthy Customer in Savings account
        assertEquals(0.0d, wealthyCustomer.withdraw(1.0d, new Date(), "Saving"), 0.001);
    }

    @Test
    public void testToStringWithdraw() {
        Date date = new Date();
        Withdraw withdraw = new Withdraw(100, date, "Checking");
        assertEquals("Withdrawal of: 100.0 Date: " + date + " from Account: Checking", withdraw.toString());
        Withdraw withdraw2 = new Withdraw(-101, date, "Checking");
        assertEquals("Withdrawal of: -101.0 Date: " + date + " from Account: Checking", withdraw2.toString());
        Withdraw withdraw3 = new Withdraw(101, date, "Saviing");
        assertEquals("Withdrawal of: 101.0 Date: " + date + " from Account: Saviing", withdraw3.toString());
    }

    @Test
    public void testToStringDeposit() {
        Date date = new Date();
        Deposit deposit = new Deposit(100, date, "Checking");
        assertEquals("Deposit of: 100.0 Date: " + date + " into Account: Checking", deposit.toString());
        Deposit deposit2 = new Deposit(-131, date, "Checking");
        assertEquals("Deposit of: -131.0 Date: " + date + " into Account: Checking", deposit2.toString());
        Deposit deposit3 = new Deposit(131, date, "Saviing");
        assertEquals("Deposit of: 131.0 Date: " + date + " into Account: Saviing", deposit3.toString());
    }
}