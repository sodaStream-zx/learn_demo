package pri.zxx.learndemo.exceptionhandle;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-21-00:42
 */
public class MyException extends Exception {
    private int exId;
    private String code;
    private String msg;
    private String throwLocations;
    private String requestUrl;

    public MyException(String message) {
        super(message);
    }

    public MyException() {
    }

    public int getExId() {
        return exId;
    }

    public void setExId(int exId) {
        this.exId = exId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getThrowLocations() {
        return throwLocations;
    }

    public void setThrowLocations(String throwLocations) {
        this.throwLocations = throwLocations;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "exId=" + exId +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", throwLocaltion='" + throwLocations + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                '}';
    }
}
