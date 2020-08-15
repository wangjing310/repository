package reflect;

public class GetClassObject {
    /*类对象，就是用于描述这种类，都有什么属性，什么方法的
    获取类对象的三种方法*
    /1.Object-->getClass()
     2.任何数据类型（包括基本数据类型）都有一个“静态”的class属性
     3.通过class类的静态方法：forName（String className）
     */
    public static void main(String[] args){
        //1.通过类的实例获取
        Person per1=new Person();  //创建student对象，创建class对象
        Class perClass = per1.getClass();
        System.out.println("类名称"+perClass.getName());

        //2.直接通过类获取
        Class perClass1 = Person.class;
        System.out.println(perClass==perClass1);

        try{
            //3.通过完整类名获取
            Class perClass3 = Class.forName("reflect.Person");
            System.out.println(perClass3==perClass1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
