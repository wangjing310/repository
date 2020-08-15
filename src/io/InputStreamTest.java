package io;

import java.io.FileInputStream;

public class InputStreamTest {

    public static void main(String[] args){
        String path="D:\\work\\sellcom_1.sql";
        FileInputStream fileInputStream=null;
        try{
            fileInputStream =new FileInputStream(path);
            int temp=0;
            while ((temp=fileInputStream.read())!=-1)
                System.out.print((char) temp);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if (fileInputStream!=null)
                    fileInputStream.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

    }


}
