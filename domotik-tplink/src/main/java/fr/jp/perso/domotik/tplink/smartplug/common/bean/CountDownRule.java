package fr.jp.perso.domotik.tplink.smartplug.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.responses.TpLinkResponse;
import fr.jp.perso.domotik.tplink.smartplug.common.serializers.BooleanToNumericSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountDownRule extends TpLinkResponse {
   private String id;
   @JsonSerialize(using = BooleanToNumericSerializer.class)
   private Boolean enable;
   private Integer delay;
   @JsonSerialize(using = BooleanToNumericSerializer.class)
   private Boolean act;
   private String name;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Boolean isEnable() {
      return enable;
   }

   public void setEnable(Boolean enable) {
      this.enable = enable;
   }

   public Integer getDelay() {
      return delay;
   }

   public void setDelay(Integer delay) {
      this.delay = delay;
   }

   public Boolean isAct() {
      return act;
   }

   public void setAct(Boolean act) {
      this.act = act;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
