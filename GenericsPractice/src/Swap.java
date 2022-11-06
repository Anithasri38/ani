import java.lang.*;
import java.util.*;
public class Swap<T> {
    private T[] t;
    public <T> void swap(T[] array,int left,int right)
    {
        T temp=array[right];
        array[right]=array[left];
        array[left]=temp;
        for(T t:array)
        {
            System.out.println(t);
        }
    }
    public static void main(String args[])
    {
        Integer arry[]={2,3};
        System.out.println("Elements in array before Swapping");
        Swap<Integer> swap=new Swap<Integer>();
        for(Integer n:arry)
        {
            System.out.println(n);
        }
        System.out.println("After swapping");
        swap.swap(arry,0,1);


    }
}
