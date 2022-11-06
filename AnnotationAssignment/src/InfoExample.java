import java.lang.annotation.*;
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Info
{
    String AuthorID() default "C-126";
    String AuthorName() default "Tech";
    String SuperVisor() default "Manager";
    String Date() default "03-08-2022";
    String Time() default "9.00Am";
    int Version() default 5;
}
@Info(AuthorID="C-1456",AuthorName="teamB",SuperVisor="Manager",Date="06-11-2022",Time="1.00PM",Version=6)
class Project
{
    String projectName;
    String projectId;
    public Project(String projectName,String projectId)
    {
        this.projectName=projectName;
        this.projectId=projectId;
    }
    public void getProjectDetails()
    {
        System.out.println("ProjectName:"+projectName);
        System.out.println("ProjectID:"+projectId);
    }
}
public class InfoExample {
    public static void main(String args[])throws Exception
    {
        Project p=new Project("LibraryManagement","U-22");
        p.getProjectDetails();
        System.out.println("ProjectInfo....");
        Class s=p.getClass();
        Annotation a=s.getAnnotation(Info.class);
        Info info=(Info)a;
        System.out.println("AuthorID:"+info.AuthorID());
        System.out.println("AuthorName:"+info.AuthorName());
        System.out.println("Supervisor:"+info.SuperVisor());
        System.out.println("Starting date:"+info.Date());
        System.out.println("StringTime:"+info.Time());
        System.out.println("Version:"+info.Version());
    }
}
