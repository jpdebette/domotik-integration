package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;

public class GetCountDownRuleCommand extends TpLinkCommand {
   @Override
   public String getCommandName() {
      return "get_rules";
   }
}
