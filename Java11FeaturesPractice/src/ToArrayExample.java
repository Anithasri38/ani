import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class ToArrayExample {
    public static void main(String args[])
    {
        String str="A quick brown fox jumps over the lazy dog";
        String[] str1=str.split(" ");
        ArrayList<String> strList=new ArrayList<String>(Arrays.asList(str1));
        System.out.println(strList);
        String[] arr=strList.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
