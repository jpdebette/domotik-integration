package fr.jp.perso.domotik.tplink.smartplug.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TpLinkTypes {
   IOT_SMART_PLUG_SWITCH("IOT.SMARTPLUGSWITCH");

   private String typeLabel;

   TpLinkTypes(String typeLabel) {
      this.typeLabel = typeLabel;
   }

   @JsonValue
   public String toValue() {
      return typeLabel;
   }
}
