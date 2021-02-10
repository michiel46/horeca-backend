package be.liantis.horeca.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestaurantJsonInputDto {

   private String json_featuretype;
   @JsonProperty("Naam")
   private String naam;
   @JsonProperty("Formule")
   private String formule;
   @JsonProperty("Straat")
   private String straat;
   @JsonProperty("HuisNr")
   private String huisnummer;
   @JsonProperty("Postcode")
   private String postcode;
   @JsonProperty("Deelgemeente")
   private String deelgemeente;
   @JsonProperty("Gemeente")
   private String gemeente;
   @JsonProperty("Branche")
   private String branche;
   @JsonProperty("Check_dat")
   private String check_dat;
   @JsonProperty("Winkelgebied")
   private String winkelgebied;
   @JsonProperty("Subcentrum")
   private String subcentrum;
   @JsonProperty("StrnmEnHuisnr")
   private String StraatEnHuisNummer;
   @JsonProperty("Aangemaakt op")
   private String creatieDatum;
   @JsonProperty("json_ogc_wkt_crs")
   private String geoGcsString;
   private Geometry json_geometry;

   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   @ToString
   public class Geometry {
      private String type;
      private float[] coordinates;
   }
}
