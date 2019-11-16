package pri.zxx.learndemo.designmodels.builder;

import pri.zxx.learndemo.designmodels.builder.componet.*;

import java.util.logging.Logger;

/**
 * @author 一杯咖啡
 * @desc 内部类实例化对象 随机添加组件 测试类
 * @createTime 2018-12-23-17:30
 */
public class BuilderTest {
    private static final Logger log = Logger.getLogger(BuilderTest.class.getName());

    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setKeyBoard(new KeyBoard("雷蛇机械键盘", 6.2, "雷蛇"))
                .setMoniter(new Moniter("ioc显示器", 2.4, "ioc"))
                .setMouse(new Mouse("雷蛇鼠标", 4.2, "雷蛇"))
                .setRam(new Ram("镁光内存条16g", 5.6, "curls"))
                .Build();
        log.info(computer.toString());
        //默认对象
        Computer computer1 = new Computer();
        log.info("\n   com2 = " + computer1.toString());
    }
}
