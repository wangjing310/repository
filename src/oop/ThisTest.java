package oop;

public class ThisTest {
    /*1this指向当前类的实例变量*/
    int Id;
    String name;

    void test(int Id,String name){
        this.Id=Id;
        this.name=name;
        System.out.println(Id+name);
        this.defultTest();   //3.调用当前类方法,this可省略
    }
    public static void main(String args[]){
        new ThisTest(5).test(1,"小仙女");

        ThisTest thisTest = new ThisTest();



    }
    void defultTest(){
        System.out.println("小野猫");
    }
    /*2调用默认构造函数*/
    ThisTest(){
        System.out.println("小哥哥");
    }

    ThisTest(int a){

        this();
        System.out.println("小脑斧"+a);
    }

    int  squre(int x){

        return x*x;
    }
}
