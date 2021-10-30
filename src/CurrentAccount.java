import java.lang.IllegalArgumentException;
//import  java.math.*;
public class CurrentAccount extends BankAccount {
    private  double overDraftLimit = 0;
    private  final double depositServiceFee = 2.50;
    private  final double withdrawalServiceCharge = 5.00;
    private final  double monthlyIntrestRate = 0.0375;
    private final  String accountNumberPrefix ="102";
    public static int accountNumberPostfix = 1000;
    public static boolean isFirst = true;


    public double getOverDraftLimit() {
        return overDraftLimit;
    }


    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public CurrentAccount(){

        if(CurrentAccount.isFirst){
            String accountNumber = accountNumberPrefix + CurrentAccount.accountNumberPostfix;
            int accNo = Integer.parseInt(accountNumber);
            this.setAccountNumber(accNo);
            CurrentAccount.isFirst = false;
        }
        CurrentAccount.accountNumberPostfix+=1;
        String accountNumber = accountNumberPrefix + CurrentAccount.accountNumberPostfix;
        int accNo = Integer.parseInt(accountNumber);
        this.setAccountNumber(accNo);
    }



    public void deposit(double amount) {
       if(amount!=0){
           double balance = this.getBalance();
           balance += amount - depositServiceFee;
           this.setBalance(balance);
       } else {
           System.out.println("Deposit Operation requires the amount !!! Iweka");
           throw new IllegalArgumentException("Deposit Operation requires the amount !!! Iweka");
       }
    }
    public  void withdraw(double amount) throws Exception {
        // Charge :5.00
        // balance > amount to be withdrawn (Service charge)
        // Balance < amount to be withdrawn (Service charge) + (intrest on balance owing)
        if (this.getBalance() > amount){
           double balance = this.getBalance();
           balance = balance - (amount + this.withdrawalServiceCharge);
           this.setBalance(balance);
        } else if(this.getBalance()< amount && this.overDraftLimit>= amount){
            double balance = this.getBalance();
            balance = balance - (amount + this.withdrawalServiceCharge);
            this.setBalance(balance);
        } else{
            throw new Exception("Overdraft is above the Limnit !! Hazviite izvozvo");
        }

    }

    public void monthlyIntrestIncrease(){
    //  At the end of the month when we charge intrest on the balance owed;
    // -balance - 3.75% of the balance
        if(this.getBalance() < 0){
            double balance = this.getBalance();
            // Balance is negative
            balance = balance + (balance * this.monthlyIntrestRate);
            this.setBalance(balance);
        }
    }


}
