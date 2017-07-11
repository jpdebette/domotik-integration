package fr.jp.perso.domotik.tplink.smartplug.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.jp.perso.domotik.ApiResponseDto;
import fr.jp.perso.domotik.tplink.services.TpLinkController;
import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetSystemInfoResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.hs100.HS100;
import fr.jp.perso.domotik.tplink.smartplug.hs105.HS105;

public class SmartPlugController {
   @Autowired
   private SystemService systemService;
   @Autowired
   private TimeService timeService;
   @Autowired
   private CountDownService countDownService;

   @GetMapping(path = "/{deviceIpAddress}/systemInfo")
   public ApiResponseDto getSystemInfo(@PathVariable String deviceIpAddress) {
      TpLinkSmartPlug tpLinkSmartPlug = constructSmartPlug(deviceIpAddress);
      try {
         GetSystemInfoResponse response = systemService.getSystemInfo(tpLinkSmartPlug);
         return TpLinkController.processResponse(response);
      } catch(Exception ex) {
         return TpLinkController.processException(ex);
      }
   }

   @GetMapping(path = "/{deviceIpAddress}/reboot/{delay}")
   public ApiResponseDto reboot(@PathVariable String deviceIpAddress, @PathVariable int delay) {
      if(delay < 1 || delay > 3600) {
         throw new RuntimeException("Delay of reboot should be between 1 second and 1 hour.");
      }
      TpLinkSmartPlug tpLinkSmartPlug = constructSmartPlug(deviceIpAddress);
      try {
         TpLinkResponse response = systemService.reboot(tpLinkSmartPlug, delay);
         return TpLinkController.processResponse(response);
      } catch(Exception ex) {
         return TpLinkController.processException(ex);
      }
   }

   @GetMapping(path = "/{deviceIpAddress}/turnOn")
   public ApiResponseDto turnOn(@PathVariable String deviceIpAddress) {
      TpLinkSmartPlug tpLinkSmartPlug = constructSmartPlug(deviceIpAddress);
      try {
         TpLinkResponse response = systemService.changeRelayState(tpLinkSmartPlug, true);
         return TpLinkController.processResponse(response);
      } catch(Exception ex) {
         return TpLinkController.processException(ex);
      }
   }

   @GetMapping(path = "/{deviceIpAddress}/turnOff")
   public ApiResponseDto turnOff(@PathVariable String deviceIpAddress) {
      TpLinkSmartPlug tpLinkSmartPlug = constructSmartPlug(deviceIpAddress);
      try {
         TpLinkResponse response = systemService.changeRelayState(tpLinkSmartPlug, false);
         return TpLinkController.processResponse(response);
      } catch(Exception ex) {
         return TpLinkController.processException(ex);
      }
   }

   @GetMapping(path = "/{deviceIpAddress}/turnLedOn")
   public ApiResponseDto turnLedOn(@PathVariable String deviceIpAddress) {
      TpLinkSmartPlug tpLinkSmartPlug = constructSmartPlug(deviceIpAddress);
      try {
         TpLinkResponse response = systemService.changeLedState(tpLinkSmartPlug, true);
         return TpLinkController.processResponse(response);
      } catch(Exception ex) {
         return TpLinkController.processException(ex);
      }
   }

   @GetMapping(path = "/{deviceIpAddress}/turnLedOff")
   public ApiResponseDto turnLedOff(@PathVariable String deviceIpAddress) {
      TpLinkSmartPlug tpLinkSmartPlug = constructSmartPlug(deviceIpAddress);
      try {
         TpLinkResponse response = systemService.changeLedState(tpLinkSmartPlug, false);
         return TpLinkController.processResponse(response);
      } catch(Exception ex) {
         return TpLinkController.processException(ex);
      }
   }

   private TpLinkSmartPlug constructSmartPlug(String deviceIpAddress) {
      if (this instanceof Hs100Controller) {
         return new HS100(deviceIpAddress);
      } else if (this instanceof Hs105Controller) {
         return new HS105(deviceIpAddress);
      } else {
         throw new IllegalArgumentException(String.format("This controller: %s is not supported by TpLink API.", this.getClass().getSimpleName()));
      }
   }
}
