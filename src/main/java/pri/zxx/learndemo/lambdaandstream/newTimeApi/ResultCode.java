package pri.zxx.learndemo.lambdaandstream.newTimeApi;

/**
 * 业务状态码统一定义,
 * 不推荐使用404，500等http状态码
 */
public enum ResultCode {
    OK(0, "成功"),

    SYSTEM_ERROR(500, "系统错误,请稍后重试!"),

    USER_NOT_LOGIN(2, "用户未登录,请登录后重试!"),
    USER_LOGIN_FAILED(3, "登录失败,请重新登录!"),
    MISSING_PARAM(4, "参数缺失,请检查后重试!"),
    ILLEGAL_PARAM(5, "参数非法,请检查后重试!"),
    DATA_EMPTY(6, "没有相应数据!"),

    EXTERNAL_INTERFACE_ERROR(7, "调用外部接口失败，请稍后重试!"),

    LACK_OF_BOND(10, "存在某合同保证金余额不足!"),

    CLOUD_ORDER_ALREADY_PAID(21, "订单已经支付成功，请勿重新支付!"),
    ;

    /**
     * 业务状态代码
     */
    int code;

    /**
     * 业务消息
     */
    String msg;


    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
