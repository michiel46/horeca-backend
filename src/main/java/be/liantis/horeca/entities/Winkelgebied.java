package be.liantis.horeca.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "winkelgebieden")
public class Winkelgebied {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String naam;
   private String subcentrum;

   public Winkelgebied(String naam, String subcentrum) {
      this.naam = naam;
      this.subcentrum = subcentrum;
   }
}
