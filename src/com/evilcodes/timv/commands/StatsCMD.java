package com.evilcodes.timv.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class StatsCMD extends JavaPlugin
{
  static StatsCMD instance = new StatsCMD();

  public static StatsCMD getCommand() {
    return instance;
  }
  public void execStatsCMD(CommandSender cs, String[] strings, Command cmnd) {
    cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV Stats " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
    if (cs.hasPermission("timv.user")) {
    	Player p = (Player)cs;     	
     cs.sendMessage(ChatColor.DARK_AQUA + "     Name:" + ChatColor.GOLD + " " + cs.getName() );
     cs.sendMessage(ChatColor.DARK_AQUA + "     Karma:" + ChatColor.GOLD + " " + p.getLevel() );
     cs.sendMessage(ChatColor.DARK_AQUA + "     Spiele:" + ChatColor.GOLD + " " + p.getAddress() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Spielzeit:" + ChatColor.GOLD + " " + p.getPlayerTime() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Traitorpunkte:" + ChatColor.GOLD + " " + p.getExp() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Detektivpunkte:" + ChatColor.GOLD + " " + p.getExp() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Innocentpunkte:" + ChatColor.GOLD + " " + p.getExp() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Gewonnene Spiele:" + ChatColor.GOLD + " " + p.getEntityId() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Verlorene Spiele:" + ChatColor.GOLD + " " + p.getExp() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Kills:" + ChatColor.GOLD + " " + p.getExp() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Tode:" + ChatColor.GOLD + " " + p.getExp() );
      cs.sendMessage(ChatColor.DARK_AQUA + "     Beste Killserie:" + ChatColor.GOLD + " " + p.getExp() );
    }
    if (cs.hasPermission("timv.admin")) {
    	cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV Stats - Admin " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
        cs.sendMessage(ChatColor.DARK_AQUA + "     Admin:" + ChatColor.GOLD + " Ja" );
        cs.sendMessage(ChatColor.DARK_AQUA + "     Status:" + ChatColor.GOLD + " " + Bukkit.getMotd() + "     §f(bug)" );
        cs.sendMessage(ChatColor.DARK_AQUA + "     Online Spieler:" + ChatColor.GOLD + " " + Bukkit.getOnlinePlayers().length + "§3 / §6" + Bukkit.getMaxPlayers() );
    }
    cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV Stats " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
  }
}