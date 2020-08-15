package io;

import java.io.File;
import java.io.FileWriter;

public class WriterTest {
    public static void main(String[] args){
        //创建要操作文件的路径
        //File.separator表示系统相关的分隔符，Linux下为：/  Windows下为：\\
        //String path=File.separator+"fileTest"+File.separator+"work"+File.separator+"demo1";
        String path ="D:\\work\\demo1.txt";

        //以path为路径创建FileWriter对象
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(path);
            //将字符串写入到该文件中
            fileWriter.write("Nerxious is a good boys\\r\\n");
            fileWriter.flush();   //想要在流关闭前输出信息需要手动flush（）
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (fileWriter!=null){
                try{
                    //关闭流
                    fileWriter.close(); //字符流在关闭流的时候才信息才写入
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }





    }
}
