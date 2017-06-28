package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;

public class EditCountDownRuleCommand extends CountDownCommand {
   public EditCountDownRuleCommand(CountDownRule countDownRule) {
      this.countDownRule = countDownRule;
   }

   @Override
   public String getCommandName() {
      return "edit_rule";
   }
}
