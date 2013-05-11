package com.evilcodes.timv.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCMD
{
  static StartCMD instance = new StartCMD();

  public static StartCMD getCommand() {
    return instance;
  }

  public void execStartCMD(CommandSender cs, String[] strings, Command cmnd) {

    if (!cs.hasPermission("timv.admin")) { 
    	
    	cs.sendMessage(ChatColor.BOLD + "§cDu kannst auf diesen Befehl nicht zugreifen!");
  	  	Player p = (Player)cs;
  	  	p.playSound(((Player) cs).getLocation(), Sound.HURT, 60.0F, 0.0F);
    }
        
    else {
    	cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
        cs.sendMessage(ChatColor.BOLD + "§cDu hast das Spiel gestartet!");
        
        //START GAME NOW!
        
        cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
        
    }
  }
}