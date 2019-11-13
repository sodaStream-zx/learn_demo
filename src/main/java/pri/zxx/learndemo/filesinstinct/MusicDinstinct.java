package pri.zxx.learndemo.filesinstinct;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-04-13-13:17
 */
public class MusicDinstinct {
    public ArrayList<File> allFile = new ArrayList<>();

    public static void main(String[] args) {
        MusicDinstinct musicDinstinct = new MusicDinstinct();
        String path = "E:\\";
        musicDinstinct.listFiles(new File(path));
        System.out.println("总数量：：" + musicDinstinct.allFile.size());
        long count = musicDinstinct.allFile.stream().map(file -> file.getName()).distinct().count();
        System.out.println("去重后数量：" + count);


        //获取重复的文件名称
        List<String> collect = musicDinstinct.allFile.stream()
                .map(file -> file.getName())
                // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .collect(Collectors.toMap(file -> file, o -> 1, (integer, integer2) -> integer + integer2))
                //.collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
                // 所有 entry 对应的 Stream
                .entrySet().stream()
                // 过滤出元素出现次数大于 1 的 entry
                .filter(entry -> entry.getValue() > 1)
                // 获得 entry 的键（重复元素）对应的 Stream
                .map(entry -> entry.getKey())
                // 转化为 List
                .collect(Collectors.toList());
        System.out.println("----------size---------" + collect.size());
        List<File> sameMusic = musicDinstinct.allFile.stream().filter(file -> collect.contains(file.getName())).collect(Collectors.toList());
        System.out.println("相同文件数量：" + sameMusic.size());
        HashMap<String, File> oneMap = new HashMap<>(600);
        sameMusic.stream().sorted((o1, o2) -> {
            if (o1.length() <= o2.length()) {
                return 1;
            }
            return 0;
        }).forEach(file -> {
            if (!oneMap.containsKey(file.getName())) {
                oneMap.put(file.getName(), file);
            }
        });
        oneMap.forEach((s, file) -> System.out.println(s + " ----- " + file.getAbsolutePath() + " size: " + file.length()));
        oneMap.forEach((s, file) -> file.delete());
        System.out.println("重复数量：" + oneMap.size());
    }

    public void listFiles(File file) {
        if (file.isDirectory()) {
            Stream.of(file.listFiles()).forEach(f -> listFiles(f));
        } else {
            if (file.isFile()) {
                allFile.add(file);
            }
        }
    }
}
