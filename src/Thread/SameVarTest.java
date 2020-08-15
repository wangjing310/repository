package Thread;

import jdbc.Test;

public class SameVarTest {
    //两个线程在用同一个变量时，一个线程用这个变量期间，另一个线程不能用这个变量
    public static void main(String[] args){
        Thread t1=new Mythread8();
        Thread t2=new Mythread8();
        t1.start();
        t2.start();
    }
}

class Mythread8 extends Thread {

    public static int i = 0;
    @Override
    public void run() {

        synchronized (Mythread8.class) {  //同步代码块
            for (; i < 20; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " " + i);
                if (i==10){
                    i++;
                    break;
                }
            }
        }
    }
}