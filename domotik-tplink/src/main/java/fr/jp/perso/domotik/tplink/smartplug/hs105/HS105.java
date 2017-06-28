package fr.jp.perso.domotik.tplink.smartplug.hs105;

import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.services.ResponseService;
import fr.jp.perso.domotik.tplink.smartplug.hs105.responses.GetHS105SystemInfoResponse;

public class HS105 extends TpLinkSmartPlug {
   public HS105(String ip) {
      super(ip);
   }

   public ResponseService<GetHS105SystemInfoResponse> getSystemInfoDeserializer() {
      return new ResponseService<>(GetHS105SystemInfoResponse.class);
   }
}
