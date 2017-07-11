package fr.jp.perso.domotik.tplink.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jp.perso.domotik.ApiResponseDto;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkModel;

@RestController
@RequestMapping("/tplink")
public class TpLinkController {
   private static final Logger log = LoggerFactory.getLogger(TpLinkController.class);

   @GetMapping(path = "/model")
   public List<String> getModelIds() {
      List<String> models = new ArrayList<>();
      for(TpLinkModel tpLinkModel : TpLinkModel.values()) {
         models.add(tpLinkModel.name());
      }
      return models;
   }

   public static ApiResponseDto processResponse(TpLinkResponse tpLinkResponse) {
      ObjectMapper mapper = new ObjectMapper();
      ApiResponseDto apiResponseDto = new ApiResponseDto();
      apiResponseDto.setSuccess(true);
      try {
         apiResponseDto.setResponse(mapper.writeValueAsString(tpLinkResponse));
      } catch(JsonProcessingException ex) {
         String errorMessage = "Error when parsing the tpLink response...";
         apiResponseDto.setSuccess(false);
         apiResponseDto.setResponse(errorMessage);
         log.error(errorMessage, ex);
      }

      return apiResponseDto;
   }

   public static ApiResponseDto processException(Exception ex) {
      ApiResponseDto apiResponseDto = new ApiResponseDto();
      apiResponseDto.setResponse(ex.getMessage());
      return apiResponseDto;
   }

   /**
    * Time Services
    **//*

   public GetTimeResponse getTime(TpLinkSmartPlug tpLinkSmartPlug) {
      return timeService.getTime(tpLinkSmartPlug);
   }

   public GetTimezoneResponse getTimezone(TpLinkSmartPlug tpLinkSmartPlug) {
      return timeService.getTimezone(tpLinkSmartPlug);
   }

   *//**
    * Count down Services
    **//*

   public CountDownRule getCountDownRule(TpLinkSmartPlug tpLinkSmartPlug) {
      return countDownService.getCountDownRule(tpLinkSmartPlug);
   }

   public TpLinkResponse addCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, CountDownRule countDownRule) {
      return countDownService.addCountDownRule(tpLinkSmartPlug, countDownRule);
   }

   public TpLinkResponse editCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, CountDownRule countDownRule) {
      return countDownService.editCountDownRule(tpLinkSmartPlug, countDownRule);
   }

   public TpLinkResponse deleteCountDownRule(TpLinkSmartPlug tpLinkSmartPlug, String countDownRuleId) {
      return countDownService.deleteCountDownRule(tpLinkSmartPlug, countDownRuleId);
   }

   public TpLinkResponse deleteAllCountDownRules(TpLinkSmartPlug tpLinkSmartPlug) {
      return countDownService.deleteAllCountDownRules(tpLinkSmartPlug);
   }*/
}
