import java.util.*;
public class Result {
    public static void main(String args[]) {
        int sub1, sub2, sub3;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Subject1 Marks");
        sub1 = s.nextInt();
        System.out.println("Enter Subject2 Marks");
        sub2 = s.nextInt();
        System.out.println("Enter Subject3 Marks");
        sub3 = s.nextInt();
        if ((sub1 > 60) && (sub2 > 60) && (sub3 > 60)) {
            System.out.println("Passed");
        }
        else
        {
            if(((sub1>60)&&(sub2>60))||((sub1>60)&&(sub3>60))||((sub2>60)&&(sub3>60)))
            {
                System.out.println("Promoted");
            }
            else
            {
                System.out.println("Failed");
            }
        }
    }
}
