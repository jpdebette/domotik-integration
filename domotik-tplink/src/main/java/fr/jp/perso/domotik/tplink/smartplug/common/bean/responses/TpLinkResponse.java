package fr.jp.perso.domotik.tplink.smartplug.common.bean.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TpLinkResponse {
   @JsonProperty(value = "err_code", access = JsonProperty.Access.WRITE_ONLY)
   private int errorCode;

   @JsonProperty(value = "err_msg", access = JsonProperty.Access.WRITE_ONLY)
   private String errorMessage;

   public int getErrorCode() {
      return errorCode;
   }

   public String getErrorMessage() {
      return errorMessage;
   }
}
