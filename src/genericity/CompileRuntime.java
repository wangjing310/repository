package genericity;

import java.util.ArrayList;
import java.util.List;

public class CompileRuntime {
    //泛型只在编译时有效
    public static void main(String[] args){
        List<String> stringList=new ArrayList<String>();
        List<Integer> integerList=new ArrayList<Integer>();

        Class stringListClass=stringList.getClass();
        Class integerListClass=integerList.getClass();

        System.out.println(stringListClass);
        System.out.println(integerListClass);

        if (stringListClass.equals(integerListClass)){
            System.out.println("泛型测试，类型相同");
        }
    }
}
