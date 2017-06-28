package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.time;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;

public class GetTimezoneCommand extends TpLinkCommand {
   @Override
   public String getCommandName() {
      return "get_timezone";
   }
}
