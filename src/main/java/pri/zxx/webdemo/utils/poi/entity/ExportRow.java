package pri.zxx.webdemo.utils.poi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExportRow
 * @description todo
 * @Author nemoy
 * @Version 1.0
 */
public class ExportRow {
    private List<ExportCell> list = new ArrayList<>();

    public List<ExportCell> getList() {
        return list;
    }

    public void setList(List<ExportCell> list) {
        this.list = list;
    }

    public void add(ExportCell c) {
        list.add(c);
    }
}
