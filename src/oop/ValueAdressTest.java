package oop;

public class ValueAdressTest {
    int data=50;

    void change(int data){
        data=data+100;
        System.out.println(data);
    }

    public static void main(String[] args){
      ValueAdressTest v=new ValueAdressTest();
      v.change(300);
      System.out.println(v.data);

      ValueAdressTest v1=new ValueAdressTest();
      v1.change1(v1);
      System.out.println(v1.data);

    }

    void change1(ValueAdressTest v1){
        v1.data=v1.data+100;
    }
}
