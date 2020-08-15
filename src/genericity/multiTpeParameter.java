package genericity;

public class multiTpeParameter {
    //多个参数
    public static void main(String[] args){
        Box1<String,Integer> box1=new Box1<String,Integer>();
        box1.add("hello world",199);
        System.out.println(box1.getT());
        System.out.println(box1.getV());

        Box1<Integer,String> box2=new Box1<>();

        box2.add(199,"hello world");
        System.out.println(box2.getV());
        System.out.println(box2.getT());
    }

}
