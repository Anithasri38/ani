import java.lang.annotation.*;
import java.lang.reflect.*;
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Execute
{
    int Sequence();
}
class MyClass
{
    @Execute(Sequence=3)
    public void myMethod1()
    {
        System.out.println("Good Evening");
    }
    @Execute(Sequence=2)
    public void myMethod2()
    {
        System.out.println("Good Afternoon");
    }
    @Execute(Sequence=1)
    public void myMethod3()
    {
        System.out.println("Good Morning");
    }
}
public class ExecuteExample {
    public static void main(String args[])throws Exception
    {
        MyClass s=new MyClass();
        s.myMethod3();
        s.myMethod2();
        s.myMethod1();
        Class c=s.getClass();
        Method m1=c.getMethod("myMethod1");
        Annotation a=m1.getAnnotation(Execute.class);
        Execute e=(Execute)a;
        Method m2=c.getMethod("myMethod2");
        Annotation a1=m2.getAnnotation(Execute.class);
        Execute e1=(Execute)a1;
        Method m3=c.getMethod("myMethod3");
        Annotation a2=m3.getAnnotation(Execute.class);
        Execute e2=(Execute)a2;
        System.out.println("Priority of myMethod1:"+e.Sequence());
        System.out.println("Priority of myMethod2:"+e1.Sequence());
        System.out.println("Priority of myMethod3:"+e2.Sequence());
    }
}
