package oop;

public class ObjectClass {

    /**
     * 初始化对象三种方法
     */
    //1.通过引用变量
        public int id;
        public String name;

    //2.通过方法初始化对象
    public void initialize(int in,String str){
        id=in;
        name=str;
    }
    public void show(){
        System.out.println(id+"   "+name);
    }

   //银行存款取款实例

    int no;
    String u_name;
    float amount;

    public void insert(int n,String name,float a){
        no=n;
        u_name=name;
        amount=a;

    }

    public void deposit(int ad){
        amount=amount+ad;
        System.out.println("存入"+ad);
    }

    public void withDraw(int draw){
        if (draw>amount)
            System.out.println("余额不足");
        else{
            amount=amount-draw;
            System.out.println("取款"+draw);}

    }

    public void display(){
        System.out.println("姓名:"+name+"卡号:"+no+"余额:"+amount);
    }

    //3.构造函数作用：初始化对象，在创建对象时被调用

    int x;
    ObjectClass(int x){
        this.x=x;   //指向当前类的实例变量
        System.out.println(x);

    }
    public static void main(String args[]){
        ObjectClass objectClass=new ObjectClass(5);
    }

}
