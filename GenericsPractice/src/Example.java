import java.util.*;
import java.lang.*;
import java.util.*;
 class MyGenericClassExample<T> {
    private List<T> list;
    public void setList(List<T> list)
    {
        this.list=list;
    }
    public List<T> getList()
    {
        return list;
    }
}
class Example
{
    public static void main(String args[])
    {
        MyGenericClassExample<Integer> obj=new MyGenericClassExample<>();
        List<Integer> list1=new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        obj.setList(list1);
        //System.out.println(obj.getList());
        List<Integer> list=obj.getList();
        list.forEach(System.out::println);
        System.out.println("............................");
        MyGenericClassExample<String> obj1=new MyGenericClassExample<>();
        List<String> list2=new ArrayList<>();
        list2.add("Anitha");
        list2.add("Sri");
        list2.add("AniSri");
        obj1.setList(list2);
        //System.out.println(obj1.getList());
        list2.forEach(System.out::println);

    }
}

