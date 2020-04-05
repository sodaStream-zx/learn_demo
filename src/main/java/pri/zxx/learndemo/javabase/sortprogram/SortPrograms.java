package pri.zxx.learndemo.javabase.sortprogram;

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
        System.out.print(way + ": ");
        for (int x : array) {
            System.out.print(x + "  ");
        }
        System.out.println("");
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {

        int length = array.length;
        for (int i = 1; i < length - 1; i++) {
            //当前摸一张
            int now = array[i];
            int index = i;
            while (index > 0 && (array[index - 1] > now)) {
                //与前一张比较 如果前一张大
                //把前一张向后移动一位
                array[index] = array[index - 1];
                //判断后二位时候比当前小
                index--;
            }
            //把拿到的变量，放入留下来的空位中
            array[index] = now;
        }
        console(array, "插入排序");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 7, 6, 42, 51, 32, 54, 81, 46, 53, 42, 46, 487, 55, 12, 4, 59, 3, 234, 635};
        console(arr, "未排序");
//        sort(arr);
//        sortStrage(arr);
//        rreverseSort(arr);
        insertSort(arr);
    }
}
