import java.lang.*;

public class StringBufferMetods {
    public static void main(String args[]) {
        StringBuffer str = new StringBuffer("StringBuffer");
        str.append(" is a peer class of String");
        str.append(" that provides much of");
        str.append(" the functionality of strings");
        System.out.println(str);
        StringBuffer str1 = new StringBuffer("how are u _");
        str1.replace(10, 11, "insertText");
        System.out.println(str1);
        StringBuffer str2=new StringBuffer("This method returns the reversed object on which it was called ");
        System.out.println(str2.reverse());
    }
}
