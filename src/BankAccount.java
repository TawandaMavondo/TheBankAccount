public class BankAccount {
    private int accountNumber;
    private  double balance = 0.00;
    private String customerName;
    private Address address;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void deposit(double amount){
        this.balance = this.balance + amount;
    }
    public  void withdraw(double amount) throws Exception {
        this.balance -= amount;
    }
}
