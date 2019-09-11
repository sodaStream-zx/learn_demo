package pri.zxx.nio;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author Twilight
 * @desc nio 学习
 * @createTime 2019-06-29-21:16
 */
public class NioTest {
    private static final Logger log = LoggerFactory.getLogger(NioTest.class);

    @Test
    public void myTest3() {
        //直接缓冲区 在jvm中缓存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        //非直接缓冲区 在操作系统物理内存中
        ByteBuffer btb = ByteBuffer.allocate(1024);
    }

    @Test
    public void myTest2() {
        //mark 标记位置
        //reset 重置位置
        //remaining 获取缓冲区可以操作的数量
    }

    @Test
    public void myTest() {
        //分配一个指定大小的缓冲区 1024
        ByteBuffer btb = ByteBuffer.allocate(1024);
        int capacity = btb.capacity(); //容量
        int limit = btb.limit();// 可操作性数据大小
        int position = btb.position(); //正在操作的位置
        //position <= limit <=capacity
        System.out.println("ca:" + capacity);
        System.out.println("limit:" + limit);
        System.out.println("position:" + position);
        String str = "asdasfasfasfasf";
        btb.put(str.getBytes());//放入数据
        System.out.println("---------put-----------");
        printInfo(btb);
        System.out.println("---------flip-----------");
        btb.flip();//切换模式 更改指向位置
        printInfo(btb);
        System.out.println("---------read-----------");
        byte[] det = new byte[btb.limit()];
        btb.get(det);//获取数据
        System.out.println("String:" + (new String(det)));
        printInfo(btb);
        System.out.println("---------rewind-----------");
        btb.rewind(); //可重复读数据
        printInfo(btb);
        System.out.println("---------clear-----------");
        btb.clear();//清空缓冲区（数据处于被遗忘状态） 数据并没有被清空
        printInfo(btb);
    }

    private void printInfo(ByteBuffer btb) {
        System.out.println("ca:" + btb.capacity());
        System.out.println("limit:" + btb.limit());
        System.out.println("position:" + btb.position());
    }

    @Test
    public void myTest4() {
        //不存在，添加新的 计算今天与下一个月今天的天数 （要么第一次测试，要么过期了）
        //获取开通时间的天数
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String time = dataMapper.getStartVipTime(userId);
        String time = "2019-06-20 16:30";
        String now = "2019-07-20 07:30";
        LocalDateTime startTime = LocalDateTime.parse(time, dateTimeFormatter);
        LocalDateTime nowMonth = LocalDateTime.parse(now, dateTimeFormatter);
        //比如 13号 设置超时间为 当前时间到下个月13号
        int dayOfMonth = startTime.getDayOfMonth();
//        LocalDateTime nowMonth = LocalDateTime.now();
        LocalDateTime to;
        if (nowMonth.getDayOfMonth() <= dayOfMonth) {
            //不是今天
            to = LocalDateTime.of(nowMonth.getYear(), nowMonth.getMonth(), dayOfMonth, 23, 59, 59);
        } else {
            //当前月份的 下一个月  和 开通vip的时间
            to = LocalDateTime.of(nowMonth.getYear(), nowMonth.getMonth().plus(1L), dayOfMonth, 23, 59, 59);
        }
        Duration between = Duration.between(nowMonth, to);
        long fireTme = between.toMillis();
        try {
            log.warn(1L + " :" + fireTme + " :" + TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error("添加测试次数异常 {}", e);
        }
    }
}
