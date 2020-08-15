package oop;

public class ArrayTest {
    /**
     * 一维数组
     */
    //声明
    int[] arr1;
    int []arr2;
    int arr[];
    //声明，实例
    int arr3[]=new int[5];
    //声明，实例，初始

    Class[] a=new Class[]{};

     static void minTest(int arr[]){
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i])
                min=arr[i];
        }
        System.out.println(min);
    }

    public static void main(String[] args) {   //静态方法不能--直接--调用非静态数据成员和非静态方法
        ArrayTest arrayTest=new ArrayTest();
        int arr4[]={2,5,7,9};
        minTest(arr4);
        twoTest();
        arrayTest.testClass();
        arrayTest.arrayCopy();
        arrayTest.arryMatrix();
    }

    /**
     * 二维数组
     */
    //声明
    int[][] arr5;
    int [][]arr6;
    int arr7[][];
    //实例
    int[][] arr8=new int[5][5];

    public static void twoTest(){
        int[][] arr9={{1,2,3},{4,5,6}};
        for (int i=0;i<2;i++){
            for (int j=0;j<3;j++){
                System.out.print(arr9[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * java数组的类名
     */
    //数组是一个对象
    public void testClass(){
        int a[]={1,2,3};
        Class c = a.getClass();
        String name=c.getName();  //获取数组对象名
        System.out.println("获取数组对象名"+name);
    }

    public void arrayCopy(){
        char arrfrom[]={'c','v','d','g','n','w','r','h'};
        char arrto[]=new char[5];
        System.arraycopy(arrfrom,1,arrto,0,5);
        System.out.println(new String(arrto));
    }

    public void arryMatrix(){
        int arr1[][]={{1,2,3},{1,2,3}};
        int arr2[][]={{4,5,6},{4,5,6}};
        int arr3[][]=new int[2][3];
        for (int i=0;i<2;i++)
        {
            for (int j=0;j<3;j++){
                arr3[i][j]=arr1[i][j]+arr2[i][j];
                System.out.print(arr3[i][j]);
            }
            System.out.println();

        }
    }

}
