package pri.zxx.learndemo.models.builder.Person;

/**
 * @author 一杯咖啡
 * @desc
 * @createTime 2018-12-31-21:11
 */
public class Human {
    private String name;
    private String sex;
    private String number;
    private String address;
    private int age;
    private double high;

    public Human(String name, String sex, String number, String address, int age, double high) {
        this.name = name;
        this.sex = sex;
        this.number = number;
        this.address = address;
        this.age = age;
        this.high = high;
    }

    public Human() {
    }

    public static void main(String[] args) {

        Human builder = new Human.Builder("zxx", "15282648585").address("世界").build();
        System.out.println("builder  = " + builder.toString());
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public double getHigh() {
        return high;
    }

   /* public Human(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.number = builder.number;
        this.address = builder.address;
        this.age = builder.age;
        this.high = builder.high;
    }
*/

    public Builder Builder(String name, String number) {
        return new Builder(name, number);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", high=" + high +
                '}';
    }

    public static class Builder {
        //something important
        private String name;
        private String number;
        //something default
        private String sex = "男";
        private String address = "花桥";
        private int age = 18;
        private double high = 173.0;

        public Builder(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder high(double high) {
            this.high = high;
            return this;
        }

        public Human build() {
            return new Human(name, number, sex, address, age, high);
        }
    }
}
