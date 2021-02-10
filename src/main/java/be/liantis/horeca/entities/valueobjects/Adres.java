package be.liantis.horeca.entities.valueobjects;

import javax.persistence.Embeddable;

@Embeddable
public class Adres {
   private String straat;
   private String huisNummer;
   private String postcode;
   private String gemeente;
   private String deelgemeente;
}
