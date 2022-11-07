
import java.lang.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class News
{
    int newsId;
    String postedByUser;
    String commentByUser;
    String comment;
    News(int newsId,String postedByUser,String commentByUser,String comment)
    {
        this.newsId=newsId;
        this.postedByUser=postedByUser;
        this.commentByUser=commentByUser;
        this.comment=comment;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getPostedByUser() {
        return postedByUser;
    }

    public String getCommentByUser() {
        return commentByUser;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", postedByUser='" + postedByUser + '\'' +
                ", commentByUser='" + commentByUser + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
public class StreamsAssignment2 {
    public static void main(String args[])
    {
        List<News> news= Arrays.asList(
                new News(1001,"Anitha","Anisri","Please provide clear Budget"),
                new News(1002,"Sandy","Sai","Thanks for your clear Budget"),
        new News(1002,"Anitha","Sai","Article was nice"),
        new News(1004,"Surya","Sri","thanks for good news")
        );
           long a=(news.stream().filter(p -> p.getComment().contains("Budget")).count());
           System.out.println(a);
       System.out.println(news.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

    }

}
