package highcourse;

import oop.Person;

import java.io.IOException;

public class ExceptionTest1 {
    //2.throws抛出异常，给调用该方法者处理，自己不处理

    public static void readChar()throws IOException {  //把错误抛出
        int input=System.in.read();
        System.out.println(input);
    }
    //1）.调用者处理该异常
    public static void main(String[] args) {
        try{
            readChar();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {  //只要有try就一定被执行，通常用来资源释放操作，关闭文件，关闭数据库链接
                   //finally的返回值会覆盖try/catch的返回值

        }


    }
    //2）.抛出异常
    public static void test()throws IOException{
        readChar();
    }

    //3）.throw 手动抛出异常
    public void save(Person person){
        if (person==null)
            throw new IllegalArgumentException("对象为空");  //throw 后面跟可抛出的对象引用

    }



}
