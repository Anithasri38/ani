import java.lang.*;
import java.util.*;
public class MapAppend {
    public static void main(String args[])
    {
        Map<String,String> list=new HashMap<>();
        list.put("Ani","sri");
        list.put("Sri","Ani");
        list.put("hello","world");
        StringBuilder str=new StringBuilder();
        for(Map.Entry<String,String> p:list.entrySet())
        {
            String str1=p.getKey()+p.getValue();
            System.out.println(str1);
            str.append(str1);
        }
        System.out.println(str);
    }
}
