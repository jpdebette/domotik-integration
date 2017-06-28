package fr.jp.perso.domotik.tplink.smartplug.common.services;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.ResponseDeserializer;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponseWrapper;

public class ResponseService<T extends TpLinkResponse> {
   private ObjectMapper mapper = new ObjectMapper();
   private Class<T> clazz;

   public ResponseService(Class<T> clazz) {
      this.clazz = clazz;
   }

   T deserializeResponse(String response) {
      TpLinkResponseWrapper<T> tpLinkResponseWrapper;
      try {
         SimpleModule simpleModule = new SimpleModule();
         ResponseDeserializer<T> tResponseDeserializer = new ResponseDeserializer<>(clazz);
         simpleModule.addDeserializer(TpLinkResponseWrapper.class, tResponseDeserializer);
         mapper.registerModule(simpleModule);

         tpLinkResponseWrapper = mapper.readValue(response, new TypeReference<TpLinkResponseWrapper<T>>() {});
      } catch(IOException e) {
         throw new RuntimeException("Problem during deserializing the response.", e);
      }

      return tpLinkResponseWrapper.getResponse();
   }
}
