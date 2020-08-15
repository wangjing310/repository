package genericity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class genericMap
{
    public static void main(String[] args){
        //集合使用泛型与不使用泛型
        Map map=new HashMap();  //1.不使用泛型list取出的值为object类型，需要强转
                                //2.使用泛型 list取出的就是指定的类型
        map.put(1,"w");
        map.put(2,"j");
        Set set=map.entrySet();
        Iterator ite=set.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
    }
}
