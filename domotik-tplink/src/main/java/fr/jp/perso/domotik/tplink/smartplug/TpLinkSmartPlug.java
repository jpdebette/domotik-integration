package fr.jp.perso.domotik.tplink.smartplug;

import fr.jp.perso.domotik.SmartDevice;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.GetSystemInfoResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.services.ResponseService;

public abstract class TpLinkSmartPlug extends SmartDevice {
   public TpLinkSmartPlug(String ipAddress) {
      super(ipAddress);
   }

   public abstract ResponseService<? extends GetSystemInfoResponse> getSystemInfoDeserializer();
}
