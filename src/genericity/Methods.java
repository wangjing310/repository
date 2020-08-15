package genericity;

public class Methods {

    //  定义public <T> T showKeyName(Generic<E> container){}

    public static <E> void printArry(E[] inputArry){
        for (E elment:inputArry)
        {
            System.out.println(elment);
        }

    }
    public static void main(String[] args){
        Integer intArry[]={1,2,3,4,5,6};
        Double doubleArry[]={1.0,2.0,3.0,4.0,5.0};
        String stringArry[]={"小脑斧","小野猫","小哥哥","小姐姐"};

        printArry(intArry);
        printArry(doubleArry);
        printArry(stringArry);

    }

}
