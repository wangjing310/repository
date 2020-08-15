package io;

import java.io.*;

public class BufferedTest {


    public static void main(String[] args) throws  Exception{

        String path1="D:\\work\\text1.txt";
        String path2="D:\\work\\text2.txt";

       try{
           FileInputStream inputStream = new FileInputStream(path1);
           FileOutputStream outputStream=new FileOutputStream(path2);

           BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
           BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
           int a=0;
           while (true){
               a=bufferedInputStream.read();
               bufferedOutputStream.write((char)a);
               if(a==-1){
                  break;

               }
           }

           bufferedOutputStream.flush();
       }catch (Exception e){
           e.printStackTrace();
       }finally {

       }







    }
}
