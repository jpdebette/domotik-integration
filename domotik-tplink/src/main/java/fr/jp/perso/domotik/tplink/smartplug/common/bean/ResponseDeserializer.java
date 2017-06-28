package fr.jp.perso.domotik.tplink.smartplug.common.bean;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponseWrapper;

public class ResponseDeserializer<T extends TpLinkResponse> extends JsonDeserializer<TpLinkResponseWrapper<T>> {
   private Class<T> clazz;

   public ResponseDeserializer(Class<T> clazz) {
      this.clazz = clazz;
   }

   @Override
   public TpLinkResponseWrapper<T> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
      ObjectNode objectNode = jsonParser.readValueAsTree();
      String commandName = objectNode.elements().next().fieldNames().next();
      JsonNode result = objectNode.elements().next().elements().next();
      JsonParser parser = result.traverse();
      parser.setCodec(jsonParser.getCodec());
      T getSystemInfoResponse = parser.readValueAs(clazz);
      return new TpLinkResponseWrapper(getSystemInfoResponse);
   }
}
