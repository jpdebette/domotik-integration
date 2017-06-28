package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkCommands {
   GET_SYSTEM_INFO("get_sysinfo");

   private String label;

   TpLinkCommands(String label) {
      this.label = label;
   }

   @JsonValue
   public String toValue() {
      return label;
   }
}
