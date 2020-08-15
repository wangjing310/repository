package arithmetic;

public class SelectSort {

    /**选择排序，从小到大
     * 找出数组中最小的值若与a[i]不等，交换数值，
     * @author JWang
     *
     */
   public static void main(String[] args){
       int[] arr={55,22,67,87,90,12};
       for (int i=0;i<arr.length;i++){
           int position=i;
           for (int j=i+1;j<arr.length;j++){
               if (arr[position]>arr[j])
                   position=j;
           }
           int temp=arr[i];
           arr[i]=arr[position];
           arr[position]=temp;
       }
       for (int i=0;i<arr.length;i++){
       System.out.println(arr[i]);
       }
   }
}
