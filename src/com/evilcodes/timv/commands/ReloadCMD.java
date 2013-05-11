package com.evilcodes.timv.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.evilcodes.timv.TIMV;

public class ReloadCMD
{
  static ReloadCMD instance = new ReloadCMD();
  @SuppressWarnings("unused")
private TIMV plugin;
  public static ReloadCMD getCommand() {
    return instance;
  }

  public void execReloadCMD(CommandSender cs, String[] strings, Command cmnd) {
	  if (cs.hasPermission("timv.admin")) {
		  //Disable & Enable
		  cs.sendMessage(ChatColor.BOLD + "§cDer Befehl existiert noch nicht!");
		  cs.sendMessage(ChatColor.AQUA + "Plugin reloaded!");
	  	  Player p = (Player)cs;
	  	  p.playSound(((Player) cs).getLocation(), Sound.HURT, 60.0F, 0.0F);
	  } else {
		  cs.sendMessage(ChatColor.BOLD + "§cDu hast dafür keine Berechtigung!");
	  	  Player p = (Player)cs;
	  	  p.playSound(((Player) cs).getLocation(), Sound.HURT, 60.0F, 0.0F);
	  }
  }
}