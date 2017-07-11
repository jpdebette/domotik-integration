package fr.jp.perso.domotik.tplink.smartplug.common.services;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommandWrapper;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.AddCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.CountDownRule;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.DeleteAllCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.DeleteCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.EditCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.countdown.GetCountDownRuleCommand;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkTarget;

public class CountDownServiceTest {

   @Test
   public void shouldSerializeGetCountDownRuleCorrectly() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();

      TpLinkCommandWrapper command = new TpLinkCommandWrapper(TpLinkTarget.COUNT_DOWN, new GetCountDownRuleCommand());
      String json = mapper.writeValueAsString(command);

      Assert.assertEquals( "{\"count_down\":{\"get_rules\":{}}}", json);
   }

   @Test
   public void shouldSerializeAddCountDownRuleCorrectly() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();

      CountDownRule countDownRule = new CountDownRule();
      countDownRule.setEnable(true);
      countDownRule.setAct(true);
      countDownRule.setDelay(1800);
      countDownRule.setName("turn on");

      TpLinkCommandWrapper command = new TpLinkCommandWrapper(TpLinkTarget.COUNT_DOWN, new AddCountDownRuleCommand(countDownRule));
      String json = mapper.writeValueAsString(command);

      Assert.assertEquals( "{\"count_down\":{\"add_rule\":{\"enable\":1,\"delay\":1800,\"act\":1,\"name\":\"turn on\"}}}", json);
   }

   @Test
   public void shouldSerializeEditCountDownRuleCorrectly() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();

      CountDownRule countDownRule = new CountDownRule();
      countDownRule.setId("qwertyuiopasdfghjkl");
      countDownRule.setEnable(true);
      countDownRule.setAct(true);
      countDownRule.setDelay(1800);
      countDownRule.setName("turn on");

      TpLinkCommandWrapper command = new TpLinkCommandWrapper(TpLinkTarget.COUNT_DOWN, new EditCountDownRuleCommand(countDownRule));
      String json = mapper.writeValueAsString(command);

      Assert.assertEquals( "{\"count_down\":{\"edit_rule\":{\"id\":\"qwertyuiopasdfghjkl\",\"enable\":1,\"delay\":1800,\"act\":1,\"name\":\"turn on\"}}}", json);
   }

   @Test
   public void shouldSerializeDeleteCountDownRuleCorrectly() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();

      TpLinkCommandWrapper command = new TpLinkCommandWrapper(TpLinkTarget.COUNT_DOWN, new DeleteCountDownRuleCommand("qwertyuiopasdfghjkl"));
      String json = mapper.writeValueAsString(command);

      Assert.assertEquals( "{\"count_down\":{\"delete_rule\":{\"id\":\"qwertyuiopasdfghjkl\"}}}", json);
   }

   @Test
   public void shouldSerializeDeleteAllCountDownRulesCorrectly() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();

      TpLinkCommandWrapper command = new TpLinkCommandWrapper(TpLinkTarget.COUNT_DOWN, new DeleteAllCountDownRuleCommand());
      String json = mapper.writeValueAsString(command);

      Assert.assertEquals( "{\"count_down\":{\"delete_all_rules\":{}}}", json);
   }
}
