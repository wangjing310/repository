package basejava;

public class Operator {

    public void test1(){
        //前++ 先加1再运算，后++先运算再加1
        int a=10;
        System.out.println(a++); //10 (11)
        System.out.println(++a);//12
        System.out.println(--a);//11
        System.out.println(a--);//11 (10)
    }

    public void test2(){
        int a=10;
        int b=10;
        System.out.println(a++ + b++); //10+10=20  (a=11) (b=11)
        System.out.println(++a + ++b); //12+12=24
    }

    public void test3(){
        //~按位取反 ，！非
        int a=10;
        int b=-10;
        boolean c=false;
        boolean d=true;
        System.out.println(~a);
        System.out.println(~b);
        System.out.println(!c);
        System.out.println(!d);
    }
    public void test4(){
        //左移 乘，右移 除
        System.out.println(10<<2); //10*4=40
        System.out.println(10>>2); //10/4=2
    }

    public void test5(){
        //逻辑与 ，逻辑或
        int a=10;
        int b=20;
        int c=30;

        System.out.println(a>b && c>a);  //flase
        System.out.println(b>a || b>c);  //true
    }

    public void test6(){
        //  A instanceof B 判断 对象A是否为类B的实例
        Operator operator=new Operator();
        if (operator instanceof Operator){
            System.out.println(true);
        }
        else System.out.println(false);
    }

    public static void main(String[] args) {
        Operator o=new Operator();
        o.test3();
    }




}
