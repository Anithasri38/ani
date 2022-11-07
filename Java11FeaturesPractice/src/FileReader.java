import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
class FileReaderExample {
    public static void main(String args[]) throws Exception{
        File f=new File("out/production/Java11FeaturesPractice/data/read.txt");
        System.out.println(f.exists());
    }
}
