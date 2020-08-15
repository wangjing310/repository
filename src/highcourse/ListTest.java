package highcourse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args){

        List<String> list=new ArrayList<String>();
        list.add("hello");
        list.add("word");
        list.add("oo");
        //1.foreach遍历集合
        for (String str:list)
        {
            System.out.println(str);
        }
        //2.把集合变为数组
        String arr[]=new String[list.size()];

        list.toArray(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        //迭代器遍历
        Iterator<String> ite=list.iterator();
        while (ite.hasNext()){  //判断下一个元素之后有值
            System.out.println(ite.next());
        }
    }

}
