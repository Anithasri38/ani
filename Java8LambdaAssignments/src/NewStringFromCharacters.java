import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.lang.String;
import java.util.function.Consumer;

public class NewStringFromCharacters {
    public static void main(String args[])
    {
        List<String> list=new ArrayList<>();
        list.add("Anitha");
        list.add("Sri");
        list.add("appu");
        list.add("Sai");
       // Consumer lists=s->System.out.println();

        StringBuilder str=new StringBuilder();
             for(String l:list)
             {
                 str.append(l.charAt(0));
             }
             System.out.println(str);

    }
}
