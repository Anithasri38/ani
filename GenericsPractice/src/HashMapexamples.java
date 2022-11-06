import java.lang.*;
import java.util.*;
class HashMapExamples{
    public static void main(String args[])
    {
        HashMap<Integer,Double> map=new HashMap<Integer,Double>();
        map.put(1,1.200);
        map.put(2,1.250);
        map.put(3,1.300);
        map.put(4,1.7600);
        map.put(5,1.2800);
        map.put(6,1.250);
        map.put(7,1.280);
        map.put(8,2.200);
        map.put(9,7.200);
        map.put(10,8.200);
        System.out.println("Iterating HashMap...");
        for(Map.Entry m:map.entrySet())
        {
            System.out.println("Key="+m.getKey()+"  value="+m.getValue());
        }

    }
}
