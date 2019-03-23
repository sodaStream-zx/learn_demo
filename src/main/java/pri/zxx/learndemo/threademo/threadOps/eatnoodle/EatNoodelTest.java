package pri.zxx.learndemo.threademo.threadOps.eatnoodle;

/**
 * @author 一杯咖啡
 * @desc 吃面测试
 * @createTime 2018-11-21-23:31
 */
public class EatNoodelTest {
    public static void main(String[] args) {
        IEatTool knife = new EatTool("刀");
        IEatTool fork = new EatTool("叉");
        new TableEatNoodle("张三", knife, fork).start();
        new TableEatNoodle("李四", knife, fork).start();
        // new TableEatNoodle("王五", fork, knife).start();
        // new TableEatNoodle("王五", knife, fork).start();
        //new TableEatNoodle("李四", fork, knife).start();
    }
}
