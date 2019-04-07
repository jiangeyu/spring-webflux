package think.in.java.chapter14.constructor;

enum Sex {
    man, women;
}

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午1:08 2019/4/6
 * @desc
 */
public class Person {

    public int age;
    private String name;

    public Sex sex = Sex.man;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }


    private Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    public void draw() {
        System.out.println("person draw :");
    }

    public void draw(int age, String name) {
        System.out.println("person draw :" + age + " name: " + name);
    }

    private String sing(String musicName) {
        System.out.println("--- person sing");
        return musicName;
    }
}
