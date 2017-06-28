package fr.jp.perso.domotik.tplink.smartplug.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommandWrapper;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.time.GetTimeCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.time.GetTimezoneCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetTimeResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetTimezoneResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkTargets;

@Component
class TimeService {
   @Autowired
   private RequestService requestService;

   GetTimeResponse getTime(TpLinkSmartPlug tpLinkSmartPlug) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTargets.TIME, new GetTimeCommand());

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<GetTimeResponse> responseService = new ResponseService<>(GetTimeResponse.class);
      return responseService.deserializeResponse(response);
   }

   GetTimezoneResponse getTimezone(TpLinkSmartPlug tpLinkSmartPlug) {
      TpLinkCommandWrapper request = new TpLinkCommandWrapper(TpLinkTargets.TIME, new GetTimezoneCommand());

      String response = requestService.sendRequest(tpLinkSmartPlug.getIpAddress(), request);

      ResponseService<GetTimezoneResponse> responseService = new ResponseService<>(GetTimezoneResponse.class);
      return responseService.deserializeResponse(response);
   }
}
