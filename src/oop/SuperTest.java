package oop;
import inherit.Animal;

public class SuperTest extends Person {
    //super调用直接父类的属性，方法，构造函数（当子类和父类有相同的属性，方法时用super调用父类方法和属性）
    float salary;
    SuperTest(){
        super(); //3.调用父类构造器,必须在子类构造其中
    }

     SuperTest(String name,int age,float salary){

         super(name,age);//person中没有无参构造器时，子类继承时必须显示调用父类有参构造器，并传进相应参数，否则报错
         this.salary=salary;
     }
    void display(){
         System.out.println(name+age+salary);

    }

    public static void main(String[] args){
         SuperTest superTest1=new SuperTest();
         SuperTest superTest=new SuperTest("wangjing",18,10000);
         superTest.display();
    }
}
