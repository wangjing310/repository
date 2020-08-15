package Thread;

public class ThreadTest {
    //java.lang.Thread  唯一一个操作线程的类

    /**
     * main线程和Mythread线程抢夺资源同时执行
     *
     */
    public static void main(String[] args){
        //new 一个线程就是新建一个新线程
        Thread t=new MyThread();
        Thread t1=new MyThread();
        t.start();  //开启MyThread线程
        t1.start();

        for (int i=0;i<5;i++){
            String name = Thread.currentThread().getName();
            System.out.println(name+"   "+i);
        }
    }
}

/**
 *
    自定义类继承Thread
    重写run（）方法
 */
class MyThread extends Thread{
    //声明  新线程的开启，新线程要执行什么
        @Override
        public void run() {
            for (int i=0;i<5;i++){
                String name = Thread.currentThread().getName();
                System.out.println(name+"   "+i);
            }
        }
    }