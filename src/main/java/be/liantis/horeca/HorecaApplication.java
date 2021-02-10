package be.liantis.horeca;

import be.liantis.horeca.entities.Restaurant;
import be.liantis.horeca.repositories.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class HorecaApplication {

   public static void main(String[] args) {
      SpringApplication.run(HorecaApplication.class, args);
   }

   @Bean
   public CommandLineRunner loadDatabase(RestaurantRepository repository) {
      return args -> {
         Restaurant restaurant = new Restaurant();
         repository.save(restaurant);
      };
   }

}
