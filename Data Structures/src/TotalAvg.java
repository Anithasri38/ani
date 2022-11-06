import java.util.*;
public class TotalAvg {
    public static void main(String args[])
    {
        int a[][], total[], i, j, sum = 0;
        float avg[];
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of students");
        int n = s.nextInt();
        System.out.println("Enter number of subjects");
        int m = s.nextInt();
        a = new int[n][m];
        total = new int[n];
        avg = new float[n];
        for (i = 0; i < n; i++) {

            for (j = 0; j < 3; j++) {
                System.out.println("Enter Subject" + (j + 1) + " marks for Student" + (i + 1));
                a[i][j] = s.nextInt();
            }
        }
        for (i = 0; i < 3; i++) {
            sum = 0;
            for (j = 0; j < 3; j++) {
                sum = sum + a[i][j];
            }
            total[i] = sum;
            avg[i] = total[i] / 3f;
        }
        for (i = 0; i < 3; i++) {
            System.out.println("Student1 total marks is: " + total[i] + " And Average marks is: " + avg[i]);

        }
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = 0; j < n; j++) {
                sum = sum + a[j][i];
            }
            total[i] = sum;
            avg[i]=total[i]/3f;
        }
        for (i = 0; i < 3; i++) {
            System.out.println("Total Marks of students in subject" + (i + 1) + " is: " + total[i] + " And average is: " + avg[i]);

        }
    }

    }

