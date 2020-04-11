package pri.zxx.webdemo.utils.poi.entity;

/**
 * @ClassName ExportCell
 * @description todo
 * @Author nemoy
 * @Version 1.0
 */
public class ExportCell {

    private String value;

    private Integer start;

    private Integer end;

    public ExportCell(String value, Integer start, Integer end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
