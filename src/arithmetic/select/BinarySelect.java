package arithmetic.select;

public class BinarySelect {
    /**
     * 二分查找
     * 前提：有序
     * 将查找值与中间值对比，
     * @author JWang
     *
     */

    public static int binarySelect(int[] arr,int value){
        int heigh=arr.length-1;
        int low=0;
        int mid;;
        while(low<=heigh){
            mid=(low+heigh)/2;
            if (value==arr[mid])
                return mid;
            else{
                if (value>arr[mid])
                    low=mid+1;
                else
                    heigh=mid-1;
            }
        }
        return -1;

    }

    public static void main(String[] args){
        int[] arr={12,56,67,87,99,102};
        int i = binarySelect(arr, 5);
        System.out.println(i);
    }
}
