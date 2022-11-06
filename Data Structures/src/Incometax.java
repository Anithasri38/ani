import java.util.*;
public class Incometax {
    public static void main(String args[]) {
        double t= 0,i;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Income :");
        i = s.nextDouble();
        t=incomeTax(i);
        System.out.println("Income tax amount is :"+t);
    }
        static double incomeTax ( double it)
        {
            double tax;
            if (it <= 180000) {
                tax = 0;
            } else if (it <= 300000) {
                tax = 0.1 * (it - 180000);
            } else if (it <= 500000) {
                tax = (0.2 * (it - 300000)) + (0.1 * 100000);
            } else if (it <= 1000000) {
                tax = (0.3 * (it - 500000)) + (0.2 * 200000) + (0.1 * 100000);
            } else {
                tax = (0.4 * (it - 1000000)) + (0.3 * 500000) + (0.2 * 200000) + (0.1 * 100000);
            }
            return tax;
        }

}
