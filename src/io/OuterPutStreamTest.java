package io;

import java.io.FileOutputStream;

public class OuterPutStreamTest {

    public static void main(String[] args){
        String path="D:\\work\\demo1.txt";
        FileOutputStream fileOutputStream=null;
        try{
             fileOutputStream=new FileOutputStream(path);
             String str="Nerxious is a good boy\\r\\n";
             byte[] bytes=str.getBytes();//使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
             fileOutputStream.write(bytes);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        finally {
            try{
                if (fileOutputStream!=null)
                    fileOutputStream.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }



}
