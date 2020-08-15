package Thread;

public class WaitTest {
    //锁对象调用wait()并且在synchronized代码块中才有效果
    //强行把把某个线程拿到的锁对象释放掉
    public static void main(String[] args){
        Thread t1=new MyTread10();
        Thread t2=new MyTread10();
        t1.start();
        t2.start();
    }
}
class MyTread10 extends Thread{
    static int i;
    @Override
    public void run() {
        synchronized (MyTread10.class){
            try{
                String name = Thread.currentThread().getName();
                for (;i<20;i++){
                    if (i==10){
                        i++;
                        MyTread10.class.wait();  //i=10时把当前拿到锁对象的线程释放掉

                    }
                    System.out.println(name+" "+i);

                }

                MyTread10.class.notify();   //唤醒等待这个锁对象的一个线程
               // MyTread10.class.notifyAll();   //唤醒等待这个锁对象的所有线程
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}