package pri.zxx.learndemo.my;

import org.junit.Test;

/**
 * @author zxx
 * @desc 递加
 * @createTime 2019-10-30-下午 2:02
 */
public class DemoTest {
    /**
     * 这就是为啥算法很重要
     */
    public void addToMany(Long max) {
        Long sum = 0L;
        sum = (max + 1) * (max / 2);
        System.out.println(sum);
    }

    /**
     * 这个为啥会慢
     */
    public void addOneByOne(Long max) {
        Long sum = 0L;
        for (int i = 0; i <= max; i++) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }

    @Test
    public void myTest() {
        Long max = 1000000000L;
        Long st = System.currentTimeMillis();
//        this.addToMany(max);
        addOneByOne(max);
        System.out.println("cost:" + (System.currentTimeMillis() - st));
//        System.out.println(Long.MAX_VALUE);
    }
}
