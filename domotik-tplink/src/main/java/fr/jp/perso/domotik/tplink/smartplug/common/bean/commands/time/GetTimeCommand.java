package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.time;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;

public class GetTimeCommand extends TpLinkCommand {
   @Override
   public String getCommandName() {
      return "get_time";
   }
}
