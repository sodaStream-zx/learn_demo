package pri.zxx.learndemo.threademo.javabase.sortprogram;

/**
 * desc: 排序算法
 **/
public class SortPrograms {
    /**
     * desc: 冒泡排序
     **/
    public static void sort(int[] array) {
        //控制层数
        for (int i = 0; i < array.length; i++) {
            //控制相邻元素比较
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        console(array, "冒泡排序");
    }

    /**
     * desc: 直接排序
     **/
    public static void sortStrage(int[] array) {
        //控制循环次数
        for (int i = 0; i < array.length; i++) {
            int index = 0;
            //提取最大值得数组下标
            for (int j = 1; j <= array.length - (i + 1); j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            //将下标对应的最大值，与数组的倒数第二个元素替换
            int temp = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = array[index];
            array[index] = temp;
        }
        console(array, "直接排序法");
    }

    /**
     * desc: 翻转排序
     **/
    public static void rreverseSort(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        console(array, "翻转排序");
    }

    //打印排序后的队列
    public static void console(int[] array, String way) {
        System.out.println("排序方法：" + way);
        for (int x : array) {
            System.out.print(x + ",");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 7, 6, 4, 5, 3, 5, 8, 4, 5, 4, 4, 4, 55, 1, 2, 3, 12, 4, 5, 3, 234, 635};
        console(arr, "未排序");
        System.out.println();
        sort(arr);
        System.out.println();
        sortStrage(arr);
        System.out.println();
        rreverseSort(arr);
    }
}
