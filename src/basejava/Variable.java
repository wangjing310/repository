package basejava;

/**
 * 三种类型变量
 */
public class Variable {
    int instance=10;  //实例变量
    static int sta=20;   //静态变量
    public void test(){
        int part=30; //局部变量
    }

    //数据类型
    public void testType(){
        int a=10;
        float f=a;
        System.out.println(a);  //10
        System.out.println(f);  //10.0
    }

    public void testType1(){
        float f=10.6f;
        int i=(int)f; //强制转换：大的数据类型往小的数据类型转换,直接把小数点后面舍掉
        System.out.println(f);   //10.5
        System.out.println(i);   //10
    }

    public void testType2(){
        byte a=10;
        byte b=10;
        byte c=(byte)(a+b);
        System.out.println(c);

    }

    public void testType3(){
        int a=130;
        byte b=(byte)a;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        Variable v=new Variable();
        v.testType3();
    }
}
