import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

class Trader
{
    String name;
    String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
   public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trader)) return false;
        Trader trader = (Trader) o;
        return Objects.equals(getCity(), trader.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity());
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
public class StreamsAssignment3 {
    public static void main(String args[])
    {
        List<Trader> trader=Arrays.asList(
               new Trader("Anitha","Guntur"),
                new Trader("Appu","Bangalore"),
               new Trader("Sai","Hyderabad"),
                new Trader("Tan","Delhi"),
               new Trader("Anisri","Delhi"),
                new Trader("Teddy","Pune"),
               new Trader("Cherry","Pune")
        );
        System.out.println("Unique cities");
       trader.stream().distinct().forEach(p->System.out.println(p.getCity()));
       System.out.println("Traders in Pune sorted by Name");
        trader.stream().filter(p->p.getCity().equalsIgnoreCase("Pune")).sorted((Comparator.comparing(Trader::getName))).forEach(p->System.out.println(p.getName()));
        System.out.println("Traders who is in guntur");
        trader.stream().filter(p->p.getCity().equalsIgnoreCase("Guntur")).forEach(p->System.out.println(p.getName()));
        System.out.println("Traders names Sorted Alphabetically");
        trader.stream().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList()).forEach(p->System.out.println(p.getName()));


    }
}
