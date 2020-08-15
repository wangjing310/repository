package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    /**
     * Arrays工具类，对数组进行操作，里面全是静态方法
     * @param args
     */
    public static void main(String[] args){
        String[] names1 = { "Eric", "John", "Alan", "Liz" };
        String[] names2 = { "Eric", "John", "Alan", "Liz" };


        //1.asList方法,使用该方法可以返回一个固定大小的List
        List<String> stringList = Arrays.asList("Welcome", "To", "Java","World!");
        for (String s:stringList) {
             System.out.println(s);
        }

        //2.binarySearch方法支持在整个数组中查找,返回下标
        int index1 = Arrays.binarySearch(new int[]{1, 2, 4, 6, 7}, 6);
        System.out.println(index1);
        //在某个区间里面找
         int index2 = Arrays.binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 6, 6);
         System.out.println(index2);

         //3.copyOf(),copyOfRange()
        String[] copy = Arrays.copyOf(names2, 3);
        for (String s:copy) {
            System.out.println(s);
        }
        System.out.println("-------");
        String[] rangeCopy = Arrays.copyOfRange(names2, 2, names2.length);
        for (String s:rangeCopy) {
            System.out.println(s);
        }

        //4.sort()对数组排序
        String[] names = { "Liz", "John", "Eric", "Alan" };
        //只排序前两个
        Arrays.sort(names, 0, 2);   //[John, Liz, Eric, Alan]
        //全部排序
        Arrays.sort(names);   //[Alan, Eric, John, Liz]

        //5.toString方法可以方便我们打印出数组内容
        System.out.println(Arrays.toString(names));
        // deepToString方法打印二维数组
        int[][] stuGrades = { { 80, 81, 82 }, { 84, 85, 86 }, { 87, 88, 89 } };
        System.out.println(Arrays.deepToString(stuGrades));

        //7. equals（）比较1维数组是否相等，deepEquals（）比较二维数组是否相等，返回true/false
        System.out.println(Arrays.equals(names1, names2));

        //8.fill（）填充数组 将指定的元素放在指定的数组中
        int[] array = new int[8];
        Arrays.fill(array, 1);
        System.out.println(Arrays.toString(array));

    }
}