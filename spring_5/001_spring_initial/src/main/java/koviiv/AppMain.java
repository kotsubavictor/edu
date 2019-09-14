package koviiv;

import koviiv.world.Animal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain
{
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");

        Animal cat = context.getBean("cat", Animal.class);
        Animal dog = context.getBean("dog", Animal.class);

        System.out.println(cat.say());
        System.out.println(dog.say());

        context.close();

    }
}
