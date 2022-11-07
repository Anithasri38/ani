import java.lang.*;
import java.util.*;
public class UpperCase {
    public static void main(String args[])
    {
        List<String> list=new ArrayList<>();
        list.add("Anitha");
        list.add("Sri");
        list.add("appu");
        list.add("Sai");
        list.replaceAll(p->p.toUpperCase(Locale.ROOT));
        System.out.println(list);
    }
}
