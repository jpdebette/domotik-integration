package fr.jp.perso.domotik.tplink.smartplug.common.services;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.jp.perso.domotik.tplink.smartplug.hs100.HS100;
import fr.jp.perso.domotik.tplink.smartplug.hs105.HS105;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemServiceTest {
   private HS105 hs105 = new HS105("192.168.25.51");
   private HS100 hs100 = new HS100("192.168.25.52");

   @Mock
   private RequestService requestService;
   @InjectMocks
   private SystemService systemService;

   @Test
   public void shouldGetSystemInfoForHS105() throws Exception {
      /*String expectedPlugResponse = "{\"system\":{\"get_sysinfo\":{\"sw_ver\":\"blabla\",\"hw_ver\":\"1.0\",\"type\":\"IOT.SMARTPLUGSWITCH\",\"model\":\"HS105(US)\"" +
              ",\"mac\":\"awefawefaweeaw\",\"dev_name\":\"Smart Wi-Fi Plug Mini\",\"alias\":\"Ampli\",\"relay_state\":1,\"on_time\":5805,\"active_mode\":\"none\"" +
              ",\"feature\":\"TIM\",\"updating\":0,\"icon_hash\":\"some_stuff\",\"rssi\":-38,\"led_off\":1,\"longitude_i\":-10000,\"latitude_i\":-20000,\"hwId\":\"wefwefwef\"" +
              ",\"fwId\":\"00000000000000000000000000000000\",\"deviceId\":\"asdasdsaferg5656\",\"oemId\":\"asdasdasasd\",\"err_code\":18}}}";
      ArgumentCaptor<TpLinkCommandWrapper> argumentCaptor = ArgumentCaptor.forClass(TpLinkCommandWrapper.class);
      Mockito.when(requestService.sendRequest(Mockito.anyString(), argumentCaptor.capture())).thenReturn(expectedPlugResponse);

      GetHS105SystemInfoResponse plugResponse = (GetHS105SystemInfoResponse)systemService.getSystemInfo(hs105);

      Assert.assertEquals("{\"system\":{\"get_sysinfo\":{}}}", new ObjectMapper().writeValueAsString(argumentCaptor.getValue()));
      Assert.assertEquals(TpLinkActiveMode.NONE, plugResponse.getActiveMode());
      Assert.assertEquals("Ampli", plugResponse.getAlias());
      Assert.assertEquals("asdasdsaferg5656", plugResponse.getDeviceId());
      Assert.assertEquals("Smart Wi-Fi Plug Mini", plugResponse.getDeviceName());
      Assert.assertEquals("TIM", plugResponse.getFeature());
      Assert.assertEquals("00000000000000000000000000000000", plugResponse.getFirmwareId());
      Assert.assertEquals("wefwefwef", plugResponse.getHardwareId());
      Assert.assertEquals("1.0", plugResponse.getHardwareVersion());
      Assert.assertEquals("some_stuff", plugResponse.getIconHash());
      Assert.assertEquals(-20000, plugResponse.getLatitudeI());
      Assert.assertEquals(-10000, plugResponse.getLongitudeI());
      Assert.assertEquals("awefawefaweeaw", plugResponse.getMacAddress());
      Assert.assertEquals(TpLinkModel.HS105_US, plugResponse.getModel());
      Assert.assertEquals("asdasdasasd", plugResponse.getOemId());
      Assert.assertEquals(true, plugResponse.getRelayState());
      Assert.assertEquals(-38, plugResponse.getRssi());
      Assert.assertEquals("blabla", plugResponse.getSoftwareVersion());
      Assert.assertEquals(TpLinkType.IOT_SMART_PLUG_SWITCH, plugResponse.getType());
      Assert.assertEquals(5805, plugResponse.getUpTime());
      Assert.assertEquals(18, plugResponse.getErrorCode());
      Assert.assertEquals(true, plugResponse.isLedOff());
      Assert.assertEquals(false, plugResponse.isUpdating());*/
   }

   @Test
   public void shouldGetHS100SystemInfoCorrectly() throws IOException {
      /*String expectedPlugResponse = "{\"system\":{\"get_sysinfo\":{\"sw_ver\":\"blabla\",\"hw_ver\":\"1.0\",\"type\":\"IOT.SMARTPLUGSWITCH\",\"model\":\"HS105(US)\"" +
              ",\"mac\":\"awefawefaweeaw\",\"dev_name\":\"Smart Wi-Fi Plug Mini\",\"alias\":\"Ampli\",\"relay_state\":1,\"on_time\":5805,\"active_mode\":\"none\"" +
              ",\"feature\":\"TIM\",\"updating\":0,\"icon_hash\":\"some_stuff\",\"rssi\":-38,\"led_off\":1,\"longitude\":-10000,\"latitude\":-20000,\"hwId\":\"wefwefwef\"" +
              ",\"fwId\":\"00000000000000000000000000000000\",\"deviceId\":\"asdasdsaferg5656\",\"oemId\":\"asdasdasasd\",\"err_code\":18}}}";

      ArgumentCaptor<TpLinkCommandWrapper> argumentCaptor = ArgumentCaptor.forClass(TpLinkCommandWrapper.class);
      Mockito.when(requestService.sendRequest(Mockito.anyString(), argumentCaptor.capture())).thenReturn(expectedPlugResponse);

      GetHS100SystemInfoResponse plugResponse = (GetHS100SystemInfoResponse)systemService.getSystemInfo(hs100);

      Assert.assertEquals("{\"system\":{\"get_sysinfo\":{}}}", new ObjectMapper().writeValueAsString(argumentCaptor.getValue()));
      Assert.assertEquals(TpLinkActiveMode.NONE, plugResponse.getActiveMode());
      Assert.assertEquals("Ampli", plugResponse.getAlias());
      Assert.assertEquals("asdasdsaferg5656", plugResponse.getDeviceId());
      Assert.assertEquals("Smart Wi-Fi Plug Mini", plugResponse.getDeviceName());
      Assert.assertEquals("TIM", plugResponse.getFeature());
      Assert.assertEquals("00000000000000000000000000000000", plugResponse.getFirmwareId());
      Assert.assertEquals("wefwefwef", plugResponse.getHardwareId());
      Assert.assertEquals("1.0", plugResponse.getHardwareVersion());
      Assert.assertEquals("some_stuff", plugResponse.getIconHash());
      Assert.assertEquals(-20000, plugResponse.getLatitude());
      Assert.assertEquals(-10000, plugResponse.getLongitude());
      Assert.assertEquals("awefawefaweeaw", plugResponse.getMacAddress());
      Assert.assertEquals(TpLinkModel.HS105_US, plugResponse.getModel());
      Assert.assertEquals("asdasdasasd", plugResponse.getOemId());
      Assert.assertEquals(true, plugResponse.getRelayState());
      Assert.assertEquals(-38, plugResponse.getRssi());
      Assert.assertEquals("blabla", plugResponse.getSoftwareVersion());
      Assert.assertEquals(TpLinkType.IOT_SMART_PLUG_SWITCH, plugResponse.getType());
      Assert.assertEquals(5805, plugResponse.getUpTime());
      Assert.assertEquals(18, plugResponse.getErrorCode());
      Assert.assertEquals(true, plugResponse.isLedOff());
      Assert.assertEquals(false, plugResponse.isUpdating());*/
   }

   /*@Test
   public void shouldSetRelayStateCorrectly() throws JsonProcessingException {
      String expectedPlugResponse = "{\"system\":{\"set_relay_state\":{\"err_code\":0}}}";

      ArgumentCaptor<TpLinkCommandWrapper> argumentCaptor = ArgumentCaptor.forClass(TpLinkCommandWrapper.class);
      Mockito.when(requestService.sendRequest(Mockito.anyString(), argumentCaptor.capture())).thenReturn(expectedPlugResponse);

      TpLinkResponse plugResponse = systemService.changeRelayState(hs100, true);

      Assert.assertEquals("{\"system\":{\"set_relay_state\":{\"state\":1}}}", new ObjectMapper().writeValueAsString(argumentCaptor.getValue()));
      Assert.assertEquals(0, plugResponse.getErrorCode());
   }

   @Test
   public void shouldHandleError() throws JsonProcessingException {
      String expectedPlugResponse = "{\"system\":{\"reboot\":{\"err_code\":-3,\"err_msg\":\"invalid argument\"}}}";

      ArgumentCaptor<TpLinkCommandWrapper> argumentCaptor = ArgumentCaptor.forClass(TpLinkCommandWrapper.class);
      Mockito.when(requestService.sendRequest(Mockito.anyString(), argumentCaptor.capture())).thenReturn(expectedPlugResponse);

      TpLinkResponse plugResponse = systemService.reboot(hs100, 1);

      Assert.assertEquals("{\"system\":{\"reboot\":{\"delay\":1}}}", new ObjectMapper().writeValueAsString(argumentCaptor.getValue()));
      Assert.assertEquals(-3, plugResponse.getErrorCode());
   }*/
}
