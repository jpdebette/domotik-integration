package fr.jp.perso.domotik;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpotifyApp {
   public static void main(String[] args) throws IOException {
      SpringApplication.run(SpotifyApp.class, args);
   }
}
