package pri.zxx.learndemo.leetcode;

/**
 * @author Twilight
 * @desc 判断一个字符串中字符是否唯一
 * @createTime 2020-03-26-21:02
 */
public class UniqueStr {
    public static boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean leetecode = isUnique("qazwsxedcrfvatgbyhnujmikolp");
        System.out.println(leetecode);
    }
}
