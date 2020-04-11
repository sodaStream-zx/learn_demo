package pri.zxx.webdemo.utils.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pri.zxx.webdemo.utils.poi.entity.ExportCell;
import pri.zxx.webdemo.utils.poi.entity.ExportHeader;
import pri.zxx.webdemo.utils.poi.entity.ExportRow;

/**
 * @ClassName ExportBaseService
 * @description todo
 * @Author nemoy
 * @Version 1.0
 */
public class ExportBaseService {
    public static Logger logger = LoggerFactory.getLogger(ExportBaseService.class);
    protected ExportHeader header;
    private String fileName;
    private String sheetName;
    private Integer columnWidth = 20;

    public void setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    protected void setHeader(HSSFSheet sheet) {
        Integer i = 0;
        for (ExportRow r : header.getList()) {
            Integer j = 0;
            HSSFRow row = sheet.createRow(i);
            for (ExportCell c : r.getList()) {
                sheet.setColumnWidth(j, columnWidth * 256);
                HSSFCell cell = row.createCell(c.getStart());
                cell.setCellValue(c.getValue());
                if (c.getEnd() - c.getStart() > 0) {
                    CellRangeAddress region = new CellRangeAddress(i, i, c.getStart(), c.getEnd());
                    sheet.addMergedRegion(region);
                }
            }
            i++;
        }
    }
}
