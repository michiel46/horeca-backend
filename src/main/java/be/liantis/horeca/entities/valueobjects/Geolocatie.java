package be.liantis.horeca.entities.valueobjects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Geolocatie {
   private String lengtegraad;
   private String breedtegraad;
}
