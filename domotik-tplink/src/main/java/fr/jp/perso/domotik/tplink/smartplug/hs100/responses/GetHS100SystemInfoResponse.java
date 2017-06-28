package fr.jp.perso.domotik.tplink.smartplug.hs100.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetSystemInfoResponse;

public class GetHS100SystemInfoResponse extends GetSystemInfoResponse {
   @JsonProperty("longitude")
   private int longitude;
   @JsonProperty("latitude")
   private int latitude;

   public int getLongitude() {
      return longitude;
   }

   public int getLatitude() {
      return latitude;
   }
}
