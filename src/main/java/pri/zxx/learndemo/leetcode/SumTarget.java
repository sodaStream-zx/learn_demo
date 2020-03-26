package pri.zxx.learndemo.leetcode;

/**
 * @author Twilight
 * @desc 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2020-03-26-21:02
 */
public class SumTarget {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
