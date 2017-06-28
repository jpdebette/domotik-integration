package fr.jp.perso.domotik.tplink.smartplug.common.bean.commands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public abstract class TpLinkCommand {
   @JsonIgnore
   public abstract String getCommandName();
}
