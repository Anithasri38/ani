import java.lang.*;
import java.util.*;
class Pairing<K,V> {
    private K key1,key2;
    private V value1,value2;
    public void setKey1(K k)
    {
        this.key1=k;
    }
    public K getKey1()
    {
        return key1;
    }
    public void setKey2(K k)
    {
        this.key2=k;
    }
    public K getKey2()
    {
        return key2;
    }
    public void setValue1(V v)
    {
        this.value1=v;
    }
    public V getValue1()
    {
        return value1;
    }
    public void setValue2(V v)
    {
        this.value2=v;
    }
    public V getValue2()
    {
        return value2;
    }

}
class PairClass
{
    public static void main(String args[])
    {
        Pairing<String, String> obj1 = new Pairing<String,String>();
        obj1.setKey1("Anitha");
        String key=obj1.getKey1();
        System.out.println("The element in Key is "+key);
        obj1.setValue1("Sri");
        String value=obj1.getValue1();
        System.out.println("The element in Value is "+value);
        System.out.println("..........................");
        Pairing<String,java.util.Date> obj2=new Pairing<String,java.util.Date>();
        obj2.setKey2("Today is:");
        String value1=obj2.getKey2();
        System.out.println(value1);
        obj2.setValue2(new Date());
        System.out.println(obj2.getValue2());

    }
}

