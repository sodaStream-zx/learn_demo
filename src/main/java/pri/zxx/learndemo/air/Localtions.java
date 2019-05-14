package pri.zxx.learndemo.air;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc 封装数据
 * @createTime 2019-05-14-19:51
 */
public class Localtions {
    //记录文件
    private LinkedHashMap<Integer, String> signalData = new LinkedHashMap<>();
    //记录坐标
    private LinkedHashMap<Integer, String> local = new LinkedHashMap<>();

    public static void main(String[] args) {
        Localtions localtions = new Localtions();
//        String[] locs = new String[]{
//                "Plane1 1 1 1",
//                "Plane1 1 1 1 1 2 3",
//                "Plane1 2 3 4 1 1 1",
//                "Plane1 3 4 5",
//                "Plane1 1 1 1 1 2 3",
//                "Plane1 2 4 5 1 2 3",
//                "Plane1 2 2 3 1 2 3",
//                "Plane1 1 4 5 1 2 3"
//        };
        String[] locs = new String[]{
                "Plane1 0 -1 -2",
                "Plane1 0 -1 -2 1 2 3",
                "Plane1 1 1 1 1 1 1",
                "Plane1 2 2 2",
                "Plane1 1 1 1 1 2 3",
                "Plane1 2 4 5 1 2 3",
                "Plane1 2 2 3 1 2 3",
                "Plane1 1 4 5 1 2 3"
        };
        //记录位置
        for (int i = 0; i < locs.length; i++) {
            localtions.addData(i, locs[i]);
        }
        LinkedHashMap<Integer, String> data = localtions.getSignalData();
        LinkedHashMap<Integer, String> local = localtions.getLocal();
        System.out.println("-------------------");
        System.out.println("record:" + data);
        System.out.println("local:" + local);
        System.out.println("-------------------");


        String id0 = localtions.getDataById(0);
        String id1 = localtions.getDataById(1);
        String id2 = localtions.getDataById(2);
        String id3 = localtions.getDataById(3);
        String id4 = localtions.getDataById(4);
        String id100 = localtions.getDataById(100);
        System.out.println(id0);
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);
        System.out.println(id4);
        System.out.println(id100);

    }

    public LinkedHashMap<Integer, String> getSignalData() {
        return signalData;
    }

    public LinkedHashMap<Integer, String> getLocal() {
        return local;
    }

    //输入接口
    public synchronized void addData(Integer id, String msg) {
        String[] split = msg.split("\\s+");
        Assert.assertTrue("输入参数有误", (split.length == 4 || split.length == 7));
        signalData.putIfAbsent(id, msg);
        Integer len = split.length;
        if (id == 0 && len == 4) {
            //第一条消息，直接放进去
            local.putIfAbsent(id, msg.replaceAll("\\s+", ","));
        } else {
            String next = checkAndReturn(id, msg);
            local.putIfAbsent(id, next);
        }
    }

    //对比接口
    private String checkAndReturn(Integer id, String msg) {
        String[] split = msg.split("\\s+");
        String pre = this.getTocheck(id - 1);
        if (split.length == 7) {
            Integer x = Integer.valueOf(split[1]) + Integer.valueOf(split[4]);
            Integer y = Integer.valueOf(split[2]) + Integer.valueOf(split[5]);
            Integer z = Integer.valueOf(split[3]) + Integer.valueOf(split[6]);
            if (pre.equals("NA,NA,NA")) {
                return "NA,NA,NA";
            }
            String[] preLocal = pre.split(",");
            if (Integer.valueOf(preLocal[1]) != Integer.valueOf(split[1]) ||
                    Integer.valueOf(preLocal[2]) != Integer.valueOf(split[2]) ||
                    Integer.valueOf(preLocal[3]) != Integer.valueOf(split[3])) {
                return "NA,NA,NA";
            }
            String next = split[0] + "," + x + "," + y + "," + z;
            return next;
        } else {
            String comp = Stream.of(split).collect(Collectors.joining(","));
            if (pre.equals(comp)) {
                return pre;
            } else {
                return "NA,NA,NA";
            }
        }
    }

    //获取与对比
    public String getTocheck(Integer id) {
        return local.get(id);
    }

    //输出接口
    public String getDataById(Integer id) {
        String result = local.get(id);
        if (StringUtils.isEmpty(result)) {
            return "Cannot find " + id;
        } else if (result.equals("NA,NA,NA")) {
            return "Error：" + id;
        } else {
            String[] split = result.split(",");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(split[0])
                    .append(" ")
                    .append(id)
                    .append(" ")
                    .append(split[1])
                    .append(" ")
                    .append(split[2])
                    .append(" ")
                    .append(split[3]);
            return stringBuffer.toString();
        }
    }
}
