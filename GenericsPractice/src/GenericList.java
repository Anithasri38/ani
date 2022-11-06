import java.lang.*;
import java.util.*;
public class GenericList {
    public static void main(String args[])
    {
        /*List<Integer> list=new ArrayList<Integer>();
        list.add(100);
        list.add(200);
        list.add(300);
        Iterator<Integer> ltr=list.iterator();
        while(ltr.hasNext())
        {
            Integer n=ltr.next();
            System.out.println(n);
        }*/
        List list=new ArrayList();
        list.add("y");
        list.add("a");
        list.add("e");
        list.add(new Integer(100));
        Iterator<String> itr=list.iterator();
        while(itr.hasNext())
        {
            Object s=itr.next();
            if(s instanceof String)
            {
                String data=(String)s;
                System.out.println(data);
            }
            else if(s instanceof Integer)
            {
                Integer data=(Integer)s;
                System.out.println(data);
            }
            else
            {
                System.out.println(s);
            }
        }
    }
}
