package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkType {
   IOT_SMART_PLUG_SWITCH("IOT.SMARTPLUGSWITCH");

   private String typeLabel;

   TpLinkType(String typeLabel) {
      this.typeLabel = typeLabel;
   }

   @JsonValue
   public String toValue() {
      return typeLabel;
   }
}
