package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//复制文件，使用Buffer提高效率
public class StringBufferTest {
    public static void main(String[] args){
        String path1="F:\\fileTest\\work\\demo1.txt";
        String path2="F:\\fileTest\\work\\demo2.txt";

        FileReader fileReader=null;
        FileWriter fileWriter=null;
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;



        try{
            fileReader=new FileReader(path1);
            fileWriter=new FileWriter(path2);
            //将需要提高效率的文件对象放在其构造函数中
            bufferedReader=new BufferedReader(fileReader);
            bufferedWriter=new BufferedWriter(fileWriter);

            String line=null;

            while ((line=bufferedReader.readLine())!=null){
                //读取行，直到返回null
                //readLine()方法只返回换行符之前的数据
                bufferedWriter.write(line);
                //写完之后换行
                bufferedWriter.newLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if (bufferedReader!=null && bufferedWriter!=null)
                    bufferedReader.close();
                    bufferedWriter.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
