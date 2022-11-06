import java.lang.*;
import java.util.*;
public class UniqueObjects {
    public static void main(String args[])
    {
        HashSet<String> obj=new HashSet<>();
        obj.add("Book");
        obj.add("Table");
        obj.add("Chair");
        obj.add("Book");
        obj.add("pen");
        obj.add("Mobile");
        obj.add("Plank");
        obj.add("Spoon");
        obj.add("Cooker");
        obj.add("table");
       System.out.println(obj);
    }
}
