package com.evilcodes.timv.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LeaveCMD extends JavaPlugin
{
  static LeaveCMD instance = new LeaveCMD();

  public static LeaveCMD getCommand() {
    return instance;
  }
  public void execLeaveCMD(CommandSender cs, String[] strings, Command cmnd) {
	  Player p = (Player)cs;
	  cs.sendMessage(ChatColor.RED + "§lDer Befehl ist noch nicht hinzugefügt!");
	  p.playSound(((Player) cs).getLocation(), Sound.HURT, 60.0F, 0.0F);
	  }
}