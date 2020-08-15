package oop;

public interface Draw {
    public void draw();
    //jdk8以后，可以在接口中设置default的方法体
    default void test(){
        System.out.println("default method");
    }
    //jdk8以后接口可以有静态方法
    static void test2(){
        System.out.println("static method");
    }
}
