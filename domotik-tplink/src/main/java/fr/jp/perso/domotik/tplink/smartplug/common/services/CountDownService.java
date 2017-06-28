package fr.jp.perso.domotik.tplink.smartplug.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommandWrapper;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.AddCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.DeleteAllCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.DeleteCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.EditCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.GetCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkTargets;

@Component
class CountDownService {
   @Autowired
   private RequestService requestService;

   CountDownRule getCountDownRule(TpLinkSmartPlug tpLinkSmartPlug) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTargets.COUNT_DOWN, new GetCountDownRuleCommand());

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<CountDownRule> responseService = new ResponseService<>(CountDownRule.class);
      return responseService.deserializeResponse(response);
   }

   CountDownRule addCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, CountDownRule countDownRule) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTargets.COUNT_DOWN, new AddCountDownRuleCommand(countDownRule));

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<CountDownRule> responseService = new ResponseService<>(CountDownRule.class);
      return responseService.deserializeResponse(response);
   }

   CountDownRule editCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, CountDownRule countDownRule) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTargets.COUNT_DOWN, new EditCountDownRuleCommand(countDownRule));

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<CountDownRule> responseService = new ResponseService<>(CountDownRule.class);
      return responseService.deserializeResponse(response);
   }

   CountDownRule deleteCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, String countDownRuleId) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTargets.COUNT_DOWN, new DeleteCountDownRuleCommand(countDownRuleId));

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<CountDownRule> responseService = new ResponseService<>(CountDownRule.class);
      return responseService.deserializeResponse(response);
   }

   CountDownRule deleteAllCountDownRules(TpLinkSmartPlug tpLinkSmartPlug) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTargets.COUNT_DOWN, new DeleteAllCountDownRuleCommand());

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<CountDownRule> responseService = new ResponseService<>(CountDownRule.class);
      return responseService.deserializeResponse(response);
   }
}
