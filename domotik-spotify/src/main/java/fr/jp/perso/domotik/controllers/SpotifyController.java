package fr.jp.perso.domotik.controllers;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import fr.jp.perso.domotik.beans.SpotifyTokenResponse;
import fr.jp.perso.domotik.services.SessionManager;
import fr.jp.perso.domotik.services.SpotifyService;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {
   @Autowired
   private SessionManager sessionManager;
   @Autowired
   private SpotifyService spotifyService;

   @RequestMapping(path = "/{clientId}/getToken", method = RequestMethod.GET)
   public String getTokenByAuthorizationCode(@PathVariable String clientId) {
      final String uri = "https://accounts.spotify.com/authorize";
      RestTemplate restTemplate = new RestTemplate();

      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
              .queryParam("client_id", clientId)
              .queryParam("response_type", "code")
              .queryParam("redirect_uri", "http://whatever.com")
              .queryParam("scope", "user-read-private user-read-email user-read-playback-state streaming");

      HttpHeaders headers = new HttpHeaders();

      headers.set("Accept", "text/html,application/xhtml+xml,application/xml;");
      headers.set("Cookie", "");

      HttpEntity<String> entity = new HttpEntity<>(headers);

      ResponseEntity<String> rep = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);

      if (rep.getStatusCode() != HttpStatus.FOUND) {
         throw new RuntimeException("No redirect received from Spotify, received: " + rep.toString());
      }

      String redirectUrl = rep.getHeaders().get("Location").get(0);
      MultiValueMap<String, String> parameters = UriComponentsBuilder.fromHttpUrl(redirectUrl).build().getQueryParams();
      String code = parameters.get("code").get(0);

      return getToken(clientId, code);
   }

   private String getToken(String clientId, String code) {
      if (code == null || code.trim().isEmpty()) {
         throw new RuntimeException("No code received from Spotify...");
      }

      String clientSecret = "";

      String idSecret = clientId + ":" + clientSecret;
      String idSecretEncoded = new String(Base64.encodeBase64(idSecret.getBytes()));

      final String uri = "https://accounts.spotify.com/api/token?grant_type=authorization_code&code=" + code + "&redirect_uri=http://whatever.com";
      RestTemplate restTemplate = new RestTemplate();

      HttpHeaders headers = new HttpHeaders();
      headers.set("Authorization", "Basic " + idSecretEncoded);
      HttpEntity<String> entity = new HttpEntity<>(headers);

      ResponseEntity<SpotifyTokenResponse> response = restTemplate.exchange(uri, HttpMethod.POST, entity, SpotifyTokenResponse.class);
      return response.getBody().toString();
   }

   @RequestMapping(path = "/{clientId}/renewToken", method = RequestMethod.GET)
   public String renewToken(@PathVariable String clientId) {
      String refreshToken = "";
      String clientSecret = "";

      String idSecret = clientId + ":" + clientSecret;
      String idSecretEncoded = new String(Base64.encodeBase64(idSecret.getBytes()));

      final String uri = "https://accounts.spotify.com/api/token?grant_type=refresh_token&refresh_token=" + refreshToken;
      RestTemplate restTemplate = new RestTemplate();

      HttpHeaders headers = new HttpHeaders();
      headers.set("Authorization", "Basic " + idSecretEncoded);
      HttpEntity<String> entity = new HttpEntity<>(headers);

      ResponseEntity<SpotifyTokenResponse> response = restTemplate.exchange(uri, HttpMethod.POST, entity, SpotifyTokenResponse.class);
      return response.getBody().toString();
   }
}
