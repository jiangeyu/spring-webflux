package main;

import declare.parents.Animal;
import declare.parents.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"config*", "aop*", "declare.parents*"})
public class SpringBootDemoApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

        Person person = (Person) context.getBean("women");
        person.likePerson();
        Animal animal = (Animal) person;
        animal.eat();

        Animal animal1 = (Animal) context.getBean("femaleAnimal");
        animal1.eat();

        String[] beanNames = context.getBeanNamesForType(Runnable.class);
        Arrays.asList(beanNames).stream().forEach(System.out::println);

    }

}
