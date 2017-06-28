package fr.jp.perso.domotik.tplink.smartplug.hs105.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetSystemInfoResponse;

public class GetHS105SystemInfoResponse extends GetSystemInfoResponse {
   @JsonProperty("longitude_i")
   private int longitudeI;
   @JsonProperty("latitude_i")
   private int latitudeI;

   public int getLongitudeI() {
      return longitudeI;
   }

   public int getLatitudeI() {
      return latitudeI;
   }
}
