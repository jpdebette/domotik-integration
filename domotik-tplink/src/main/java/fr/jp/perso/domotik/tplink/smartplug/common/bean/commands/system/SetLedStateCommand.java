package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.serializers.BooleanToNumericSerializer;

public class SetLedStateCommand extends TpLinkCommand {
   @JsonSerialize(using = BooleanToNumericSerializer.class)
   private boolean off;

   public SetLedStateCommand(boolean state) {
      this.off = !state;
   }

   @Override
   public String getCommandName() {
      return "set_led_off";
   }
}
