package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;

public class DeleteAllCountDownRuleCommand extends TpLinkCommand {
   @Override
   public String getCommandName() {
      return "delete_all_rules";
   }
}
