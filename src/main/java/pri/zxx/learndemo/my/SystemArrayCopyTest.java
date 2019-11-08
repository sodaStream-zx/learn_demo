package pri.zxx.learndemo.my;

/**
 * @author Twilight
 * @desc 使用system.arraycopy复制数组
 * @createTime 2019-11-08-17:06
 */
public class SystemArrayCopyTest {
    public static void main(String[] args) {
        //定义需要删除的位置
        int index = 4;
        //定义数组
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int size = intArr.length - 1;
        int copyLen = size - index;
        if (copyLen > 0) {
            System.arraycopy(intArr, index + 1, intArr, index, copyLen);
            // 最后一位设置为null 需要再进行缩容  arrayList 中的trimToSize()
            intArr[size] = null;
        } else {
            System.out.println("index 超出数组大小");
        }
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
    }
}
