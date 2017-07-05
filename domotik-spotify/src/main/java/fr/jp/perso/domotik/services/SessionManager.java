package fr.jp.perso.domotik.services;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {
   private String currentToken;

   public String getCurrentToken() {
      return currentToken;
   }

   public void setCurrentToken(String currentToken) {
      this.currentToken = currentToken;
   }
}
