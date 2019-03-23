package pri.zxx.learndemo.threademo.javabase.sortprogram;

/**
 * desc:数组翻转操作
 **/
public class ArrayOperation {

    /**
     * desc: 打印一维数组
     **/
    public static void consoleList(int[] array) {
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println(" ");
        System.out.println("-----------------------");
    }

    /**
     * desc: 打印二维数组
     **/
    public static void console(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    /**
     * desc: 翻转一维数组
     **/
    public static void reversList(int[] array) {
        System.out.println("原一维数组 : ");
        consoleList(array);
        System.out.println("翻转一维数组 : ");
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        consoleList(array);
    }

    /**
     * desc: 翻转二维数组
     **/
    public static void revers(int[][] array) {
        System.out.println("原二维数组 : ");
        console(array);
        System.out.println("翻转二维数组 : ");
        for (int i = 0; i < array.length; i++) {
            //j=i,保持行列元素对调只一次。如果设置为0开始，则重复调换位置
            for (int j = i; j < array[i].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;

            }
        }
        console(array);
    }

    /**
     * desc: 二维数组左右对调
     **/
    public static void reservesMatrix(int[][] array) {
        System.out.println("原二维数组 : ");
        console(array);
        System.out.println("左右对调后二维数组 : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length / 2; j++) {
                int temp = array[i][j];
                array[i][j] = array[i][array[i].length - j - 1];
                array[i][array[i].length - j - 1] = temp;
            }
        }
        console(array);
    }

    public static void main(String[] args) {
        int[] arrList = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        reversList(arrList);
        int[][] arr = new int[][]{{1, 2, 3, 6}, {4, 5, 6, 4}, {7, 8, 9, 5}, {10, 11, 12}};
        revers(arr);
        reservesMatrix(arr);
    }
}
