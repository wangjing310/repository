package oop;

public abstract class AbstrctTest {//如果类中有任何抽象方法类必须声明为抽象的
    /**
     * 抽象类里可以有数据成员，方法体，抽象方法，构造函数
     */
    int Id;

    AbstrctTest(){System.out.println("constructor");}

    abstract void test();

    void test1(){
        System.out.println("方法体");
    }

}
