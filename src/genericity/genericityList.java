package genericity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class genericityList {
    public static void main(String[] args){

        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        List<Integer> list1=new ArrayList<Integer>();
        list1.add(13);
        list1.add(14);
        list1.add(15);
        for (Integer i:list1){
            System.out.println(i);
        }
        List<String> list2=new LinkedList<>();
        list2.add("hello");
        list2.add("world");

        Iterator<String> ite=list2.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }

    }

}
