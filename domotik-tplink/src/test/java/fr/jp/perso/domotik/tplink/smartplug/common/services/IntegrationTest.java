package fr.jp.perso.domotik.tplink.smartplug.common.services;

import fr.jp.perso.domotik.tplink.smartplug.TpLinkSmartPlug;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkActiveModes;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkModels;
import fr.jp.perso.domotik.tplink.smartplug.hs100.HS100;
import fr.jp.perso.domotik.tplink.smartplug.hs100.responses.GetHS100SystemInfoResponse;
import fr.jp.perso.domotik.tplink.smartplug.hs105.HS105;
import fr.jp.perso.domotik.tplink.smartplug.hs105.responses.GetHS105SystemInfoResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
   private HS105 hs105 = new HS105("192.168.25.51");
   private HS100 hs100 = new HS100("192.168.25.52");

   @Autowired
   private SystemService systemService;
   @Autowired
   private CountDownService countDownService;

   @Test
   public void testsCompilation() throws Exception {
      testHS105();
      testHS100();
   }

   public void testHS105() throws Exception {
      GetHS105SystemInfoResponse getHS105SystemInfoResponse = shouldGetSystemInfoForHS105();
      TpLinkResponse response = systemService.changeLedState(hs105, !getHS105SystemInfoResponse.isLedOff());
      validateResponse(response);
      Thread.sleep(3000);
      response = systemService.changeLedState(hs105, getHS105SystemInfoResponse.isLedOff());
      validateResponse(response);
      Thread.sleep(3000);
      response = systemService.changeRelayState(hs105, !getHS105SystemInfoResponse.getRelayState());
      validateResponse(response);
      Thread.sleep(3000);
      response = systemService.changeRelayState(hs105, getHS105SystemInfoResponse.getRelayState());
      validateResponse(response);
      Thread.sleep(3000);
      testCountDownService(hs105);
   }

   public void testHS100() throws Exception {
      GetHS100SystemInfoResponse getHS100SystemInfoResponse = shouldGetHS100SystemInfoCorrectly();
      TpLinkResponse response = systemService.changeLedState(hs100, !getHS100SystemInfoResponse.isLedOff());
      validateResponse(response);
      Thread.sleep(3000);
      response = systemService.changeLedState(hs100, getHS100SystemInfoResponse.isLedOff());
      validateResponse(response);
      Thread.sleep(3000);
      response = systemService.changeRelayState(hs100, !getHS100SystemInfoResponse.getRelayState());
      validateResponse(response);
      Thread.sleep(3000);
      response = systemService.changeRelayState(hs100, getHS100SystemInfoResponse.getRelayState());
      validateResponse(response);
      Thread.sleep(3000);
      testCountDownService(hs100);
   }

   public GetHS105SystemInfoResponse shouldGetSystemInfoForHS105() throws Exception {
      GetHS105SystemInfoResponse plugResponse = (GetHS105SystemInfoResponse)systemService.getSystemInfo(hs105);
      Assert.assertEquals("Ampli", plugResponse.getAlias());
      Assert.assertEquals("Smart Wi-Fi Plug Mini", plugResponse.getDeviceName());
      Assert.assertEquals(false, plugResponse.isLedOff());
      Assert.assertEquals(TpLinkModels.HS105_US, plugResponse.getModel());

      return plugResponse;
   }

   public GetHS100SystemInfoResponse shouldGetHS100SystemInfoCorrectly() throws Exception {
      GetHS100SystemInfoResponse plugResponse = (GetHS100SystemInfoResponse)systemService.getSystemInfo(hs100);
      Assert.assertEquals(TpLinkActiveModes.NONE, plugResponse.getActiveMode());
      Assert.assertEquals("Camera", plugResponse.getAlias());
      Assert.assertEquals(TpLinkModels.HS100_US, plugResponse.getModel());
      Assert.assertEquals(false, plugResponse.isLedOff());

      return plugResponse;
   }

   public void testCountDownService(TpLinkSmartPlug tpLinkSmartPlug) throws Exception {
      CountDownRule countDownRule = countDownService.getCountDownRule(tpLinkSmartPlug);
      Assert.assertTrue(!countDownRule.isAct());

      Thread.sleep(1000);

      String randomName = UUID.randomUUID().toString();
      countDownRule.setAct(true);
      countDownRule.setDelay(300);
      countDownRule.setName(randomName);
      countDownService.addCountDownRule(tpLinkSmartPlug, countDownRule);

      Thread.sleep(1000);

      countDownRule = countDownService.getCountDownRule(tpLinkSmartPlug);
      Assert.assertTrue(countDownRule.isAct());
      Assert.assertTrue(countDownRule.getDelay() > 250);
      Assert.assertTrue(countDownRule.getDelay() <= 300);
      Assert.assertTrue(randomName.equals(countDownRule.getName()));

      Thread.sleep(1000);

      randomName = UUID.randomUUID().toString();
      countDownRule.setName(randomName);
      countDownRule.setDelay(500);
      countDownService.editCountDownRule(tpLinkSmartPlug, countDownRule);

      Thread.sleep(1000);

      countDownRule = countDownService.getCountDownRule(tpLinkSmartPlug);
      Assert.assertTrue(countDownRule.isAct());
      Assert.assertTrue(countDownRule.getDelay() > 450);
      Assert.assertTrue(countDownRule.getDelay() <= 500);
      Assert.assertTrue(randomName.equals(countDownRule.getName()));

      Thread.sleep(1000);

      TpLinkResponse response = countDownService.deleteCountDownRule(tpLinkSmartPlug, countDownRule.getId());
      validateResponse(response);

      Thread.sleep(1000);

      countDownRule = countDownService.getCountDownRule(tpLinkSmartPlug);
      Assert.assertTrue(!countDownRule.isAct());
   }

   private void validateResponse(TpLinkResponse tpLinkResponse) {
      Assert.assertTrue(tpLinkResponse.getErrorCode() == 0);
      Assert.assertTrue(tpLinkResponse.getErrorMessage() == null);
   }
}
