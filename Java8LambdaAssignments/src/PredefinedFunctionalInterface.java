import java.lang.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefinedFunctionalInterface {
    public static void main(String rgs[])
    {
        Predicate<Integer> p= i->i%2==0;
        System.out.println(p.test(8));
        Consumer<String> d=s->System.out.println(s);
       d.accept("Hello Good Morning");
        Supplier<Integer> s=()->{
            Integer[] a={1,2,8,6,3};
            return a.length;
        };
        Consumer<Integer> c=t->System.out.println(t);
        c.accept(s.get());
        System.out.println(s.get());
        Function<Integer,Integer> f=i->i+i;
        System.out.println(f.apply(10));
    }
}
