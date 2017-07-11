package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkActiveMode {
   NONE("none"), SCHEDULE("schedule");

   private String activeModeLabel;

   TpLinkActiveMode(String activeModeLabel) {
      this.activeModeLabel = activeModeLabel;
   }

   @JsonValue
   public String toValue() {
      return activeModeLabel;
   }
}
