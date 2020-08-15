package Thread;

public class InterruptTest {
    //interrupt中断某个线程的阻塞状态  sleep，wait,join
    public static void main(String[] args)throws  Exception{
        Thread t = new MyThread5();
        t.start();
        Thread.sleep(5000);  //主线程睡眠五秒，中断阻塞状态
        t.interrupt();
    }
}

class MyThread5 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i+" "+this.isAlive());
            if (i==4){
            try{
                sleep(90000);//每循环一次睡眠一秒
            }
            catch(Exception e){
                e.printStackTrace();
            }
            }
        }
    }
}