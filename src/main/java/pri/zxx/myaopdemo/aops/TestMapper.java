package pri.zxx.myaopdemo.aops;

public class TestMapper {
    public static void main(String[] args) {
        UserMapper userMapper = SqlSession.getMapper(UserMapper.class);
        int addResult = userMapper.addUser("aaaa", 12);
        User user = userMapper.query("aaaa");
        System.out.println(user.toString());
        //System.out.println(list);
    }
}