package fr.jp.perso.domotik.tplink.smartplug.common.bean.responses;

public class TpLinkResponseWrapper<T extends TpLinkResponse> {
   private T response;

   public TpLinkResponseWrapper(T response) {
      this.response = response;
   }

   public T getResponse() {
      return response;
   }
}

