package be.liantis.horeca.entities;

import javax.persistence.*;

@Entity
@Table(name = "sectoren")
public class Sector {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String code;
   private String naam;
}
