import java.lang.*;
import java.util.*;
class Employee
{
    Integer id;
    String name;
    String department;
    int salary;
    Employee(Integer id,String name,String department,int salary)
    {
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class MyNameComp implements Comparator<Employee>
{
    public int compare(Employee e1,Employee e2)
    {
        return e1.getName().compareTo(e2.getName());
    }
}
class MySalaryComp implements Comparator<Employee>
{
    public int compare(Employee e1,Employee e2)
    {
        return e1.getSalary()-e2.getSalary();
    }
}
class MyDepartmentComp implements Comparator<Employee>
{
    public int compare(Employee e1,Employee e2)
    {
        return e1.getDepartment().compareTo(e2.getDepartment());
    }
}
class MyIdComp implements Comparator<Employee>
{
    public int compare(Employee e1,Employee e2)
    {
        return e1.getId()-(e2.getId());
    }
}

public class TreeSetExample {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        TreeSet<Employee> emp=new TreeSet<Employee>();
        emp.add(new Employee(1001,"Ai","Bsc",20000));
        emp.add(new Employee(1002,"sri","Bsc",26000));
        emp.add(new Employee(1003,"Anitha","Bca",35000));
        emp.add(new Employee(1004,"Sushma","Bsc",20000));
        emp.add(new Employee(1005,"Bhagyam","B.com",18000));
        emp.add(new Employee(1006,"Harshi","Bsc",20000));
        emp.add(new Employee(1007,"Deppu","B.com",18000));
        emp.add(new Employee(1008,"Sandy","Bca",25000));
        emp.add(new Employee(1009,"Megu","Bsc",20000));
        emp.add(new Employee(1010,"Anithasri","Bca",25000));
        //Iterator<Employee> iterator=emp.iterator();
        System.out.println("Choose 1 for ID\nChoose 2 for Name\nChoose 3 for Department\nSalary");
        Integer choose=s.nextInt();
        switch(choose)
        {
            case 1:System.out.println("Employee Details Sorted By Name");
                    TreeSet<Employee> nameComp=new TreeSet<Employee>(new MyNameComp());
                nameComp.add(new Employee(1001,"Ai","Bsc",20000));
                nameComp.add(new Employee(1002,"sri","Bsc",26000));
                nameComp.add(new Employee(1003,"Anitha","Bca",35000));
                nameComp.add(new Employee(1004,"Sushma","Bsc",20000));
                nameComp.add(new Employee(1005,"Bhagyam","B.com",18000));
                nameComp.add(new Employee(1006,"Harshi","Bsc",20000));
                nameComp.add(new Employee(1007,"Deppu","B.com",18000));
                nameComp.add(new Employee(1008,"Sandy","Bca",25000));
                nameComp.add(new Employee(1009,"Megu","Bsc",20000));
                nameComp.add(new Employee(1010,"Anithasri","Bca",25000));
                 for(Employee e:nameComp)
                 {
                     System.out.println(e.getName());
                 }
                 break;
            case 2:System.out.println("Employee details Sorted by Salary");
                    TreeSet<Employee> salComp=new TreeSet<Employee>(new MySalaryComp());
                salComp.add(new Employee(1001,"Ai","Bsc",20000));
                salComp.add(new Employee(1002,"sri","Bsc",26000));
                salComp.add(new Employee(1003,"Anitha","Bca",35000));
                salComp.add(new Employee(1004,"Sushma","Bsc",20000));
                salComp.add(new Employee(1005,"Bhagyam","B.com",18000));
                salComp.add(new Employee(1006,"Harshi","Bsc",20000));
                salComp.add(new Employee(1007,"Deppu","B.com",18000));
                salComp.add(new Employee(1008,"Sandy","Bca",25000));
                salComp.add(new Employee(1009,"Megu","Bsc",20000));
                salComp.add(new Employee(1010,"Anithasri","Bca",25000));
                for(Employee e:salComp)
                {
                    System.out.println(e.getSalary());
                }
                break;
            case 3:System.out.println("Employee Details Sorted by Department");
                   TreeSet<Employee> deptComp=new TreeSet<Employee>(new MyDepartmentComp());
                deptComp.add(new Employee(1001,"Ai","Bsc",20000));
                deptComp.add(new Employee(1002,"sri","Bsc",26000));
                deptComp.add(new Employee(1003,"Anitha","Bca",35000));
                deptComp.add(new Employee(1004,"Sushma","Bsc",20000));
                deptComp.add(new Employee(1005,"Bhagyam","B.com",18000));
                deptComp.add(new Employee(1006,"Harshi","Bsc",20000));
                deptComp.add(new Employee(1007,"Deppu","B.com",18000));
                deptComp.add(new Employee(1008,"Sandy","Bca",25000));
                deptComp.add(new Employee(1009,"Megu","Bsc",20000));
                deptComp.add(new Employee(1010,"Anithasri","Bca",25000));
                for(Employee e:deptComp)
                {
                    System.out.println(e.getDepartment());
                }
                break;
            case 4:System.out.println("Employee Details Sorted by ID");
                    TreeSet<Employee> idComp=new TreeSet<Employee>(new MyIdComp());
                idComp.add(new Employee(1001,"Ai","Bsc",20000));
                idComp.add(new Employee(1002,"sri","Bsc",26000));
                idComp.add(new Employee(1003,"Anitha","Bca",35000));
                idComp.add(new Employee(1004,"Sushma","Bsc",20000));
                idComp.add(new Employee(1005,"Bhagyam","B.com",18000));
                idComp.add(new Employee(1006,"Harshi","Bsc",20000));
                idComp.add(new Employee(1007,"Deppu","B.com",18000));
                idComp.add(new Employee(1008,"Sandy","Bca",25000));
                idComp.add(new Employee(1009,"Megu","Bsc",20000));
                idComp.add(new Employee(1010,"Anithasri","Bca",25000));
                for(Employee e:idComp)
                {
                    System.out.println(e.getId());
                }

        }

    }
}
