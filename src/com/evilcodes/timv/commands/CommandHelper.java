package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHelper
{
  CommandSender sender;
  Command cmd;

  public CommandHelper(CommandSender cs, Command cm)
  {
    this.sender = cs;
    this.cmd = cm;
  }

  public void noPermission() {
    this.sender.sendMessage("§4Du hast dafür keine Berechtigung!");
  }

  public void noConsole() {
    this.sender.sendMessage("§4Du darfst nicht die Konsole sein!");
  }

  public void wrongArgs() {
    this.sender.sendMessage("§4Falsche Befehlsform!");
    this.sender.sendMessage("§4Richtig: " + this.cmd.getUsage());
  }

  public void unknownCommand() {
    this.sender.sendMessage("§aUnbekannter Befehl!");
    this.sender.sendMessage("§aMache §b/timv hilfe §afür Hilfe!");
  }
}