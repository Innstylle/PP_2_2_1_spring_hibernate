package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Skoda", 10);
        Car car2 = new Car("Reno", 20);
        Car car3 = new Car("Opel", 30);
        User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
        User user3 = new User("User3", "Lastname3", "user3@gmail.com", car3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        List<User> userList = userService.listUsers();
        for (User u : userList) {
            System.out.println(u);
        }

        List<User> userListByCar1 = userService.listUsersByModelAndSeries("Reno", "20");
        System.out.println(userListByCar1);

        List<User> userListByCar2 = userService.listUsersByModelAndSeries("Opel", "30");
        System.out.println(userListByCar2);

        context.close();
    }
}
