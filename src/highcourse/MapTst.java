package highcourse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTst {
    public static void main(String[] args){
        Map<String,String> map=new HashMap<String,String>();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");

        /**
         * 遍历map的两种方式：
         */
        //1.通过keySet获得map里面的所有key
        for (String key:map.keySet()){
            System.out.println(key+"="+map.get(key));
        }
        //2.map没有迭代器，通过map.entrySet（）使用Iterator遍历
        Set set=map.entrySet();
        Iterator ite=set.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }

    }
}
