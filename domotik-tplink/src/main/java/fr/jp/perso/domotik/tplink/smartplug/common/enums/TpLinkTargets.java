package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkTargets {
   SYSTEM("system"), TIME("time"), COUNT_DOWN("count_down");

   private String label;

   TpLinkTargets(String label) {
      this.label = label;
   }

   @JsonValue
   public String toValue() {
      return label;
   }
}
