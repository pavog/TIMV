package com.evilcodes.timv.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class HelpCMD
{
  static HelpCMD instance = new HelpCMD();

  public static HelpCMD getCommand() {
    return instance;
  }

  public void execHelpCMD(CommandSender cs, String[] strings, Command cmnd) {
    cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV Help " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
    if (cs.hasPermission("timv.user")) {
        cs.sendMessage(ChatColor.DARK_AQUA + "     /timv hilfe/help   " + ChatColor.GOLD + "Zeigt diese Hilfeseite" );
        cs.sendMessage(ChatColor.DARK_AQUA + "     /timv stats   " + ChatColor.GOLD + "Zeigt deine TIMVStatistiken" );
        cs.sendMessage(ChatColor.DARK_AQUA + "     /timv leave   " + ChatColor.GOLD + "Kehre zur Lobby zurück" );
        cs.sendMessage(ChatColor.DARK_AQUA + "     Weitere Befehle folgen!");
    }
    if (cs.hasPermission("timv.admin")) {
        cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV Help - Admin " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
        cs.sendMessage(ChatColor.DARK_AQUA + "     /timv stats   " + ChatColor.GOLD + "Zeigt deine TIMVStatistiken & Admindetails" );
        cs.sendMessage(ChatColor.DARK_AQUA + "     /timv reload   " + ChatColor.GOLD + "Lädt das Plugin neu" );
        cs.sendMessage(ChatColor.DARK_AQUA + "     /timv start   " + ChatColor.GOLD + "Startet eine Arena" );
    }
    cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]" + ChatColor.DARK_AQUA + " TIMV Help " + ChatColor.AQUA + "[" + ChatColor.GOLD + "---------------" + ChatColor.AQUA + "]");
  }
}