package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.serializers.BooleanToNumericSerializer;

public class SetRelayStateCommand extends TpLinkCommand {
   @JsonSerialize(using = BooleanToNumericSerializer.class)
   private boolean state;

   public SetRelayStateCommand(boolean state) {
      this.state = state;
   }

   @Override
   public String getCommandName() {
      return "set_relay_state";
   }
}
