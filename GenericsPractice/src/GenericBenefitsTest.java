import java.lang.*;
import java.util.*;
public class GenericBenefitsTest {
    public static void main(String args[])
    {
        MyGenericClass<Integer> obj1=new MyGenericClass<>();
         obj1.setObject(100);
         System.out.println(obj1.getObject());
         MyGenericClass<String> obj2=new MyGenericClass<>();
         obj2.setObject("Anitha");
         System.out.println(obj2.getObject());
         MyGenericClass<Double> obj3=new MyGenericClass<>();
         obj3.setObject(123.567);
         System.out.println(obj3.getObject());
    }
}
