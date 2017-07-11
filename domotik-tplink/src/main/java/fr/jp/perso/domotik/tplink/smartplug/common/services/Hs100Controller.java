package fr.jp.perso.domotik.tplink.smartplug.common.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jp.perso.domotik.CommandDto;

@RestController
@RequestMapping("/tplink/HS100_US")
public class Hs100Controller extends SmartPlugController {

   @GetMapping(path = "/command")
   public List<CommandDto> getCommands() {
      List<CommandDto> commands = new ArrayList<>();
      commands.add(new CommandDto("systemInfo"));
      commands.add(new CommandDto("turnOn"));
      commands.add(new CommandDto("turnOff"));
      commands.add(new CommandDto("turnLedOn"));
      commands.add(new CommandDto("turnLedOff"));

      return commands;
   }
}
