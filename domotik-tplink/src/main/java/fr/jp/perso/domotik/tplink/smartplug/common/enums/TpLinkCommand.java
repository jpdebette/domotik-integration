package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkCommand {
   GET_SYSTEM_INFO("get_sysinfo");

   private String label;

   TpLinkCommand(String label) {
      this.label = label;
   }

   @JsonValue
   public String toValue() {
      return label;
   }
}
