package oop;

import inherit.Animal;
import inherit.Bird;
import inherit.Dog;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Polymorphism extends Person{

    int a=200;
    public void run(){
        System.out.println("child running...");
    }

    public static void main(String[] args){
        Person p=new Polymorphism();  //向上转换
        p.run();  //调用子类方法
        System.out.println(p.a);  //100  调用父类属性
    }

}
