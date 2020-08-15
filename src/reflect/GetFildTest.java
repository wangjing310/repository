package reflect;

import java.lang.reflect.Field;

public class GetFildTest {

    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("reflect.Person");
        Field[] fields = clazz.getDeclaredFields();  //获取所有私有字段
        for (Field f:fields){
            System.out.println(f.getName());
        }

        //1.2 获取指定名字的Field（如果是私有的，见下面的4)
        Field field = clazz.getDeclaredField("name");
        System.out.println("\n获取指定Field名=: " + field.getName());

        //2、获取指定对象的Field的值
        Person person = new Person("ABC", 12);
        Object val = field.get(person);
        System.out.println("获取指定对象字段'name'的Field的值=： " + val);

        //3、设置指定对象的Field的值
        field.set(person,"wangjing");
        System.out.println("设置指定对象字段'name'的Field的值=: " + person.name);

    }

}
