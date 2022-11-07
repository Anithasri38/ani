import java.lang.*;
import java.util.*;
interface Order
{
    void orderPrice(int p);
}
public class OrdersDetails {
    public static void main(String args[])
    {
        Order placeOrder=(p)->{
            System.out.println("Enter Price");
            Scanner s=new Scanner(System.in);
            p=s.nextInt();
            if(p>10000)
            {
                System.out.println("The order is completed");
            }
            else
            {
                System.out.println("The order is not completed");
            }
        };
    }
}
