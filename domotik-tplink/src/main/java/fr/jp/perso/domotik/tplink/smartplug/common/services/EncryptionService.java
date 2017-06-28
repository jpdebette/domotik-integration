package fr.jp.perso.domotik.tplink.smartplug.common.services;

import java.nio.ByteBuffer;
import java.util.Arrays;

class EncryptionService {

   private static final int INITIALIZATION_VECTOR = 171;

   static byte[] encrypt(String request) {
      int key = INITIALIZATION_VECTOR;

      ByteBuffer buffer = ByteBuffer.allocate(4 + request.length());
      buffer.putInt(request.length());

      for (int i = 0; i < request.length(); i++) {
         int cipher = key ^ request.charAt(i);
         key = cipher;
         buffer.put((byte) cipher);
      }

      return buffer.array();
   }

   static byte[] decrypt(byte[] encryptedResponse) {
      encryptedResponse = removeHeader(encryptedResponse);
      int key = INITIALIZATION_VECTOR;
      byte[] response = new byte[encryptedResponse.length];
      for (int i = 0; i < encryptedResponse.length; i++) {
         response[i] = (byte)(key ^ encryptedResponse[i]);
         key = encryptedResponse[i];
      }

      return response;
   }

   protected static byte[] removeHeader(byte[] encryptedResponse) {
      return Arrays.copyOfRange(encryptedResponse, 4, encryptedResponse.length);
   }
}
