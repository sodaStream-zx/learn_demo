package pri.zxx.learndemo.justTest;

/**
 * @author Twilight
 * @desc 枚举测试
 * @createTime 2019-10-25-下午 2:30
 */
public enum EnumTest {
    THEFAIL("失败", 1, 500),
    THESUCCECSS("成功", 2, 200),
    THEEXCEPTION("异常", 3, 300);
    private String msg;
    private Integer code;
    private Integer status;

    EnumTest(String msg, Integer code, Integer status) {
        this.msg = msg;
        this.code = code;
        this.status = status;
    }

    public static void main(String[] args) {
        Integer code = EnumTest.THEEXCEPTION.getCode();
        System.out.println(code);
        System.out.println(EnumTest.THESUCCECSS.toString());
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "EnumTest{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", status=" + status +
                '}';
    }
}
