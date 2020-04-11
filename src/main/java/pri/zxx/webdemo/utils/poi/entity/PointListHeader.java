package pri.zxx.webdemo.utils.poi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PointListHeader
 * @description todo
 * @Author nemoy
 * @Version 1.0
 */
public class PointListHeader {
    private List<ExportRow> list;

    public PointListHeader(Integer c) {
        if (c > 0) {
            this.list = new ArrayList<>(c);
        } else {
            System.out.println("export xls header count not valid");
        }
    }

    public List<ExportRow> getList() {
        return list;
    }

    public void setList(List<ExportRow> list) {
        this.list = list;
    }

    public void add(ExportRow r) {
        list.add(r);
    }
}