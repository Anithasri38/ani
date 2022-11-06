import java.util.*;
public class Arithmetic {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter first number");
        int a=s.nextInt();
        System.out.println("Enter second number");
        int b=s.nextInt();
        try
        {
            int c=a/b;
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
    }
}
