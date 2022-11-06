public class SavingsAccount{
    long id;
    double balance;
    SavingsAccount(long id,double b)
    {
        id=id;
        balance=b;
    }
     double deposit(double m)
    {
        balance=balance+m;
        return balance;
    }
    double withdraw(double m)
    {
        balance=balance-m;
        return balance;
    }
}
