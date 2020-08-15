package Thread;

public class StopTest {
    public static void main(String[] args){
        //stop关闭线程，运行一段时间关闭t1线程
        //isAlive()测试线程是否活着返回true/flase
        MyThread3 t1=new MyThread3();
        t1.start();
        for (int i=0;i<9999;i++){
            if (i==2000){
                t1.flag=false;
            }
            System.out.println(t1.isAlive());

        }
        //t1.stop();
        //t1.flag=false;

    }
}

class MyThread3 extends Thread{
    public boolean flag=true;
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
      //死循环，不让他停一直运行
        while(flag){
            System.out.println(name);
        }
    }
}