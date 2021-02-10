package be.liantis.horeca.controllers;

import be.liantis.horeca.controllers.dtos.RestaurantJsonInputDto;
import be.liantis.horeca.controllers.dtos.RestaurantJsonInputDtoConverter;
import be.liantis.horeca.entities.Restaurant;
import be.liantis.horeca.entities.Sector;
import be.liantis.horeca.entities.Winkelgebied;
import be.liantis.horeca.repositories.RestaurantRepository;
import be.liantis.horeca.repositories.SectorRepository;
import be.liantis.horeca.repositories.WinkelgebiedRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RestaurantJsonInputController {

   private RestaurantRepository restaurantRepository;
   private SectorRepository sectorRepository;
   private WinkelgebiedRepository winkelgebiedRepository;

   public RestaurantJsonInputController(RestaurantRepository restaurantRepository, SectorRepository sectorRepository, WinkelgebiedRepository winkelgebiedRepository) {
      this.restaurantRepository = restaurantRepository;
      this.sectorRepository = sectorRepository;
      this.winkelgebiedRepository = winkelgebiedRepository;
   }

   public void processJson(List<RestaurantJsonInputDto> restaurantJsonInputDtos) {
      List<Restaurant> restaurants = convertToDomainObjects(restaurantJsonInputDtos);
      saveRestaurants(restaurants);
   }

   private List<Restaurant> convertToDomainObjects(List<RestaurantJsonInputDto> restaurantJsonInputDtos) {
      return restaurantJsonInputDtos.stream().map(RestaurantJsonInputDtoConverter::fromDto).collect(Collectors.toList());
   }

   private void saveRestaurants(List<Restaurant> restaurants) {
      restaurants.forEach(restaurant -> {
         Optional<Winkelgebied> optionalWinkelgebied = winkelgebiedRepository.findWinkelgebiedByNaamAndSubcentrum(restaurant.getWinkelgebied().getNaam(), restaurant.getWinkelgebied().getSubcentrum());
         if (optionalWinkelgebied.isPresent()) {
            restaurant.setWinkelgebied(optionalWinkelgebied.get());
         } else {
            winkelgebiedRepository.save(restaurant.getWinkelgebied());
         }

         Optional<Sector> optionalSector = sectorRepository.findSectorByCodeAndAndNaam(restaurant.getSector().getCode(), restaurant.getSector().getNaam());
         if (optionalSector.isPresent()) {
            restaurant.setSector(optionalSector.get());
         } else {
            sectorRepository.save(restaurant.getSector());
         }

         restaurantRepository.save(restaurant);
      });
   }
}
