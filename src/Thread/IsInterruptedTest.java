package Thread;

public class IsInterruptedTest {
    //isinterropted()判断是否被更改标志位，被中断某个状态返回true
   public static void main(String[] args)throws Exception{
       Thread t=new MyThread6();
       t.start();
       Thread.sleep(1);
       t.interrupt();
   }

}


class MyThread6 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
        // System.out.println(this.isInterrupted()) //标志位改变之后不重置
         System.out.println(this.interrupted()+" "+i);   //标志位改变之后重置为flase


        }
    }
}