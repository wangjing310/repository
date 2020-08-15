package controlstatement;

public class TestFor {
    //普通循环
    public void testFor(){
        for(int i=1;i<10;i++){
            System.out.println(i);

        }
    }
   //foreach 用来循环遍历数组或者集合
    public void testForEach(){
        int arr[]={1,2,3,4,5};
        for (int i:arr) {
            System.out.println(i);
        }
    }

    public void whiletest(){
        while (true){
            System.out.println("你是个煞笔");
        }
    }

    public void dowhile(){
        int i=1;
        do {
            i++;
            System.out.println(i);
        }
        while(i<5);
    }

}
