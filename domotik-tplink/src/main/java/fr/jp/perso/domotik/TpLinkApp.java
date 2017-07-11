package fr.jp.perso.domotik;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.jp.perso.domotik.tplink.services.TpLinkController;

@SpringBootApplication
public class TpLinkApp {
   private static TpLinkController tpLinkController = new TpLinkController();

   public static void main(String[] args) throws IOException {
      SpringApplication.run(TpLinkApp.class, args);

      /*System.out.println("Get information on HS105...");
      GetSystemInfoResponse systemInfo = tpLinkController.getSystemInfo(hs105);
      System.out.println("Alias: " + systemInfo.getAlias());

      System.out.println("Get information on HS100...");
      GetSystemInfoResponse systemInfo2 = tpLinkController.getSystemInfo(hs100);
      System.out.println("Alias: " + systemInfo2.getAlias());*/

      /*System.out.println("Turn On...");
      TpLinkResponse tpLinkResponse = tpLinkController.turnOn(host);
      System.out.println("Result: " + (tpLinkResponse.getErrorCode() == 0 ? "OK" : "Error: " + tpLinkResponse.getErrorCode()));*/

      /*TpLinkResponse tpLinkResponse = tpLinkController.reboot(hs100, 1);
      System.out.println("Result: " + (tpLinkResponse.getErrorCode() == 0 ? "OK" : "Error: " + tpLinkResponse.getErrorCode()));*/
   }
}
