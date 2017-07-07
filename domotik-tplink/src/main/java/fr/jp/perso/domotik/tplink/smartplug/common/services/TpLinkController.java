package fr.jp.perso.domotik.tplink.smartplug.common.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jp.perso.domotik.ApiResponseDto;
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
public class TpLinkController {
   private final Logger log = LoggerFactory.getLogger(TpLinkController.class);
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
   public ApiResponseDto getSystemInfo(@RequestBody SmartDeviceDto smartDeviceDto) {
      try {
         TpLinkSmartPlug tpLinkSmartPlug;
         if(smartDeviceDto.getModel() == Model.TpLink_HS100) {
            tpLinkSmartPlug = new HS100(smartDeviceDto.getIpAddress());
         } else if(smartDeviceDto.getModel() == Model.TpLink_HS105) {
            tpLinkSmartPlug = new HS105(smartDeviceDto.getIpAddress());
         } else {
            throw new IllegalArgumentException(String.format("The model: %s is not supported by TpLink API.", smartDeviceDto.getModel().name()));
         }

         GetSystemInfoResponse response = systemService.getSystemInfo(tpLinkSmartPlug);
         return processResponse(response);
      } catch (Exception ex) {
         return processException(ex);
      }
   }

   private ApiResponseDto processResponse(TpLinkResponse tpLinkResponse) {
      ObjectMapper mapper = new ObjectMapper();
      ApiResponseDto apiResponseDto = new ApiResponseDto();
      apiResponseDto.setSuccess(true);
      try {
         apiResponseDto.setResponse(mapper.writeValueAsString(tpLinkResponse));
      } catch(JsonProcessingException ex) {
         String errorMessage = "Error when parsing the tpLink response...";
         apiResponseDto.setSuccess(false);
         apiResponseDto.setResponse(errorMessage);
         log.error(errorMessage, ex);
      }

      return apiResponseDto;
   }

   private ApiResponseDto processException(Exception ex) {
      ApiResponseDto apiResponseDto = new ApiResponseDto();
      apiResponseDto.setResponse(ex.getMessage());
      return apiResponseDto;
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
