import java.lang.*;
public class StringBulderMethods {
        public static void main(String args[]) {
            StringBuilder str = new StringBuilder("StringBuilder");
            str.append(" is a peer class of String");
            str.append(" that provides much of");
            str.append(" the functionality of strings");
            System.out.println(str);
            StringBuilder str1 = new StringBuilder("how are u _");
            str1.replace(10, 11, "insertText");
            System.out.println(str1);
            StringBuilder str2=new StringBuilder("This method returns the reversed object on which it was called ");
            System.out.println(str2.reverse());
        }


}
