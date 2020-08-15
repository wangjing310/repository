package io;

import java.io.FileReader;
import java.io.Reader;

public class ReaderTest {
    public static void main(String[] args){
        String path="D:\\work\\demo1.txt";
        FileReader fileReader=null;


        try{
            fileReader=new FileReader(path);

            while (true) {
                int temp = fileReader.read();  //read()返回-1表示文件读取完
                if (temp == -1)
                    break;
                System.out.print((char)temp);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        finally {
            if (fileReader!=null)
                try{
                    fileReader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

        }

    }
}
