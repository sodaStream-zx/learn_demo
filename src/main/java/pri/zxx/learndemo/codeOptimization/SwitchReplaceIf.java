package pri.zxx.learndemo.codeOptimization;

/**
 * @author zxx
 * @desc
 * @createTime 2019-11-05-下午 2:43
 */
public class SwitchReplaceIf {
    public static void main(String[] args) {
        SwitchReplaceIf switchReplaceIf = new SwitchReplaceIf();
        switchReplaceIf.myTest("a");
    }

    public void myTest(String condition) {
        switch (condition) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            case "c":
                System.out.println("c");
                break;
            case "d":
                System.out.println("d");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
