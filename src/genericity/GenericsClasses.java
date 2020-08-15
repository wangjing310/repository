package genericity;

public class GenericsClasses {
    public static void main(String[] args){
        Box<Integer> box1=new Box<Integer>();  //类型参数只能用引用类型
        Box<String> box2=new Box<String>();
        box1.setT(199);
        box2.setT("hello 小脑斧");
        System.out.println(box1.getT());
        System.out.println(box2.getT());
    }
}
