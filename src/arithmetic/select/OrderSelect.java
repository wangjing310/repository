package arithmetic.select;

public class OrderSelect {
    /**
     * 顺序查找
     * @author JWang
     *
     */

    public static <T> T orderSelect(T[] arr,T value){
        T result=null;
        for (int i=0;i<arr.length;i++)
            if (arr[i]==value)
                return arr[i];

            return result;
    }

    public static void main(String[] args){
        Integer[] arr1={12,34,89,9,43,55,7,1};
        Integer i = orderSelect(arr1, 15);
        System.out.println(i);

        String[] arr2={"sd","ed","qq","肚肚疼"};
        String s = orderSelect(arr2, "肚肚疼");
        System.out.println(s);

    }
}
