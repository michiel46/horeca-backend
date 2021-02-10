package be.liantis.horeca.controllers.dtos;

import be.liantis.horeca.entities.Restaurant;
import be.liantis.horeca.entities.Sector;
import be.liantis.horeca.entities.Winkelgebied;
import be.liantis.horeca.entities.valueobjects.Adres;
import be.liantis.horeca.entities.valueobjects.Geolocatie;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class RestaurantJsonInputDtoConverter {

   public static Restaurant fromDto(RestaurantJsonInputDto inputDto) {
      String sectorCode = inputDto.getBranche().split("-")[0];
      String sectorNaam = inputDto.getBranche().split("-")[1];

      return Restaurant.builder()
         .id(0)
         .naam(inputDto.getNaam())
         .creatieDatum(LocalDate.parse(inputDto.getCreatieDatum(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
         .checkDatum(LocalDate.parse(inputDto.getCheck_dat(), DateTimeFormatter.ofPattern("yyyyMMdd")))
         .keten(!inputDto.getFormule().equalsIgnoreCase("(Zelfst/nvt)"))
         .ketenNaam(!inputDto.getFormule().equalsIgnoreCase("(Zelfst/nvt)") ? inputDto.getFormule() : null)
         .adres(new Adres(inputDto.getStraat(), inputDto.getHuisnummer(), inputDto.getPostcode(), inputDto.getGemeente(), inputDto.getDeelgemeente()))
         .geolocatie(new Geolocatie(String.valueOf(inputDto.getJson_geometry().getCoordinates()[0]), String.valueOf(inputDto.getJson_geometry().getCoordinates()[1])))
         .sector(new Sector(sectorCode, sectorNaam))
         .winkelgebied(new Winkelgebied(inputDto.getWinkelgebied(), inputDto.getSubcentrum()))
         .build();
   }
}
