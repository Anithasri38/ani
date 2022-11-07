import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
public class Transaction{
    Trader Trader;
    int year;
    int value;
    Transaction(Trader trader,int year,int value)
    {
        this.Trader=trader;
        this.year=year;
        this.value=value;
    }

    public Trader getTrader() {
        return Trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Trader=" + Trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
class TradingTransaction
{
    public static void main(String args[])
    {
        List<Transaction> list= Arrays.asList(
                new Transaction(new Trader("Anitha","Guntur"),2011,100000),
                new Transaction(new Trader("Appu","Bangalore"),2010,50000),
                new Transaction(new Trader("Sai","Hyderabad"),2011,75000),
                new Transaction(new Trader("Tan","Delhi"),2014,120000),
                new Transaction(new Trader("Anisri","Delhi"),2016,80000),
                new Transaction(new Trader("Teddy","Pune"),2019,95000),
                new Transaction(new Trader("Cherry","Pune"),2020,85000)
        );
        System.out.println(list);
        System.out.println("Transaction details of trader living in Delhi");
        list.stream().filter(p->p.Trader.getCity().equalsIgnoreCase("Delhi")).forEach(p->System.out.println(p.getValue()));
        System.out.println("HighestValue of the Transaction");
        Optional<Transaction> MaxValue=list.stream().max(Comparator.comparingInt(Transaction::getValue));
        System.out.println(MaxValue.get());
        System.out.println("Minimum value of the Transaction");
        Optional<Transaction> MinValue=list.stream().min(Comparator.comparingInt(Transaction::getValue));
        System.out.println(MinValue);
        System.out.println("Transactions in the year 2011 sorted by value");
        list.stream().filter(p->p.getYear()==2011).sorted((Transaction o1,Transaction o2)->(int)o1.getValue()-o2.getValue()).forEach(p->System.out.println(p.getValue()));
    }
}
