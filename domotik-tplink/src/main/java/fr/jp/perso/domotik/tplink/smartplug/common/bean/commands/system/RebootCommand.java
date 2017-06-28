package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;

public class RebootCommand extends TpLinkCommand {
   @JsonProperty
   private int delay;

   public RebootCommand(int delay) {
      this.delay = delay;
   }

   @Override
   public String getCommandName() {
      return "reboot";
   }
}
