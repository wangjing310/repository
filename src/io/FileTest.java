package io;

import java.io.File;
import java.io.FileFilter;

public class FileTest {

    public static void main(String[] args) throws Exception{
        //1.File类共提供了三个不同的构造函数，

        //(1)创建文件对象f1，f1所指的文件是在当前目录下创建的Test.txt,
        File file = new File("test.txt");
        boolean fileCreate = file.createNewFile();//如果文件存在返回true，不存在则创建该文件

        //2.mkdirs()创建文件目录
        File file1=new File("F:\\fileTest\\home");
        file1.mkdirs(); //mrdirs()不论F:\\fileTest目录存不存在都创建home目录

        File file2=new File("F:\\fileTest\\home");
        file2.mkdir();  //mkdir()只有当F:\\fileTest存在才创建home目录

        //3.删除文件
        file.delete();  //deleteOnExit()jvm终止时删除文件

        //4.文件大小
        File file3=new File("fileTest");
        boolean filecreate=file3.createNewFile();

        long length=file3.length();// length()返回类型为long,没有文件则返回空
        System.out.println("legth："+length);

        //5.listRoots()静态方法获取文件系统中可用根目录的列表。它返回一个File对象数组。
        File[] root=File.listRoots();
        for (File f:root){
            System.out.println(f.getPath()); //C:\ ， E:\ ， F:\ ， G:\
        }

        //list(返回String类型)，或listFiles(返回File类型 )方法列出目录中的所有文件和目录
        String dirpath="D:\\";
        File dir=new File(dirpath);

        File[] list=dir.listFiles();
        for (File dirfile :list)
            if (dirfile.isFile())  //isFile()判断
                System.out.println(dirfile.getPath()+"(file)");
        else if(dirfile.isDirectory())  //isDirectory()目录判断
            System.out.println(dirfile.getPath()+"(directory)");

        //文件过滤器
        //FileFilter fileter=files ->{};
        System.out.println("------------");
        FileFilter fileter=files ->{
            if (files.isFile()){
                String fileName=files.getName().toLowerCase();
                if (fileName.endsWith(".exe"))
                    return false;
            }
            return true;
        };

        File[] list1=dir.listFiles(fileter);
        for (File f1:list1){
            if (f1.isFile())
                System.out.println(f1.getPath()+"(file)");
            else if (f1.isDirectory())
                System.out.println(f1.getPath()+"(directory)");
        }

    }

}
