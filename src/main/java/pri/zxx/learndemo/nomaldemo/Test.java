package pri.zxx.learndemo.nomaldemo;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-01-12-23:08
 */
public class Test {
    public static void main(String[] args) {
        float s = (float) 10.1;
        System.out.println((float) 10.1 == 10.1f);
        long f = 10L;
        double f2 = 10.0;
        System.out.println(10L == f2);
        System.out.println(10 == 10L);
        System.out.println(10 == 10F);
        System.out.println(10.1 == 10.1f);
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(10.1f)));

        System.out.println(Long.toBinaryString(Double.doubleToLongBits(10.1)));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(10.1f)));

        System.out.println(Long.toBinaryString(Double.doubleToLongBits(-10.01)));
        System.out.println(Long.toBinaryString(10));
        System.out.println(Long.toBinaryString(10L));
    }
}
