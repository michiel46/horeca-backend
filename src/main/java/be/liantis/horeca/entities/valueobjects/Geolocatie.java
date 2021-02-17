package be.liantis.horeca.entities.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Geolocatie {
   private String lengtegraad;
   private String breedtegraad;
}
