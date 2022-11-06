import java.lang.*;
import java.util.*;
interface GenericInter<E>{
    void setValues(E e);
    E getValues();
}
class Examples<E,K> implements GenericInter<E>
{
    private E e;
    private K k;
    public void setValues(E e)
    {
        this.e=e;
    }
    public E getValues()
    {
        return e;
    }
    public void setK(K k)
    {
        this.k=k;
    }
    public K getK()
    {
        return k;
    }

}
class GenericInterface
{
    public static void main(String args[])
    {
        Examples<Integer,String> obj1=new Examples<Integer,String>();
        obj1.setValues(300);
        Integer value=obj1.getValues();
        System.out.println(value);
        obj1.setK("Anitha");
        String values=obj1.getK();
        System.out.println(values);

    }
}
