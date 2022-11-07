import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

class Fruits
{
    String name;
    int calories;
    int price;
    String color;
    Fruits(String name,int calories,int price,String color)
    {
        this.name=name;
        this.calories=calories;
        this.price=price;
        this.color=color;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
public class FruitAssignment{
    public static void main(String args[])
    {
        List<Fruits> fruits= Arrays.asList(
                new Fruits("Mango",100,150,"Yellow"),
                new Fruits("Orange",150,90,"Orange"),
                new Fruits("Banana",90,40,"Yellow"),
                new Fruits("Apple",60,100,"Red"),
                new Fruits("Cherries",50,200,"Red")
        );
       /*fruits.stream().filter(p->p.getCalories()<100).sorted(new Comparator<Fruits>(){
           @Override
           public int compare(Fruits o1, Fruits o2) {
               return o2.getCalories()- o1.getCalories();
           }
       }).forEach(p->System.out.println(p.getName()));*/
        System.out.println("list of fruits sorted by calories");
        fruits.stream().filter(p->p.getCalories()<100).sorted((Fruits o1,Fruits o2)->(int)o2.getCalories()-o1.getCalories()).forEach(p->System.out.println(p.getName()));
        System.out.println("List of fruits fruits sorted by color");
        fruits.stream().sorted(new Comparator<Fruits>(){
            @Override
            public int compare(Fruits o1, Fruits o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        }).forEach(p->System.out.println(p.getName()));
        System.out.println("List of Fruits whose color red sorted by price");
        fruits.stream().filter(p->p.getColor().equalsIgnoreCase("Red")).sorted((Fruits o1,Fruits o2)->(int)o1.getPrice()-o2.getPrice()).forEach(p->System.out.println(p.getName()));
    }
}
