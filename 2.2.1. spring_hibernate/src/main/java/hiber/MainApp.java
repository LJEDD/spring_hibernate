package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;



public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);



      User user1 = (new User("Name1", "LastN1", "int1@m.com"));
      User user2 = (new User("Name2", "LastN2", "int2@m.com"));
      User user3 = (new User("Name3", "LastN3", "int3@m.com"));
      User user4 = (new User("Name4", "LastN4", "int4@m.com"));


      Car car1 = new Car("car1", 1900);
      Car car2 = new Car("car2", 1901);
      Car car3 = new Car("car3", 1902);
      Car car4 = new Car("car4", 1903);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println("Koordinati voditelya :"+" "+userService.getUserByCar("car1", 1900));

      context.close();
   }
}
