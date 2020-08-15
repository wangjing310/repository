package oop;

public class InstanceInitialBlock extends Person{

    //实例初始化代码块，编译时把其复制到构造器Super（）之后的位置
    InstanceInitialBlock(){
        System.out.println("invok constructor");
    }

    {System.out.println("invock InstanceBloack");}

    public static void main(String[] args){
        InstanceInitialBlock initialBlock=new InstanceInitialBlock();

    }
}
