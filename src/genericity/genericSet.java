package genericity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class genericSet {
    public static void main(String[] args){
        Set<String> set=new HashSet<>();
        set.add("hahaha");
        set.add("yeyeye");
        Iterator ite=set.iterator();
        while (ite.hasNext());
        System.out.println(ite.next());
    }

}
