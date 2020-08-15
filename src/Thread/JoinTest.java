package Thread;

public class JoinTest {
    public static void main(String[] args)throws Exception{
        Thread t=new MyThread7();
        System.out.println("开始运行");
        t.start();
        //写到哪个线程的代码块中就让哪个线程进入阻塞状态
        //等到调用join方法的线程执行完，阻塞的线程再去执行
        t.join();
        System.out.println("结束运行");
    }

}

class MyThread7 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);//每循环一次睡眠一秒
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}