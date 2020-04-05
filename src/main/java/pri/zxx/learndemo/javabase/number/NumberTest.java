package pri.zxx.learndemo.javabase.number;

public class NumberTest {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        int maxValue2 = Integer.MAX_VALUE;
        int c = maxValue + maxValue2;
        System.out.println("c= " + c);
        System.out.println("MaxInt = " + (maxValue + 1));
        System.out.println("MaxInt = " + (maxValue + 2));
        System.out.println("MaxInt = " + (maxValue + 3));
        System.out.println("MaxInt = " + (maxValue + Integer.MAX_VALUE));
        System.out.println(Boolean.parseBoolean(String.valueOf(1)));
        NumberTest numberTest = new NumberTest();
        System.out.print(numberTest.toString());
    }
}


