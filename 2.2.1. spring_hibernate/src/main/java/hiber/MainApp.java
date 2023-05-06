package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        ////      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
////      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
////      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
////      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
////
////      List<User> users = userService.listUsers();
////      for (User user : users) {
////         System.out.println("Id = "+user.getId());
////         System.out.println("First Name = "+user.getFirstName());
////         System.out.println("Last Name = "+user.getLastName());
////         System.out.println("Email = "+user.getEmail());
////         System.out.println();
////      }

        User user1 = new User("Ivan", "Ivanov", "Vanya@gmail.com");
        User user2 = new User("Petr", "Petrov", "Petro@mail.ru");
        User user3 = new User("Oleg", "Smirnov", "Oleg@rabmler.ru");
        Car car1 = new Car("KIA", 5);
        Car car2 = new Car("BMW", 10);
        Car car3 = new Car("Mazda", 15);
        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car: " + user.getCar());
        }

        User user4 = userService.getUserByCar("Audi", 20);
        System.out.println(user4);
        User user5 = userService.getUserByCar("KIA", 5);
        System.out.println(user5);

        context.close();
    }
}
