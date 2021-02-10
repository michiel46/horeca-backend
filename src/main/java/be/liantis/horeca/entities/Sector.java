package be.liantis.horeca.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "sectoren")
public class Sector {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String code;
   private String naam;

   public Sector(String code, String naam) {
      this.code = code;
      this.naam = naam;
   }
}
