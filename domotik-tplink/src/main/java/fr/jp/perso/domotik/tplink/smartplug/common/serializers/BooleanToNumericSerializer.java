package fr.jp.perso.domotik.tplink.smartplug.common.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BooleanToNumericSerializer extends JsonSerializer<Boolean> {
   @Override
   public void serialize(Boolean value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      gen.writeNumber(value == null ? 0 : value ? 1 : 0);
   }
}