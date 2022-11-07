import java.lang.*;
import java.util.*;
interface interest
{
    void interests(int amount,int rate,int time);
}
public class SimpleInterest {
    public static void main(String args[])
    {
         interest Interest=(var amount,var rate,var time)->{
             var amountInterest=amount*rate*time/100;
             System.out.println("Interest="+amountInterest);
         };
         Interest.interests(10000,3,2);
    }
}
