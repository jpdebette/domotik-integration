package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkTarget {
   SYSTEM("system"), TIME("time"), COUNT_DOWN("count_down");

   private String label;

   TpLinkTarget(String label) {
      this.label = label;
   }

   @JsonValue
   public String toValue() {
      return label;
   }
}
