package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;

public class DeleteCountDownRuleCommand extends CountDownCommand {
   public DeleteCountDownRuleCommand(String id) {
      this.countDownRule = new CountDownRule();
      this.countDownRule.setId(id);
   }

   @Override
   public String getCommandName() {
      return "delete_rule";
   }
}
