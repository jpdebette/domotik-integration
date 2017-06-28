package fr.jp.perso.domotik;

public abstract class SmartDevice {
   private String ip;

   public SmartDevice(String ip) {
      this.ip = ip;
   }

   public String getIp() {
      return ip;
   }
}
