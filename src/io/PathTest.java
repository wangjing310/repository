package io;

import java.io.File;

public class PathTest {
    public static void main(String[] args){
        //Windows在路径名中使用反斜杠(\)作为名称分隔符，而UNIX使用正斜杠(/)
        //分隔符File.separator使Java代码在不同的平台上工作
        //String path="F:\\fileTest\\work\\demo1.txt";
        File file=new File("fileTest.txt");
        //获取绝对路径  相对系统的文件路径
        System.out.println(file.getAbsoluteFile());
        //返回文件名称
        System.out.println(file.getName());
        //返回文件的相对目录,构造函数中封装的什么路径就返回什么路径
        System.out.println(file.getPath());

    }

}
