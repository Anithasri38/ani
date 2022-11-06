import java.util.*;
import java.lang.*;
public class StringOperation {
    public static void main(String args[])
    {
        String str="Java String pool refers to collection of Strings which are stored in heap memory";
        System.out.println("String Lower Case is "+str.toLowerCase());
        System.out.println("String Upper Case is "+str.toUpperCase());
        System.out.println(str.replace('a','$'));
        System.out.println(str.contains("collection"));
        String str1="java string pool refers to collection of strings which are stored in heap memory";
        if(str.equals("java string pool refers to collection of strings which are stored in heap memory"))
        {
            System.out.println("Both Strings are equal without ignoring case");
        }
        else if(str.equalsIgnoreCase("java string pool refers to collection of strings which are stored in heap memory"))
        {
            System.out.println("Both strings are equal ignoring case");
        }

    }
}
