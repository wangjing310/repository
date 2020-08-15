package reflect;

import java.lang.reflect.Constructor;

public class GetConstrcter {

    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("reflect.Person");

      //3、利用newInstance创建对象：调用的类必须有无参的构造器
        Object o = clazz.newInstance();
        System.out.println(o);

        System.out.println("···········");
        //获取Construor对象
        Constructor[] constructors = clazz.getConstructors();//获取所有公共构造器
        for (Constructor c:constructors){
            System.out.println(c);
        }

        Constructor constructor = clazz.getConstructor(String.class, int.class);//通过参数获取指定的构造器
        System.out.println("指定的："+constructor);

        //调用构造器的Instance（）创建构造器对象
        Person person = (Person) constructor.newInstance("王晶", 18);
        System.out.println(person.toString());

    }
}
