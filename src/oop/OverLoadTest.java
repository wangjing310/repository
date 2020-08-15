package oop;

public class OverLoadTest {
    //重载两种方法
    // 1.更改参数类型

    public void add(int a,int b){
        System.out.println(a+b);
    }

    public void add(float a,float b){
        System.out.println(a+b);

    }

    public static void main(String arg[]){
        OverLoadTest objectClass=new OverLoadTest();
        objectClass.add(20,20);
        objectClass.add(20.0f,20.1f);
        OverLoadTest.minus(30,20);
        OverLoadTest.minus(30,1,2);

        objectClass.multipuly(20,20);  //第二个int参数自动提升为double类型
        objectClass.multipuly(20,20,20);
    }

    //2.修改参数数量
    static void minus(int a,int b){
        System.out.println(a-b);

    }

    static void minus(int a,int b,int c){
        System.out.println(a-b-c);

    }

    //方法重载类型提升  byte->short->int->long->float->double

    public void multipuly(int a,double b){
        System.out.println(a*b);

    }
    public void multipuly(int a,int b,int c){
        System.out.println(a*b*c);
    }

}
