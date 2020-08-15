package oop;

public final class FinalTest
{
    //1.禁止变量值被修改
    //2.禁止方法重写
    //3.禁止被继承
    final int f=400;
    final void run(){
        System.out.println("不能重写");
    }
}
