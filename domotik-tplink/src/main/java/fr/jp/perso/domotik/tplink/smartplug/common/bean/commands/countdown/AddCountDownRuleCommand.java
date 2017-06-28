package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;

public class AddCountDownRuleCommand extends CountDownCommand {
   public AddCountDownRuleCommand(CountDownRule countDownRule) {
      this.countDownRule = countDownRule;
   }

   @Override
   public String getCommandName() {
      return "add_rule";
   }
}
