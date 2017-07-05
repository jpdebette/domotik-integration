package fr.jp.perso.domotik.beans;

public class SpotifyTokenResponse {
   private String access_token;
   private int expires_in;
   private String refresh_token;
   private String scope;
   private String token_type;

   public String getAccess_token() {
      return access_token;
   }

   public int getExpires_in() {
      return expires_in;
   }

   public String getRefresh_token() {
      return refresh_token;
   }

   public String getScope() {
      return scope;
   }

   public String getToken_type() {
      return token_type;
   }

   @Override
   public String toString() {
      return "Token: " + access_token + "\r"
              + "Refresh token: " + refresh_token;
   }
}
