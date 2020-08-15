package oop;

import inherit.Animal;

public class OverWrite extends Animal {
    @Override
    //重写返回类型和方法名必须与父类方法一致
    public void eat() {
        super.eat();
        System.out.println("我想吃鱼~喵喵");
    }

    public static void main(String[] args){
        OverWrite overWrite=new OverWrite();
        overWrite.eat();

    }
}
