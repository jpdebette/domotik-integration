package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkActiveModes {
   NONE("none"), SCHEDULE("schedule");

   private String activeModeLabel;

   TpLinkActiveModes(String activeModeLabel) {
      this.activeModeLabel = activeModeLabel;
   }

   @JsonValue
   public String toValue() {
      return activeModeLabel;
   }
}
