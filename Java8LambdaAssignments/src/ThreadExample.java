import java.lang.*;
import java.util.*;
public class ThreadExample {
    public static void main(String args[])
    {
        Thread t1=new Thread(()->{
            List<Integer> list=new ArrayList<Integer>();
            list.add(1);
            list.add(4);
            list.add(5);
             list.add(3);
             System.out.println(list);
            //Consumer<List<Integer>> numList=list1->list.stream().forEach(a->System.out.println(a+" "));
            //modify.addThen(numList).accept(list);
        });
        t1.start();
    }
}
