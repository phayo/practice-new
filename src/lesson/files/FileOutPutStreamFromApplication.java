package lesson.files;

import java.io.*;

public class FileOutPutStreamFromApplication {
    public static void main(String[] args) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream("/Users/ebuka/Documents/Practice/users.csv"));
        String s="ATesting out function is working";
        byte b[]=s.getBytes();
        os.write(b);
        os.flush();
        os.close();
        System.out.println("success");
        
        //Write a java class
        String content = "";
    }
}