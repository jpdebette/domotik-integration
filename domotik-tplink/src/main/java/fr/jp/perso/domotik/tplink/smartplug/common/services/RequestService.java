package fr.jp.perso.domotik.tplink.smartplug.common.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jp.perso.domotik.tplink.smartplug.common.bean.commands.TpLinkCommandWrapper;

@Component
class RequestService {
   private final static int PORT = 9999;
   private final static int TIMEOUT = 10000;

   String sendRequest(String host, TpLinkCommandWrapper request) {
      ObjectMapper mapper = new ObjectMapper();
      byte[] response;
      try {
         response = sendRequest(host, mapper.writeValueAsString(request));
      } catch(JsonProcessingException e) {
         throw new RuntimeException("Problem during serializing the request.", e);
      }
      return new String(response);
   }

   private static byte[] sendRequest(String host, String request) {
      try (Socket socket = new Socket()) {
         socket.connect(new InetSocketAddress(host, PORT), TIMEOUT);
         socket.getOutputStream().write(EncryptionService.encrypt(request));
         byte[] encryptedResponse = getResponse(socket);
         socket.shutdownInput();
         socket.shutdownOutput();
         return EncryptionService.decrypt(encryptedResponse);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   private static byte[] getResponse(Socket socket) throws IOException {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();

      byte[] buffer = new byte[1024];
      int read;
      do {
         read = socket.getInputStream().read(buffer);
         baos.write(buffer, 0, read);
      } while (read == buffer.length);

      return baos.toByteArray();
   }
}
