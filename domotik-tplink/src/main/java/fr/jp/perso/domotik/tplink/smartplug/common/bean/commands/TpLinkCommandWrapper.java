package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.jp.perso.domotik.tplink.smartplug.common.enums.TpLinkTarget;

@JsonSerialize(using = CommandSerializer.class)
public class TpLinkCommandWrapper {
   private TpLinkTarget target;
   private TpLinkCommand command;

   public TpLinkCommandWrapper(TpLinkTarget target, TpLinkCommand command) {
      this.target = target;
      this.command = command;
   }

   public TpLinkTarget getTarget() {
      return target;
   }

   public TpLinkCommand getCommand() {
      return command;
   }
}

class CommandSerializer extends JsonSerializer<TpLinkCommandWrapper> {
   @Override
   public void serialize(TpLinkCommandWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      gen.writeStartObject();
      gen.writeFieldName(value.getTarget().toValue());
      gen.writeStartObject();
      gen.writeObjectField(value.getCommand().getCommandName(), value.getCommand());
      gen.writeEndObject();
      gen.writeEndObject();
   }
}