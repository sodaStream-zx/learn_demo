package pri.zxx.learndemo.justTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Twilight
 * @desc 使用system.arraycopy复制数组
 * @createTime 2019-11-08-17:06
 */
public class SystemArrayCopyTest {
    /**
     * system.arraycopy 方法
     */
    @Test
    public void systemArrCp() {
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

    @Test
    public void yuesefu() {
        this.resolve(3, 40);
    }

    /**
     * 约瑟夫环
     */
    public void resolve(Integer read, Integer menbers) {
        //报数位置 read
        //人数
        List<String> strings = IntStream.range(1, menbers + 1).mapToObj(String::valueOf).collect(Collectors.toList());
        do {
            ArrayList<String> index = new ArrayList<>();
            System.out.println("str:" + strings.toString());
            for (int i = 1; i <= strings.size(); i++) {
                if (i % read == 0) {
                    index.add(strings.get(i - 1));
                }
            }
            //删除需要删除的数据
            int checkReload = strings.size() % read;
            System.out.println("size: " + strings.size() + " ,   checkReload : " + checkReload);
            System.out.println("--------------------------------------------------");
            strings.removeAll(index);
            index.clear();
            if (checkReload != 0) {
                //如果第一位报数不为1 则重组 头元素
                strings = this.reloadArray(strings, checkReload);
            }
        } while (strings.size() > (read - 1));
        System.out.println("剩下的人位置 ：" + strings);
    }

    //重组数组
    private List<String> reloadArray(List<String> strings, int checkReload) {
        List<String> pre = strings.subList(strings.size() - checkReload, strings.size());
        List<String> next = strings.subList(0, strings.size() - checkReload);
        pre.addAll(next);
        strings = pre;
        return strings;
    }
}
