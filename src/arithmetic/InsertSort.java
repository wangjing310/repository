package arithmetic;

public class InsertSort {
    /**
     * 直接插入排序
     * 把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，
     * 排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表
     * @author JWang
     */

    public static void main(String[] args){
        int arr[]={44,34,22,89,38,40,33,90};
        int i,j,k;
        for (i=1;i<arr.length;i++){
            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j=i-1;j>=0;j--)
                if (arr[j]<arr[i])
        break;

            if (j!=i-1){
            //将比a[i]大的数据向后移
            int temp=arr[i];

            for (k=i-1;k>j;k--){
                arr[k+1]=arr[k];
            }
            arr[k+1]=temp;
            }
        }
        for (int s=0;s<arr.length;s++){
            System.out.println(arr[s]+" ");
        }

    }
}
