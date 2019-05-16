package think.in.java.chapter14.field;

import think.in.java.chapter14.constructor.Person;

import java.lang.reflect.Field;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午3:11 2019/4/7
 * @desc
 */
public class FieldDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("------Field getName");
        Field ageField = clazz.getDeclaredField("age");
        System.out.println(ageField.getName());

        System.out.println("------Field getDeclaredField setAccessible");
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person, "lx");
        System.out.println(person.toString());

        System.out.println("------Field getType");
        System.out.println(nameField.getType());
        System.out.println("------Field toGenericString");
        System.out.println(nameField.toGenericString());
        System.out.println("------Field getDeclaringClass");
        System.out.println(nameField.getDeclaringClass());

        System.out.println("------Field isEnumConstant");
        Field sexField = Person.Sex.class.getField("man");
        System.out.println(sexField.toGenericString());
        System.out.println("-- is enum " + sexField.isEnumConstant());

        System.out.println("------Field toGenericString isSynthetic");
        Field sexField2 = clazz.getField("sex");
        System.out.println(sexField2.toGenericString());
        System.out.println("-- is syn " + sexField2.isSynthetic());

        System.out.println("------Field  getFields");
        Field[] fields2 = clazz.getFields();

        for (Field field : fields2) {
            System.out.println(field.getName());
        }
    }
}
