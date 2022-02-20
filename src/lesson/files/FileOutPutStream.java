package lesson.files;

import java.io.*;

public class FileOutPutStream {
    public static void main(String[] args) {

        try{
            OutputStream os = new BufferedOutputStream(new FileOutputStream("/Users/ebuka/Documents/Practice/users.csv"));
            String s="ATesting out function is working";
            byte b[]=s.getBytes();
            os.write(b);
            os.flush();
            os.close();
            System.out.println("success");


            //Write a java class
            String content = "package lesson.files;\n" +
                    "\n" +
                    "import java.io.*;\n" +
                    "\n" +
                    "public class FileOutPutStreamFromApplication {\n" +
                    "    public static void main(String[] args) throws IOException {\n" +
                    "        OutputStream os = new BufferedOutputStream(new FileOutputStream(\"/Users/ebuka/Documents/Practice/users.csv\"));\n" +
                    "        String s=\"ATesting out function is working\";\n" +
                    "        byte b[]=s.getBytes();\n" +
                    "        os.write(b);\n" +
                    "        os.flush();\n" +
                    "        os.close();\n" +
                    "        System.out.println(\"success\");\n" +
                    "        \n" +
                    "        //Write a java class\n" +
                    "        String content = \"\";\n" +
                    "    }\n" +
                    "}";

            OutputStream os1 = new BufferedOutputStream(new FileOutputStream("/Users/ebuka/Documents/Practice/src/lesson/files/FileOutPutStreamFromApplication.java"));// This is the location in the computer I want to store the file
            byte[] bb = content.getBytes();
            os1.write(bb);
            os1.flush();
            os1.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
