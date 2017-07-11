package fr.jp.perso.domotik.tplink.smartplug.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommandWrapper;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system.GetSystemInfoCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system.RebootCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system.SetLedStateCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.system.SetRelayStateCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetSystemInfoResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkTarget;

@Component
class SystemService {
   @Autowired
   private RequestService requestService;

   GetSystemInfoResponse getSystemInfo(TpLinkSmartPlug tpLinkSmartPlug) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTarget.SYSTEM, new GetSystemInfoCommand());

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<? extends GetSystemInfoResponse> responseService = tpLinkSmartPlug.getSystemInfoDeserializer();
      return responseService.deserializeResponse(response);
   }

   TpLinkResponse changeRelayState(TpLinkSmartPlug tpLinkSmartPlug, boolean state) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTarget.SYSTEM, new SetRelayStateCommand(state));

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<TpLinkResponse> responseService = new ResponseService<>(TpLinkResponse.class);
      return responseService.deserializeResponse(response);
   }

   TpLinkResponse changeLedState(TpLinkSmartPlug tpLinkSmartPlug, boolean state) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTarget.SYSTEM, new SetLedStateCommand(state));

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<TpLinkResponse> responseService = new ResponseService<>(TpLinkResponse.class);
      return responseService.deserializeResponse(response);
   }

   TpLinkResponse reboot(TpLinkSmartPlug tpLinkSmartPlug, int delay) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTarget.SYSTEM, new RebootCommand(delay));

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<TpLinkResponse> responseService = new ResponseService<>(TpLinkResponse.class);
      return responseService.deserializeResponse(response);
   }
}
