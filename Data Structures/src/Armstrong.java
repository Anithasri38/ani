import java.util.*;
public class Armstrong {
    public static void main(String args[]) {
        int num,rem,temp,i,start,end;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Starting Number");
        start=s.nextInt();
        System.out.println("Enter Ending Number");
        end=s.nextInt();
        for(i=start+1;i<end;i++)
        {
            temp=i;
            num=0;
            while(temp!=0)
            {
                rem=temp%10;
                num=num+rem*rem*rem;
                temp=temp/10;
            }
            if(i==num)
            {
                System.out.println(i);
            }
        }
    }
}
