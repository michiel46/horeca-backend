package be.liantis.horeca.entities;

import be.liantis.horeca.entities.valueobjects.Adres;
import be.liantis.horeca.entities.valueobjects.Geolocatie;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
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
}
