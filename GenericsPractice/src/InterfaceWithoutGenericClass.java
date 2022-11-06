import java.lang.*;
import java.util.*;
interface InterfaceGe<String>
{
     void setValues(String e);
      String getValues();
}
class GenericInters implements InterfaceGe<String>
{
    String e;
    public void setValues(String e)
    {
        this.e=e;
    }
    public String getValues()
    {
        return e;
    }
}
public class InterfaceWithoutGenericClass {
    public static void main(String args[])
    {
        GenericInters obj1=new GenericInters();
        obj1.setValues("Anitha");
        String s=obj1.getValues();
        System.out.println(s);
    }
}
