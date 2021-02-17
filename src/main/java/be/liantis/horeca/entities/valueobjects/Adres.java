package be.liantis.horeca.entities.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adres {
   private String straat;
   private String huisNummer;
   private String postcode;
   private String gemeente;
   private String deelgemeente;
}
