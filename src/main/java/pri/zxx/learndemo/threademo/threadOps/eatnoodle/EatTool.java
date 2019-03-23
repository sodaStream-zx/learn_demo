package pri.zxx.learndemo.threademo.threadOps.eatnoodle;

/**
 * @author 一杯咖啡
 * @desc 工具实现
 * @createTime 2018-11-21-23:22
 */
public class EatTool implements IEatTool {
    private String toolName;

    public EatTool(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String getTool() {
        return toolName;
    }

    @Override
    public String toString() {
        return "EatTool{" +
                "toolName='" + toolName + '\'' +
                '}';
    }
}
