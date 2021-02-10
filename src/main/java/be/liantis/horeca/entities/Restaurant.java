package be.liantis.horeca.entities;

import be.liantis.horeca.entities.valueobjects.Adres;
import be.liantis.horeca.entities.valueobjects.Geolocatie;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "restaurants")
public class Restaurant {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String naam;
   private LocalDate creatieDatum;
   private LocalDate checkDatum;
   private boolean keten;
   private String ketenNaam;

   @Embedded
   private Adres adres;
   @Embedded
   private Geolocatie geolocatie;

   @ManyToOne
   private Sector sector;
   @ManyToOne
   private Winkelgebied winkelgebied;

   public Restaurant(String naam, LocalDate creatieDatum, LocalDate checkDatum, boolean keten, String ketenNaam, Adres adres, Geolocatie geolocatie, Sector sector, Winkelgebied winkelgebied) {
      this.naam = naam;
      this.creatieDatum = creatieDatum;
      this.checkDatum = checkDatum;
      this.keten = keten;
      this.ketenNaam = ketenNaam;
      this.adres = adres;
      this.geolocatie = geolocatie;
      this.sector = sector;
      this.winkelgebied = winkelgebied;
   }

   public void setSector(Sector sector) {
      this.sector = sector;
   }

   public void setWinkelgebied(Winkelgebied winkelgebied) {
      this.winkelgebied = winkelgebied;
   }
}
