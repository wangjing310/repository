package oop;

public class Gather {
    //聚合：当前类创建其他类的对象，调用其他类的方法
    ThisTest thisTest;
    Double  PI=3.14;

   public void area(int r){
       new ThisTest();
       int result=thisTest.squre(r);
       System.out.println(PI*result);
}
}
