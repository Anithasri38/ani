import java.util.*;
public class Bank {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        SavingsAccount saving = new SavingsAccount(1000012311, 20000.00);
        while (true) {
            System.out.println("Choose 1 for deposit\nChoose 2 for Withdraw\nChoose 3 for exit");
            int choose = s.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Enter amount you want to deposit");
                    double amount1 = s.nextDouble();
                    double Balance = saving.deposit(amount1);
                    System.out.println("After depositing " + amount1 + " the total balance in account is:" + Balance);
                    break;
                case 2:
                    System.out.println("Enter amount u want to withdraw");
                    double amount2 = s.nextDouble();
                    if ((saving.balance == 0)||(saving.balance < amount2)) {
                        throw new ArithmeticException("InsufficientBalanceException");
                    }
                    else if((amount2<saving.balance)&&(amount2<0))
                    {
                       throw new ArithmeticException("IllegalBankTransactionException");
                    }
                  else
                    {
                        double Balance2 = saving.withdraw(amount2);
                        System.out.println("After withdrawing " + amount2 + " the balance in account is:" + Balance2);
                    }
                    break;
                case 3:System.exit(0);

            }
        }
    }
}
