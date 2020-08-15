package arithmetic;

public class Bubble {

    /**冒泡排序---从小到大
     * 第一个数和第二个数比较，若大与第二个数则交换，第二个再与第三个数比较，每一趟比较把最大值沉到最后
     * @author JWang
     */
    public static void main(String[] args){
        int[] arr={23,12,45,11,66,22,88,43};
        int temp;
        for (int i=0;i<arr.length-1;i++){   //length-1因为最后一次已经排好序了
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
