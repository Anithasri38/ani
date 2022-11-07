package com.company;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception{
	 // File f=new File("out/production/FileReaderDemo/details/StudentsList.txt");
      var path="out/production/FileReaderDemo/details/StudentsList.txt";
      String data= Files.readString(Path.of(path));
      System.out.println("Students Names");
      System.out.println(data);
      System.out.println("Total Students="+data.lines().count());
    }
}
