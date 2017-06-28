package fr.jp.perso.domotik.tplink.smartplug.hs100;

import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.services.ResponseService;
import fr.jp.perso.domotik.tplink.smartplug.hs100.responses.GetHS100SystemInfoResponse;

public class HS100 extends TpLinkSmartPlug {
   public HS100(String ip) {
      super(ip);
   }

   public ResponseService<GetHS100SystemInfoResponse> getSystemInfoDeserializer() {
      return new ResponseService<>(GetHS100SystemInfoResponse.class);
   }
}
