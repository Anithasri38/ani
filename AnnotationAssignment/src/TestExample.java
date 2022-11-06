import java.lang.annotation.*;
import java.lang.reflect.*;
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test
{
    String imply();
}
class TestCase
{
    @Test(imply="The Following Method is TestCase")
    public void getInformation()
    {
        System.out.println("Successfully Tested");
    }
}
public class TestExample{
    public static void main(String args[])throws Exception
    {
        TestCase c=new TestCase();
        c.getInformation();
        System.out.println("Method MetaData:");
        Class s=c.getClass();
        Method m=s.getMethod("getInformation");
        Annotation a=m.getAnnotation(Test.class);
        Test t=(Test)a;
        System.out.println(t.imply());

    }
}
