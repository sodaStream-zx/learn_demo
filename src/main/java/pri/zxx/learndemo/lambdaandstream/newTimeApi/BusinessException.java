package pri.zxx.learndemo.lambdaandstream.newTimeApi;

/**
 * <p>业务异常</p>
 *
 * @author <a href="mailto:xxbjiy@163.com">huangxl</a>
 * @since 2020/1/8 8:34
 */
public class BusinessException extends RuntimeException {
    private ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;

    }

    public BusinessException(String msg) {
        super(msg);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
