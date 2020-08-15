package Thread;

public class
RunnableTest {
    public static void main(String[] args){

        Runnable r1= new MyThread1();
        Runnable r2= new MyThread1();
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.setName("hello");
        t2.setName("word");
        t1.start();
        t2.start();

    }
}

/**
 * 2.实现runnable接口创建新线程
 */
 class MyThread1 implements Runnable{
     @Override
     public void run() {
         for (int i=0;i<5;i++){
             String name = Thread.currentThread().getName();
             System.out.println(name+"   "+i);
         }

     }
 }