import java.text.NumberFormat;

public class AccountTest {

    public static void main(String[] args) throws Exception {
        CurrentAccount currentAccount1 = new CurrentAccount();
        System.out.println(currentAccount1.getAccountNumber());


        currentAccount1.setOverDraftLimit(200);
        currentAccount1.deposit(100);

        currentAccount1.withdraw(200);

        // 30 days is up and the intrest is to be charged

        currentAccount1.monthlyIntrestIncrease();

        currentAccount1.monthlyIntrestIncrease();
        CurrentAccount currentAccount2 = new CurrentAccount();



        NumberFormat currency = NumberFormat.getCurrencyInstance();

        System.out.println(currency.format(currentAccount1.getBalance()));
        System.out.println(currentAccount2.getAccountNumber());


    }

}
