package pri.zxx.learndemo.javabase.listdemo;

import java.util.Arrays;

public class ListTest {
    /**
     * desc: 二分查找
     **/
    public static void binarySearchTest() {
        int[] arr = new int[]{1, 5, 44, 3, 2, 5, 5, 9};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("search 4 : ");
        int index = Arrays.binarySearch(arr, 4);
        System.out.print("index : " + index);
        //System.out.println(" ; arr[4] = "+arr[index+1]);
    }

    public static void main(String[] args) {
        binarySearchTest();
    }
}
