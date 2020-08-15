package oop;

public class Person {
    String name;
    int age;

    int a=100;

    public Person(){System.out.println("父类无参构造器");} //在创建对象时被调用

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void test(){
        System.out.println("父类方法");
    }

    public void run(){
        System.out.println("runing....");
    }
}
