package fr.jp.perso.domotik;

public abstract class SmartDevice {
   private String ipAddress;

   public SmartDevice(String ipAddress) {
      this.ipAddress = ipAddress;
   }

   public String getIpAddress() {
      return ipAddress;
   }
}
