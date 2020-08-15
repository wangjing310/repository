package Thread;

import java.util.Random;

public class MainThreadTest {
    /**
     * 无论是多少分支都是main一个线程
     * @param args
     */
    public static void main(String[] args){

        String name=Thread.currentThread().getName();
        System.out.println(name);
        System.out.println("------");

        new MainThreadTest().test1();


    }

    public void test1(){
        int i=new Random().nextInt(20);
        if (i>10){
            //拿到当前线程的名字
            String name=Thread.currentThread().getName();//写到哪个线程执行的代码块中就执行的是哪个线程
            System.out.println(name+"  "+i);
        }else{
           String name=Thread.currentThread().getName();
            System.out.println(name+"  "+i);
        }
        test2();
    }

    public void test2(){
        System.out.println("------test2-----");
        for (int i=0;i<3;i++){
            String name = Thread.currentThread().getName();
            System.out.println(name+"  "+i);
        }
        test3();
    }

    public void test3(){
        try{
            int i=10/0;
        }
        catch(Exception e){
            String name=Thread.currentThread().getName();
            System.out.println(name);
        }
    }
}
