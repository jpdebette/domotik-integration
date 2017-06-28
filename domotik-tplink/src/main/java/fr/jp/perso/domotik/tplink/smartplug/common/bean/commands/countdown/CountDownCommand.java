package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommand;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class CountDownCommand extends TpLinkCommand {
   protected CountDownRule countDownRule;

   @JsonValue
   public CountDownRule getCountDownRule() {
      return countDownRule;
   }
}
