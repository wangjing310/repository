package oop;

public class CloneTest implements Cloneable{
    //对象克隆
    int rollno;
    String name;

    public CloneTest(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    //父类克隆语句
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args){
        try{
            CloneTest c1=new CloneTest(1,"小脑斧");
            CloneTest c2=(CloneTest) c1.clone();  //克隆方法，需要处理异常
            System.out.println(c1.rollno+c1.name);
            System.out.println(c2.rollno+c2.name);
        }catch (CloneNotSupportedException c){
        }

    }

}
