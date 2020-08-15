package oop;

public class StaticTest {
    //静态变量所有对象共享
    //
    static int count=0;
    StaticTest(){
        count++;
        System.out.println(count);
    }
    //静态代码块：类加载时在main()方法之前执行，初始化静态数据成员
    static {
        System.out.println("我是静态代码块");
    }
    public static void main(String args[]){
        StaticTest s1=new StaticTest(1,"王晶",colleage);
        s1.disply();
        chenge();
        StaticTest s2=new StaticTest(2,"宋钟基",colleage);
        s2.disply();

    }

    //静态方法调用静态成员
    int rollNo;
    String name;
    static String colleage="undergraduate";

    StaticTest(int n,String na,String c){
        rollNo=n;
        name=na;
        colleage=c;
    }
    //静态方法只能调用静态变量,不能调用非静态成员和非静态方法
    static void chenge(){
        colleage="graduate";
    }

    void disply(){
        System.out.println(rollNo+"  "+name+"  "+colleage);

    }


}
