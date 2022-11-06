import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int a,rem,sum=0,i;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number");
        a=s.nextInt();
        for(i=a;a!=0;a=a/10)
        {
            rem=a%10;
            sum=sum+rem*rem*rem;
        }
        if(sum==i)
        {
            System.out.println(sum+" is armstrong number");
        }
        else
        {
            System.out.println(sum+" is not armstrong number");
        }
    }
}
