package fr.jp.perso.domotik.tplink.smartplug.common.bean.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkActiveModes;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkModels;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkTypes;

public class GetSystemInfoResponse extends TpLinkResponse {
   @JsonProperty("sw_ver")
   private String softwareVersion;
   @JsonProperty("hw_ver")
   private String hardwareVersion;
   @JsonProperty("type")
   private TpLinkTypes type;
   @JsonProperty("model")
   private TpLinkModels model;
   @JsonProperty("mac")
   private String macAddress;
   @JsonProperty("dev_name")
   private String deviceName;
   @JsonProperty("alias")
   private String alias;
   @JsonProperty("relay_state")
   private boolean relayState;
   @JsonProperty("on_time")
   private int upTime;
   @JsonProperty("active_mode")
   private TpLinkActiveModes activeMode;
   @JsonProperty("feature")
   private String feature;
   @JsonProperty("updating")
   private boolean updating;
   @JsonProperty("icon_hash")
   private String iconHash;
   @JsonProperty("rssi")
   private int rssi;
   @JsonProperty("led_off")
   private boolean ledOff;
   @JsonProperty("hwId")
   private String hardwareId;
   @JsonProperty("fwId")
   private String firmwareId;
   @JsonProperty("deviceId")
   private String deviceId;
   @JsonProperty("oemId")
   private String oemId;

   public String getSoftwareVersion() {
      return softwareVersion;
   }

   public String getHardwareVersion() {
      return hardwareVersion;
   }

   public TpLinkTypes getType() {
      return type;
   }

   public TpLinkModels getModel() {
      return model;
   }

   public String getMacAddress() {
      return macAddress;
   }

   public String getDeviceName() {
      return deviceName;
   }

   public String getAlias() {
      return alias;
   }

   public boolean getRelayState() {
      return relayState;
   }

   public int getUpTime() {
      return upTime;
   }

   public TpLinkActiveModes getActiveMode() {
      return activeMode;
   }

   public String getFeature() {
      return feature;
   }

   public boolean isUpdating() {
      return updating;
   }

   public String getIconHash() {
      return iconHash;
   }

   public int getRssi() {
      return rssi;
   }

   public boolean isLedOff() {
      return ledOff;
   }

   public String getHardwareId() {
      return hardwareId;
   }

   public String getFirmwareId() {
      return firmwareId;
   }

   public String getDeviceId() {
      return deviceId;
   }

   public String getOemId() {
      return oemId;
   }
}
