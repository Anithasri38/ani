import java.lang.*;
import java.util.*;
interface Arithmetic
{
    void operation(int a,int b);
}
public class ArithmeticOperations {
    public static void main(String args[])
    {
        Arithmetic operation=((a, b) -> {
            System.out.println("Addition="+(a+b));
            System.out.println("Subtraction="+(a-b));
            System.out.println("Division="+(a/b));
            System.out.println("Multiplication="+(a*b));
        });
        operation.operation(6,7);
    }
}
