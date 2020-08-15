import basejava.Operator;
import basejava.Variable;
import controlstatement.TestBreakContinue;
import controlstatement.TestFor;
import controlstatement.TestIf;
import inherit.BabyDog;
import inherit.Bird;
import inherit.Dog;
import oop.Gather;
import oop.ObjectClass;
import oop.StaticTest;

import java.nio.file.OpenOption;

public class Main {

    public static void main(String[] args) {

        Variable variable=new Variable();
        //variable.testType();
        //variable.testType1();
        //variable.testType2();
        //variable.testType3();
        //System.out.println("Hello World!");

        Operator o=new Operator();
        //o.test1();
        //o.test2();
        //o.test3();
        //o.test4();
        //o.test5();
        //o.test6();

        TestIf testIf=new TestIf();
        //testIf.grade();
        //testIf.testSwitch();

        TestFor testFor=new TestFor();
        //testFor.testFor();
       // testFor.testForEach();
        //testFor.whiletest();
        //testFor.dowhile();

        TestBreakContinue breakContinue=new TestBreakContinue();
        //breakContinue.breaktest();

       // ObjectClass objectClass=new ObjectClass();
       // objectClass.id=1420561;
       // objectClass.name="王晶";
        //System.out.println(objectClass.id+"```"+objectClass.name);

        //objectClass.initialize(101,"王晶");
        //匿名对象
       // new ObjectClass().show();

        /*objectClass.insert(123456,"王女士",100000);
        objectClass.deposit(2000);
        objectClass.withDraw(300);
        objectClass.display();*/

        //Gather gather=new Gather();
        //gather.area(3);

        Dog dog=new Dog();  //单继承
        dog.leg=4;
        dog.eat();
        dog.bark();
        System.out.println(dog.leg);

        BabyDog babyDog=new BabyDog();   //多级继承
        babyDog.leg=4;
        babyDog.eat();
        babyDog.bark();
        babyDog.cry();
        System.out.println(dog.leg);

        Bird bird=new Bird();   //分层继承
        bird.leg=2;
        bird.eat();
        bird.fly();
        System.out.println(bird.leg);


    }
}
