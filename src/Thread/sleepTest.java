package Thread;

public class sleepTest {
    //sleep()睡眠时间到了回到就绪态
    public static void main(String[] args)throws Exception{
        Thread t=new MyThread4();
        t.start();
        Thread.sleep(5000); //让主线程休眠，写在哪一个线程运行的代码块中就让哪个线程休眠
        t.stop();//主线程睡眠五秒后终止线程
    }
}

class MyThread4 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i+" "+this.isAlive());
            try{
                Thread.sleep(1000);//每循环一次睡眠一秒
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}