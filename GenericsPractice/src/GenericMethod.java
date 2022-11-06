import java.lang.*;
import java.util.*;
class GenericMe<T>
{
    private T[] arr;
    public GenericMe(T[] arr)
    {
        super();
        this.arr=arr;
    }
    public T[]  getArray()
   {
        return arr;
   }
  /* public <E> void printElements(E[] arr)
   {
       for(E e: arr)
       {
           System.out.println(e);
       }
   }
   */
}
public class GenericMethod {
    public static void main(String args[])
    {
        Integer arr[]={1,2,3,4,5};
        GenericMe<Integer> obj=new GenericMe<Integer>(arr);
        Integer[] arr2=obj.getArray();
       // obj.printElements(arr2);
        System.out.println(".................................");
        String str[]={"anitha","sri"};
        GenericMe<String> obj1=new GenericMe<String>(str);
        String str1[]=obj1.getArray();
        //obj1.printElements(str1);
    }
}
