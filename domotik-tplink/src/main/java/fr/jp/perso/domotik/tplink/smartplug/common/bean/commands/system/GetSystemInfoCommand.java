package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;

public class GetSystemInfoCommand extends TpLinkCommand {
   @Override
   public String getCommandName() {
      return "get_sysinfo";
   }
}
