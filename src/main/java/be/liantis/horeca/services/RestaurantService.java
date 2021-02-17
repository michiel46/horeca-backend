package be.liantis.horeca.services;

import be.liantis.horeca.entities.Restaurant;
import be.liantis.horeca.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

   private RestaurantRepository restaurantRepository;

   public RestaurantService(RestaurantRepository restaurantRepository){
      this.restaurantRepository = restaurantRepository;
   }

   public List<Restaurant> findAllHoreca() {
      return (List<Restaurant>) restaurantRepository.findAll();
   }

}
