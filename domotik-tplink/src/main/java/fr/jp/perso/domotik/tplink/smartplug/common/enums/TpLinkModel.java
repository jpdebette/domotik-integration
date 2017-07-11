package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkModel {
   HS105_US("HS105(US)"), HS100_US("HS100(US)");

   private String modelLabel;

   TpLinkModel(String modelLabel) {
      this.modelLabel = modelLabel;
   }

   @JsonValue
   public String getModelLabel() {
      return modelLabel;
   }
}
