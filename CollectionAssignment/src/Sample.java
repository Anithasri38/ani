import java.lang.*;
import java.util.*;
import java.util.function.BiConsumer;

class Emplo
{
    private Integer id;
    private String name;
    private Double salary;
    private String email;
    Emplo(Integer id,String name,Double salary,String email)
    {
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.email=email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emplo)) return false;
        Emplo emplo = (Emplo) o;
        return id.equals(emplo.id) && name.equals(emplo.name) && salary.equals(emplo.salary) && email.equals(emplo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, email);
    }

    /* public int hashCode()
        {
            return 15;
        }
        public boolean equals(Object obj)
        {
            return true;
        }*/
    public String toString()
    {
        return "EmployeesD [id="+id+",name="+name+",salary="+salary+",email="+email+"] ";
    }
}
class Department
{
    private Integer deptId;
    private String deptName;
    private String deptLocation;
    Department(Integer id,String deptname,String deptLocation)
    {
        this.deptId=id;
        this.deptName=deptname;
        this.deptLocation=deptLocation;
    }
    public String toString()
    {
        return "Department [deptId="+deptId+",deptName="+deptName+",deptLocation="+deptLocation+",] ";
    }

}
public class Sample {
    public static void main(String args[])
    {
        Emplo e1=new Emplo(1001,"Ani",20000.00,"anitha@gamil.com");
        Emplo e2=new Emplo(1002,"Joy",20000.00,"anitha@gamil.com");
        Emplo e3=new Emplo(1003,"Sun",20000.00,"anitha@gamil.com");
        Emplo e4=new Emplo(1004,"Moon",20000.00,"anitha@gamil.com");
        Emplo e5=new Emplo(1005,"Star",20000.00,"anitha@gamil.com");
        Department d1=new Department(1200,"IT","Boston");
        Department d2=new Department(1202,"Finance","Bangalore");
       // Map<Emplo,Department> empDeptMap=new HashMap<>();
        Map<Emplo,Department> empDeptMap=new LinkedHashMap<>();
        empDeptMap.put(e1,d1);
        empDeptMap.put(e2,d1);
        empDeptMap.put(e3,d1);
        empDeptMap.put(e4,d2);
        empDeptMap.put(e5,d2);
        empDeptMap.put(null,d1);
        empDeptMap.put(null,d2);
        System.out.println(empDeptMap.size());
        System.out.println("........................................");
        Set<Map.Entry<Emplo,Department>> entrySet=empDeptMap.entrySet();
       /* for(Map.Entry<Emplo,Department> entry:entrySet)
        {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }*/
        for(Map.Entry<Emplo,Department> entry:entrySet)
        {
            Emplo employee=entry.getKey();
            Department department=entry.getValue();
            System.out.println(employee);
            System.out.println(department);
        }
       /* System.out.println("........................................");
        Set<Emplo> keys=empDeptMap.keySet();
        for(Emplo Employee:keys)
        {
            System.out.println(Employee);
            Department value=empDeptMap.get(Employee);
            System.out.println(value);
        }
        System.out.println("........................................");
        empDeptMap.forEach(new BiConsumer<Emplo, Department>() {
            @Override
            public void accept(Emplo key, Department value) {
                System.out.println(key);
                System.out.println(value);
            }
        });
        System.out.println("........................................");
        empDeptMap.forEach((key,value)->
        {
            System.out.println(key);
            System.out.println(value);
        });
        System.out.println("........................................");
        Collection<Department> value=empDeptMap.values();
        for(Department department:value)
        {
            System.out.println(department);
        }
        System.out.println("........................................");*/
    }
}
