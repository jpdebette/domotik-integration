package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkModels {
   HS105_US("HS105(US)"), HS100_US("HS100(US)");

   private String modelLabel;

   TpLinkModels(String modelLabel) {
      this.modelLabel = modelLabel;
   }

   @JsonValue
   public String toValue() {
      return modelLabel;
   }
}
