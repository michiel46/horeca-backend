package be.liantis.horeca.controllers;

import be.liantis.horeca.entities.Restaurant;
import be.liantis.horeca.services.RestaurantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

   private RestaurantService restaurantService;

   public RestaurantController(RestaurantService restaurantService){
      this.restaurantService = restaurantService;
   }

   @GetMapping
   @CrossOrigin
   public List<Restaurant> getAllHoreca() {
      return restaurantService.findAllHoreca();
   }

}
