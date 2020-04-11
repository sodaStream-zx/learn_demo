//package pri.zxx.webdemo.utils.poi;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import pri.zxx.webdemo.utils.poi.entity.ExportCell;
//import pri.zxx.webdemo.utils.poi.entity.ExportHeader;
//import pri.zxx.webdemo.utils.poi.entity.ExportRow;
//
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author TJ2020-6
// * @desc
// * @createTime 2020-04-09-10:35
// */
//@Service
//public class ActivityExportServiceImpl extends ExportBaseService {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    public void init(String s, String fileName, String sheetName) throws Exception {
//        //first row
//        header = new ExportHeader(2);
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        s = s == null ? "1970-01-01 00:00:00" : s;
//        ExportCell firstLine = new ExportCell(s + "从网络运营中心导出活动扫码数据", 0, 16);
//        ExportRow r1 = new ExportRow();
//        r1.add(firstLine);
//        header.add(r1);
//        //second row
//        ExportRow r2 = new ExportRow();
//        List<String> titles = Arrays.asList("扫码ID", "扫码日期", "活动ID", "活动名称", "潭酒openID",
//                "渠道", "网点名称", "中奖时间", "中奖金额", "是否支付", "扫码类型", "二维码内容", "经度", "维度", "订单ID",
//                "备注", "中奖组MD5");
//        Integer i = 0;
//        for (String str : titles) {
//            ExportCell cc = new ExportCell(str, i, i++);
//            r2.add(cc);
//        }
//        header.add(r2);
//        setFileName(fileName);
//        setSheetName(sheetName);
//        setColumnWidth(10);
//    }
//
//    public void setContent(HttpServletResponse response, WebResult<List<>> result) {
//
//        try {
//            //写入xls
//            HSSFWorkbook workbook = new HSSFWorkbook();
//            HSSFSheet sheet = workbook.createSheet(getSheetName());
//            setHeader(sheet);
//            setListData(sheet, result.getData());
//            for (int i = 0; i < 16; i++) {
//                sheet.autoSizeColumn(i, true);
//            }
//            String fileName = getFileName();
//            response.setHeader("Content-Disposition",
//                    "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
//            response.setContentType("application/octet-stream");
//            response.flushBuffer();
//            workbook.write(response.getOutputStream());
//            workbook.close();
//        } catch (Exception e) {
//            logger.error(e.toString());
//        }
//    }
//
//    private void setListData(HSSFSheet sheet, List<Activity> list) {
//        try {
//            Integer i = 2;
//            String fieldList[] = {
//                    "scanId", "scanTime", "engageId", "engageNames",
//                    "orderOpenid", "channel", "shopName", "prizeTime",
//                    "amount", "sendStatus", "orderType", "qrcode", "lng", "lat", "orderId", "theTip", "groupMd"};
//            for (Activity item : list) {
//                HSSFRow row = sheet.createRow(i++);
//                for (Integer j = 0; j < fieldList.length; j++) {
//                    HSSFCell cell = row.createCell(j);
//                    String fieldValue = null;
//                    //处理时间
//                    String voValue = fieldList[j];
//                    if (voValue.contains("Time")) {
//                        fieldValue = dealWithTime(item, voValue);
//                    }
//                    //处理渠道
//                    if (voValue.equalsIgnoreCase("channel")) {
//                        fieldValue = dealWithChannel(item.getChannel());
//                    }
//                    if (voValue.equalsIgnoreCase("sendStatus")) {
//                        fieldValue = dealWithSendStatus(item.getSendStatus());
//                    }
//                    if (voValue.equalsIgnoreCase("theTip")) {
//                        fieldValue = dealWithTips(item);
//                    }
//                    if (voValue.equalsIgnoreCase("orderType")) {
//                        fieldValue = dealWithType(item.getOrderType(), item.getCode());
//                    }
//                    if (voValue.equalsIgnoreCase("amount")) {
//                        fieldValue = ideaWithAmount(item);
//                    }
//                    //利用反射从实体中获取数据
//                    if (fieldValue == null) {
//                        Class<?> clazz = Class.forName("com.tanjiu.vo.activity.Activity");
//                        Method method = clazz.getMethod("get" + StringUtil.upperCase(fieldList[j]));
//                        if (method != null) {
//                            Object obj = method.invoke(item);
//                            if (obj != null) {
//                                fieldValue = obj.toString();
//                            } else {
//                                fieldValue = " ";
//                            }
//                        }
//                    }
//                    cell.setCellValue(fieldValue);
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            logger.error(e.toString());
//        } catch (InvocationTargetException e) {
//            logger.error(e.toString());
//        } catch (IllegalAccessException e) {
//            logger.error(e.toString());
//        } catch (NoSuchMethodException e) {
//            logger.error(e.toString());
//        } catch (Exception e) {
//            logger.error(e.toString());
//        }
//    }
//
//    //处理金额
//    private String ideaWithAmount(Activity item) {
//        Long engageId = item.getEngageId();
//        if (engageId == null) {
//            return String.valueOf(item.getAmount());
//        } else {
//            if (engageId.equals(12L)) {
//                return String.valueOf(item.getPrice());
//            } else {
//                return String.valueOf(item.getAmount());
//            }
//        }
//    }
//
//    private String dealWithType(String orderType, String code) {
//        if (StringUtils.isEmpty(code) && StringUtils.isEmpty(orderType)) {
//            return "未识别";
//        } else if (StringUtils.isEmpty(orderType)) {
//            switch (code) {
//                case "2":
//                    return "未生产";
//                case "5":
//                    return "待发货";
//                case "9":
//                    return "伪造码";
//                default:
//                    return " ";
//            }
//        } else {
//            if (orderType.equals("2") && code.equals("1")) {
//                return "评鉴产品";
//            } else if (orderType.equals("1") && code.equals("3")) {
//                return "支付完成";
//            } else {
//                return "已发货";
//            }
//        }
//    }
//
//    //处理备注
//    private String dealWithTips(Activity item) {
//        String mealMark = dealWithMealMark(item.getMealMark());
//        BigDecimal price = item.getPrice();
//        if (!StringUtils.isEmpty(mealMark)) {
//            if (price == null) {
//                return mealMark;
//            } else {
//                return mealMark + ";" + price.toString();
//            }
//        } else {
//            return (price == null ? " " : price.toString());
//        }
//
//    }
//
//    private String dealWithMealMark(Integer mMark) {
//        if (mMark == null) {
//            return " ";
//        }
//        //1:标签可餐饮免单；2：未打标签红包,只对渠道类型4餐饮有效',
//        switch (mMark) {
//            case 1:
//                return "标签可餐饮免单";
//            case 2:
//                return "未打标签红包,只对渠道类型";
//            case 4:
//                return "餐饮有效";
//            default:
//                return " ";
//        }
//    }
//
//    //处理支付状态
//    private String dealWithSendStatus(Integer sendStatus) {
//        if (sendStatus == null) {
//            return "-";
//        }
//        switch (sendStatus) {
//            case 0:
//                return "未支付";
//            case 1:
//                return "已支付";
//            default:
//                return " - ";
//        }
//    }
//
//    //1 全渠道经销商，2团购经销商，3烟酒店，4餐饮，5，潭酒会品鉴店，10 电商
//    //处理渠道
//    private String dealWithChannel(Integer flag) {
//        if (flag == null) {
//            return " ";
//        }
//        switch (flag) {
//            case 1:
//                return "全渠道经销商";
//            case 2:
//                return "团购经销商";
//            case 3:
//                return "烟酒店";
//            case 4:
//                return "餐饮";
//            case 5:
//                return "潭酒会品鉴店";
//            case 10:
//                return "电商";
//            default:
//                return " ";
//        }
//    }
//
//    //处理时间
//    private String dealWithTime(Activity item, String voValue) {
//        //从实体内获取多个字段拼接为一个属性值
//        if (voValue.equalsIgnoreCase("scanTime")) {
//            Date scanTime = item.getScanTime();
//            if (scanTime == null) {
//                return "00-00-00 00:00:00";
//            }
//            return DateUtil.basicFormat.format(scanTime);
//        } else {
//            Date prizeTime = item.getPrizeTime();
//            if (prizeTime == null) {
//                return "00-00-00 00:00:00";
//            }
//            return DateUtil.basicFormat.format(prizeTime);
//        }
//    }
//}
