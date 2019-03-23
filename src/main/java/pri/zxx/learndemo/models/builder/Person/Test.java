package pri.zxx.learndemo.models.builder.Person;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2019-01-02-0:22
 */
public class Test {
    public static void main(String[] args) {
        Human human = new Human().Builder("required", "requirednum").build();

        Human ss = new Human().Builder("zxx", "deafultnum").address("zxx").build();
        System.out.println("human+ " + human.toString());
        System.out.println("bu = " + ss);
    }
}
