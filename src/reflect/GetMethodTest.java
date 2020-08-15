package reflect;

import java.lang.reflect.Method;

public class GetMethodTest {

    public static void main(String[] args)throws Exception{
        Class clazz = Class.forName("reflect.Person");  //获得clazz类对象
        Person p=new Person();

        //获取所有除私有方法
        Method[] methods = clazz.getMethods();
        for (Method m:methods)
        {
            System.out.println("除私有方法的所有方法"+m);
        }
        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method ms:declaredMethods){
            System.out.println("所有方法"+ms);
        }

        System.out.println("`````````");
        //获取指定方法
        Method method = clazz.getDeclaredMethod("setName", new Class[]{String.class});  //参数（“方法名“，参数）
        System.out.println(method);

        //执行方法
         method.invoke(p, new Object[]{"wangjing"});  //(对象，)
    }
}
