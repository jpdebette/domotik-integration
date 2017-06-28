package fr.jp.perso.domotik;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.jp.perso.domotik.tplink.smartplug.common.services.TpLinkFacade;

@SpringBootApplication
public class App {
   private static TpLinkFacade tpLinkFacade = new TpLinkFacade();

   public static void main(String[] args) throws IOException {
      SpringApplication.run(App.class, args);

      /*System.out.println("Get information on HS105...");
      GetSystemInfoResponse systemInfo = tpLinkFacade.getSystemInfo(hs105);
      System.out.println("Alias: " + systemInfo.getAlias());

      System.out.println("Get information on HS100...");
      GetSystemInfoResponse systemInfo2 = tpLinkFacade.getSystemInfo(hs100);
      System.out.println("Alias: " + systemInfo2.getAlias());*/

      /*System.out.println("Turn On...");
      TpLinkResponse tpLinkResponse = tpLinkFacade.turnOn(host);
      System.out.println("Result: " + (tpLinkResponse.getErrorCode() == 0 ? "OK" : "Error: " + tpLinkResponse.getErrorCode()));*/

      /*TpLinkResponse tpLinkResponse = tpLinkFacade.reboot(hs100, 1);
      System.out.println("Result: " + (tpLinkResponse.getErrorCode() == 0 ? "OK" : "Error: " + tpLinkResponse.getErrorCode()));*/
   }
}
