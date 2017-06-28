package fr.jp.perso.domotik.tplink.smartplug.common.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.jp.perso.domotik.Model;
import fr.jp.perso.domotik.SmartDeviceDto;
import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetSystemInfoResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetTimeResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetTimezoneResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.hs100.HS100;
import fr.jp.perso.domotik.tplink.smartplug.hs105.HS105;

@RestController
@RequestMapping("/tplink")
public class TpLinkFacade {
   @Autowired
   private SystemService systemService;
   @Autowired
   private TimeService timeService;
   @Autowired
   private CountDownService countDownService;

   @RequestMapping(path = "/status", method = RequestMethod.GET)
   public String getStatus() {
      return "Up and running...";
   }

   @RequestMapping(path = "/systemInfo", method = RequestMethod.POST)
   public GetSystemInfoResponse getSystemInfo(@RequestBody SmartDeviceDto smartDeviceDto) throws IOException {
      TpLinkSmartPlug tpLinkSmartPlug;
      if (smartDeviceDto.getModel() == Model.TpLink_HS100) {
         tpLinkSmartPlug = new HS100(smartDeviceDto.getIpAddress());
      } else if (smartDeviceDto.getModel() == Model.TpLink_HS105) {
         tpLinkSmartPlug = new HS105(smartDeviceDto.getIpAddress());
      } else {
         throw new RuntimeException(String.format("The model: %s is not supported by TpLink API.", smartDeviceDto.getModel().name()));
      }

      return systemService.getSystemInfo(tpLinkSmartPlug);
   }

   public TpLinkResponse reboot(TpLinkSmartPlug tpLinkSmartPlug, int delay) {
      if (delay < 1 || delay > 3600) {
         throw new RuntimeException("Delay of reboot should be between 1 second and 1 hour.");
      }
      return systemService.reboot(tpLinkSmartPlug, delay);
   }

   public TpLinkResponse turnOn(TpLinkSmartPlug tpLinkSmartPlug) {
      return systemService.changeRelayState(tpLinkSmartPlug, true);
   }

   public TpLinkResponse turnOff(TpLinkSmartPlug tpLinkSmartPlug) {
      return systemService.changeRelayState(tpLinkSmartPlug, false);
   }

   public TpLinkResponse turnLedOn(TpLinkSmartPlug tpLinkSmartPlug) {
      return systemService.changeLedState(tpLinkSmartPlug, true);
   }

   public TpLinkResponse turnLedOff(TpLinkSmartPlug tpLinkSmartPlug) {
      return systemService.changeLedState(tpLinkSmartPlug, false);
   }

   /** Time Services **/

   public GetTimeResponse getTime(TpLinkSmartPlug tpLinkSmartPlug) {
      return timeService.getTime(tpLinkSmartPlug);
   }

   public GetTimezoneResponse getTimezone(TpLinkSmartPlug tpLinkSmartPlug) {
      return timeService.getTimezone(tpLinkSmartPlug);
   }

   /** Count down Services **/

   public CountDownRule getCountDownRule(TpLinkSmartPlug tpLinkSmartPlug) {
      return countDownService.getCountDownRule(tpLinkSmartPlug);
   }

   public TpLinkResponse addCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, CountDownRule countDownRule) {
      return countDownService.addCountDownRule(tpLinkSmartPlug, countDownRule);
   }

   public TpLinkResponse editCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, CountDownRule countDownRule) {
      return countDownService.editCountDownRule(tpLinkSmartPlug, countDownRule);
   }

   public TpLinkResponse deleteCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, String countDownRuleId) {
      return countDownService.deleteCountDownRule(tpLinkSmartPlug, countDownRuleId);
   }

   public TpLinkResponse deleteAllCountDownRules(TpLinkSmartPlug tpLinkSmartPlug) {
      return countDownService.deleteAllCountDownRules(tpLinkSmartPlug);
   }
}
