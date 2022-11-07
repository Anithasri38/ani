import java.lang.*;
import java.util.*;
public class RemoveOddLength {
    public static void main(String args[])
    {
        List<String> list=new ArrayList<>();
        list.add("Anitha");
        list.add("Sri");
        list.add("appu");
        list.add("Sai");
        System.out.println(list);
        list.removeIf(p->p.length()%2!=0);
        list.replaceAll(p->p.toUpperCase(Locale.ROOT));
        System.out.println(list);
    }
}
