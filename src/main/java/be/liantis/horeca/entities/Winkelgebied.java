package be.liantis.horeca.entities;

import javax.persistence.*;

@Entity
@Table(name = "winkelgebieden")
public class Winkelgebied {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String naam;
   private String subcentrum;
}
