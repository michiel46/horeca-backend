package be.liantis.horeca;

import be.liantis.horeca.controllers.RestaurantJsonInputController;
import be.liantis.horeca.controllers.dtos.RestaurantJsonInputDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class HorecaApplication {

   public static void main(String[] args) {
      SpringApplication.run(HorecaApplication.class, args);
   }

   @Bean
   public CommandLineRunner loadDatabase(RestaurantJsonInputController service) {
      return args -> {
         ObjectMapper mapper = new ObjectMapper();
         mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         TypeReference<List<RestaurantJsonInputDto>> typeReference = new TypeReference<List<RestaurantJsonInputDto>>() {};
         InputStream inputStream = TypeReference.class.getResourceAsStream("/horeca.json");
         try {
            List<RestaurantJsonInputDto> restaurantJsonInputDtos = mapper.readValue(inputStream, typeReference);
            service.processJson(restaurantJsonInputDtos);
         } catch (IOException ex) {
            System.err.println("Exception!! + " + ex);
         }

      };
   }
}
