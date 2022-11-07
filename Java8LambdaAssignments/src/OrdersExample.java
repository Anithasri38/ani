import java.lang.*;
import java.util.*;
import java.util.stream.Stream;

class orders
{
    String order_name;
    int orderPrice;
    orders(String name,int price)
    {
        this.order_name=name;
        this.orderPrice=price;
    }

    @Override
    public String toString() {
        return "orders{" +
                "order_name='" + order_name + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
public class OrdersExample {
    public static void main(String args[])
    {
        List<orders> orders=Arrays.asList(
          new orders("Chocolates",500),
          new orders("WashingMachine",30000),
          new orders("RealMePhone",20000),
          new orders("Fan",5000)
        );
        orders.stream().filter(p->p.orderPrice>10000).forEach(p->System.out.println(p+" Completed"));
    }
}
